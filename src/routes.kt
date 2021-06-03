package saoria.ktor.demo

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
import saoria.ktor.demo.model.ComplexObject
import saoria.ktor.demo.model.SimpleObject
import java.time.ZonedDateTime

fun Route.registerSimpleRoute() {
    get("/api/simple") {
        call.respond(
            SimpleObject(
                id = "id",
                name = "name",
                num = 2,
                date = ZonedDateTime.now()
            )
        )
    }
}

fun Route.registerComplexRoute() {
    get("/api/complex") {
        call.respond(
            ComplexObject(
                id = "id",
                nested = SimpleObject(
                    id = "id",
                    name = "name",
                    num = 2,
                    date = ZonedDateTime.now()
                )
            )
        )
    }
}

fun Route.registerHtmlRoute() {
    get("/api/html") {
        val title = "title"
        val text = "text"

        call.respondHtml {
            head {
                title {
                    +title
                }
            }
            body {
                h1 {
                    +"Hello this is $text!"
                }
            }
        }
    }
}
