package backend.models;

public class UserProfile {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;

    public UserProfile() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.trim().matches("[a-zA-Z ]+")) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 13) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be 13 or older");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            this.gender = gender.toLowerCase();
        } else {
            throw new IllegalArgumentException("Gender must be male or female");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 30 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight must be between 30kg and 200kg");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height >= 120 && height <= 250) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be between 120cm and 250cm");
        }
    }
}
