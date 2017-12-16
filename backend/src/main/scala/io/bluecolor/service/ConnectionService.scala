package io.bluecolor.service

import scala.collection.JavaConversions._
import scala.annotation.meta.setter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import com.fasterxml.jackson.databind.ObjectMapper

import io.bluecolor.repository.ConnectionRepository
import io.bluecolor.model.{Connection, User}
import io.bluecolor.exception._

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles



@Service
@Transactional
class ConnectionService @Autowired()(val connectionRepository: ConnectionRepository){

  @(Autowired @setter)
  private var userService: UserService = _

  private val log:Logger  = LoggerFactory.getLogger(MethodHandles.lookup.lookupClass)

  def findAll = connectionRepository.findAll

  def findOne(id: Long) = connectionRepository.findOne(id)

  def test (connection: Connection) = {
    true
  }


  def create(connection: Connection): Connection =
    connectionRepository.save(connection)

  def update(id: Long, connection: Connection) = {
    con.name = connection.name
    con.jdbcUrl = connection.jdbcUrl
    con.username = connection.username
    con.password = connection.password
    connectionRepository.save(con)
  }

  def delete(id: Long): Connection = {
    val connection = connectionRepository.findOne(id);
    connectionRepository.delete(id)
    connection
  }

}
