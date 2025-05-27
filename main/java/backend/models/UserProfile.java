package backend.models;

public class UserProfile {
    private String name;
    private int age;
    private String gender;
    private double weight; // in kg
    private double height; // in cm

    public UserProfile() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.trim().matches("[a-zA-Z ]+")) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 2) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age.");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            this.gender = gender.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid gender.");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Invalid weight.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Invalid height.");
        }
    }
}
