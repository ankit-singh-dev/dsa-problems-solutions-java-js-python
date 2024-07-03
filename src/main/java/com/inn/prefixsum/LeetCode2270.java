package prefixsum;

/*
 * https://leetcode.com/problems/number-of-ways-to-split-array/description/
 */

public class LeetCode2270 {

	public static void main(String[] args) {
		int[] nums = { 2,3,1,0 };
		System.out.println(waysToSplitArray(nums));
	}

	public static int waysToSplitArray(int[] nums) {
		int cnt = 0;
		int len = nums.length;
		for (int i = 1; i < len - 1; i++) {
			int leftSum = 0;
			for(int j=0;j<i;j++) {
				leftSum += nums[j];
			}
			int rightSum = 0;
			for(int j=i;j<len;j++) {
				rightSum += nums[j];
			}
			System.out.println(leftSum + " " + rightSum);
			if(leftSum >= rightSum) {
				cnt++;
			}
		}
		return cnt;
	}
}
