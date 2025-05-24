////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package backend.models;
//
//import java.util.Scanner;
//
//public class FitnessGoal extends BMI_Calculation_Tips {
//    double bmi;
//
//    public void suggestPlanBasedOnGoalAndBMI(double bmi) {
//        this.bmi = bmi;
//        Scanner in = new Scanner(System.in);
//        System.out.println("Do you want a diet plan? (cut/maintain/bulk)");
//        String goal = in.next().toLowerCase();
//        System.out.println("\n Based on your goal and BMI (" + bmi + "), here’s your diet suggestion:\n");
//        switch (goal) {
//            case "cut":
//                System.out.println("➤ Lower your intake by 500 kcal/day.\n➤ Focus on lean protein, veggies, and whole grains.");
//                System.out.println("Breakfast: 4 egg whites, 2 whole eggs, spinach, 1 slice whole grain toast\n\nLunch: Grilled chicken breast, quinoa, steamed broccoli\n\nSnack: Greek yogurt (0% fat) + berries\n\nDinner: Salmon, mixed vegetables, small sweet potato\n\nPost-workout (optional): Whey protein shake with water");
//                break;
//            case "maintain":
//                System.out.println("➤ Maintain current intake.\n➤ Eat balanced meals (carbs, protein, fat) and stay active.");
//                System.out.println("Breakfast: Oats + banana + whey + peanut butter\n\nLunch: Turkey breast wrap + side salad\n\nSnack: Mixed nuts + protein bar\n\nDinner: Beef stir-fry with brown rice\n\nDessert: Cottage cheese with honey");
//                break;
//            case "bulk":
//                System.out.println("➤ Increase intake by 300–500 kcal/day.\n➤ Prioritize protein, complex carbs, and strength training.");
//                System.out.println("Breakfast: 4 eggs + oats + banana\n\nLunch: Grilled chicken burrito with avocado\n\nSnack: Mass gainer or whey + peanut butter + banana\n\nDinner: Pasta with lean beef sauce, side veggies\n\nPost-workout: Whey + banana + rice cakes");
//            default:
//                System.out.println(" Invalid goal. Please enter cut, maintain, or bulk.");
//                in.close();
//                System.exit(0);
//        }
//
//    }
//}
