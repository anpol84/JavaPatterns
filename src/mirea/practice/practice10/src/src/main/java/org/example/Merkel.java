package org.example;

import org.springframework.stereotype.Component;

@Component
public class Merkel implements Politician{
    @Override
    public void doPolitic() {
        System.out.println("Merkel's politic");
    }
}
