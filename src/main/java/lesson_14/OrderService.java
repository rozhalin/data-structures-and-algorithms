package lesson_14;

import java.util.List;

public class OrderService {

    /**
     * Возвращает итоговую сумму цен предметов из списка с учётом скидки по типу заказа.
     * <p>
     * Скидка определяется типом заказа ({@link Type}):
     * <ul>
     *    <li>{@link Type#VIP} — 10%</li>
     *    <li>{@link Type#NEW} — 5%</li>
     *   <li>{@link Type#COMMON} — без скидки</li>
     *   </ul>
     * </p>
     * Дополнительно применяются следующие правила:
     *  <ul>
     *    <li>Если в заказе более 10 предметов, к базовой скидке добавляется +1%.</li>
     *    <li>Если итоговая сумма (после применения скидок) превышает 1000, из неё вычитается фиксированная сумма 50.</li>
     *  </ul>
     *  </p>
     *
     * @param items список предметов; не должен быть null, элементы не должны быть null
     * @param type тип заказа; определяет базовую скидку согласно {@link Type}
     * @return сумма цен всех предметов с учетом примененной скидки
     */
    public static double calc(List<Item> items, Type type) {
        double sum = 0;
        for (Item i : items) {
            sum += i.getPrice() * i.getQuantity();
        }

        double discount = type.getDiscount();

        if (items.size() > 10) {
            discount += 0.01;
        }

        sum = sum * (1. - discount);

        if (sum > 1000) {
            sum = sum - 50;
        }

        return sum;
    }
}
