/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //Something i have already done
        //This is the merge method used in merge sort with the constraint of not using extra space
        //Make sure to compare the last element from both arrays
        //Add the larger element at end of the nums1 array
        //reduce the counter depending on above condition
        
        int end1 = m-1;
        int end2 = n-1;
        int last = m+n-1;
        
        while(end1>=0 && end2>=0){
            if(nums1[end1]>nums2[end2])
            {
                nums1[last] = nums1[end1];
                end1--;
            }
            else{
                nums1[last] = nums2[end2];
                end2--;
            }
            last--;
        }
        
        //Now, one array would become empty and need to add rest element in nums1 from that array
        while(end2>=0){
            nums1[last] = nums2[end2];
            end2--;
            last--;
        }
        
    }
}