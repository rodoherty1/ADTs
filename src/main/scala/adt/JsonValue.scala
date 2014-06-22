package adt

sealed trait JsonValue

case class JsonObject (entries: Map[String, JsonValue]) extends JsonValue
case class JsonArray (values: Seq[JsonValue]) extends JsonValue
case class JsonString (value: String) extends JsonValue
case class JsonNumber (value: BigDecimal) extends JsonValue
case class JsonBoolean (value: Boolean) extends JsonValue
case object JsonNull extends JsonValue
