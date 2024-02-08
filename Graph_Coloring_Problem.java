
package ProjectCode;

import java.util.Scanner;

public class Graph_Coloring_Problem {

   static int node,edges,a,b,m;
        
    static int color[];
    
    static int graph[][];
    
    static boolean isSafe(int v,int c){
        
        for(int i=0;i<node;i++){
            
            if( graph[v][i]==1 && color[i]==c ){
                
                return false;
            }
            
        }
        
        return true;
        
    }
    
    static boolean graphColoringUtil(int v){
        
        if( v==node ){
            
            return true;
            
        }
        
        for(int i=1;i<=m;i++){
            
            if( isSafe( v,i ) ){
                
                color[v]=i;
                
                if( graphColoringUtil( v+1 ) ){
                    
                    return true;
                    
                }
                
                color[v]=0;
                
            }
            
        }
        
        return false;
        
    }
    
    static void printSolution(){
        
        System.out.println("solution exist and assignmed color are: ");
        
        for(int i=0;i<node;i++){
            
            System.out.print(color[i]+"  ");
            
        }
        
        System.out.println();
        
    }
    
    static boolean graphColoring(){
        
        color=new int[node];
        
       if( !graphColoringUtil( 0 ) ){
           
           System.out.println("solution not exist");
           
           return false;
           
       }
        
       printSolution();
       
       return true;
       
    }
    
    static Scanner scanner=new Scanner(System.in);
    
    public static void main(String[] args) {
        
        node=scanner.nextInt();
        
      graph=new int[node][node];
        
        edges=scanner.nextInt();
        
        m=scanner.nextInt();
        
        for(int i=0;i<edges;i++){
            
            a=scanner.nextInt()-1;
            
            b=scanner.nextInt()-1;
            
           try{
               
               graph[a][b]=1;
              
           }catch(Exception e){
               
               
           }
            
           try{
               
               graph[b][a]=1;
               
           }catch(Exception e){
               
               
           }
           
        }
    
        System.out.println("inputed matrix: ");
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
                
                System.out.print(graph[i][j]+"  ");
                
            }
            
            System.out.println();
            
        }
        
        graphColoring();
        
    }
    
}
/*5 5 5
1 2
1 3
2 3
2 4
4 5*/

/*5 5 3
1 2
1 3
2 3
2 4
4 5*/

/*4 5 3
2 1
3 1
3 2
4 1
4 3*/

/*5 8 3
1 2 
1 3 
2 3 
2 4 
2 5 
4 3 
4 2 
5 4 */