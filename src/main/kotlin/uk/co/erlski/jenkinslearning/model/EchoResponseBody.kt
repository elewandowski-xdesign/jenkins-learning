package uk.co.erlski.jenkinslearning.model

data class EchoResponseBody(var response: String) {
    override fun toString(): String {
        return response
    }
}
