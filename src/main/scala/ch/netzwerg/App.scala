package ch.netzwerg

import org.scalajs.dom.document
import upickle.default._

import scala.scalajs.js

object App extends js.JSApp {

  case class Demo(variables: Seq[Variable])

  case class Variable(name: String, `type`: String, value: VariableValue)

  class VariableValue(val value: String)

  object VariableValue {

    def apply(value: String): VariableValue = new VariableValue(value)

    def unapply(variableValue: VariableValue): Option[String] = Some(variableValue.value)

    implicit val variableValueReader = upickle.default.Reader[VariableValue] {
      case v => new VariableValue(v.toString)
    }

  }

  @scala.scalajs.js.annotation.JSExport
  override def main(): Unit = {

    val json =
      """{
      "variables": [
      {
        "name": "one",
        "type": "string",
        "value": "kermit"
      },
      {
        "name": "two",
        "type": "long",
        "value": 42
      },
      {
        "name": "three",
        "type": "boolean",
        "value": true
      }
      ]
    }"""

    try {
      val result = read[Demo](json).variables.mkString
      document.getElementById("root").innerHTML = "Result: " + result
    } catch {
      case t: Throwable =>
        document.getElementById("root").innerHTML = "Error: " + t
        t.printStackTrace()
    }

  }

}
