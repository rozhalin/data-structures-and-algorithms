package lesson_1.ex2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NodeNetwork {

    private final Map<String, Router> nodes;

    public NodeNetwork() {
        this.nodes = new HashMap<>();
    }

    public Router getOrCreateRouter(String id) {
        return nodes.computeIfAbsent(id, Router::new);
    }

    public void addConnection(String from, String to, Double bandwidth, Double loss) {
        Router routerFrom = getOrCreateRouter(from);
        Router routerTo = getOrCreateRouter(to);
        routerFrom.addConnection(routerTo, bandwidth, loss);
        routerTo.addConnection(routerFrom, bandwidth, loss);
    }

    public void print() {
        System.out.println("Сеть(ноды)");
        System.out.println("Число роутеров: " + nodes.size());

        List<String> sortedKeys = nodes.keySet().stream().sorted().toList();

        for (String id : sortedKeys) {
            Router router = nodes.get(id);

            System.out.printf("Роутер %s%n", id);
            Set<Connection> connections = router.getConnections();

            for (Connection connection : connections) {
                System.out.printf("\t-> сосед %s: пропускная способность=%.2f, потери=%.2f%n",
                        connection.getTargetId(), connection.getBandwidth(), connection.getLoss());
            }
            System.out.printf("\tКоличество соседей: %d%n", connections.size());
        }

        System.out.println("\nСписок всех связей:");
        for (String id : sortedKeys) {
            Router router = nodes.get(id);
            Set<Connection> connections = router.getConnections();

            for (Connection connection : connections) {
                if (id.compareTo(connection.getTargetId()) < 0) {
                    System.out.printf("Связь %s -- %s: пропускная способность=%.2f, потери=%.2f%n",
                            id, connection.getTargetId(), connection.getBandwidth(), connection.getLoss());
                }
            }
        }
    }
}
