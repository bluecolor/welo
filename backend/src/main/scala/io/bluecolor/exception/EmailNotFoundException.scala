package io.bluecolor.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
case class EmailNotFoundException(email: String) extends
  RuntimeException(s"""Mail address "${email}" not found""") {
}
