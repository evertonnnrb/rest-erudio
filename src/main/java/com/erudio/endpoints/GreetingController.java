package com.erudio.endpoints;

import com.erudio.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s !";
    private final AtomicLong iALong = new AtomicLong(1L);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")
                             String name) {
        return new Greeting(iALong.incrementAndGet(), String.format(template, name));
    }

}
