package by.javatr.libproject.bean;

import by.javatr.libproject.util.Status;

public class User {
    private String name;
    private String password;
    private Status status;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        status = Status.OFFLINE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "{ " +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", password='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (user.getName() == null) {
            if (getName() != null) return false;
        }
        if (user.getPassword() == null) {
            if (getPassword() != null) return false;
        }
        if (user.getStatus() == null) {
            if (getStatus() != null) return false;
        }
        return getName().equals(user.getName())
                && getPassword().equals(user.getPassword())
                && getStatus().equals(user.getStatus());
    }

    @Override
    public int hashCode() {
        return 31
                + (name == null ? 1 : name.hashCode())
                + (password == null ? 1 : name.hashCode())
                + (status == null ? 1 : status.hashCode());
    }


    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }
}
