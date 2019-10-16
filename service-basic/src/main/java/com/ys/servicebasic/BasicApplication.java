package com.ys.servicebasic;

import com.ys.servicebasic.verticles.monitors.MonitorVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.ext.cluster.infinispan.InfinispanClusterManager;

public class BasicApplication {

    public static void main(String[] args) {
        ClusterManager clusterManager = new InfinispanClusterManager();

        VertxOptions options = new VertxOptions().setClusterManager(clusterManager);
        Vertx.clusteredVertx(options, res -> {
            if(res.succeeded()){
                Vertx vertx = res.result();

                vertx.deployVerticle(MonitorVerticle.class.getName());
            }
        });
    }
}
