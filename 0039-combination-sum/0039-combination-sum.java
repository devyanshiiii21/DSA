class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        findCombinations(0,candidates,target,ans,list);
        return ans;
    }
    
    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> list){
        
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(arr[index] <= target){
            list.add(arr[index]);
            findCombinations(index, arr, target-arr[index], ans, list);
            list.remove(list.size()-1);
        }
        findCombinations(index+1, arr, target, ans, list);
    }
}