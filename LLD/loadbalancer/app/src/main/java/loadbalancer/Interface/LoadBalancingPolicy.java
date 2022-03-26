package loadbalancer.Interface;

import loadbalancer.Domain.Server;

import java.util.List;

public interface LoadBalancingPolicy {
    Server assignServer(String request); // Ideally request is a request object sent by client
    void setServerList(List<Server> serverList);
}
