
package LabExam;

import java.util.Scanner;

// I took a boolean which will check if the node is Available or not
//using the input given by the user, the node which must be visited, I compared with existing node
//if match found, my program will add cost, othewise ignore
//thats how the code will go through a certain node

public class Problem2 {

    static int nodes,edges,weight,source,distination,a,b,target;
    
    static Scanner scanner=new Scanner(System.in);
    
    static int graph[][];
    
    static boolean visited[];
    
    static int minCostPath(int start,int end){
        
        if( start==end ){
            
            return 0;
            
        }
        
        visited[start]=true;
        
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<nodes;i++){
            
            if( graph[start][i]!=Integer.MAX_VALUE && !visited[i] ){
                
                int curr=minCostPath(i,distination);
                
                if( curr<Integer.MAX_VALUE ){
                    
                    ans=Math.min(ans, graph[start][i]+curr );
                    
                }
                
            }
            
        }
        
        visited[start]=false;
        
        return ans;
        
    }
    
    public static void main(String[] args) {
        
        nodes=scanner.nextInt();//take the total number of vertices
        
        graph=new int[nodes][nodes];//initialize the size of matrix
        
        visited=new boolean[nodes];//check if the node visited or not
        
        edges=scanner.nextInt();//take the tottal number of edges
        
        for(int i=0;i<nodes;i++){
            
            for(int j=0;j<nodes;j++){
                
                graph[i][j]=Integer.MAX_VALUE;//first initialize all the distance as infinity
                
            }
            
        }
        
        for(int i=0;i<edges;i++){
            
            a=scanner.nextInt()-1;//take input of the source
            b=scanner.nextInt()-1;//take input of the child
            
            weight=scanner.nextInt();//take input of the weight
            
            graph[a][b]=weight;//store it in the matrix
            
          //  graph[b][a]=weight;
            
        }
        
        source=scanner.nextInt()-1;//take the source vertex
        distination=scanner.nextInt()-1;//input the distiantion
        
        target=scanner.nextInt()-1;//input the raget vertices
        
        visited[source]=true;//marked source as visited
        
        int x=minCostPath( source,target );//find the distance between source and targer
        int y=minCostPath(target,distination);//fins the ditance between target and distination

        System.out.println("x: "+x+" y: "+y);
        
        System.out.println("The cost is: "+ (x+y ) );//finally add their sum
        
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
1 7 4*/

/*4 5
1 2 1
2 3 2
1 3 1
1 4 5
4 3 6
1 3 2*/

/*5 5
1 2 3
1 5 1
5 4 4
2 3 2
3 5 4
1 3 5*/
