package lesson_1.ex2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Router {

    private final String id;
    private final Set<Connection> connections;

    public Router(String id) {
        this.id = id;
        this.connections = new HashSet<>();
    }

    public void addConnection(Router target, Double bandwidth, Double loss) {
        this.connections.add(new Connection(target.getId(), bandwidth, loss));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Router router)) return false;
        return Objects.equals(id, router.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public Set<Connection> getConnections() {
        return this.connections;
    }
}
