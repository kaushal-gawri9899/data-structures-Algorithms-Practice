import java.util.LinkedList;

public class solution {
    private LinkedList<Integer> adj[];

    //Here s is the source node
    public void bfs(int s)
    {
        //v could be the number of vertices
        int v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
        {
            adj[i] = new LinkedList();
        }


        boolean visited[] = new boolean[v];
        
        LinkedList<Integer> queue = new LinkedList();
        visited[s]=true;
        queue.add(s);

        //or while(queue.size()!=0)
        while(!queue.isEmpty())
        {
            //Dequeue a vertex from our queue 
            s = queue.poll();
            System.out.println(s+" ");

            //now visit all the neighbours of the current vertex. If it hasn't been visited mark that vertex visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            //Iterate over all the neighbours of source s
            while(i.hasNext())
            {
               int node = i.next();
               if(!visited[node])
               {
                   visited[node]=true;
                   queue.add(node);
               }
            }

        }


    }
}
