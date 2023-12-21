package uk.co.erlski.jenkinslearning.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import uk.co.erlski.jenkinslearning.model.EchoInputBody

class EchoServiceTest() {

    private val echo = EchoService()

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun buildEcho() {
        assertThat(echo.buildEcho(EchoInputBody(input = "yes", name = "no"))).asString().isEqualTo("yesno")
    }

    @Test
    fun failTest() {
        assertThat(echo.buildEcho(EchoInputBody(input = "yes", name = "no"))).asString().isEqualTo("noyes")
    }
}