package com.github.daggerok.impl.en;

import com.github.daggerok.api.Greeting;

import static java.lang.String.format;

public class EnglishGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return format("Hello, %s!", name);
    }
}
