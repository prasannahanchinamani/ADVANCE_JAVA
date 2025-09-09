package java8_features.insurance_system;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.sum;

public class MainPolicy {
    public static void main(String[] args) {
        // Create a list of Policy objects
        List<Policy> policyList = new ArrayList<>();

        // Add sample policies
        policyList.add(new Policy("POL1001", "Prasanna", 1100.50));
        policyList.add(new Policy("POL1002", "Prajwal", 1500.00));
        policyList.add(new Policy("POL1003", "Pramodh", 1800.75));

        System.out.println("print Original List");
        policyList.forEach(System.out::println);

//        System.out.println("Filter Policies by Premium Amount");)
//        policyList.sort((e1,e2) -> (Double.compare(e2.getPremiumAmount(),e1.getPremiumAmount())));

        System.out.println("After filtering  List");
        policyList.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .forEach(System.out::println);

        //Sort Policies by Holder Name:
        policyList.sort((e1, e2) -> (e1.getHolder_Name().compareTo(e2.getHolder_Name())));
        System.out.println(" Sort Based on HolderName List");
        policyList.forEach(System.out::println);

        // Compute Total Premium
        double totalPremium = policyList.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();

        System.out.println("Total Premium: " + totalPremium);

    }
}