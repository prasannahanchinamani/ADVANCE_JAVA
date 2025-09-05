package InsurancePolicyManagement;

public class Main {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        PolicyManager manager1 = new PolicyManager(
                new PolicyFileWriter(manager), new PolicyFileReader(manager)
        );

       String  output="C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\filehandling\\src\\main\\java\\InsurancePolicyManagement\\policy_summary.csv";
        String input="C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\filehandling\\src\\main\\java\\InsurancePolicyManagement\\Policy.csv";
        manager1.processPolicies(input,output);
    }
}