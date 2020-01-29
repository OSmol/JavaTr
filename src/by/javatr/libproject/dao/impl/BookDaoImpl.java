package by.javatr.libproject.dao.impl;

import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.entity.Author;
import by.javatr.libproject.entity.Book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDaoImpl implements BookDAO {
    private String path;

    public BookDaoImpl(String path) {
        this.path = path;
    }

    @Override
    public void addBook(Book book) throws DAOException {
        try (FileWriter fw = new FileWriter(path, true)) {

            fw.write(book.getId() + "//" + book.getName() + "//" + book.getAuthor().getName() + "//" + book.getPublish() + "//");
            fw.append('\n');

        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteBook(int id) throws DAOException {
        List<Book> bookList;

        bookList = getAll();

        int i = 0;
        int temp = 0;
        for (Book item : bookList) {
            if (item.getId() == id) {
                temp = i;
            }
            i++;
        }
        bookList.remove(temp);

        for (Book item : bookList) {
            addBook(new Book(item.getId(), item.getName(), item.getAuthor(), item.getPublish()));
        }
    }

    @Override
    public void updateBook(int id, Book book) {

    }

    @Override
    public List<Book> getAll() throws DAOException {
        List<Book> bookList = new ArrayList<>();

        try (FileReader fr = new FileReader(path)) {

            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine()) {
                String text = scan.nextLine();

                String[] textSplit = text.split("//");

                try {
                    bookList.add(new Book(Integer.parseInt(textSplit[0]), textSplit[1], new Author(textSplit[2]), Integer.parseInt(textSplit[3])));
                } catch (NumberFormatException e) {
                    throw new DAOException("File had invalid format", e);
                }
            }

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return bookList;
    }

    @Override
    public Book findByName(String name) throws DAOException {
        Book book = null;
        List<Book> bookList = getAll();

        for (Book item : bookList) {
            if (name.toUpperCase().equals(item.getName().toUpperCase())) {
                return item;
            }
        }

        return null;
    }


}
