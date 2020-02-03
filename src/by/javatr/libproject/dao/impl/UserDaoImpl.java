package by.javatr.libproject.dao.impl;

import by.javatr.libproject.bean.User;
import by.javatr.libproject.dao.UserDAO;
import by.javatr.libproject.dao.exception.DAOException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDAO {

    private String path = "E:\\EpmLibProject\\src\\resources\\UserFile.txt";

    public UserDaoImpl() {
    }

    public User findByName(String name) throws DAOException {
        List<User> userList = getAll();
        User user = null;

        for (User item:userList) {
            if (item.getName().equalsIgnoreCase(name)) {
                user = item;
                break;
            }
        }

        return user;
    }

    @Override
    public void registration(User user) throws DAOException {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(user.getName() + "//" + user.getPassword());
            fw.append('\n');
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public List<User> getAll() throws DAOException {
        List<User> userList = new ArrayList<>();

        try (Scanner scan = new Scanner(new FileReader(path))) {

            while (scan.hasNextLine()) {
                String text = scan.nextLine();
                String[] textSplit = text.split("//");
                userList.add(new User(textSplit[0], textSplit[1]));
            }

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return userList;
    }
}
