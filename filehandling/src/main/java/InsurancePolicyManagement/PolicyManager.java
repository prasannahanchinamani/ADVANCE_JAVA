package InsurancePolicyManagement;

public class PolicyManager {
    private FileWriterHandler policywrite;
    private FileReaderHandler policyread;

    public PolicyManager(FileWriterHandler policywrite, FileReaderHandler policyread) {
        this.policywrite = policywrite;
        this.policyread = policyread;
    }

    public void processPolicies(String inputFile, String outputFile) {
        policyread.readPolicies(inputFile);
        policywrite.writePolicies(outputFile);
    }
}

