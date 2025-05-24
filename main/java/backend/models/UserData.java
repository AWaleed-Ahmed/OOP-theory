//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package backend.models;

import java.util.Scanner;

public class UserData {
    private int age;
    private String gender;
    private double weight;
    private double height;
    public Scanner sc;

    public UserData() {
        this.sc = new Scanner(System.in);
    }
    public void setAge(int age) {
        if (age <= 0) {
//            System.out.println("invalid age ");
        }

        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeigth() {
        return this.weight;
    }

    public void setWeigth(double weigth) {
        if (weigth <= (double)0.0F) {
//            System.out.println("invalid weigth");
        }

        this.weight = weight;
    }

    public double getHeigth() {
        return this.height;
    }

    public void setHeigth(double heigth) {
        if (heigth <= (double)0.0F) {
//            System.out.println("invalid heigth");
        }

        this.height = heigth;
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
