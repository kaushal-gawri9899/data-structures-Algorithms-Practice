class Solution{

    public int search(int[] nums, int target)
    {

        int end = nums.length-1;
        int start = 0;
        int index = -1;

        while(start<=end)
        {
            int mid = start + (end-start)/2;

            if(nums[mid]==target)
            {
                index = mid;
                return index;
            }

            if(nums[start]<=nums[mid])
            {
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[end])
                {
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
            }

        }

        return index;
    }
}