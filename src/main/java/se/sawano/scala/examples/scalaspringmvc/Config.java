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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.List;

@EnableWebMvc
@Configuration
public class Config extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        HashMap<String, HttpMessageConverter<?>> defaultConverters = getDefaultMessageConverters();
        MappingJacksonHttpMessageConverter scalaConverter =
                createJsonMessageConverterWithScalaSupport();
        defaultConverters.put(scalaConverter.getClass().toString(), scalaConverter);

        converters.addAll(defaultConverters.values());
    }

    private HashMap<String, HttpMessageConverter<?>> getDefaultMessageConverters() {
        RestTemplate dummyTemplate = new RestTemplate();
        HashMap<String, HttpMessageConverter<?>> defaultConverters = new HashMap<String, HttpMessageConverter<?>>();
        for (HttpMessageConverter<?> c : dummyTemplate.getMessageConverters()) {
            defaultConverters.put(c.getClass().toString(), c);
        }
        return defaultConverters;
    }

    private MappingJacksonHttpMessageConverter createJsonMessageConverterWithScalaSupport() {
        ObjectMapper mapper = createObjectMapper();
        mapper.registerModule(new DefaultScalaModule());
        MappingJacksonHttpMessageConverter converter = createJacksonMessageConverter();
        converter.setObjectMapper(mapper);
        return converter;
    }

    @Bean
    public MappingJacksonHttpMessageConverter createJacksonMessageConverter() {
        return new MappingJacksonHttpMessageConverter();
    }

    @Bean
    public ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }
}
