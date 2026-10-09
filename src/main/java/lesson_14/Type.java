package lesson_14;

public enum Type {

    VIP(0.1),
    NEW(0.05),
    COMMON(0.00);

    private final double discount;

    Type(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return this.discount;
    }
}
