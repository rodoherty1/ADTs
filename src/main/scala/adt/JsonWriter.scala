package adt

object JsonWriter {

    def write(value: JsonValue): String = {
        value match {
            case JsonObject(entries) => {
                val serialisedEntries = for {
                    (key, value) <- entries                    
                } yield key + ":" + write(value)
                
                "{" + (serialisedEntries mkString ", ") + "}"
            }
            
            case JsonArray(entries) => {
                val serialisedEntries = entries map write
                "{" + (serialisedEntries mkString ", ") + "}"
            }
            
            case JsonString(value) => "\"" + value + "\""
            
            case JsonNumber(value) => value.toString
            
            case JsonBoolean(value) => value.toString
            
            case JsonNull => "null"
        }
    }
    
    
    def write[A](value: A)(implicit conv: JsonConverter[A]): String = 
        write(conv.convertToJson(value))
}