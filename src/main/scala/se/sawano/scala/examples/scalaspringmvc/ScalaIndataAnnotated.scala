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
import javax.validation.constraints.{Min, NotNull}
import reflect.BeanProperty
import org.codehaus.jackson.annotate.JsonProperty
import annotation.target.beanGetter

/**
 * If we are using the Jackson Scala module we can remove the @JsonProperty annotations.
 * <p/>
 * You could also use @field instead of @beanGetter for JSR-303 to work.
 */
case class ScalaIndataAnnotated(@JsonProperty("name") @BeanProperty @(NotNull@beanGetter) val name: String,
  @JsonProperty("age") @BeanProperty @(Min@beanGetter)(1) val age: Integer)
