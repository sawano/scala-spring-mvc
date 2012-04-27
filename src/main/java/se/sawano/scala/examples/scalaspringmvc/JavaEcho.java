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

package se.sawano.scala.examples.scalaspringmvc;

import org.codehaus.jackson.annotate.JsonProperty;

public class JavaEcho {

    private final String name;
    private final String weekDay;


    public JavaEcho(@JsonProperty("name") String name, @JsonProperty("weekDay") String weekDay) {
        this.name = name;
        this.weekDay = weekDay;
    }

    public String getName() {
        return name;
    }

    public String getWeekDay() {
        return weekDay;
    }

    @Override
    public String toString() {
        return "JavaEcho{ name='" + name + "\', weekDay='" + weekDay + "\'}";
    }
}
