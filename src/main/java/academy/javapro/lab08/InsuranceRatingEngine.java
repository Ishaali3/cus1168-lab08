package academy.javapro.lab08;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class InsuranceRatingEngine {
    private Map<String, Object> knowledgeBase = new HashMap<>();
    private List<Rule> rules = new ArrayList<>();

    public InsuranceRatingEngine() {
        initializeKnowledgeBase();
        initializeRules();
    }

    private void initializeKnowledgeBase() {
        // Base rates
        knowledgeBase.put("baseRate.sedan", 1000.0);
        knowledgeBase.put("baseRate.suv", 1200.0);
        knowledgeBase.put("baseRate.luxury", 1500.0);
        knowledgeBase.put("baseRate.sports", 1800.0);

        // Age risk factors
        knowledgeBase.put("ageFactor.16-19", 2.0);
        knowledgeBase.put("ageFactor.20-24", 1.5);
        knowledgeBase.put("ageFactor.25-65", 1.0);
        knowledgeBase.put("ageFactor.66+", 1.3);

        // Accident surcharges
        knowledgeBase.put("accidentSurcharge.0", 0.0);
        knowledgeBase.put("accidentSurcharge.1", 300.0);
        knowledgeBase.put("accidentSurcharge.2+", 600.0);
    }

    private void initializeRules() {
        // Base rate rule
        rules.add(new Rule("base rate",
                profile -> true,
                (profile, premium) -> {
                    String vehicleCategory = determineVehicleCategory(profile);
                    double baseRate = (double) knowledgeBase.get("baseRate." + vehicleCategory);
                    premium.setBaseRate(baseRate);
                }));

        // Age factor rule
        rules.add(new Rule("age factor",
                profile -> true,
                (profile, premium) -> {
                    int age = profile.getAge();
                    double factor;
                    String explanation;
                    if (age < 20) {
                        factor = (double) knowledgeBase.get("ageFactor.16-19");
                        explanation = "Drivers under 20 have higher statistical risk";
                    } else if (age < 25) {
                        factor = (double) knowledgeBase.get("ageFactor.20-24");
                        explanation = "Drivers 20-24 have moderately higher risk";
                    } else if (age < 66) {
                        factor = (double) knowledgeBase.get("ageFactor.25-65");
                        explanation = "Standard rate for drivers 25-65";
                    } else {
                        factor = (double) knowledgeBase.get("ageFactor.66+");
                        explanation = "Slight increase for senior drivers";
                    }
                    double adjustment = premium.getBaseRate() * (factor - 1.0);
                    premium.addAdjustment("Age factor", adjustment, explanation);
                }));

        // Accident history rule
        rules.add(new Rule("accident history",
                profile -> profile.getAccidentsInLastFiveYears() > 0,
                (profile, premium) -> {
                    int accidents = profile.getAccidentsInLastFiveYears();
                    double surcharge;
                    String explanation;
                    if (accidents == 1) {
                        surcharge = (double) knowledgeBase.get("accidentSurcharge.1");
                        explanation = "Surcharge for 1 accident in past 5 years";
                    } else {
                        surcharge = (double) knowledgeBase.get("accidentSurcharge.2+");
                        explanation = "Major surcharge for 2+ accidents in past 5 years";
                    }
                    premium.addAdjustment("Accident history", surcharge, explanation);
                }));
    }

    private String determineVehicleCategory(DriverProfile profile) {
        String make = profile.getVehicleMake().toLowerCase();
        String model = profile.getVehicleModel().toLowerCase();

        if (Arrays.asList("bmw", "mercedes", "lexus", "audi").contains(make)) {
            return "luxury";
        } else if (Arrays.asList("ferrari", "porsche", "mustang", "corvette").contains(make)) {
            return "sports";
        } else if (Arrays.asList("suv", "explorer", "tahoe", "highlander").contains(model)) {
            return "suv";
        } else {
            return "sedan";
        }
    }

    public Premium calculatePremium(DriverProfile profile) {
        Premium premium = new Premium();
        for (Rule rule : rules) {
            if (rule.matches(profile)) {
                rule.apply(profile, premium);
            }
        }
        return premium;
    }

    static class Rule {
        private String name;
        private Predicate<DriverProfile> condition;
        private BiConsumer<DriverProfile, Premium> action;

        public Rule(String name, Predicate<DriverProfile> condition, BiConsumer<DriverProfile, Premium> action) {
            this.name = name;
            this.condition = condition;
            this.action = action;
        }

        public boolean matches(DriverProfile profile) {
            return condition.test(profile);
        }

        public void apply(DriverProfile profile, Premium premium) {
            action.accept(profile, premium);
        }

        public String getName() {
            return name;
        }
    }
}
