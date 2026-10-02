class Solution {
    public String multiply(String num1, String num2) {
        // Handle the edge case where either number is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        
        // Multiply each digit starting from the rightmost side
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Indices for where the two-digit result will be added
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add the current multiplication result to any existing value in pos[p2]
                int sum = mul + pos[p2];
                
                // Set the ones digit at p2, and carry over the tens digit to p1
                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }
        
        // Build the final string, skipping any leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }
}