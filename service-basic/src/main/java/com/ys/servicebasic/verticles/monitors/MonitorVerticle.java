package com.ys.servicebasic.verticles.monitors;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class MonitorVerticle extends AbstractVerticle {

    public static final String APP_MONITOR_BUS_NAME="eventbus.monitor.app";

    @Override
    public void start() throws Exception {

//        vertx.eventBus().consumer(APP_MONITOR_BUS_NAME, new Handler<Message<JsonObject>>() {
//            @Override
//            public void handle(Message<JsonObject> event) {
//                System.out.println(event.body().toString());
//            }
//        });

        vertx.eventBus().request("health", "health", new Handler<AsyncResult<Message<JsonObject>>>() {
            @Override
            public void handle(AsyncResult<Message<JsonObject>> event) {
                System.out.println(event.result().body().toString());
            }
        });

    }
}
