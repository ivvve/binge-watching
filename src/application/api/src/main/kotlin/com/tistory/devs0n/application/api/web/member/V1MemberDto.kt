package com.tistory.devs0n.application.api.web.member

import com.tistory.devs0n.bingewatching.domain.member.core.application.command.JoinNewMemberCommand
import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member

class V1MemberDto {
    class JoinNewMember {
        data class Request(
            val username: String
        ) {
            fun toCommand(): JoinNewMemberCommand {
                return JoinNewMemberCommand(username = this.username)
            }
        }

        data class Response(
            val id: String,
            val username: String,
        ) {
            companion object {
                fun of(member: Member): Response {
                    return Response(
                        id = member.id,
                        username = member.username,
                    )
                }
            }
        }
    }
}
