package backend.models;

public class BMICalculator {
    private double bmi;

    public double calculateBMI(UserProfile profile) {
        if (profile == null) throw new IllegalArgumentException("UserProfile cannot be null.");
        double weight = profile.getWeight();
        double height = profile.getHeight();
        bmi = (weight * 10000.0d) / Math.pow(height, 2.0d);
        return bmi;
    }

    public double getBmi() {
        return bmi;
    }
}
