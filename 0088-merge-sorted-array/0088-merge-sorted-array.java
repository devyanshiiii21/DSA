class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int left = m-1, right = n-1, k = m+n-1;
        while(right>=0){
            if(left>=0 && nums1[left] >= nums2[right]){
                nums1[k] = nums1[left];
                left--;
                k--;
            }
            else{
                nums1[k] = nums2[right];
                right--;
                k--;
                
            }
        }
        
    }
}