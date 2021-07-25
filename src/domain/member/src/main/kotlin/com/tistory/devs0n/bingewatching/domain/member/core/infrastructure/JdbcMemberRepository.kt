package com.tistory.devs0n.bingewatching.domain.member.core.infrastructure

import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member
import com.tistory.devs0n.bingewatching.domain.member.core.domain.MemberRepository
import com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberRepositoryException
import org.slf4j.LoggerFactory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
internal class JdbcMemberRepository(
    private val repositoryRepository: InternalRepository
) : MemberRepository {
    override fun save(member: Member): Member {
        return wrapMemberRepositoryException {
            this.repositoryRepository.save(member)
        }
    }

    override fun findById(id: UUID): Member? {
        return wrapMemberRepositoryException {
            this.repositoryRepository.findById(id).orElse(null)
        }
    }

    override fun existsByUsername(username: String): Boolean {
        return wrapMemberRepositoryException {
            this.repositoryRepository.existsByUsername(username)
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private fun <RETURN> wrapMemberRepositoryException(function: () -> RETURN): RETURN {
        return try {
            function.invoke()
        } catch (exception: Exception) {
            LOGGER.debug("JdbcMemberRepository occurred exception - ${exception.message}")
            throw MemberRepositoryException(exception)
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}

internal interface InternalRepository : CrudRepository<Member, UUID> {
    fun existsByUsername(username: String): Boolean
}
