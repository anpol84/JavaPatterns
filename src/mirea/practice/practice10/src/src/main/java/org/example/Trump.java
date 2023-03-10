package org.example;

import org.springframework.stereotype.Component;

@Component
public class Trump implements Politician{
    @Override
    public void doPolitic() {
        System.out.println("Trump's politic");
    }
}
