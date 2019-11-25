package com.sayboard.domain;

/**
 * @outhor moke
 * @date 2019-11-25
 */
public class User {
    private int id;
    private String empName;
    private String password;

    public User() {
    }

    public User(int id, String empName, String password) {
        this.id = id;
        this.empName = empName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
