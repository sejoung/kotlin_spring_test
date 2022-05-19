package io.github.sejoung.kotlin.jackson.serialize

import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test

internal class ObjectMapperFoctoryTest {

    @Test
    internal fun name() {
        val json = """
                        {
                         "user":{
                                    "source": "source",
                                    "path":  "/media/6284dc4ce423ef017a787a35/hls/ori.m3u8"
                                 },
                          "orderName":"old"
                        }
        """.trimIndent()
        val actual = ObjectMapperFoctory.objectMapper.readValue<OldOrder>(json)
        println(actual)
    }
}