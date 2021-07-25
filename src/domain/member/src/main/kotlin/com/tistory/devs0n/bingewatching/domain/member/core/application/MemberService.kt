package com.tistory.devs0n.bingewatching.domain.member.core.application

import com.tistory.devs0n.bingewatching.domain.member.core.application.command.JoinNewMemberCommand
import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member
import com.tistory.devs0n.bingewatching.domain.member.core.domain.MemberRepository
import com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberDomainDataDuplicationException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun joinNewMember(command: JoinNewMemberCommand): Member {
        val username = command.username

        if (memberRepository.existsByUsername(username)) {
            LOGGER.debug("Member.username is duplicated - username: $username")
            throw MemberDomainDataDuplicationException("username", username)
        }

        val member = Member.new(username)
        this.memberRepository.save(member)

        LOGGER.info("New member joined - id: ${member.id}")
        return member
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
