package com.tistory.devs0n.bingewatching.domain.member.common.utils

import io.kotest.core.spec.style.DescribeSpec
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.*

internal class StringUtilsKtTest: DescribeSpec({
    describe("hasSpace") {
        describe("문자열에 공백(' ')이 포함되어있으면") {
            it("true를 리턴한다") {
                assertThat(" ".hasSpace()).isTrue
                assertThat(" a".hasSpace()).isTrue
                assertThat("a ".hasSpace()).isTrue
            }
        }

        describe("문자열에 공백(' ')이 포함되어있지 않으면") {
            it("false를 리턴한다") {
                assertThat("".hasSpace()).isFalse
                assertThat("a".hasSpace()).isFalse
            }
        }
    }

    describe("hasLengthBetween") {
        describe("문자열이 입력 범위 내에 있으면") {
            it("true를 리턴한다") {
                assertThat("test".hasLengthBetween(4, 5)).isTrue
                assertThat("test".hasLengthBetween(4, 5)).isTrue
                assertThat("test".hasLengthBetween(3, 4)).isTrue
            }
        }

        describe("문자열이 입력 범위 밖에 있으면") {
            it("false를 리턴한다") {
                assertThat("test".hasLengthBetween(5, 5)).isFalse
                assertThat("test".hasLengthBetween(3, 3)).isFalse
            }
        }
    }
})
