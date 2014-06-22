package adt

trait JsonConverter[-A] {
	def convertToJson(value: A): JsonValue
}

