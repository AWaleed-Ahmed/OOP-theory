package backend.models;

public class BMICalculator extends Person {
    private double bmi;

    public BMICalculator(UserProfile userProfile) {
        super(userProfile);
    }

    @Override
    public double calculateBMI() {
        double weight = userProfile.getWeight();
        double height = userProfile.getHeight();
        bmi = (weight * 10000.0) / (height * height);
        return bmi;
    }

    @Override
    public String getHealthTips() {
        if (bmi < 18.5) {
            return """
                    YOU ARE UNDERWEIGHT

                    ⛳ Eat more calories than you burn — aim for a calorie surplus
                    ⛳ Focus on nutrient-dense foods: nuts, whole grains, avocados, lean meats
                    ⛳ Do strength training to build healthy muscle mass
                    ⛳ Eat frequently (every 2-3 hours)
                    ⛳ Track your progress weekly
                    """;
        } else if (bmi < 24.9) {
            return """
                    YOU ARE NORMAL

                    ⛳ Maintain your weight with a balanced diet
                    ⛳ Combine cardio with strength workouts
                    ⛳ Drink 2-3 liters of water daily
                    ⛳ Try yoga or stretching for flexibility
                    """;
        } else if (bmi < 30) {
            return """
                    YOU ARE OVERWEIGHT

                    ⛳ Aim for a calorie deficit
                    ⛳ Cut down on sugary and processed foods
                    ⛳ Start with moderate cardio: walking, cycling
                    ⛳ Eat high-protein meals
                    """;
        } else {
            return """
                    YOU ARE OBESE

                    ⛳ Consult a doctor or nutritionist
                    ⛳ Begin with low-impact activities
                    ⛳ Track meals with a food diary
                    ⛳ Avoid sugary drinks
                    ⛳ Stay consistent
                    """;
        }
    }
}
