class Solution {
    public double myPow(double x, long n) {
        double result = 1.0;
        double mul = 1.0;
        if( n == 0){
            return 1;
        }
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }
        while(n!=0){
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}