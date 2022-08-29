package io.github.sejoung.kotlin.jackson.serialize

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException

class UserRawSerializer : StdSerializer<User>(User::class.java) {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: User, gen: JsonGenerator, provider: SerializerProvider) {
        gen.apply {
            writeStartObject()
            writeStringField(User::source.name, "${value.source}")
            writeStringField(User::path.name, value.path)
            writeEndObject()
        }
    }
}

class UserRawDeserializer : StdDeserializer<User>(User::class.java) {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext) =
        p.codec.readTree<JsonNode>(p).let { node ->
            User(
                source = node.get(User::source.name).asText(),
                path = node.get(User::path.name).asText(),
            )
        }
}

class UserSerializer : StdSerializer<User>(User::class.java) {
    override fun serialize(value: User, gen: JsonGenerator, provider: SerializerProvider) =
        gen.writeString(value.path + value.source)
}

class UserDeserializer : StdDeserializer<User>(User::class.java) {
    override fun deserialize(p0: JsonParser, p1: DeserializationContext): User {
        println(p0.text)
        return User(source = "test", path = "p0.text")
    }
}
