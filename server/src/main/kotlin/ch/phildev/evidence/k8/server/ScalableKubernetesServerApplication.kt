package ch.phildev.evidence.k8.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScalableKubernetesServerApplication

fun main(args: Array<String>) {
    runApplication<ScalableKubernetesServerApplication>(*args)
}

