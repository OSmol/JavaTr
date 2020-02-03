package by.javatr.libproject.bean;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 6614321234L;

    private int id;
    private String name;
    private Author author;
    private int publish;

    public Book(int id, String name, int publish) {
        this.id = id;
        this.name = name;
        this.publish = publish;
        author = new Author();
    }

    public Book(int id, Author author, int publish) {
        this.id = id;
        this.name = "default";
        this.author = author;
        this.publish = publish;
    }

    public Book(int id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
        publish = 0;
    }

    public Book(int id, String name, Author author, int publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }


    public Book() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (book.getName() == null) {
            if (getName() != null) return false;
        }
        if (book.getAuthor() == null) {
            if (getAuthor() != null) return false;
        }
        return getId() == book.getId() &&
                getPublish() == book.getPublish() &&
                getName().equals(book.getName()) &&
                getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return 31 + (getAuthor() == null ? 1 : getAuthor().hashCode())
                + (getName() == null ? 1 : getName().hashCode())
                + getPublish()
                + getId();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", publish=" + publish;
    }

    public final Author getAuthor() {
        return author;
    }

    public final void setAuthor(Author author) {
        this.author = author;
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }


    public final int getPublish() {
        return publish;
    }

    public final void setPublish(int publish) {
        this.publish = publish;
    }
}
