package com.tistory.devs0n.bingewatching.domain.member.core.infrastructure

import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@DisplayName("JdbcMemberRepository")
internal class DataJdbcMemberRepositoryTest : MemberDataJdbcTestInitializer() {
    @Autowired
    lateinit var memberRepository: DataJdbcMemberRepository

    @Test
    fun `save - Member를 저장한다`() {
        // given
        val member = Member.new("chris")

        // when
        memberRepository.save(member)

        // then
        val savedMember = memberRepository.findById(member.id)!!
        assertThat(savedMember).isEqualTo(member)
    }

    @Test
    fun `existsByUsername - 해당 username의 Member 저장 유무를 리턴한다`() {
        // given
        val username = "chris"

        // when
        val shouldBeFalse = memberRepository.existsByUsername(username)
        // then
        assertThat(shouldBeFalse).isFalse

        // given
        memberRepository.save(Member.new(username))
        // when
        val shouldBeTrue = memberRepository.existsByUsername(username)
        // then
        assertThat(shouldBeTrue).isTrue
    }
}
