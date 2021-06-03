package saoria.ktor.demo

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import saoria.ktor.demo.model.TimeAdapter
import java.time.ZonedDateTime

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            registerTypeAdapter(ZonedDateTime::class.java, TimeAdapter())
        }
    }

    routing {
        registerSimpleRoute()
        registerComplexRoute()
        registerHtmlRoute()
    }
}

