package InsurancePolicyManagement;

public class Policy {
    private String policyId;
    private String holderName;
    private int amount;

    public Policy(String policyId, String holderName, int amount) {
        this.policyId = policyId;
        this.holderName = holderName;
        this.amount = amount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getAmount() {
        return amount;
    }
}