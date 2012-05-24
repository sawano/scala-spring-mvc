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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java controller using Scala classes.
 *
 * @author Daniel Sawano
 */
@RequestMapping("/javascala")
@Controller
public class JavaScalaController {

    private static final Logger logger = LoggerFactory.getLogger(JavaScalaController.class);

    @RequestMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

    @RequestMapping("/echo")
    @ResponseBody
    public ScalaEcho echo(@RequestParam String name) {
        return new ScalaEcho(name, getWeekDay());
    }

    String getWeekDay() {
        return new SimpleDateFormat("E").format(new Date());
    }

    @RequestMapping(value = "/indata", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void receiveData(@RequestBody @Valid ScalaIndata indata) {
        logger.debug("Got valid POSTed data: {}", indata);
    }

}
