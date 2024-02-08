
package Lab9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath_From_Source_To_Distance {

    static Scanner scanner=new Scanner(System.in);
    
    static int nodes,edges,a,b,weight,source,distination;
    
    static List< List<Integer> > paths=new ArrayList<>();
    
    static List<Integer> list[];
    
    static List<Integer> path;
    
    static List<Integer> parent[];
    
    static void BFS(){
        
        List<Integer> distance=new ArrayList<>(0);
        
        for(int i=0;i<nodes;i++){
            
            distance.add(Integer.MAX_VALUE);
            
        }
                        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        pq.add(source);
        
        parent[source].add(-1);
        
        distance.set(source, 0);
        
        while(!pq.isEmpty()){
            
            int u=pq.poll();
            
            for(int v: list[u]){
                
                if(  distance.get(v)>distance.get(u)+1){
                    
                    distance.set(v, distance.get(u)+1 );
                    
                    
                    pq.add(v);
                
                    parent[v].clear();
                    
                    parent[v].add(u);
                    
                }else if( distance.get(v)==distance.get(u)+1 ){
                    
                    parent[v].add( distance.get(u)+1 );
                    
                }
                
            }
            
        }
        
    }
    
    static void findPaths(List<Integer> parent[],int u){
        
        if( u==-1 ){
            
            paths.add(path);
            
            return;
            
        }
        
        try{
        
            System.out.println("u: "+u);
            
        for(int par: parent[u]){
            
            path.add(u);
            
            findPaths(parent,par);
            
            path.remove( path.size()-1 );
            
        }
        
        }catch(Exception e){
            
            
        }
        
    }
    
    static void printPaths(){
        
        BFS();
        
        findPaths(parent,source);
        
        for(List i: paths){
            
            Collections.reverse(i);
            
            List<Integer> l=i;
            
            for(int u: l){
                
                System.out.print(u+"  ");
                
            }
            
            System.out.println();
            
        }
        
    }
    
    public static void main(String[] args) {
        
        nodes=scanner.nextInt();
        
        list=new ArrayList[nodes];
        
        parent=new ArrayList[nodes];
        
        for(int i=0;i<nodes;i++){
            
            list[i]=new ArrayList<>();
            
            parent[i]=new ArrayList<>();
            
        }
        
        edges=scanner.nextInt();
        
        for(int i=0;i<edges;i++){
            
            a=scanner.nextInt()-1;
            b=scanner.nextInt()-1;
            
            try{
                
                list[a].add(b);
                
            }catch(Exception e){
                
                
            }
            
            try{
                
                list[b].add(a);
                
            }catch(Exception e){
                
                
            }
            
        }
        
        source=scanner.nextInt()-1;
        distination=scanner.nextInt()-1;
        
        printPaths();
        
    }
          
}
/*6 7
1 2 
1 3 
2 4 
2 5 
3 4 
4 6 
5 6 
1 6*/

/*6 8
1 1 
1 2 
1 3 
2 4 
2 5 
3 4 
4 6 
5 6 
1 6*/