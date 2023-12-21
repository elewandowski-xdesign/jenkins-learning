package uk.co.erlski.jenkinslearning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JenkinsLearningApplication

fun main(args: Array<String>) {
    runApplication<JenkinsLearningApplication>(*args)
}
