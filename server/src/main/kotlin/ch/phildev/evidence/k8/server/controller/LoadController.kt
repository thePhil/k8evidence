package ch.phildev.evidence.k8.server.controller

import ch.phildev.evidence.k8.server.controller.dto.BlockingDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/evidence/k8/load")
class LoadController(val loadRepository: LoadRepository) {

    @GetMapping("hello")
    fun sayHello() : Mono<String> {
        return loadRepository.getLoadHello()
    }


    @GetMapping("blocking",consumes= [MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE])
    fun blocking( @RequestBody millis : BlockingDto) : Flux<String> {
        return loadRepository.blockingLoad(millis)
    }

    @GetMapping("sample")
    fun getSample() : Mono<BlockingDto> {
        return Mono.just(BlockingDto(5,5))
    }

}

