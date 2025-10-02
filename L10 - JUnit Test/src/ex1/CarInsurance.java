package ex1;

public class CarInsurance {
    private final double basisPremium = 0; // invariant: basisPremium > 0.

    /**
     * Create a CarInsurance.
     * Pre: basisPremium > 0.
     */
    public CarInsurance(double basisPremium) {
        //   this.basisPremium = basisPremium;
    }
    /**
     * Calculate and return a premium based of the following rules:
     * - person age below 25: calculated premium is basis premium plus 25%,
     * - woman: calculated premium is reduced with 5%,
     * - if the person have been driving without damages for:
     * - 0 to 2 years: calculated premium is reduced with 0%,
     * - 3 to 5 years: calculated premium is reduced with 15%,
     * - 6 to 8 years: calculated premium is reduced with 25%,
     * - more than 8 years: calculated premium is reduced with 35%.
     * Throw a RuntimeException, if age < 18, or yearsWithoutDamage < 0,
     * or YearsWithoutDamage > age-18.
     */
}