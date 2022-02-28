package com.ktserver.ktserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtserverApplication

fun main(args: Array<String>) {
    runApplication<KtserverApplication>(*args)
}
