/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
class Solution {
    
    
    public int[] productExceptSelf(int[] nums)
    {
        /*An example of preprocessing
        
        We create a solution array and initialize it with 1
        We declare a variable left
        Now, we iterate over nums and update our solution array and variable left such that solution[i]=solution[i]*left and left=left*nums[i]
        This basically updates the solution array such that left variable will have the values as the product of all values from index 0 to index i, i.e, left = nums[0]*nums[1]*nums[2]*...nums[i]  
        
        Now, we iterate over nums again and update our solution array and variable right such that solution[i] = solution[i]*right and right=right*nums[i] where i=len-1 and i>=0, that is we start from the end
        This basically updates the solution array such that right variable will have the values as the product of all values from index len-1 to index i, i.e, right = nums[len-1]*nums[len-2]*nums[len-3]...*nums[i]
        
        */
        int len = nums.length;
        int[] solution = new int[len];
        
        Arrays.fill(solution, 1);
        
        int left = 1;
        
        /*Dry Run 
        
        solution : 1 1 1 1
        left=1
        i=0         solution[0] = 1*1 = 1        left=1*1=1
        
        i=1         solution[1] = 1*1 = 1       left=1*2=2
        
        i=2         solution[2] = 1*2 = 2       left=2*3=6
        
        i=3         solution[3] = 1*6 = 6       left=6*4=24
        
        
        //Updated the current values such that they are a product of all values from index 0 to index i-1
        
        solution : 1 1 2 6
        right=1
        
        i=3         solution[3] = 6*1 = 6       right=1*4=4
        
        i=2         solution[2] = 2*4 = 8       right=4*3=12
        
        i=1         solution[1] = 1*12 = 12     right=12*2=24
        
        i=0         solution[0] = 1*24 = 24     right=24*1=24
        
        Thus, solution array to be returned is : [24,12,8,6]
        
        */
        for(int i=0; i<len; i++)
        {
            solution[i]=solution[i]*left;
            left= left*nums[i];
        }
        
        int right = 1;
        
        for(int i=len-1; i>=0; i--)
        {
            solution[i]=solution[i]*right;
            right=right*nums[i];
        }
        
        return solution;
    }
    
    
    /*BRUTE FORCE*/
//     public int[] productExceptSelf(int[] nums) {
        
//         //int product = 0;
//         int[] solution = new int[nums.length];
        
//         for(int i=0; i<nums.length; i++)
//         {
//             int product =1;
//             for(int j=0; j<nums.length; j++)
//             {
//                 if(i!=j)
//                 {
//                     product*=nums[j];
//                 }
//             }
            
//             solution[i] = product;
//         }
        
//         return solution;
//     }
}
