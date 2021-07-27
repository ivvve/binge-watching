package com.tistory.devs0n.application.api.web.member

import com.tistory.devs0n.bingewatching.domain.member.core.application.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/members")
class V1MemberController(
    private val memberService: MemberService,
) {
    @PostMapping
    fun joinNewMember(request: V1MemberDto.JoinNewMember.Request): ResponseEntity<V1MemberDto.JoinNewMember.Response> {
        val member = this.memberService.joinNewMember(request.toCommand())
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(V1MemberDto.JoinNewMember.Response.of(member))
    }
}
