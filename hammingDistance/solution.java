/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Input: x = 1, y = 4
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 */
class Solution {
    public int hammingDistance(int x, int y) {
       
        if(x==y)
            return 0;
        
        // This is bit operation x XOR y
        // Returns the int of the binary value
        // when x = 1 and y = 4, bits = 5
        int bits = x^y, count =0;

        
        while(bits!=0)
        {
            bits = bits & (bits-1);
            count++;
        }
        return count;
        
    }
    
//     public int countBitDiff(int num)
//     {
//         int count=0;
//         //when num = 5, 
//         while(num!=0)
//         {
//             System.out.println(num);
//             //This is the bitwise AND operation
//             // num = 5 & 4 = 4, count++ = 1
//             // num = 4 & 3 = 0, count++ = 2 
//             num = num & (num-1);
//             System.out.println(num);
//             count++;
//         }
        
//         return count;
//     }
}