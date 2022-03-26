package loadbalancer.Interface;

import loadbalancer.Domain.Server;

public interface LoadBalancerService {
    Object get(String client, Object path);
    Object post(String client, Object path);
    Object update(String client, Object path);
    Object delete(String client, Object path);
    void addServer(Server server);
    void deleteServer(Server server);
}
