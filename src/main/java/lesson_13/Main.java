package lesson_13;

import lesson_9.MinusOperation;
import lesson_9.PlusOperation;
import lesson_9.Register;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        Register register = new Register();

        Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
        operations.put("+", new PlusOperation());
        operations.put("-", new MinusOperation());

        register.reg(Map.class, operations);

        CalculatorViewModel viewModel = new CalculatorViewModel(operations);
        CalculatorView view = new CalculatorView(viewModel);

        view.apply();
    }
}
