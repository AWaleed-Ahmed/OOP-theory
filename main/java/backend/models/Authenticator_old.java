//package backend.models;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Authenticator_old {
//    String[] username = new String[50];
//    int[] password = new int[50];
//    int userCount = 0;
//    int nameIndex = 8;
//    int passwordIndex = -1;
//
//    public void signup(String newUsername, int newPassword) {
//        this.username[this.userCount] = newUsername;
//        this.password[this.userCount] = newPassword;
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
//            writer.write(newUsername + "," + newPassword);
//            writer.newLine();
//        } catch (IOException e) {
//            // add sth
//        }
//
//        ++this.userCount;
//    }
//
//    public void loadUsersFromFile() {
//        try {
//            File file = new File("users.txt");
//            Scanner fileScanner = new Scanner(file);
//
//            int i;
//            for(i = 0; fileScanner.hasNextLine() && i < 50; ++i) {
//                String line = fileScanner.nextLine();
//                String[] userData = line.split(",");
//                this.username[i] = userData[0];
//                this.password[i] = Integer.parseInt(userData[1]);
//            }
//
//            this.userCount = i;
//        } catch (FileNotFoundException var6) {
////            add sth
//        }
//
//    }
//
//    public void verifyUsername(String name) {
//
//        for(int i = 0; i < this.userCount; ++i) {
//            if (this.username[i].equals(name)) {
//                this.nameIndex = i;
//            }
//        }

//        if (this.nameIndex == 8)
//        {
//            System.out.println("Invalid username ! not found in record");
//        }

//    }
//
//    public void verifyPassword(int key) {
//        for(int i = 0; i < this.userCount; ++i) {
//            if (this.password[i] == key) {
//                this.passwordIndex = i;
//            }
//        }

//        if (this.passwordIndex == -1) {
//            System.out.println("invalid password!! Not found in record");
//        }

//    }
//
//    public boolean verify() {
//        return this.passwordIndex == this.nameIndex;
//    }
//}
