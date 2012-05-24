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
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ValidationTestIT {

    Logger logger = LoggerFactory.getLogger(getClass());

    RestTemplate restTemplate;
    String baseUrl;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:9090/scala-spring-mvc/";
    }

    @Test
    public void javaPost() {
        JavaIndata indata = new JavaIndata("Daniel", 1);
        restTemplate.postForObject(baseUrl + "java/indata", indata, Void.class, (Object) null);
    }

    @Test
    public void javaPostWithInvalidAge() {
        try {
            JavaIndata indata = new JavaIndata("Daniel", -1);
            restTemplate.postForObject(baseUrl + "java/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void javaPostWithMissingName() {
        try {
            JavaIndata indata = new JavaIndata(null, 1);
            restTemplate.postForObject(baseUrl + "java/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void scalaJavaPost() {
        JavaIndata indata = new JavaIndata("Daniel", 1);
        restTemplate.postForObject(baseUrl + "scalajava/indata", indata, Void.class, (Object) null);
    }

    @Test
    public void scalaJavaPostWithInvalidAge() {
        try {
            JavaIndata indata = new JavaIndata("Daniel", -1);
            restTemplate.postForObject(baseUrl + "scalajava/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void scalaJavaPostWithMissingName() {
        try {
            JavaIndata indata = new JavaIndata(null, 1);
            restTemplate.postForObject(baseUrl + "scalajava/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void scalaPost() {
        ScalaIndata indata = new ScalaIndata("Daniel", 1);
        restTemplate.postForObject(baseUrl + "scala/indata", indata, Void.class, (Object) null);
    }

    @Test
    public void scalaPostWithInvalidAge() {
        try {
            ScalaIndata indata = new ScalaIndata("Daniel", -1);
            restTemplate.postForObject(baseUrl + "scala/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void scalaPostWithMissingName() {
        try {
            ScalaIndata indata = new ScalaIndata(null, 1);
            restTemplate.postForObject(baseUrl + "scala/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void scalaPostAnnotated() {
        ScalaIndataAnnotated indata = new ScalaIndataAnnotated("Daniel", 1);
        restTemplate.postForObject(baseUrl + "scala/indataannotated", indata, Void.class, (Object) null);
    }

    @Test
    public void scalaPostAnnotatedWithInvalidAge() {
        try {
            ScalaIndataAnnotated indata = new ScalaIndataAnnotated("Daniel", -1);
            restTemplate.postForObject(baseUrl + "scala/indataannotated", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void scalaPostAnnotatedWithMissingName() {
        try {
            ScalaIndataAnnotated indata = new ScalaIndataAnnotated(null, 1);
            restTemplate.postForObject(baseUrl + "scala/indataannotated", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void javaScalaPost() {
        ScalaIndata indata = new ScalaIndata("Daniel", 1);
        restTemplate.postForObject(baseUrl + "javascala/indata", indata, Void.class, (Object) null);
    }

    @Test
    public void javaScalaPostWithInvalidAge() {
        try {
            ScalaIndata indata = new ScalaIndata("Daniel", -1);
            restTemplate.postForObject(baseUrl + "javascala/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

    @Test
    public void javaScalaPostWithMissingName() {
        try {
            JavaIndata indata = new JavaIndata(null, 1);
            restTemplate.postForObject(baseUrl + "javascala/indata", indata, Void.class, (Object) null);
            fail("Expected JSR-303 validation to fail");
        }
        catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }
}
