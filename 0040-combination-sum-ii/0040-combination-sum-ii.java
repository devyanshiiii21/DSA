class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,list);
        return ans;
    }
    
    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> list){
        
            if(target == 0){
                ans.add(new ArrayList<>(list));
                return;
        }
        
        for(int i = index; i< arr.length; i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
       
            list.add(arr[i]);
            findCombinations(i+1, arr, target-arr[i], ans, list);
            list.remove(list.size()-1);
        }
    }
}