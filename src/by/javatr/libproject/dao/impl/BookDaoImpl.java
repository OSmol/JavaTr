package by.javatr.libproject.dao.impl;

import by.javatr.libproject.bean.Author;
import by.javatr.libproject.bean.Book;
import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.exception.DAOInvalidFormatException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDaoImpl implements BookDAO {
    private String path = "E:\\EpmLibProject\\src\\resources\\BookFile.txt";

    public BookDaoImpl() {
    }

    @Override
    public void addBook(Book book) throws DAOException {
        try (FileWriter fw = new FileWriter(path, true)) {

            fw.write(book.getId() + "//" + book.getName() + "//" + book.getAuthor().getName() + "//" + book.getPublish());
            fw.append('\n');

        } catch (IOException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public void deleteBook(int id) throws DAOException {
        List<Book> bookList = removeBook(id, getAll());
        updateFile(bookList);
    }


    private List<Book> removeBook(int id, List<Book> bookList) {

        int i = 0;
        int temp = 0;
        for (Book item : bookList) {
            if (item.getId() == id) {
                temp = i;
            }
            i++;
        }
        bookList.remove(temp);
        return bookList;
    }

    @Override
    public void updateBook(int id, Book book) throws DAOException {
        List<Book> bookList = removeBook(id, getAll());
        bookList.add(book);
        updateFile(bookList);
    }


    private void updateFile(List<Book> bookList) throws DAOException {

        try (FileWriter fw = new FileWriter(path, false)) {
            for (Book item : bookList) {
                fw.write(item.getId() + "//" + item.getName() + "//" + item.getAuthor().getName() + "//" + item.getPublish());
                fw.append('\n');
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }


    @Override
    public List<Book> getAll() throws DAOException {
        List<Book> bookList = new ArrayList<>();

        try (Scanner scan = new Scanner(new FileReader(path))) {

            while (scan.hasNextLine()) {
                String text = scan.nextLine();

                String[] textSplit = text.split("//");

                try {
                    bookList.add(new Book(Integer.parseInt(textSplit[0]), textSplit[1], new Author(textSplit[2]), Integer.parseInt(textSplit[3])));
                } catch (NumberFormatException e) {
                    throw new DAOInvalidFormatException("File had invalid format", e);
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
            if (name.equalsIgnoreCase(item.getName())) {
                book = item;
                break;
            }
        }

        return book;
    }


}
