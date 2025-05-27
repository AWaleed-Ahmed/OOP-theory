package backend.models;

import java.util.Scanner;

public class UserData {
    private int age;
    private String gender;
    private double weight;
    private double height;
    public Scanner sc;
    private String name;

    public UserData() {
        this.sc = new Scanner(System.in);
    }

    public void setName(String name) {
        if (!(name == null)) {
            String trimmedName = name.trim();
            if (!(trimmedName.isEmpty())) {
                if (trimmedName.matches("[a-zA-Z]+")) {
                    this.name = name;
                }
            }
        }
        else {
            // set text label to invalid name
        }
    }

    public void setAge(int age) {
        if (age >= 2) {
            this.age = age;
        }
        else {
            // set text label to invalid age
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(double weight) {
        if (weight >= (double)0.0F) {
            this.weight = weight;
        }
        else {
            // set text label to invalid weight
        }
    }

    public void setHeight(double height) {
        if (height >= (double)0.0F) {
            this.height = height;
        }
        else {
            // set text label to invalid weight
        }
    }

//    public void display2() {
//        System.out.println();
//        System.out.println("KINDLY ENTER YOUR AGE : ");
//        this.setAge(this.sc.nextInt());
//        System.out.println("KINDLY ENTER YOUR GENDER: ");
//        this.setGender(this.sc.next());
//        System.out.println("KINDLY ENTER YOUR WEIGTH IN KGS : ");
//        this.setWeigth(this.sc.nextDouble());
//        System.out.println("KINDLY ENTER YOUR HEIGTH IN CMS : ");
//        this.setHeigth(this.sc.nextDouble());
//    }
}
