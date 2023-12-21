package uk.co.erlski.jenkinslearning.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import uk.co.erlski.jenkinslearning.model.EchoInputBody
import uk.co.erlski.jenkinslearning.model.EchoResponseBody

@RestController
class EchoController {

    @PostMapping("/echo")
    fun echo(
        @RequestBody input: EchoInputBody
    ): ResponseEntity<EchoResponseBody> {
        val message = EchoResponseBody(input.input + input.name)
        System.err.println(message)
        return ResponseEntity(
            message, HttpStatus.OK
        )
    }

}