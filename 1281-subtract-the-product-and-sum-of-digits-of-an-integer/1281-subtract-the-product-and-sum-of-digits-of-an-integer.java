class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, pro = 1, rem = 0;
        int result =0;
        while(n>0){
            rem = n%10;
            sum = sum + rem;
            pro = pro * rem;
            n/=10;
        }
        result = pro - sum;
        return result;
    }
}