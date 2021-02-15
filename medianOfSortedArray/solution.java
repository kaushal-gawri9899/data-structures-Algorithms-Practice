/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] newArr = new int[nums1.length+nums2.length];
        
        int i =0;
        while(i<nums1.length){
            newArr[i] = nums1[i];
            i++;
        }
        
        int k = 0;
        for(int j=i; j<newArr.length; j++,k++){
            newArr[j] = nums2[k];
        }
        
        for(int n=0; n<newArr.length; n++){
            for(int m=1; m<newArr.length-n; m++){
                if(newArr[m-1]>newArr[m]){
                int temp = newArr[m-1];
                newArr[m-1] = newArr[m];
                    newArr[m] = temp;
                    }
            }
        }
        
        // for(int r=0; r<newArr.length; r++)
        //     System.out.print(newArr[r]);
        
        int sizeOfNewArray = newArr.length;
        double median = 0.0;
        if(sizeOfNewArray%2!=0){
            median = newArr[(sizeOfNewArray/2)];
        }
        else{
            int index = sizeOfNewArray/2;
            double newval = newArr[index-1] + newArr[index];
            System.out.print(newval/2);
            median = newval/2;
            
        }
        return median;
    }
}