package com.github.daggerok.impl.ru;

import com.github.daggerok.api.Greeting;

import static java.lang.String.format;

public class RussianGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return format("Привет, %s!", name);
    }
}
