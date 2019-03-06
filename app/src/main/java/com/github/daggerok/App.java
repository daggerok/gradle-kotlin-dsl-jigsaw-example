package com.github.daggerok;

import com.github.daggerok.api.Greeting;
import com.github.daggerok.impl.en.EnglishGreeting;
import com.github.daggerok.impl.ru.RussianGreeting;
import com.github.daggerok.impl.sp.SpainishGreeting;
import com.github.daggerok.impl.ua.UkrainianGreeting;
import io.vavr.control.Try;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map.of(EnglishGreeting.class, "Max",
                RussianGreeting.class, "Максим",
                SpainishGreeting.class, "Maximilian",
                UkrainianGreeting.class, "Максим")
           .forEach((type, name) -> {
            Greeting greeting = Try.of(type::getConstructor)
                    .map(constructor -> Try.of(constructor::newInstance)
                                           .getOrElseGet(throwable -> null))
                    .getOrElseGet(throwable -> null);
            System.out.println("greeting: " + greeting.greet(name));
        });
    }
}
