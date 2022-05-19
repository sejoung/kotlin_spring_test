package io.github.sejoung.kotlin.jackson.serialize

import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("ObjectMapper 커스텀 어너테이션 테스트")
internal class ObjectMapperFactoryTest {

    @DisplayName("data class 변환테스트")
    @Test
    internal fun data_class_test() {
        val json = """
                        {
                         "user":{
                                    "source": "old source",
                                    "path":  "/media/6284dc4ce423ef017a787a35/hls/ori.m3u8"
                                 },
                          "orderName":"old"
                        }
        """.trimIndent()
        val actual = ObjectMapperFactory.objectMapper.readValue<OldOrder>(json)
        assertThat(actual.user.source).isEqualTo("old source")

    }

    @DisplayName("data class @get 변환테스트")
    @Test
    internal fun data_class_get_test() {
        val json = """
                        {
                         "user":{
                                    "source": "new source",
                                    "path":  "/media/6284dc4ce423ef017a787a35/hls/ori.m3u8"
                                 },
                          "orderName":"new"
                        }
        """.trimIndent()
        val actual = ObjectMapperFactory.objectMapper.readValue<NewOrder>(json)
        assertThat(actual.user.source).isEqualTo("new source")
    }

    @DisplayName("class 변환테스트")
    @Test
    internal fun class_test() {
        val json = """
                        {
                         "user":{
                                    "source": "source",
                                    "path":  "/media/6284dc4ce423ef017a787a35/hls/ori.m3u8"
                                 },
                          "orderName":"old"
                        }
        """.trimIndent()
        val actual = ObjectMapperFactory.objectMapper.readValue<NewTest>(json)
        assertThat(actual.user?.source).isNotEqualTo("test")
    }
}