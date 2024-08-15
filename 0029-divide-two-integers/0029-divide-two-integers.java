class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow scenario
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor) return 1;
        
        boolean sign = (dividend >= 0) == (divisor >= 0); // Determine the sign of the result
        
        long n = Math.abs((long) dividend);  // Convert to long to handle overflow
        long d = Math.abs((long) divisor);   // Convert to long to handle overflow
        
        int ans = 0;
        
        while (n >= d) {
            long temp = d;
            int multiple = 1;
            
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            n -= temp;
            ans += multiple;
        }
        
        return sign ? ans : -ans;
    }
}
