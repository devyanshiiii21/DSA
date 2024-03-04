class Solution {
public:
    int singleNumber(vector<int>& nums) {
        if(nums.size()==1)return nums[0];
        sort(nums.begin(),nums.end());
            int i=0;
            for(;i<nums.size()-2;i=i+3)
            {
                if(nums[i]==nums[i+1] && nums[i]==nums[i+2])continue;
                
                else return nums[i];
            }
        return nums[i];
    }
};