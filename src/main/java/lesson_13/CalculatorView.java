package lesson_13;

import lesson_9.Model;

import java.util.Scanner;

public class CalculatorView implements CalculatorObserver {

    private final CalculatorViewModel viewModel;

    public CalculatorView(CalculatorViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.addObserver(this);
    }

    @Override
    public void onModelChanged(Model model) {
        System.out.printf("%d %s %d = %s", model.getX(), model.getOp(), model.getY(), model.getRes());
    }

    public void apply() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите оператор: ");
        String op = scanner.next();
        System.out.print("Введите x: ");
        int x = scanner.nextInt();
        System.out.print("Введите y: ");
        int y = scanner.nextInt();

        viewModel.setInput(x, y, op);
    }
}
