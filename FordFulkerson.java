
package ClassWork5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class FordFulkerson {

    static Scanner scanner=new Scanner(System.in);
    
    static int nodes,edges,a,b,weight,source,sink;
    
    static int mat[][];
    
    static boolean BFS( int rc[][],Map<Integer,Integer> map,int source,int sink ){
        
        Set<Integer> visited=new HashSet<>();
        
        Queue<Integer> queue=new LinkedList<>();
        
        visited.add(source);
        
        queue.add(source);
        
        boolean foundPath=false;
        
        while( !queue.isEmpty() ){
            
            int u=queue.poll();
            
            for(int v=0;v<rc.length;v++ ){
                
                if( !visited.contains(v) && rc[u][v]>0 ){
                    
                    map.put(v, u);
                    
                    visited.add(v);
                    
                    queue.add(v);
                    
                    if( v==sink ){
                        
                        foundPath=true;
                        
                        break;
                        
                    }
                    
                }
                
            }
            
        }
        
        return foundPath;
        
    }
    
    static int maxFlow( int mat[][],int source,int sink ){
        
        int rc[][]=new int[mat.length][ mat[0].length ];
        
        for(int i=0;i<nodes;i++){
            
            for(int j=0;j<nodes;j++){
                
                rc[i][j]=mat[i][j];
                
            }
            
        }
        
        Map<Integer,Integer> map=new HashMap<>();
        
        List< List<Integer> > list=new ArrayList<>();
        
        int maxFlow=0;
        
      //  int u=sink;
        
        while( BFS( rc,map,source,sink ) ){
            
            List<Integer> path=new ArrayList<>();
            
            int flow=Integer.MAX_VALUE;
            
            int v=sink;
            
            while( v!=source ){
                
                path.add(v);
               
              int  u=map.get(v);
                
                if( flow>rc[u][v] ){
                    
                 flow=rc[u][v];
                    
                }
                
                v=u;
                
            }
            
            path.add(source);
            
            Collections.reverse(path);
            
            list.add(path);
            
            maxFlow+=flow;
            
            v=sink;
            
            while( v!=source ){
                
               int  u=map.get(v);
                
                rc[u][v]-=flow;
                rc[v][u]+=flow;
                
                v=u;
                
            }
            
        }
        
        System.out.println("Augmented paths");
        list.forEach(path -> {
            path.forEach(i -> System.out.print( (i+1) + " "));
            System.out.println();
        });
        
        return maxFlow;
    }
    
    public static void main(String[] args) {
        
        nodes=scanner.nextInt();
        
        edges=scanner.nextInt();
        
        mat=new int[nodes][nodes];
        
        for(int i=0;i<edges;i++){
            
            a=scanner.nextInt()-1;
            b=scanner.nextInt()-1;
            
            weight=scanner.nextInt();
            
            mat[a][b]=weight;
            
        }
        
        source=scanner.nextInt()-1;
        sink=scanner.nextInt()-1;
        
        System.out.println("max Flow: "+maxFlow( mat,source,sink ) );
        
    }
    
}
/*7 11
1 2 3
1 4 3
4 5 2
5 2 1
3 1 3
3 4 1
3 5 2
4 6 6
6 7 9
5 7 1
2 3 4
1 7*/

/*6 8
1 2 8
1 5 3
2 3 9
3 5 7
3 6 2
4 6 5
5 3 7
5 4 4
1 6*/

/*6
10
1 2 16
1 3 13
2 4 12
2 3 10
3 2 4
3 5 14
4 3 9
5 4 7
5 6 4
4 6 20
1 6*/