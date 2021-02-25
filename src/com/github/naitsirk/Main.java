package com.github.naitsirk;

public class Main {

    public static int calculateBet(int points, double probability, double returnRatio) {
        double beliefProbability = 1 / returnRatio;
        double betProportion = (probability - beliefProbability) / (1 - beliefProbability);
        return (int) Math.round(points * betProportion);
    }

    public static void main(String[] args) {
        try {
            int points = Integer.parseInt(args[0]);
            double probability = Double.parseDouble(args[1]);
            double returnRatio = Double.parseDouble(args[2]);

            int betA = calculateBet(points, probability, returnRatio);
            int betB = calculateBet(points, 1 - probability, returnRatio / (returnRatio - 1));

            System.out.println("Choice A: " + betA);
            System.out.println("Choice B: " + betB);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
