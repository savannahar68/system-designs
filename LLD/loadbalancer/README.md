### Implement load balancer 

### Requirements:

0. This is a single loadbalancer
1. It should be able to act as a reverse proxy to multiple server nodes 
2. It should check for heart beat of server every second and maintain correct list of server for routing
3. It should support Load balancing strategies via config map (Strategy pattern)
4. Try to distribute the load as evenly as possible

#### Main entities of the system

1. Load balancer 
2. Server

#### Interfaces

1. LoadBalancerDao
2. LoadBalancerService
3. LoadBalancingPolicy
4. LoadBalancerCacheDao

#### Factory

1. Load balancer service factory
2. Load balancer policy factory
3. Load balancer dao factory


#### Authors: 

Prasad Rathod - https://github.com/prasadrathod | https://www.linkedin.com/in/prasadrathod
Savan Nahar - https://github.com/savannahar68 | https://www.linkedin.com/in/savannahar