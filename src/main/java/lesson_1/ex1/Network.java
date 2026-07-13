package lesson_1.ex1;

public class Network {

    private final int routerCount;
    private final double[][] bandwidth;
    private final double[][] loss;

    public Network(int routerCount) {
        this.routerCount = routerCount;
        this.bandwidth = new double[routerCount][routerCount];
        this.loss = new double[routerCount][routerCount];

        for (int i = 0; i < routerCount; i++) {
            for (int j = 0; j < routerCount; j++) {
                bandwidth[i][j] = -1.0d;
                loss[i][j] = -1.0d;
            }
        }
    }

    public void addConnection(int from, int to, double bandwidth, double loss) {
        if (from < 0 || from >= this.routerCount || to < 0 || to >= this.routerCount) {
            throw new IllegalArgumentException("Некорректный роутер");
        }

        this.bandwidth[from][to] = bandwidth;
        this.loss[from][to] = loss;
        this.bandwidth[to][from] = bandwidth;
        this.loss[to][from] = loss;
    }

    public void print() {
        System.out.println("Сеть(матрица)");
        System.out.printf("Число роутеров: %d:%n\n", this.routerCount);

        for (int i = 0; i < this.routerCount; i++) {
            System.out.printf("Роутер %d:%n", i);
            int neighborCount = 0;
            for (int j = 0; j < this.routerCount; j++) {
                if (bandwidth[i][j] >= 0.0d) {
                    neighborCount++;
                    System.out.printf("\t-> сосед %d: пропускная способность=%.2f, потери=%.2f%n",
                            j, bandwidth[i][j], loss[i][j]);
                }
            }
            System.out.printf("\tКоличество соседей: %d%n", neighborCount);
        }

        System.out.println("\nСписок всех связей:");
        for (int i = 0; i < this.routerCount; i++) {
            for (int j = i + 1; j < this.routerCount; j++) {
                if (bandwidth[i][j] >= 0.0d) {
                    System.out.printf("Связь %d -- %d: пропускная способность=%.2f, потери=%.2f%n",
                            i, j, bandwidth[i][j], loss[i][j]);
                }
            }
        }
    }
}
