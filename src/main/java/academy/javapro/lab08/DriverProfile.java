package academy.javapro.lab08;

public class DriverProfile {
    // Basic Info
    private String name;  // NEW FIELD
    private int age;
    private int yearsOfDrivingExperience;
    private String occupation;

    // Driving history
    private int accidentsInLastFiveYears;
    private int violationsInLastThreeYears;
    private boolean hasCurrentInsurance;
    private int yearsWithContinuousInsurance;

    // Vehicle information
    private String vehicleMake;
    private String vehicleModel;
    private int vehicleYear;
    private boolean hasAntiTheftDevice;
    private boolean hasAntiLockBrakes;
    private boolean hasDaytimeRunningLights;

    // Coverage options
    private int liabilityLimit;
    private int collisionDeductible;
    private int comprehensiveDeductible;
    private boolean includesRoadside;
    private boolean includesRentalCar;

    // ✅ Updated constructor with all important inputs
    public DriverProfile(String name, int age, int yearsOfDrivingExperience, String occupation,
                         int accidentsInLastFiveYears, int violationsInLastThreeYears,
                         boolean hasCurrentInsurance, int yearsWithContinuousInsurance,
                         String vehicleMake, String vehicleModel, int vehicleYear,
                         boolean hasAntiTheftDevice, boolean hasAntiLockBrakes, boolean hasDaytimeRunningLights,
                         int liabilityLimit, int collisionDeductible, int comprehensiveDeductible,
                         boolean includesRoadside, boolean includesRentalCar) {

        this.name = name;
        this.age = age;
        this.yearsOfDrivingExperience = yearsOfDrivingExperience;
        this.occupation = occupation;
        this.accidentsInLastFiveYears = accidentsInLastFiveYears;
        this.violationsInLastThreeYears = violationsInLastThreeYears;
        this.hasCurrentInsurance = hasCurrentInsurance;
        this.yearsWithContinuousInsurance = yearsWithContinuousInsurance;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.hasAntiTheftDevice = hasAntiTheftDevice;
        this.hasAntiLockBrakes = hasAntiLockBrakes;
        this.hasDaytimeRunningLights = hasDaytimeRunningLights;
        this.liabilityLimit = liabilityLimit;
        this.collisionDeductible = collisionDeductible;
        this.comprehensiveDeductible = comprehensiveDeductible;
        this.includesRoadside = includesRoadside;
        this.includesRentalCar = includesRentalCar;
    }

    // ✅ Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getYearsOfDrivingExperience() { return yearsOfDrivingExperience; }
    public void setYearsOfDrivingExperience(int yearsOfDrivingExperience) { this.yearsOfDrivingExperience = yearsOfDrivingExperience; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public int getAccidentsInLastFiveYears() { return accidentsInLastFiveYears; }
    public void setAccidentsInLastFiveYears(int accidentsInLastFiveYears) { this.accidentsInLastFiveYears = accidentsInLastFiveYears; }

    public int getViolationsInLastThreeYears() { return violationsInLastThreeYears; }
    public void setViolationsInLastThreeYears(int violationsInLastThreeYears) { this.violationsInLastThreeYears = violationsInLastThreeYears; }

    public boolean hasCurrentInsurance() { return hasCurrentInsurance; }
    public void setHasCurrentInsurance(boolean hasCurrentInsurance) { this.hasCurrentInsurance = hasCurrentInsurance; }

    public int getYearsWithContinuousInsurance() { return yearsWithContinuousInsurance; }
    public void setYearsWithContinuousInsurance(int yearsWithContinuousInsurance) { this.yearsWithContinuousInsurance = yearsWithContinuousInsurance; }

    public String getVehicleMake() { return vehicleMake; }
    public void setVehicleMake(String vehicleMake) { this.vehicleMake = vehicleMake; }

    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }

    public int getVehicleYear() { return vehicleYear; }
    public void setVehicleYear(int vehicleYear) { this.vehicleYear = vehicleYear; }

    public boolean hasAntiTheftDevice() { return hasAntiTheftDevice; }
    public void setHasAntiTheftDevice(boolean hasAntiTheftDevice) { this.hasAntiTheftDevice = hasAntiTheftDevice; }

    public boolean hasAntiLockBrakes() { return hasAntiLockBrakes; }
    public void setHasAntiLockBrakes(boolean hasAntiLockBrakes) { this.hasAntiLockBrakes = hasAntiLockBrakes; }

    public boolean hasDaytimeRunningLights() { return hasDaytimeRunningLights; }
    public void setHasDaytimeRunningLights(boolean hasDaytimeRunningLights) { this.hasDaytimeRunningLights = hasDaytimeRunningLights; }

    public int getLiabilityLimit() { return liabilityLimit; }
    public void setLiabilityLimit(int liabilityLimit) { this.liabilityLimit = liabilityLimit; }

    public int getCollisionDeductible() { return collisionDeductible; }
    public void setCollisionDeductible(int collisionDeductible) { this.collisionDeductible = collisionDeductible; }

    public int getComprehensiveDeductible() { return comprehensiveDeductible; }
    public void setComprehensiveDeductible(int comprehensiveDeductible) { this.comprehensiveDeductible = comprehensiveDeductible; }

    public boolean includesRoadside() { return includesRoadside; }
    public void setIncludesRoadside(boolean includesRoadside) { this.includesRoadside = includesRoadside; }

    public boolean includesRentalCar() { return includesRentalCar; }
    public void setIncludesRentalCar(boolean includesRentalCar) { this.includesRentalCar = includesRentalCar; }

    @Override
    public String toString() {
        return "DriverProfile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + yearsOfDrivingExperience +
                ", occupation='" + occupation + '\'' +
                ", accidents=" + accidentsInLastFiveYears +
                ", violations=" + violationsInLastThreeYears +
                ", vehicle=" + vehicleMake + " " + vehicleModel + " " + vehicleYear +
                '}';
    }
}
