package com.manish.concurrency.configLoader;

import com.manish.concurrency.util.Util;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by manishpeshwani on 09-12-2018.
 */
public class TestConfigLoader {

    public static void main(String[] args) throws Exception{
        ConfigurationLoader loader = new ConfigurationLoader();
        loader.loadConfiguration();
        loader.getConfig().thenAccept(
                config -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(config.getDatabaseName());
                }
        );
        Util.sleep(5000);
        loader.getConfig().thenAcceptAsync(
                config -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(config.getDatabaseName());
                }
        );

        System.out.println(loader.getConfig().get().getDatabaseName());

    }


}
