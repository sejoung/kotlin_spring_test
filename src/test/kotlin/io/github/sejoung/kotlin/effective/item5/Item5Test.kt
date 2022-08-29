package io.github.sejoung.kotlin.effective.item5

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("예외를 할용해 코드에 제한을 걸어라")
internal class Item5Test {

    @DisplayName("check 테스트")
    @Test
    internal fun checkTest() {
        val actual = assertThrows<IllegalStateException> {
            check(false) { "asd" }
        }
        println(actual.message)
    }

    @DisplayName("require 테스트")
    @Test
    internal fun requireTest() {
        val actual = assertThrows<IllegalArgumentException> {
            require(false) { "require error" }
        }
        println(actual.message)
    }

    @DisplayName("require 스마트 캐스팅 테스트")
    @Test
    internal fun requireSmartCasting() {
        val given: String? = null

        val actual = requireNotNull(given)
        println(actual)
    }

    @DisplayName("check 스마트 캐스팅 테스트")
    @Test
    internal fun checkSmartCasting() {
        val given: String? = null

        val actual = checkNotNull(given)
        println(actual)
    }
}
