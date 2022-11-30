package io.github.sejoung.kotlin.codespitz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringifyTest {

    data class JsonList(val a: Int, val b: String, val c: List<String>)
    data class JsonSet(val a: Int, val b: String, val c: Set<String>)
    data class JsonMap(val a: Int, val b: String, val c: Map<String, String>)

    @Test
    fun stringifyList() {
        val actual = JsonList(3, "abc", listOf("a", "b", "c")).stringify()
        print(actual)
        assertThat(actual).isEqualTo("{\"a\":3,\"b\":\"abc\",\"c\":[\"a\",\"b\",\"c\"]}")
    }

    @Test
    fun stringifySet() {
        val actual = JsonSet(3, "abc", setOf("a", "b", "c")).stringify()
        print(actual)
        assertThat(actual).isEqualTo("{\"a\":3,\"b\":\"abc\",\"c\":[\"a\",\"b\",\"c\"]}")
    }

    @Test
    fun stringifyMap() {
        val actual = JsonMap(3, "abc", mapOf("a" to "asd", "b" to "123")).stringify()
        print(actual)
        assertThat(actual).isEqualTo("{\"a\":3,\"b\":\"abc\",\"c\":{\"a\":\"asd\",\"b\":\"123\"}}")
    }

}
