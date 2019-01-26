package ch.phildev.evidence.k8

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScalableKubernetesApplication

fun main(args: Array<String>) {
    runApplication<ScalableKubernetesApplication>(*args)
}

