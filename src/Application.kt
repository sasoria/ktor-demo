package saoria.ktor.demo

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
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
        get("/") {
            call.respond(SimpleObject(
                    id = "id",
                    name = "name",
                    num = 2,
                    date = ZonedDateTime.now()
            ))
        }

        get("/complex") {
            call.respond(ComplexObject(
                    id = "id",
                    nested = SimpleObject(
                        id = "id",
                        name = "name",
                        num = 2,
                        date = ZonedDateTime.now()
                    )
            ))
        }
    }
}

