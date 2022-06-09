package com.odde.cucumber.step;

import com.odde.cucumber.Calculator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {
    @Autowired
    Calculator calculator;

    @When("add {int} and {int}")
    public void add(int a, int b) {
        calculator.add(a, b);
    }

    @Then("get {int}")
    public void get(int expected) {
        assertEquals(expected, calculator.getResult());
    }

    @When("subtract {int} from {int}")
    public void subtract(int a, int b) {
        calculator.subtract(b, a);
    }
}
