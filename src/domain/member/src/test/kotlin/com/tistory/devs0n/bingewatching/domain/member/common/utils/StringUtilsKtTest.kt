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
})
