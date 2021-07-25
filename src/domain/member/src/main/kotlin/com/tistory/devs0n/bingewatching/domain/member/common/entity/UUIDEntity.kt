package com.tistory.devs0n.bingewatching.domain.member.common.entity

import com.fasterxml.uuid.Generators
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

/**
 * If you want to know the reason why UUIDEntity should implement `org.springframework.data.domain.Persistable`
 *
 * See https://stackoverflow.com/questions/63153924/using-crudrepository-saveentity-to-insert-an-entity-with-predefined-id-field
 */
abstract class UUIDEntity : Persistable<String> {
    @Id
    @Column("id")
    private var id: String = Generators.timeBasedGenerator().generate().toString()
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

    // for `equality`
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UUIDEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
