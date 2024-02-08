
package Lab6;

import java.util.Scanner;

public class Floyed_Warshell {
    
    static Scanner scanner=new Scanner(System.in);
    
    static int node,edges,a,b,weight;
    
    static void detect(int mat[][]){
       
        int dis[][]=new int[node][node];
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
                
                dis[i][j]=mat[i][j];
                
            }
            
        }
        
       for(int k=0;k<node;k++){
            
            for(int i=0;i<node;i++){
                
                for(int j=0;j<node;j++){
                    
                    if(mat[i][k] == Integer.MAX_VALUE || mat[k][j] == Integer.MAX_VALUE) {
                    
                        continue;
                    
                    }
                    
        if(  (dis[i][k] + dis[k][j]) < dis[i][j]){ 
       
          //  System.out.println("I am here");
            
            System.out.println("for i: "+i+" and j: "+j+" dis[i][j]: "+dis[i][j]);
          
            System.out.println("for i: "+i+" j: "+j+" dis[i][k]: "+dis[i][k]+" dis[k][j] "+dis[k][j] );
            
        dis[i][j] = (dis[i][k] + dis[k][j]); 
                    
                   }
                        
                }
                
            }
         
            System.out.println("After the one rotation: ");
            
          for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
                
                if( dis[i][j]==Integer.MAX_VALUE ){
                    
                    System.out.print("IN   ");
                    
                }else
                
                System.out.print(dis[i][j]+"    ");
                
            }
            
            System.out.println();
            
        }   
            
        } 
        
       System.out.println("\nThe matrix is: ");
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
                
                if( dis[i][j]==Integer.MAX_VALUE ){
                    
                    System.out.print("IN   ");
                    
                }else
                
                System.out.print(dis[i][j]+"    ");
                
            }
            
            System.out.println();
            
        }
       
    }
    
    public static void main(String[] args) {
        
        node=scanner.nextInt();
        
        edges=scanner.nextInt();
        
        int mat[][]=new int[node][node];
        
       for(int i=0;i<node;i++){
           
           for(int j=0;j<node;j++){
               
               if( i==j ){
                   
                   mat[i][j]=0;
                   
               }else{
               
               mat[i][j]=Integer.MAX_VALUE;
               
               }
               
           }
           
       }
        
        for(int i=0;i<edges;i++){
            
            a=scanner.nextInt()-0;
            b=scanner.nextInt()-0;
            
            weight=scanner.nextInt();
            
            mat[a][b]=weight;
    //        mat[b][a]=weight;
        }
     
        
        
        System.out.println("before matrix: ");
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
        
                if( mat[i][j]==Integer.MAX_VALUE ){
                    
                    System.out.print("IN   ");
                    
                }else
                
                System.out.print(mat[i][j]+"    ");
                
            }
            
            System.out.println();
            
        }
       
        detect(mat);
               
    }
    
}
/*4 4
1 2 5
2 3 3
3 4 1
1 4 10*/

/*4 7
1 4 7
1 2 3
2 1 8
2 3 2
3 1 5
3 4 1
4 1 2*/

/*4 6
1 2 5
1 3 8
1 4 9
2 3 3
2 4 4
3 4 1*/

/*quize:

6 9
0 1 4
0 2 3
1 2 5
1 3 2
2 3 7
3 4 2
4 0 4
4 1 4
4 5 6

*/