class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursivePermutate(0, nums, ans);
        return ans;
    }
    private void recursivePermutate(int index, int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i< nums.length; i++){
            swap(i,index, nums);
            recursivePermutate(index+1, nums, ans);
            swap(i,index, nums);
        }
    }
    private void swap(int index, int i, int[] nums){
        int temp;
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
    }
}