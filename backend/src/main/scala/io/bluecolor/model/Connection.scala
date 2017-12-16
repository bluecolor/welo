package io.bluecolor.model

import java.util.Date
import javax.persistence._
import org.hibernate.validator.constraints._
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.validation.constraints.{NotNull}
import com.fasterxml.jackson.annotation._
import com.fasterxml.jackson.databind.annotation.JsonSerialize


@Entity(name="connections")
class Connection {

  def this(id: Long) {
    this()
    this.id = id
  }

  @Id
  @GeneratedValue
  var id: Long = _

  @Column(unique = true)
  @NotNull(message="Connection name can not be empty")
  var name: String = _

  @NotNull(message="JDBC URL can not be empty")
  var jdbcUrl: String = _

  var username: String = _

  var password: String = _

}

