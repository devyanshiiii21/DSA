class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ds = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        recurseSubset(0, nums, ans, ds);
        return ds;
    }

    private void recurseSubset(int index, int[] nums, List<Integer> ans, List<List<Integer>> ds) {
        ds.add(new ArrayList<>(ans)); 
        
        for (int i = index; i < nums.length; i++) {
            ans.add(nums[i]); 
            recurseSubset(i + 1, nums, ans, ds); 
            ans.remove(ans.size() - 1); 
        }
    }
}