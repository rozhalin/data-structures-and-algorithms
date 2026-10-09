package lesson_14;

import java.util.List;

public class OrderService {

    /**
     * Возвращает итоговую сумму цен предметов из списка с учётом скидки по типу заказа.
     * <p>
     * Скидка применяется согласно бизнес-правилам:
     * <ul>
     *   <li>тип {@code "VIP"} — скидка 10%</li>
     *   <li>тип {@code "NEW"} — скидка 5%</li>
     * </ul>
     * Если тип не соответствует ни одному из допустимых значений, скидка не применяется.
     * </p>
     *
     * @param items список предметов; не должен быть null, элементы не должны быть null
     * @param type тип заказа; допустимые значения: {@code "VIP"}, {@code "NEW"}
     * @return сумма цен всех предметов с учетом применимой скидки
     */
    public static double calc(List<Item> items, Type type) {
        double sum = 0;
        for (Item i : items) {
            sum += i.getPrice() * i.getQuantity();
        }

        sum = sum * (1. - type.getDiscount());

        if (sum > 1000) {
            sum = sum - 50;
        }

        return sum;
    }
}
