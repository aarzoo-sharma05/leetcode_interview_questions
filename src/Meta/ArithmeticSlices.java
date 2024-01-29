package Meta;
import java.util.*;

//An integer array is called arithmetic if it consists of at least three elements and if the
// difference between any two consecutive elements is the same.
//
//For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
//Given an integer array nums, return the number of arithmetic subarrays of nums.
//
//A subarray is a contiguous subsequence of the array.
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            int j = i + 2;

            while (j < n && nums[j] - nums[j - 1] == diff) {
                j++;
                count++;
            }
        }

        return count;
    }
}
