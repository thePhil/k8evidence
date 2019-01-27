package ch.phildev.evidence.k8.client

import org.springframework.context.annotation.Scope
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component

@Scope(value = "singleton")
@Component
data class ShellState(
    var host: String = "",
    var port: Int = 0,
    var path: String = "/",
    var isSet: Boolean = false,
    var requestType: HttpMethod = HttpMethod.GET
)