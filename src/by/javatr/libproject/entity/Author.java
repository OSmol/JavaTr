package by.javatr.libproject.entity;

public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        if (author.getName() == null) {
            if (getName() != null) return false;
        }
        return getName().equals(author.getName());
    }

    @Override
    public int hashCode() {
        return 31 + (getName() == null ? 1 : getName().hashCode());
    }

    @Override
    public String toString() {
        return  "name='" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
