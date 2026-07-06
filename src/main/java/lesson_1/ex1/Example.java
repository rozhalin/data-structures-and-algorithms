package lesson_1.ex1;

public class Example {

    public static Network matrixNet() {
        Network network = new Network(6);

        network.addConnection(0, 1, 1500d, 0.9d);
        network.addConnection(0, 2, 2000d, 0.1d);
        network.addConnection(0, 3, 1000d, 0.5d);
        network.addConnection(1, 5, 1500d, 0.6d);
        network.addConnection(2, 5, 500d, 0.2d);
        network.addConnection(2, 4, 900d, 0.05d);
        network.addConnection(3, 4, 2500d, 0.01d);
        network.addConnection(4, 5, 300d, 0.85d);

        return network;
    }

    public static void main(String... args){
        Network network = matrixNet();
        network.print();
    }
}
