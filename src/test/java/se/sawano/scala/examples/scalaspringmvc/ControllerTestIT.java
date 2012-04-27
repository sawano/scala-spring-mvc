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

import com.fasterxml.jackson.module.scala.DefaultScalaModule;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ControllerTestIT {

    Logger logger = LoggerFactory.getLogger(getClass());

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
    
    @Test
    public void javaEcho() {
        String weekDay = new SimpleDateFormat("E").format(new Date());

        JavaEcho echo = restTemplate.getForObject(baseUrl
                + "java/echo?name={name}", JavaEcho.class, "Daniel");

        assertEquals("Daniel", echo.getName());
        assertEquals(weekDay, echo.getWeekDay());
    }

    @Test
    public void scalaEcho() {
        String weekDay = new SimpleDateFormat("E").format(new Date());

        ScalaEcho echo = createScalaTemplate().getForObject(
                baseUrl + "scala/echo?name={name}", ScalaEcho.class, "Daniel");

        assertEquals("Daniel", echo.name());
        assertEquals(weekDay, echo.weekDay());
    }

    @Test
    public void javaScalaEchoString() {
        String weekDay = new SimpleDateFormat("E").format(new Date());

        String echo = restTemplate.getForObject(baseUrl
                + "javascala/echo?name={name}", String.class, "Daniel");

        System.out.println(echo);
    }

    @Test
    public void javaScalaEcho() {
        String weekDay = new SimpleDateFormat("E").format(new Date());

        ScalaEcho echo = createScalaTemplate().getForObject(
                baseUrl + "javascala/echo?name={name}", ScalaEcho.class,
                "Daniel");

        assertEquals("Daniel", echo.name());
        assertEquals(weekDay, echo.weekDay());
    }

    @Test
    public void scalaJavaEcho() {
        String weekDay = new SimpleDateFormat("E").format(new Date());

        JavaEcho echo = restTemplate.getForObject(baseUrl
                + "scalajava/echo?name={name}", JavaEcho.class, "Daniel");

        assertEquals("Daniel", echo.getName());
        assertEquals(weekDay, echo.getWeekDay());
    }

    RestTemplate createScalaTemplate() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new DefaultScalaModule());
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        converter.setObjectMapper(mapper);
        ArrayList<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(converter);
        RestTemplate scalaTemplate = new RestTemplate();
        scalaTemplate.setMessageConverters(converters);

        return scalaTemplate;
    }
}
