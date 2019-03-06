package com.github.daggerok.impl.ua;

import com.github.daggerok.api.Greeting;

import static java.lang.String.format;

public class UkrainianGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return format("Привiт, %s!", name);
    }
}
