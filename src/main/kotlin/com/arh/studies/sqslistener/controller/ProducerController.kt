package com.arh.studies.sqslistener.controller

import com.arh.studies.sqslistener.service.producer.Producer1Queue
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/producer")
class ProducerController(private val producer: Producer1Queue) {

    private val logger = KotlinLogging.logger {}

    @PostMapping("/start")
    fun startListener() {
        CompletableFuture.runAsync { producer.start() }
        logger.info { "Producer started" }
    }

    @PostMapping("/stop")
    fun stopListener() {
        CompletableFuture.runAsync { producer.stop() }
        logger.info { "Producer stopped" }
    }
}
