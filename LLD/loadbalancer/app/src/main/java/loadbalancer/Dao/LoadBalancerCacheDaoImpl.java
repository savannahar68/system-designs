package loadbalancer.Dao;

import loadbalancer.Interface.LoadBalancerCacheDao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoadBalancerCacheDaoImpl implements LoadBalancerCacheDao {
    Map<String, UUID> cache;

    public LoadBalancerCacheDaoImpl() {
        cache = new HashMap<>();
    }

    @Override
    public UUID get(String client) {
        return cache.get(client);
    }

    @Override
    public void put(String client, UUID server) {
        cache.put(client, server);
    }
}
