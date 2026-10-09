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
    public double calc(List<Item> items, String type) {
        double s = 0;
        for (Item i : items) {
            s += i.getPrice() * i.getQuantity();
        }

        if (type.equals("VIP")) {
            s = s * 0.9;
        }

        if (type.equals("NEW")) {
            s = s * 0.95;
        }

        if (s > 1000) {
            s = s - 50;
        }

        return s;
    }
}
