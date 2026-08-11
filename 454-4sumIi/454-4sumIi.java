// Last updated: 11/08/2026, 14:20:51
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
	var pairCountBySum = new HashMap<Integer, Integer>();
	
	Arrays.stream(nums1)
		  .forEach(num1 -> Arrays.stream(nums2)
							     .forEach(num2 -> pairCountBySum.compute(num1 + num2, (k, sumCount) -> sumCount == null ? 1 : ++sumCount)));
		  
	return Arrays.stream(nums3)
				 .map(num3 -> Arrays.stream(nums4)
								    .map(num4 -> pairCountBySum.getOrDefault(-(num3 + num4), 0))
									.sum())
				 .sum();
}
}