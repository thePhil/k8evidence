package ch.phildev.evidence.k8.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.shell.Availability
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellMethodAvailability
import org.springframework.shell.standard.ShellOption
import org.springframework.web.reactive.function.client.WebClient
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@ShellComponent
class LoadClient(
) {
    @Autowired
    private lateinit var state: ShellState

    private lateinit var client: WebClient

    @ShellMethod("Configuring the webflux client with hostname and port")
    fun config(
        @ShellOption(defaultValue = "localhost", help = "The host of endpoint to call to")
        @NotEmpty
        @NotBlank
        host: String,

        @ShellOption(defaultValue = "8080", help = "The port where the webservice is exposed")
        @Min(1)
        @Max(65535)
        port: Int,

        @ShellOption(defaultValue = "/", help = "Setting the path to the request that should be called")
        path: String
    ) {
        state.host = if (!host.startsWith("http://")) "http://$host" else host
        state.port = port
        state.isSet = true
        state.path = if (!path.startsWith("/")) "/$path" else path

        client = WebClient.create("${state.host}:${state.port}")
    }

    @ShellMethod("Run the configured request")
    fun run(
        @ShellOption(defaultValue = "", help = "Provided, optional body for the configured request")
        body: String
    ): String {
        val response = client
            .method(state.requestType)
            .uri(state.path)
            .contentType(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(String::class.java)
            .block()

        return response.toString()
    }

    fun runAvailability(): Availability =
        if (state.isSet) Availability.available()
        else Availability.unavailable("the request has not been configured completely.")

    @ShellMethod("Provide configuration option for setting the mapping on the configured URL, separately")
    @ShellMethodAvailability("runAvailability")
    fun path(path : String) {
        state.path = if (!path.startsWith("/")) "/$path" else path
    }

}