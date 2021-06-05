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

fun Route.registerPdfRoute() {
    get("/api/pdf") {
        val pdfUrl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"

        call.respondHtml {
            attributes["lang"] = "no"
            attributes["style"] = "height: 100%;"

            body {
                attributes["style"] = "height: 100%; margin: 0px;"

                iframe {
                    attributes["src"] = pdfUrl
                    attributes["frameborder"] = "0"
                    attributes["height"] = "100%"
                    attributes["width"] = "100%"
                }
            }
        }
    }
}
