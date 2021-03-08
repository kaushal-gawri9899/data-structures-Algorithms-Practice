public class DSU{

    private Map<Integer, Integer> parent = new HashMap<>();
    
    //Perform makeset operation
    public void makeSet(int[] nodes)
    {
        //create n disjoint set (one for each item)
        for(int i : nodes)
            parent.put(i,i);
    }

    //Find the root(representative) of set in which element k belongs
    public int find(int k)
    {
        //If k is the root 
        //Base case
        if(parent.get(k)==k)
        return k;

        // Recur for the parent of k until we find the root
        return find(parent.get(k));
    }

    //Make union for two subsets
    public void union(int a, int b)
    {
        //Find the root or representatives of the subsets in which elements x and y belong
        int x = find(a);
        int y = find(b);

        parent.put(x,y);
    }

}
    class Main
    {

        public static void main(String[] args)
        {

            int[] nodes = {1,2,3,4,5};
            DSU set = new DSU();

            set.makeSet(nodes);

            //4 and 3 in same set
            set.union(4, 3);
            //Set we have now are {1} {2} {3,4} (3 is the reference for 3 and 4) {5}

            //2 and 1 in same set
            set.union(2,1);
            //Set we have now are {1,2} {3,4} {5} (1 is the reference for 1 and 2)

            //1 and 3 in same set
            set.union(1,3);
            //Set we have now {1,2,3,4} {5} (3 is the reference for 1,2,3 and 4)
        }
    }

