package fx

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods._

import scala.concurrent.ExecutionContext

class AsyncRest {
  private implicit val ec = ExecutionContext.global
  private implicit lazy val formats = DefaultFormats

  def joke: String = {
    "" // TODO: Implement Play-WS API call.
  }

  private def parseJson(json: String): String = {
    val ast = parse(json)
    (ast \ "value" \ "joke").extract[String]
  }
}

/*
{ "type": "success",
  "value": { "id": 111,
             "joke": "Chuck Norris has a deep and abiding respect for human life... unless it gets in his way.",
             "categories": []
           }
}

JObject(List((type, JString(success)),
             (value, JObject(List((id, JInt(174)),
                                 (joke, JString(Chuck Norris cannot love, he can only not kill.)),
                                 (categories, JArray(List)))))))
 */