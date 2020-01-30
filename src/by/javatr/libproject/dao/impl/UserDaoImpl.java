package by.javatr.libproject.dao.impl;

import by.javatr.libproject.dao.UserDAO;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.bean.User;

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
        try (FileReader fr = new FileReader(path)) {
            Scanner scan = new Scanner(fr);
            int i = 1;

            while (scan.hasNextLine()) {
                String text = scan.nextLine();
                String[] textSplit = text.split("//");
                if ((textSplit[0].equals(name))) {
                    return new User(textSplit[0],textSplit[1]);
                }

            }
            return null;

        } catch (IOException e) {
            throw new DAOException(e);
        }


    }

    @Override
    public void registration(User user) throws DAOException {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(user.getName() + "//" + user.getPassword() + "//");
            fw.append('\n');
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public List<User> getAll() throws DAOException {
        List<User> userList = new ArrayList<>();

        try (FileReader fr = new FileReader(path)) {

            Scanner scan = new Scanner(fr);

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
