package loadbalancer.Strategy;

import loadbalancer.Domain.Server;
import loadbalancer.Interface.LoadBalancingPolicy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinLbPolicy implements LoadBalancingPolicy {

    @Getter
    List<Server> serverList;
    Integer index;

    public RoundRobinLbPolicy() {
        this.serverList = new ArrayList<>();
        index = -1;
    }

    @Override
    public Server assignServer(String request) {
        int n = serverList.size();
        int i = (index + 1) % n;
        while (index != i) {
            if (serverList.get(i).getHealth()) {
                index = i;
                return serverList.get(index);
            }
            i++;
            i = i % n;
        }
        return null;
    }

    @Override
    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

}
