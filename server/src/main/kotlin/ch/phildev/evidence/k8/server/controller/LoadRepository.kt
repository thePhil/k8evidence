package ch.phildev.evidence.k8.server.controller

import ch.phildev.evidence.k8.server.controller.dto.BlockingDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface LoadRepository {
    fun getLoadHello() : Mono<String>
    fun blockingLoad(duration : BlockingDto): Flux<String>
}
