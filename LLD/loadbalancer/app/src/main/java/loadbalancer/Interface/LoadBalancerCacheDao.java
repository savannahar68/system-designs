package loadbalancer.Interface;

import java.util.UUID;

public interface LoadBalancerCacheDao {
    UUID get(String client);
    void put(String client, UUID server);
}
