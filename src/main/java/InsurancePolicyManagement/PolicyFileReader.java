package InsurancePolicyManagement;

public class PolicyFileReader implements FileReaderHandler {
    private InsurancePolicyManager policyManager;

    public PolicyFileReader(InsurancePolicyManager policyManager) {
        this.policyManager = policyManager;
    }

    @Override
    public void readPolicies(String filePath) {
        policyManager.readPolicy(filePath);
    }
}

