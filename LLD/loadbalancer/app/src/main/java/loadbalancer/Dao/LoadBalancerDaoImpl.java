package loadbalancer.Dao;

import loadbalancer.Domain.Server;
import loadbalancer.Interface.LoadBalancerDao;
import lombok.Getter;

import java.util.*;

public class LoadBalancerDaoImpl implements LoadBalancerDao {

    @Getter
    Map<UUID, Server> cache;

    public LoadBalancerDaoImpl() {
        cache = new HashMap<>();
    }

    @Override
    public Server get(UUID id) {
        return cache.get(id);
    }

    @Override
    public void put(Server server) {
        cache.put(server.getId(), server);
    }

    @Override
    public void remove(Server server) {
        cache.remove(server.getId());
    }

    public Collection<Server> getServerList() { return new ArrayList<>(cache.values()); }
}
