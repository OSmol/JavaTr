package by.javatr.libproject.entity;

public class Book {
    private int id;
    private String name;
    private Author author;
    private int publish;

    public Book(int id, String name, Author author, int publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
        return 31 +
                (getAuthor() == null ? 1 : getAuthor().hashCode()) +
                (getName() == null ? 1 : getName().hashCode()) +
                getPublish() +
                getId();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", publish=" + publish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }
}
