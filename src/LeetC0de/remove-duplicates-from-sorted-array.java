class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        int n = nums.length;
        
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int preElement = nums[0];
        count++;
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=preElement){
                preElement=nums[i];
                nums[j]=nums[i];
                j++;
                count++;
            }
        }
        return count;
    }
}