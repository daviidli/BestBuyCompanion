package com.daviidli.bestbuycompanion;

/**
 * Created by David on 2017-04-01.
 */

public class Customer {

    private String name;
    private String comments;
    private Departments department;

    public Customer() {
        // for Firebase
    }

    public Customer(String name, String comments, Departments department) {
        this.name = name;
        this.comments = comments;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Departments getDepartment() {
        return department;
    }

    public String getComments() {
        return comments;
    }
}

