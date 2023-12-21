package uk.co.erlski.jenkinslearning.controllermvc

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import uk.co.erlski.jenkinslearning.model.EchoInputBody
import uk.co.erlski.jenkinslearning.model.EchoResponseBody
import java.awt.PageAttributes

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
class EchoControllerTest {


    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun testEchoController() {
        val inputBody = EchoInputBody("Hello, ", "John")

        mockMvc.perform(
            post("/echo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputBody))
        )
            .andExpect(status().isOk)
            .andExpect { result ->
                val responseBody =
                    objectMapper.readValue(result.response.contentAsString, EchoResponseBody::class.java)

                // Add any additional assertions based on your controller logic
                // For example, you can assert the response body content
                assert(responseBody.response == "Hello, John")
            }
    }
}