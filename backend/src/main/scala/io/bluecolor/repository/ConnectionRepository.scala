package io.bluecolor.repository


import org.springframework.data.jpa.repository._
import org.springframework.stereotype.Repository
import org.springframework.data.repository.query.Param

import io.bluecolor.model.{Connection, User}

@Repository
trait ConnectionRepository extends JpaRepository[Connection, java.lang.Long] {
}
