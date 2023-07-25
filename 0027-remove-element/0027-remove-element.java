import java.util.ArrayList;
import java.util.List;

class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            if (num != val) {
                numList.add(num);
            }
        }

        // Copy the updated elements back to the array
        for (int i = 0; i < numList.size(); i++) {
            nums[i] = numList.get(i);
        }

        return numList.size();
    }
}