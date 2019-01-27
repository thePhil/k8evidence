package ch.phildev.evidence.k8.client

import org.jline.utils.AttributedString
import org.springframework.shell.jline.PromptProvider
import org.springframework.stereotype.Component

@Component
class ConnectionPromptProvider(private val state: ShellState) : PromptProvider {

    private val defaultPrompt: String = "k8-evi"
    private val delimiter: String = ":>"

    override fun getPrompt(): AttributedString =
        if (!state.isSet)
            AttributedString(defaultPrompt + delimiter)
        else
            AttributedString("[${state.requestType} ${state.host}:${state.port}${state.path}]" + delimiter)
}