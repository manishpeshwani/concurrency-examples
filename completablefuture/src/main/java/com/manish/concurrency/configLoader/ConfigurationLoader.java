package com.manish.concurrency.configLoader;

import com.manish.concurrency.configLoader.Config;
import com.manish.concurrency.util.Util;

import java.util.concurrent.*;

/**
 * Created by manishpeshwani on 09-12-2018.
 */
public class ConfigurationLoader {

    private CompletableFuture<Config> configFuture;

    void loadConfiguration(){

        configFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(Thread.currentThread().getName());

                    Config config = new Config();
                    config.setDatabaseName("INTDB");
                    Util.sleep(1000);
                    return config;
                });
    }


    public CompletableFuture<Config> getConfig(){
        return configFuture;
    }



}
