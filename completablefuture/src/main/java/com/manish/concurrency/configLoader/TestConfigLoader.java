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
        loader.getConfig().thenAcceptAsync(System.out::println);
        Util.sleep(5000);
        loader.getConfig().thenAcceptAsync(System.out::println);

        System.out.println(loader.getConfig().get().getDatabaseName());

    }


}
