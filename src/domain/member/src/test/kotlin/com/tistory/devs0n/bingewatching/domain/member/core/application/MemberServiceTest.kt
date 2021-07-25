package com.tistory.devs0n.bingewatching.domain.member.core.application

import com.tistory.devs0n.bingewatching.domain.member.core.application.command.JoinNewMemberCommand
import com.tistory.devs0n.bingewatching.domain.member.core.domain.MockMemberRepository
import com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberDomainDataDuplicationException
import io.kotest.core.spec.style.DescribeSpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

internal class MemberServiceTest : DescribeSpec({
    val memberRepository = MockMemberRepository()
    val memberService = MemberService(memberRepository)

    afterEach {
        memberRepository.clear()
    }

    describe("MemberService.") {
        describe("joinNewMember") {
            it("새로운 회원을 가입시킨다") {
                // given
                val command = JoinNewMemberCommand(username = "chris")

                // when
                val member = memberService.joinNewMember(command)

                // then
                assertThat(member.username).isEqualTo(command.username)
                assertThat(memberRepository.existsByUsername(command.username)).isTrue
            }

            describe("기존 회원과 username이 중복되면") {
                it("MemberDomainDataDuplicationException을 throw 한다") {
                    // given
                    val command = JoinNewMemberCommand(username = "chris")
                    memberService.joinNewMember(command)

                    // when & then
                    assertThatThrownBy {
                        memberService.joinNewMember(command)
                    }.isExactlyInstanceOf(MemberDomainDataDuplicationException::class.java)
                }
            }
        }
    }
})
