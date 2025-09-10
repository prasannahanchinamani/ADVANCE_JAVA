package java8_features.insurance_system;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

public class MainPolicy {
    // Sort Based on amount List
    public static void filtering_premiumAMount(List<Policy> policyList) {
        policyList.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .forEach(System.out::println);
    }

    //Sort Based on HolderName List
    public static void filtering_holderName(List<Policy> policyList) {
        policyList.sort((e1, e2) -> (e1.getHolder_Name().compareTo(e2.getHolder_Name())));
        System.out.println(" Sort Based on HolderName List");
        policyList.forEach(System.out::println);
    }

    //printing
    public static void print_Policy_Details(List<Policy> policyList) {
        policyList.stream().forEach(System.out::println);
    }

    //total premium
    public static void total_premium(List<Policy> policyList) {
        double totalPremium = policyList.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();
        System.out.println("Total sum:" + totalPremium);
    }

    //range between 1000 and 2000
    public static void premium_Range(List<Policy> policyList) {
        List<Policy> filteredList = policyList.stream()
                .filter(p -> p.getPremiumAmount() > 1000 && p.getPremiumAmount() < 2000) // correct condition
                .collect(Collectors.toList());

        filteredList.forEach(System.out::println);
    }

    //Higest premium amount
    public static void highest_premium(List<Policy> policyList) {
        int maximumAmount = policyList.stream()
                .mapToInt(p -> (int) p.getPremiumAmount())
                .max()
                .orElse(-1);
        System.out.println("maxium Premium amount:" + maximumAmount);
    }

    //group by based on holder name initial
    public static void groupby(List<Policy> policyList) {
        Map<Character, List<Policy>> groupBy = policyList.stream()
                .collect(Collectors.groupingBy(p -> p.getHolder_Name().charAt(0)));
        groupBy.forEach((letter, policies) -> {
            System.out.println("letter: " + letter);
            policies.forEach(System.out::println);
        });

    }

    //8. Compute Average Premium
    public static void averagePremium(List<Policy> policyList) {
        double avg = policyList.stream()
                .mapToDouble(Policy::getPremiumAmount) // better to use double
                .average()
                .orElse(0.0); // default if list is empty

        System.out.println("Average Premium = " + avg);
    }

    //  9 Sort Policies by Premium and Print
    public static void sort_premiumAmount(List<Policy> policyList) {
        policyList.sort((p1, p2) ->
                (p1.getPremiumAmount() < p2.getPremiumAmount()) ? -1 :
                        (p1.getPremiumAmount() > p2.getPremiumAmount()) ? 1 : 0
        );

        policyList.forEach(System.out::println);
    }

    // 10. Check If Any Policy Exceeds a Certain Premium
    public static void filtering_premiumAMount_Range(List<Policy> policyList) {
        policyList.stream()
                .filter(p -> p.getPremiumAmount() > 2000)
                .forEach(System.out::println);
    }

    // 11. Count Policies for Each Premium Range
    public static void range_Counting(List<Policy> policyList) {
        
    }


    public static void main(String[] args) {
        // Create a list of Policy objects
        List<Policy> policyList = new ArrayList<>();

        // Add sample policies
        policyList.add(new Policy("POL1001", "Prasanna", 1100.50));
        policyList.add(new Policy("POL1002", "Prajwal", 1500.00));
        policyList.add(new Policy("POL1003", "Pramodh", 1800.75));
        policyList.add(new Policy("POL1003", "Raghu", 100.75));
        System.out.println("print Original List");
        policyList.forEach(System.out::println);

        System.out.println("After filtering  List");
        filtering_premiumAMount(policyList);

        //Sort Policies by Holder Name:
        System.out.println("After filtering  List holder_name");
        filtering_holderName(policyList);


        // Compute Total Premiu
        System.out.println("Total Premium");
        total_premium(policyList);

        //printinf deatils
        print_Policy_Details(policyList);
        System.out.println();
        //print policy based on premium range
        premium_Range(policyList);
        //print  the higest policy
        highest_premium(policyList);
        //group by based on holder name initial
        groupby(policyList);
        //average premium
        averagePremium(policyList);
        //sort based on primium amount
        sort_premiumAmount(policyList);
        // 10. Check If Any Policy Exceeds a Certain Premium
        filtering_premiumAMount_Range(policyList);
        //count range
        range_Counting(policyList);

    }
}