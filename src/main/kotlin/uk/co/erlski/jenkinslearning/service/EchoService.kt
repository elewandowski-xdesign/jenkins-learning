package uk.co.erlski.jenkinslearning.service

import org.springframework.stereotype.Service
import uk.co.erlski.jenkinslearning.model.EchoInputBody
import uk.co.erlski.jenkinslearning.model.EchoResponseBody

@Service
class EchoService {

    public fun buildEcho(input: EchoInputBody) : EchoResponseBody {
        return EchoResponseBody(input.input+input.name)
    }

}