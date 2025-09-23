package simple;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

public class nslnsr {
    public static int[] nsl(int arr[]) {
        int nsl[] = new int[arr.length];
////        2, 3, 4, 2, 6, 5, 4, 5, 3
////        [-1, 0, 1, -1, 3, 4, 5, 6, 3]
        nsl[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] >= arr[i]) {
                j--;
            }
            nsl[i] = (j >= 0) ? j : -1;
        }
        return nsl;
    }

    public static int[] nsr(int arr[]) {
        //  2, 3, 4, 2, 6, 5, 4, 5, 3
//          9  3   3  9  5  6  8  8 9
        int nsr[] = new int[arr.length];
        nsr[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < arr.length && arr[j] >= arr[i]) {
                j++;
            }
            nsr[i] = (j < arr.length) ? j : arr.length;
        }
        return nsr;
    }

    public static int maxiumRectangle(int normal[]) {
        int left[] = nsl(normal);
        int right[] = nsr(normal);
        int maxium = 0;
        for (int i = 0; i < normal.length; i++) {
            maxium = Math.max(maxium, normal[i] * (right[i] - left[i] - 1));
        }
        return maxium;
    }

    public static int maximumrect(int arr[]) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int currentHegight = (i == n) ? 0 : arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > currentHegight) {
                int hgt = arr[stack.pop()];
                int wdt = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                ans = Math.max(ans, hgt * wdt);
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] prefixSum(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    public static int[] sufixSum(int arr[]) {
        int sufix[] = new int[arr.length];
        sufix[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >=0; i--) {
            sufix[i] = sufix[i + 1] + arr[i];
        }
        return sufix;
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 2, 6, 5, 4, 5, 3};
        int x[] = {6, 4, 5, -3, 2, 8};
        int max = maxiumRectangle(arr);
        System.out.println(max);
        int ans = maximumrect(arr);
        System.out.println(ans);
        int prefix[] = prefixSum(x);
        display(prefix);
        System.out.println();
        int sufix[] = sufixSum(x);
        display(sufix);

    }

}
