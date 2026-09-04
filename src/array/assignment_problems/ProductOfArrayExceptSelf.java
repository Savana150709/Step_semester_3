package array.assignment_problems;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int product = 1;

        // Left products
        for (int i = 0; i < nums.length; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        product = 1;

        // Right products
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
