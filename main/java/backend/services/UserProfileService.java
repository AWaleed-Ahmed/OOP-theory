package backend.services;

import backend.models.UserProfile;

public class UserProfileService {

    public double calculateBMI(UserProfile profile) {
        double heightInMeters = profile.getHeight() / 100.0;
        return profile.getWeight() / (heightInMeters * heightInMeters);
    }

    public String getHealthAdvice(double bmi) {
        if (bmi < 18.5) return "Underweight - Consider a balanced diet.";
        else if (bmi < 25) return "Normal - Keep it up!";
        else if (bmi < 30) return "Overweight - Try moderate exercise.";
        else return "Obese - Consult a professional.";
    }
}
