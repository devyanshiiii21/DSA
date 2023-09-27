class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0){
               list1.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }
        }
        int[] arr1 = new int[nums.length];

        for (int i = 0, j = 0; i < nums.length; i = i + 2) {
            arr1[i] = list1.get(j);
            j++;
        }

        for (int i = 1, j = 0; i < nums.length; i = i + 2) {
            arr1[i] = list2.get(j);
            j++;
        }

        return arr1;
    }
}