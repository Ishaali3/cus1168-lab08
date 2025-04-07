package academy.javapro.lab08;

import java.util.ArrayList;
import java.util.List;

public class Premium {
    private double baseRate;
    private final List<Adjustment> adjustments;

    // Constructor
    public Premium() {
        this.baseRate = 0.0;
        this.adjustments = new ArrayList<>();
    }

    // Set the base rate (e.g., based on vehicle type)
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    // Get the base rate
    public double getBaseRate() {
        return baseRate;
    }

    // Add an adjustment (e.g., age factor, accident surcharge)
    public void addAdjustment(String label, double amount, String explanation) {
        adjustments.add(new Adjustment(label, amount, explanation));
    }

    // Calculate the total premium
    public double getTotalPremium() {
        double total = baseRate;
        for (Adjustment adj : adjustments) {
            total += adj.amount;
        }
        return total;
    }

    // Return an explanation of how the premium was calculated
    public String getExplanation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Base Rate: $%.2f\n", baseRate));
        for (Adjustment adj : adjustments) {
            sb.append(String.format("%s Adjustment: $%.2f - %s\n", adj.label, adj.amount, adj.explanation));
        }
        sb.append(String.format("Total Premium: $%.2f\n", getTotalPremium()));
        return sb.toString();
    }

    // Inner class to represent individual adjustments
    private static class Adjustment {
        String label;
        double amount;
        String explanation;

        Adjustment(String label, double amount, String explanation) {
            this.label = label;
            this.amount = amount;
            this.explanation = explanation;
        }
    }
}
