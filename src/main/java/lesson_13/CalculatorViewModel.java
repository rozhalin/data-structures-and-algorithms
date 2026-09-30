package lesson_13;

import lesson_9.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class CalculatorViewModel {

    private final Model model = new Model();
    private final Map<String, BinaryOperator<Integer>> operations;

    private final List<CalculatorObserver> observers = new ArrayList<>();

    public CalculatorViewModel(Map<String, BinaryOperator<Integer>> operations) {
        this.operations = operations;
    }

    public void addObserver(CalculatorObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(CalculatorObserver observer) {
        this.observers.remove(observer);
    }

    public void setInput(int x, int y, String op) {
        this.model.setX(x);
        this.model.setY(y);
        this.model.setOp(op);
        calculate();
    }

    private void calculate() {
        BinaryOperator<Integer> operation = operations.get(this.model.getOp());
        if (operation != null) {
            model.setRes(operation.apply(this.model.getX(), this.model.getY()));
        } else {
            throw new ArithmeticException("Неизвестный оператор");
        }
        notifyObservers();
    }

    private void notifyObservers() {
        for (CalculatorObserver observer : this.observers) {
            observer.onModelChanged(this.model);
        }
    }
}
