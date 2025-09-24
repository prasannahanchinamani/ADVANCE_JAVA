package InsurancePolicyManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InsurancePolicyManager {


    List<Policy> policies = new ArrayList<>();

    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void readPolicy(String path) {
        // --- Reading policies ---
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            boolean isHeaderSkip = false;
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isHeaderSkip) {
                    isHeaderSkip = true;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3) {
                    String policyId = data[0].trim();
                    String holderName = data[1].trim();
                    int amount = Integer.parseInt(data[2].trim());
                    policies.add(new Policy(policyId, holderName, amount));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- Writing summary ---
    public void writeSummary(String path) {
        int totalPolicies = policies.size();
        int totalAmount = policies.stream().mapToInt(Policy::getAmount).sum();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("Total Number of Policies: " +
                    totalPolicies);
            writer.newLine();
            writer.write("Total Policy Amount: " + totalAmount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
