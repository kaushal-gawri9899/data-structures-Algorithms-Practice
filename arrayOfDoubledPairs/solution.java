/**
 * Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.
 * 
 * Input: arr = [3,1,3,6]
 * Output: false
 */
class Solution {
    
    /*
    Explanation : Count all the numbers
                  Loop all the numbers in order of their absolute value, thus we will use a Treemap
                  Now, we have the count of a value v, now we need the amount of 2x to match them
                  By chance if count of value v in map is > count of value 2*v, we return false
                  If the count of value v in map is <= count of value 2*v, we update the value of 2*v in map to be map.get(2*v) - map.get(v)
                 
    */
    public boolean canReorderDoubled(int[] arr) {
        
        //We use a TreeMap so that we don't need to worry about the signed values
        Map<Integer, Integer> map = new TreeMap<>();
        
        //Fill our map with all the values in array
        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        for(int v : map.keySet())
        {
            
            //Not available in our map yet
            if(map.get(v)==0)
                continue;
            
            //Check if the value is less than 0, divide by 2 if so, else multiply by 2
            int req;
            if(v < 0)
                req = v/2;
            else
                req = 2*v;
           
            if(v<0 && v%2!=0 || map.get(v)>map.getOrDefault(req,0))
                return false;
            
            map.put(req, map.get(req)-map.get(v));
            
                
        }
        return true;
    }
}

// class Solution {
//     public boolean canReorderDoubled(int[] A) {
//         if(A.length == 0) return true;
        
//         TreeMap<Integer, Integer> map = new TreeMap(new Comparator<Integer>(){
//             public int compare(Integer a, Integer b){
//                 if(Math.abs(a)==Math.abs(b)) return a-b;
//                 return Math.abs(a)-Math.abs(b);
//             }
//         });
        
//         for(int a : A){
//             map.put(a, map.getOrDefault(a, 0)+1);
//         }
        
//         for(int even : map.keySet()) {
//             if(map.get(even) != 0){
//                 int odd = even*2;
//                 if(map.containsKey(odd) && map.get(odd) >= map.get(even)){
//                     map.put(odd, map.get(odd)-map.get(even));
//                 }else{
//                     return false;
//                 }
//             }
//         }
        
//         return true;
//     }
// }