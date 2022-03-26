/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package loadbalancer;

import loadbalancer.Domain.Server;
import loadbalancer.Interface.LBServFactory;
import loadbalancer.Interface.LoadBalancerService;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {
        LoadBalancerService lbService = LBServFactory.getLoadBalancer("dao", "RoundRobinPolicy");

        Server s1 = new Server("s1", 10);
        Server s2 = new Server("s2", 10);
        Server s3 = new Server("s3", 10);
        Server s4 = new Server("s4", 10);
        Server s5 = new Server("s5", 10);

        lbService.addServer(s1);
        lbService.addServer(s2);
        lbService.addServer(s3);
        lbService.addServer(s4);
        lbService.addServer(s5);

        System.out.println("Scenario 1:  where server went unhealthy to healthy in middle of operation");
        for (int i = 0; i < 15; i++) {
            lbService.get("Client"+i, "RequestObject");
            Thread.sleep(1000);
            if (i == 3) s5.setHealth(false); // After 3 attemps setting server health to false
            if (i == 6) s5.setHealth(true);
        }

        System.out.println("\nScenario 2:  where server restarted in middle of operation");
        for (int i = 0; i < 15; i++) {
            lbService.get("Client"+i, "RequestObject");
            Thread.sleep(1000);
            if (i == 3) lbService.deleteServer(s5); // Delete server 5 as it might have undergone restart
            if (i ==6) lbService.addServer(s5); // add s5 back once it has restarted
        }
    }
}