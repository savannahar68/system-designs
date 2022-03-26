package loadbalancer.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class Loadbalancer {
    UUID id;
    List<Server> serverList;

    public Loadbalancer() {
        this.id = UUID.randomUUID();
    }
}
