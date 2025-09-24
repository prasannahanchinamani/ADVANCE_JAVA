package InsurancePolicyManagement;

public class PolicyFileHandler implements FileHandler {
    private InsurancePolicyManager manager;

    public PolicyFileHandler(InsurancePolicyManager manager) {
        this.manager = manager;
    }

    @Override
    public void readPolicy(String path) {
        manager.readPolicy(path);
    }

    @Override
    public void writePolicy(String path) {
        manager.writeSummary(path);
    }
}
