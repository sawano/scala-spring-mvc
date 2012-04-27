/*
 * Copyright 2012 Daniel Sawano
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package se.sawano.scala.examples.scalaspringmvc

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import java.text.SimpleDateFormat
import java.util.Date
import org.slf4j.LoggerFactory

@RunWith(classOf[JUnitRunner])
class ScalaControllerSpecTest extends Specification {

  val logger = LoggerFactory.getLogger(getClass)

  "Calling ScalaController.ping" should {
    "return pong" in {
      new ScalaController().ping() must be equalTo "pong"
    }
  }

  "Calling ScalController.echo" should {
    "echo name and week day" in {
      val weekDay = new SimpleDateFormat("E").format(new Date());
      val echo: ScalaEcho = new ScalaController().echo("Daniel")
      echo.name must be equalTo "Daniel"
      echo.weekDay must be equalTo weekDay

      logger.debug("ScalEcho was: {}", echo)
      success
    }
  }

}
