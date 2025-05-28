package backend.services;

import backend.models.BMICalculator;
import backend.models.UserProfile;

public class BMIService {
    private final BMICalculator bmiCalculator = new BMICalculator();

    public double getBMI(UserProfile profile) {
        return bmiCalculator.calculateBMI(profile);
    }

    public String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    public String getHealthTips(double bmi) {
        StringBuilder tips = new StringBuilder();

        if (bmi < 18.5) {
            tips.append("YOU ARE UNDERWEIGHT\n\n")
                    .append("⛳ Eat more calories than you burn.\n")
                    .append("⛳ Focus on nutrient-dense foods.\n")
                    .append("⛳ Strength training helps.\n")
                    .append("⛳ Eat every 2-3 hours.\n")
                    .append("⛳ Track progress weekly.\n");
        } else if (bmi < 24.9) {
            tips.append("YOU ARE NORMAL\n\n")
                    .append("⛳ Maintain with balanced diet.\n")
                    .append("⛳ Combine cardio & strength.\n")
                    .append("⛳ Hydrate well.\n")
                    .append("⛳ Include yoga/stretching.\n");
        } else if (bmi < 30.0) {
            tips.append("YOU ARE OVERWEIGHT\n\n")
                    .append("⛳ Focus on calorie deficit.\n")
                    .append("⛳ Avoid processed foods.\n")
                    .append("⛳ Start cardio.\n")
                    .append("⛳ High-protein meals help.\n");
        } else {
            tips.append("YOU ARE OBESE\n\n")
                    .append("⛳ Consult a doctor.\n")
                    .append("⛳ Start with low-impact activities.\n")
                    .append("⛳ Track your meals.\n")
                    .append("⛳ Avoid sugary drinks.\n")
                    .append("⛳ Stay consistent.\n");
        }

        return tips.toString();
    }
}
