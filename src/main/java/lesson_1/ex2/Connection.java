package lesson_1.ex2;

public class Connection {

    private final String targetId;
    private final Double bandwidth;
    private final Double loss;

    public Connection(String targetId, Double bandwidth, Double loss) {
        this.targetId = targetId;
        if (bandwidth.compareTo(0.0d) < 0 ) throw new IllegalArgumentException("Некорректная мощность");
        this.bandwidth = bandwidth;

        if (loss.compareTo(0.0d) < 0 || loss.compareTo(1.0d) >= 1) throw new IllegalArgumentException("Некорректные потери");
        this.loss = loss;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public Double getBandwidth() {
        return bandwidth;
    }

    public Double getLoss() {
        return loss;
    }
}
