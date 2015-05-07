package controllers

import play.api.mvc._
import scala.collection.JavaConversions._

object Application extends Controller {

  def index = Action { req =>
    val props = System.getProperties

    Ok("Scala/Play app is ready" + "\n\n"
      + props.propertyNames.toList
        .sortBy(_.toString)
        .map( k => s"$k => ${props.getProperty(k.toString)}" )
        .reduce(_+"\n"+_)
      + "\nIP:" + req.remoteAddress
    )

  }

}