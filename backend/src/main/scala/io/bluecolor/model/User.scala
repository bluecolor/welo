package io.bluecolor.model

import java.util.Date
import javax.persistence._
import org.hibernate.validator.constraints._
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.validation.constraints.{NotNull}
import com.fasterxml.jackson.annotation._
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import io.bluecolor.config.NumericBooleanSerializer
import Role._

@Entity(name="users")
class User {

  def this(id: Long) {
    this()
    this.id = id
  }

  @Id
  @GeneratedValue
  var id: Long = _

  @NotNull(message="error.username.notNull")
  @Column(unique = true)
  var username: String = _

  @JsonIgnore
  var password: String = _

  @NotNull(message="error.role.notNull")
  var role: String = Role.OPERATOR

  @NotNull(message="error.name.notNull")
  var name: String = _

  @Column(unique = true)
  @NotNull(message = "error.email.notNull")
  @Email(message="{error.email.valid}")
  var email: String = _

  @NotNull
  var system: Boolean = false

  @NotNull
  @JsonSerialize(using = classOf[NumericBooleanSerializer])
  var locked: Boolean = false

  @Column(columnDefinition = "varchar(max)")
  var options: String = _

  @Fetch(value= FetchMode.SELECT)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  @JsonIgnore
  var connections: java.util.Set[Connection] = new java.util.HashSet[Connection]

  @PrePersist @PreUpdate private def prepare = {
    username = if (username == null)  null else username.toLowerCase
    email = if (email == null)  null else email.toLowerCase
  }
}
