package lesson_9;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OperationMaker {
    Supplier<Model> datareader;
    Consumer<Model> printer;
    Map<String, BinaryOperator<Integer>> operations;

    public OperationMaker(Register register) {
        loadDependencies(register);
    }

    private void loadDependencies(Register register) {
        this.datareader = register.lookUp(Supplier.class);
        this.printer = register.lookUp(Consumer.class);
        this.operations = register.lookUp(Map.class);
    }

    public void make() {
        Model model = datareader.get();
        model.res = operations
                .get(model.op)
                .apply(model.x, model.y);
        printer.accept(model);
    }
}
