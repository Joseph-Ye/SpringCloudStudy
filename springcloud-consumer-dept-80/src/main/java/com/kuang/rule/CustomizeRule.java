package com.kuang.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class CustomizeRule extends AbstractLoadBalancerRule {

    private static int total = 0;
    private static int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                // Ribbon的随机算法
//                int index = this.chooseRandomInt(serverCount);
//                server = (Server)upList.get(index);


                if(total < 4) {
                    total++;
                    server = (Server)upList.get(currentIndex);
                } else {
                    total = 0;
                    currentIndex++;
                    if(currentIndex > upList.size()) {
                        currentIndex = 0;
                    }
                    server = (Server)upList.get(currentIndex);
                }



                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return new Random().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }
}
