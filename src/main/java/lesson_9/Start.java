package lesson_9;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Start {
    public static void main(String[] args) throws Exception {
        /*OperationMaker maker = new OperationMaker();
        maker.datareader = new DataReader();
        maker.printer = new Printer();
        maker.operations.put("+", new MinusOperation());
        maker.operations.put("-", new PlusOperation());
        maker.make();*/

        Register register = new Register();
        register.reg(Supplier.class, new DataReader());
        register.reg(Consumer.class, new Printer());

        Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
        operations.put("-", new MinusOperation());
        operations.put("+", new PlusOperation());

        register.reg(Map.class, operations);

        OperationMaker maker = new OperationMaker(register);
        maker.make();
    }
}
