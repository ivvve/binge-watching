package com.tistory.devs0n.bingewatching.domain.member.common.entity

import com.fasterxml.uuid.Generators
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime
import java.util.*

/**
 * If you want to know the reason why UUIDEntity should implement `org.springframework.data.domain.Persistable`
 *
 * See https://stackoverflow.com/questions/63153924/using-crudrepository-saveentity-to-insert-an-entity-with-predefined-id-field
 */
abstract class UUIDEntity : Persistable<UUID> {
    @Id
    @Column("id")
    private var id: UUID = Generators.timeBasedGenerator().generate()
        private set // use implicit setter for Spring Data ORM

    @CreatedDate
    @Column("created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
        private set

    @LastModifiedDate
    @Column("updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
        private set

    // for `Persistable`
    @Transient
    protected var new = false
    override fun getId() = this.id
    override fun isNew() = this.new
}
