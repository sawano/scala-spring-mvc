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

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class JavaControllerTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    JavaController controller;

    @Before
    public void setUp() throws Exception {
        controller = new JavaController();
    }

    @Test
    public void pingShouldReturnPong() throws Exception {
        String answer = controller.ping();
        assertEquals("pong", answer);
    }

    @Test
    public void echoShouldEchoNameAndWeekDay() throws Exception {
        String weekDay = new SimpleDateFormat("E").format(new Date());
        JavaEcho echo = controller.echo("Daniel");

        logger.debug("Echos is: {}", echo);
        assertEquals("Daniel", echo.getName());
        assertEquals(weekDay, echo.getWeekDay());
    }
}
