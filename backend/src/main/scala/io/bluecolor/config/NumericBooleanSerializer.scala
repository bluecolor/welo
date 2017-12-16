package io.bluecolor.config

import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider


class NumericBooleanSerializer extends JsonSerializer[java.lang.Boolean] {

  override def serialize(b: java.lang.Boolean,
                         jsonGenerator: JsonGenerator,
                         serializerProvider: SerializerProvider): Unit = {
    jsonGenerator.writeNumber(if (b) 1 else 0)
  }

}
