package ch.phildev.evidence.k8.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EvidenceK8ClientApplication

fun main(args: Array<String>) {
    runApplication<EvidenceK8ClientApplication>(*args)
}

