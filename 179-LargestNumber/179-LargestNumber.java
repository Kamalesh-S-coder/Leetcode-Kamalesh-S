// Last updated: 11/08/2026, 20:57:43
class Solution {
    public String largestNumber(int[] nums) {
        // Convert each integer to string
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        
        // Sort strings using custom comparator
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                String order1 = n1 + n2;
                String order2 = n2 + n1;
                return order2.compareTo(order1); // Sort in descending order
            }
        });
        
        // Handle edge case where the largest number is "0"
        if (numStrings[0].equals("0")) {
            return "0";
        }
        
        // Concatenate sorted strings to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String numString : numStrings) {
            largestNumber.append(numString);
        }
        
        return largestNumber.toString();
    }
}
