package com.daviidli.bestbuycompanion;

/**
 * Created by David on 2017-04-01.
 */

public class Customer {

    public String name;
    public int queueNumber;
    //private Departments department;

    public Customer() {
    }

    public Customer(String name, int queueNumber/*, Departments department*/) {
        this.name = name;
        this.queueNumber = queueNumber;
        //this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQueueNumber(int q) {
        queueNumber = q;
    }

    /*
    public Departments getDepartment() {
        return department;
    }
    */

    public int getQueue() {
        return queueNumber;
    }
}
