package com.tistory.devs0n.bingewatching.domain.member.core.infrastructure

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.init.ScriptUtils
import javax.sql.DataSource

/**
 * Spring Data JDBC Member 테스트 시 공통 설정을 처리하는 class
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJdbcTest(
    includeFilters = [
        ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = [DataJdbcMemberRepository::class])
    ]
)
class MemberDataJdbcTestInitializer {
    @Autowired
    lateinit var memberDataSource: DataSource

    @BeforeAll
    fun beforeAll() {
        this.migrateMemberSchemaOnce()
    }

    /**
     * Member Schema migration을 오직 1회만 실행하도록한다.
     *
     * @return 메서드 호출 후 migration이 되었는지를 나타내는 Boolean 값
     */
    private fun migrateMemberSchemaOnce(): Boolean {
        if (executed) {
            return false
        }

        this.memberDataSource.connection.use {
            ScriptUtils.executeSqlScript(it, ClassPathResource("migrations/V1.sql"))
        }
        executed = true
        return true
    }

    companion object {
        private var executed = false
    }
}
