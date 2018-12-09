package com.manish.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by manishpeshwani on 09-12-2018.
 */
public class AsyncTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();


        Supplier<List<Long>> supplyIds = () -> Arrays.asList(1L,2L, 3L);

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            sleep(1000);

            Supplier<List<User>> users =  () -> {
                return ids.stream().map(User::new).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(users);
        };

        Consumer<List<User>> displayer = users -> {
            System.out.println("Running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        //Chain the processing steps using CompletableFuture

        CompletableFuture<List<Long>> userIdsFuture = CompletableFuture.supplyAsync(supplyIds);
        userIdsFuture.thenCompose(fetchUsers)
                        .thenAcceptAsync(displayer, executor);

        sleep(1_000);

        executor.shutdown();
    }

    private static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
