package by.javatr.libproject.entity;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "{ " +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
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
        return getName().equals(user.getName()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return 31 + (name == null ? 1 : name.hashCode()) + (password == null ? 1 : name.hashCode());
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
