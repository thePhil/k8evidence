package ch.phildev.evidence.k8.server.controller

import ch.phildev.evidence.k8.server.controller.dto.BlockingDto
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Repository
class LoadRepositoryImpl() : LoadRepository {

    override fun blockingLoad(duration: BlockingDto): Flux<String> =
        Mono.delay(Duration.ofMillis(duration.millis.toLong()))
            .map { "do something here" }
            .delayElement(Duration.ofMillis((duration.millis * 2).toLong()))
            .elapsed()
            .flatMapMany { tup ->
                Flux.just("Elapsed since subscription: ${tup.t1}, second arg: ${tup.t2}")
            }

    override fun getLoadHello(): Mono<String> {
        return Mono.just("Hello")
    }
}
