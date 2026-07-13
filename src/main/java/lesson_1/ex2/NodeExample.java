package lesson_1.ex2;

public class NodeExample {
    public static NodeNetwork nodesNet() {
        NodeNetwork nodeNetwork = new NodeNetwork();

        nodeNetwork.addConnection("A", "B", 1500d, 0.9);
        nodeNetwork.addConnection("A", "C", 2000d, 0.1);
        nodeNetwork.addConnection("A", "D", 1000d, 0.5);
        nodeNetwork.addConnection("B", "F", 1500d, 0.6);
        nodeNetwork.addConnection("C", "F", 500d, 0.2);
        nodeNetwork.addConnection("C", "E", 900d, 0.05);
        nodeNetwork.addConnection("D", "E", 2500d, 0.01);
        nodeNetwork.addConnection("E", "F", 300d, 0.85);

        return nodeNetwork;
    }

    public static void main(String... args) {
        NodeNetwork nodeNetwork = nodesNet();
        nodeNetwork.print();
    }
}
