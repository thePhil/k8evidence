package ch.phildev.evidence.k8.client

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class EvidenceK8ClientApplication

fun main(args: Array<String>) {
    SpringApplication.run(EvidenceK8ClientApplication::class.java, *args)
}

