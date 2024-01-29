package Meta;
import java.util.*;

//Given an unsorted array of integers nums, return the length of the longest continuous increasing
//subsequence (i.e. subarray). The subsequence must be strictly increasing.
public class LongestLIS {
    public int findLengthOfLCIS(int[] nums) {
        int left = 0, right = 1, maxLen = 0;
        if(nums.length == 1){
            return 1;
        }
        while(right < nums.length){
            if(nums[right] > nums[right-1]){
                right++;
            }

            if(right == nums.length || nums[right] <= nums[right-1]){
                maxLen = Math.max(maxLen, right-left);
                left = right;
                right++;
            }
        }
        return maxLen;
    }
}
