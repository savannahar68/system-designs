package loadbalancer.Interface;

import loadbalancer.Domain.Server;

import java.util.Collection;
import java.util.UUID;

public interface LoadBalancerDao {
    Server get(UUID id);
    void put(Server server);
    void remove(Server server);
    Collection<Server> getServerList();
}
