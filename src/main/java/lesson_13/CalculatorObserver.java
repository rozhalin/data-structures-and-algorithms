package lesson_13;

import lesson_9.Model;

public interface CalculatorObserver {
    void onModelChanged(Model model);
}
