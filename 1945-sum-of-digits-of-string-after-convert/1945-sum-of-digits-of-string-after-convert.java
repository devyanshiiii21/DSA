class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to its numeric transformation
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            int num = ch - 'a' + 1;  // 'a' corresponds to 1, 'b' to 2, ..., 'z' to 26
            ans.append(num);
        }
        
        // Step 2: Convert the resulting number string to a sum of digits
        String numStr = ans.toString();
        int sum = 0;
        for (char ch : numStr.toCharArray()) {
            sum += (ch - '0');  // Sum of digits of the numeric transformation
        }
        
        // Step 3: Repeat the transformation for k-1 times
        for (int i = 1; i < k; i++) {
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10;
                sum /= 10;
            }
            sum = newSum;
        }
        
        return sum;
    }
}
