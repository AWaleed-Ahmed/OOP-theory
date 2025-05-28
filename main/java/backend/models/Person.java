package backend.models;

public abstract class Person {
    protected UserProfile userProfile;

    public Person(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public abstract double calculateBMI();

    public abstract String getHealthTips();
}
