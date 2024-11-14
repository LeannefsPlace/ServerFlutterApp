package pers.leannef.random_facts_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class RandomFactsApiApplication

fun main(args: Array<String>) {
    runApplication<RandomFactsApiApplication>(*args)
}
