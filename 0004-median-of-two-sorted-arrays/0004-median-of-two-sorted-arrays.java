import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        double med =0.0;
        for(int i = 0; i < nums1.length; i++){
            arr.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            arr.add(nums2[j]);
        }
        Collections.sort(arr);
        
        int medium = arr.size()/2;
        if(arr.size() % 2 == 1){
            med = arr.get(medium);
        }
        else{
            med = (arr.get(medium)+ arr.get(medium-1))/2.0;
        }
        return med;
    }
}