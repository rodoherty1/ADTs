package adt

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class JsonWriterTest extends WordSpec with ShouldMatchers {

    trait fixture {
    	implicit val expressionJsonConverter = new ExpressionJsonConverter()
    }
    
    "JsonWriter" should {
        "Write Number(1) as 1" in {
            new fixture {
            	JsonWriter.write (Number(1)) should be ("1")
            }
        }
        
        "Write Plus(Number(1), Number(2)) as {op:\"+\", lhs:1, rhs:2}" in {
            new fixture {
            	JsonWriter.write (Plus(Number(1), Number(2))) should be ("{op:\"+\", lhs:1, rhs:2}")
            }
        }

        "Write Minus(Number(3), Number(2)) as {op:\"-\", lhs:3, rhs:2}" in {
            new fixture {
            	JsonWriter.write (Minus(Number(3), Number(2))) should be ("{op:\"-\", lhs:3, rhs:2}")
            }
        }

        "Write Plus(Number(1), Minus(Number(3), Number(2))) as {op:\"+\", lhs:1, rhs:{op:\"-\", lhs:3, rhs:2}}" in {
            new fixture {
            	JsonWriter.write (Plus(Number(1), Minus(Number(3), Number(2)))) should be ("{op:\"+\", lhs:1, rhs:{op:\"-\", lhs:3, rhs:2}}")
            }
        }
    }
}