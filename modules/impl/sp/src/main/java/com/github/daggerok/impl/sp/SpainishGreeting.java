package com.github.daggerok.impl.sp;

import com.github.daggerok.api.Greeting;

import static java.lang.String.format;

public class SpainishGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return format("Hola, %s!", name);
    }
}
