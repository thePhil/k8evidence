package ch.phildev.evidence.k8.server.controller

import ch.phildev.evidence.k8.server.config.WebSecurityConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@Suite.SuiteClasses(WebSecurityConfig::class)
@WebFluxTest
@WithMockUser
//@AutoConfigureWebTestClient
internal class LoadControllerTest {

    @Autowired
    private lateinit var client: WebTestClient

    @MockBean
    private lateinit var repo : LoadRepository

    private val basePath: String = "/evidence/k8/load"

    @Test
    fun sayHello() {
        given(this.repo.getLoadHello()).willReturn(Mono.just("hello"))

        client.get().uri("$basePath/hello")
            .exchange().expectStatus().isOk
            .expectBody<String>().isEqualTo("hello")
    }

    @Test
    fun blocking() {
    }
}