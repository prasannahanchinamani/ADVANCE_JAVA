package InsurancePolicyManagement;

public class PolicyFileWriter implements FileWriterHandler {
    private InsurancePolicyManager policyManager;

    public PolicyFileWriter(InsurancePolicyManager policyManager) {
        this.policyManager = policyManager;
    }


    @Override
    public void writePolicies(String path) {
        policyManager.writeSummary(path);
    }
}

