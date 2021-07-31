package com.tistory.devs0n.domain.content.config

import com.tistory.devs0n.domain.content.DomainContentModule
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories(basePackageClasses = [DomainContentModule::class])
@EnableMongoAuditing
class MongoDBConfiguration
// TODO fill mongodb configuration
