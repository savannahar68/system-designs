package loadbalancer.Service;

import loadbalancer.Domain.Server;
import loadbalancer.Interface.LoadBalancerDao;
import loadbalancer.Interface.LoadBalancerService;
import loadbalancer.Interface.LoadBalancingPolicy;

import java.util.List;

public class LoadBalancerServiceImpl implements LoadBalancerService {

    LoadBalancerDao dao;
    LoadBalancingPolicy policy;

    public LoadBalancerServiceImpl(LoadBalancerDao dao, LoadBalancingPolicy policy) {
        this.dao =  dao; // this comes from factory
        this.policy = policy;
    }

    @Override
    public Object get(String client, Object path) {
        Server server = policy.assignServer(client);
        if (server != null) {
            try {
                return server.work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Service error 501!";
    }

    @Override
    public Object post(String client, Object path) {
        Server server = policy.assignServer(client);
        if (server != null) {
            try {
                return server.work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Service error 501!";
    }

    @Override
    public Object update(String client, Object path) {
        Server server = policy.assignServer(client);
        if (server != null) {
            try {
                return server.work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Service error 501!";
    }

    @Override
    public Object delete(String client, Object path) {
        Server server = policy.assignServer(client);
        if (server != null) {
            try {
                return server.work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Service error 501!";
    }

    @Override
    public void addServer(Server server) {
        dao.put(server);
        policy.setServerList((List<Server>)dao.getServerList());
    }

    @Override
    public void deleteServer(Server server) {
        dao.remove(server);
        policy.setServerList((List<Server>)dao.getServerList());
    }
}
