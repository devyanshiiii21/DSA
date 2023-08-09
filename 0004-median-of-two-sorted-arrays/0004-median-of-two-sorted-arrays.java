import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        double med =0.0;
        for(int i : nums1){
            arr.add(i);
        }
        for(int i : nums2){
            arr.add(i);
        }
        Collections.sort(arr);
        
        int size = arr.size();
        if(arr.size() % 2 == 1){
            med = arr.get(size/2);
        }
        else{
            med = (arr.get(size/2)+ arr.get(size/2 - 1))/2.0;
        }
        return med;
    }
}