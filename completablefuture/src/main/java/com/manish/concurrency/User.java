package com.manish.concurrency;

/**
 * Created by manishpeshwani on 09-12-2018.
 */
public class User {

    private long id;

    public User(){

    }

    public User(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return "com.manish.concurrency.User :" + id;
    }

}
