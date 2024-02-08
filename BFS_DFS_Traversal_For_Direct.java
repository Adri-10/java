
package Mid2PreparetionDynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Graph{
    
    int v,u;

    List< List<Integer> > list=new ArrayList<>();
Map<Integer,Integer> map=new HashMap<>();
Queue<Integer> q=new LinkedList<>();    

    public Graph(int v) {
    
        this.v = v;
    
        list=new ArrayList<>();
        
        for(int i=0;i<v;i++){
            
            list.add( new ArrayList<>() );
            map.put(i, 0);
            
        }
        
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
    
    void AddEdge(int a,int b){
        
        list.get(a).add(b);
     //   list.get(b).add(a);
     
     map.put(b, map.get(b)+1);
     
        
    }
    
    void printGraph(){
        
    for(int i=0;i<this.getV();i++){
        
        System.out.print("Node "+i);
        
        for(int x: list.get(i)){
            
            System.out.print(" -> "+x);
            
        }
        
        System.out.println();
        
    }    
        
    }
    
    void dfsHelper(int node,boolean visited[]){
        
        visited[node]=true;

        System.out.print(node+" ");

        list.get(node).stream().filter((x) -> ( visited[x]==false )).forEachOrdered((x) -> {
            dfsHelper( x,visited );
        });        
        
    }
    
    void DFS(int started){
        
        boolean []visited=new boolean[this.getV()];
        
        System.out.print("The dfs traversal is: ");
        
        dfsHelper( started,visited );
        
        System.out.println();
        
    }
    
    void BFS(int started){
        
        boolean visited[]=new boolean[this.getV()];
        
        Queue<Integer> queue=new LinkedList<>();
        
        queue.add(started);
        
        visited[started]=true;
        
        System.out.print(" The BFS traversal is: ");
        
        while( !queue.isEmpty() ){
            
            int node=queue.poll();
            
            System.out.print(node+" ");
            
            list.get(node).stream().filter((x) -> ( visited[x]==false )).map((x) -> {
                visited[x]=true;
                return x;
            }).forEachOrdered((x) -> {
                queue.add(x);
            });
            
        }
        
        System.out.println();
        
    }
    
    void Connected_Component(){
        
        System.out.print("Connected component's:  ");
        
        boolean visited[]=new boolean[this.getV()];
        
        for(int i=0;i<this.getV();i++){
            
            if( visited[i]==false ){
                
                dfsHelper( i,visited );
                System.out.println();
            }
            
        }
        
    }
    
    boolean isCycle(){
    
        System.out.println("Map value: "+map.toString());
        
        /*for(int i=0;i<map.size();i++){
            
            System.out.println(map.get(i)+" ");
            
        }*/
        
    //    System.out.println("");
        
        map.entrySet().stream().filter((entry) -> ( entry.getValue()==0 )).forEachOrdered((entry) -> {
            q.add(entry.getValue());
        });
        
        int visitedNode=0;
        
        while(!q.isEmpty()){
            
            visitedNode++;
               
            int source=q.remove();
            
            List<Integer> child=list.get(source);
            
            child.stream().map((children) -> {
                map.put(children, map.get(children)-1);
                return children;
            }).filter((children) -> (map.get(children)==0)).forEachOrdered((children) -> {
                q.add(children);
            });
            
        }
        
        return this.getV()!=visitedNode;
    }
    
    void findTheSmallestSourcePath(){
        
        int max=Integer.MAX_VALUE,ans=0;
        
        //List<Integer> l=new ArrayList<>();
        
        for(int i=0;i<this.getV();i++){
            
        if( max>list.get(i).size() ){
            
            max=list.get(i).size();
            
            ans=i;
            
        } 
            
        }
        
        System.out.println("shortest source: "+ans);
        
    }
    
}

public class BFS_DFS_Traversal_For_Direct {
    
    static Scanner scanner=new Scanner(System.in);
    
    public static void main(String[] args) {
        
     Graph graph=new Graph(5);   
        
     graph.AddEdge(0, 0);
     graph.AddEdge(0, 1);
     graph.AddEdge(0, 2);
     graph.AddEdge(0, 3);
     graph.AddEdge(0, 4);
     graph.AddEdge(1, 2);
     graph.AddEdge(1, 3);
     graph.AddEdge(1, 4);
     graph.AddEdge(2, 4);
     graph.AddEdge(2, 3);
     graph.AddEdge(2, 0);
     graph.AddEdge(3, 0);
     graph.AddEdge(3, 1);
     graph.AddEdge(3, 2);
     graph.AddEdge(3, 3);
     graph.AddEdge(3, 4);
     graph.AddEdge(4, 0);
     graph.AddEdge(4, 4);
     graph.AddEdge(4, 2);
     graph.AddEdge(4, 3);
     
     graph.printGraph();
     
     graph.DFS(1);
     graph.BFS(1);
     graph.Connected_Component();
     
        System.out.println("The graph is cycle: "+graph.isCycle());
     
        graph.findTheSmallestSourcePath();
        
    }
    
}
