package java8_features.insurance_system;

public class Policy {
    private String policy_Number;
    private String holder_Name;
    private double premiumAmount;

    public Policy(String policy_Number, String holder_Name, double premiumAmount) {
        this.policy_Number = policy_Number;
        this.holder_Name = holder_Name;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicy_Number() {
        return policy_Number;
    }

    public String getHolder_Name() {
        return holder_Name;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policy_Number='" + policy_Number + '\'' +
                ", holder_Name='" + holder_Name + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}
