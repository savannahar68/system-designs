package loadbalancer.Interface;

import loadbalancer.Dao.LoadBalancerDaoImpl;
import loadbalancer.Service.LoadBalancerServiceImpl;
import loadbalancer.Strategy.RoundRobinLbPolicy;

public interface LBServFactory {
    static LoadBalancerService getLoadBalancer(String dao, String policy) {
        // Assumption that the below obejects are getting initialized via help of config property
        LoadBalancerDao daoObject = new LoadBalancerDaoImpl();
        LoadBalancingPolicy policyObject = new RoundRobinLbPolicy();

        return new LoadBalancerServiceImpl(daoObject, policyObject);
    }
}
