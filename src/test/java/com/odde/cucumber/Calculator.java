package com.odde.cucumber;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private int result;

    public void add(int a, int b){
        result = a + b;
    }

    public int getResult() {
        return result;
    }

    public void subtract(int a, int b) {
        result = a - b;
    }
}
