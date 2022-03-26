package loadbalancer.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Server {
    UUID id;
    String name;
    Boolean health;
    Integer capacity;

    public Server(String name, Integer capacity) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.health = true;
        this.capacity = capacity; // for weighted load balancer
    }

    public String work() throws InterruptedException {
        System.out.printf("Server : %s doing work", this.name);
        System.out.println();
        Thread.sleep(1000);
        return this.id + " DONE!";
    }
}
