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
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class ControllerTestIT {

    RestTemplate restTemplate;
    String baseUrl;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:9090/scala-spring-mvc/";
    }

    @Test
    public void javaPing() {
        String answer = restTemplate.getForObject(baseUrl + "java/ping",
                String.class, (Object) null);
        assertEquals("pong", answer);
    }

    @Test
    public void scalaPing() {
        String answer = restTemplate.getForObject(baseUrl + "scala/ping",
                String.class, (Object) null);
        assertEquals("pong", answer);
    }

    @Test
    public void javaScalaPing() {
        String answer = restTemplate.getForObject(baseUrl + "javascala/ping",
                String.class, (Object) null);
        assertEquals("pong", answer);
    }

    @Test
    public void scalaJavaPing() {
        String answer = restTemplate.getForObject(baseUrl + "scalajava/ping",
                String.class, (Object) null);
        assertEquals("pong", answer);
    }

}
