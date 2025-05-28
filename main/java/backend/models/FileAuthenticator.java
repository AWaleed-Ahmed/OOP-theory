package backend.models;

import java.io.*;
import java.util.*;

public class FileAuthenticator extends AuthenticatorBase {
    private final List<User> users = new ArrayList<>();

    @Override
    public void signup(User user) {
        users.add(user);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(user.getUsername() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
    }

    @Override
    public void loadUsersFromFile() {
        users.clear();
        try (Scanner scanner = new Scanner(new File("users.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 2) {
                    users.add(new User(data[0], Integer.parseInt(data[1])));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("User file not found.");
        }
    }

    @Override
    public boolean authenticate(User inputUser) {
        for (User user : users) {
            if (user.getUsername().equals(inputUser.getUsername()) &&
                    user.getPassword() == inputUser.getPassword()) {
                return true;
            }
        }
        return false;
    }
}
