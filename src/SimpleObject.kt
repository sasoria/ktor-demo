package saoria.ktor.demo

import com.google.gson.*
import java.lang.reflect.Type
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class ComplexObject (
    val id: String,
    val nested: SimpleObject
)

data class SimpleObject (
    val id: String,
    val name: String,
    val num: Int,
    val date: ZonedDateTime
)

class MyTimeAdapter : JsonSerializer<ZonedDateTime> {
    override fun serialize(time: ZonedDateTime?, type: Type?, ctx: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(time?.format(DateTimeFormatter.ISO_ZONED_DATE_TIME))
    }

}
