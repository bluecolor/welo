package io.bluecolor.controller

import java.util.Date
import java.text.SimpleDateFormat
import javax.servlet.http.HttpServletResponse


import javax.validation.Valid
import org.springframework.security.access.annotation.Secured
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation._
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.validation.annotation._

import io.bluecolor.model.Connection
import io.bluecolor.service.ConnectionService
import io.bluecolor.exception.UniqueConstraintViolationException

@RestController
@RequestMapping(Array("/api/v1/connections"))
class ConnectionController @Autowired()(private val connectionService: ConnectionService) {

  @RequestMapping(method = Array(RequestMethod.GET) )
  def findAll = connectionService.findAll

  @RequestMapping(method = Array(RequestMethod.POST))
  def create(@RequestBody connection: Connection) =
    connectionService.create(connection)

  @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.PUT))
  def update(@PathVariable("id") id: Long, @RequestBody connection: Connection) =
    connectionService.update(id, connection)

  @RequestMapping(value = Array("/test"), method = Array(RequestMethod.POST))
  def test(@RequestBody connection: Connection): Boolean =
    connectionService.test(connection)

  @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.DELETE))
  def delete(@PathVariable("id") id: Long) = connectionService.delete(id)

}
