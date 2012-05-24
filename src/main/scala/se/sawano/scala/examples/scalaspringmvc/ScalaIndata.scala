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

import java.lang.Integer
import javax.validation.constraints.{NotNull, Min}

/**
 * If we are not using the Jackson Scala module we need to add the JSON annotations just as we did with
 * the immutable POJO.
 */
case class ScalaIndata(val name: String, val age: Integer) {

  @NotNull
  def getName() = name

  @Min(1)
  def getAge() = age
}
