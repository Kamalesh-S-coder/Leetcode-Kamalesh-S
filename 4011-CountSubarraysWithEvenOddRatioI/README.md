# 4011. Count Subarrays With Even Odd Ratio I

**Difficulty:** Medium  
[View on LeetCode](https://leetcode.com/problems/count-subarrays-with-even-odd-ratio-i/)

---

You are given an integer array `nums` and two integers `a` and `b`.

For a subarray, let:

- `x` be the number of even elements.
- `y` be the number of odd elements.

The ratio of even to odd elements in a subarray is defined as `x / y`, where ratios are compared by their exact rational values.

A subarray is considered **valid** if:

- `y > 0`, and
- `x / y <= a / b`.

Return the number of valid subarrays in `nums`.

**Example 1:**

**Input:** nums = [1,2,1,2], a = 3, b = 2

**Output:** 7

**Explanation:**

The following are the valid subarrays:

<table style="border: 1px solid black;">
	<tbody>
		<tr>
			<th style="border: 1px solid black;">Subarray</th>
			<th style="border: 1px solid black;">Values</th>
			<th style="border: 1px solid black;">Even Count</th>
			<th style="border: 1px solid black;">Odd Count</th>
			<th style="border: 1px solid black;">Ratio</th>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[0..0]</code></td>
			<td style="border: 1px solid black;"><code>[1]</code></td>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>0 / 1</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[0..1]</code></td>
			<td style="border: 1px solid black;"><code>[1, 2]</code></td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>1 / 1</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[0..2]</code></td>
			<td style="border: 1px solid black;"><code>[1, 2, 1]</code></td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;"><code>1 / 2</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[0..3]</code></td>
			<td style="border: 1px solid black;"><code>[1, 2, 1, 2]</code></td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;"><code>2 / 2</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[1..2]</code></td>
			<td style="border: 1px solid black;"><code>[2, 1]</code></td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>1 / 1</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[2..2]</code></td>
			<td style="border: 1px solid black;"><code>[1]</code></td>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>0 / 1</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[2..3]</code></td>
			<td style="border: 1px solid black;"><code>[1, 2]</code></td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>1 / 1</code></td>
		</tr>
	</tbody>
</table>

Thus, the number of valid subarrays is 7.

**Example 2:**

**Input:** nums = [2,2,1], a = 2, b = 1

**Output:** 3

**Explanation:**

The following are the valid subarrays:

<table style="border: 1px solid black;">
	<tbody>
		<tr>
			<th style="border: 1px solid black;">Subarray</th>
			<th style="border: 1px solid black;">Values</th>
			<th style="border: 1px solid black;">Even Count</th>
			<th style="border: 1px solid black;">Odd Count</th>
			<th style="border: 1px solid black;">Ratio</th>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[0..2]</code></td>
			<td style="border: 1px solid black;"><code>[2, 2, 1]</code></td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>2 / 1</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[1..2]</code></td>
			<td style="border: 1px solid black;"><code>[2, 1]</code></td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>1 / 1</code></td>
		</tr>
		<tr>
			<td style="border: 1px solid black;"><code>nums[2..2]</code></td>
			<td style="border: 1px solid black;"><code>[1]</code></td>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;"><code>0 / 1</code></td>
		</tr>
	</tbody>
</table>

Thus, the number of valid subarrays is 3.

**Example 3:**

**Input:** nums = [2,2,2], a = 1, b = 1

**Output:** 0

**Explanation:**

Every subarray contains 0 odd numbers, so no subarray is valid.

**Constraints:**

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 1000`
- `1 <= a, b <= 1000`
