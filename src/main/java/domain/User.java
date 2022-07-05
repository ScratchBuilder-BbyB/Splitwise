package domain;

import utils.IDGenerator;

public class User {
    private final int id = IDGenerator.getNextId();
    private String name;
    private String email;
    private String mobileNo;

    public User(String name, String email, String mobileNo) {
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
