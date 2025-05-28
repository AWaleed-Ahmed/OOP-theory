package backend.services;

import backend.models.User;
import java.io.*;
import java.util.*;

public abstract class AuthenticatorService {
    protected final List<User> users = new ArrayList<>();

    public AuthenticatorService() {
        loadUsersFromFile();
    }

    public abstract boolean login(String username, String password);

    public void signup(String newUsername, String newPassword) {
        users.add(new User(newUsername, newPassword));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(newUsername + "," + newPassword);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private void loadUsersFromFile() {
        File file = new File("users.txt");
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 2) {
                    users.add(new User(data[0], data[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("User file not found.");
        }
    }

    protected Optional<User> findUserByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }
}
