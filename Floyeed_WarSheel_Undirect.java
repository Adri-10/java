
package readyCopyForFinal;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Floyeed_WarSheel_Undirect {
    
    static Scanner scanner=new Scanner(System.in);
    
    static int node,edges,a,b,weight;
    
     static char[]ch={ 'A','B','C','D','E','F',
    'G','H','I','J','K','L',
    'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
     static char charA,charB;
     
    static List< Character > nodes=new ArrayList<>();
    
    static void detect(int mat[][]){
       
        int dis[][]=new int[node][node];
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
                
                dis[i][j]=mat[i][j];
                
            }
            
        }
        
        System.out.println("before matrix: ");
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
        
                if( dis[i][j]==Integer.MAX_VALUE ){
                    
                    System.out.print("IN   ");
                    
                }else
                
                System.out.print(dis[i][j]+"    ");
                
            }
            
            System.out.println();
            
        }
        
       for(int k=0;k<node;k++){
        
          // System.out.println("I am here");
           
            for(int i=0;i<node;i++){
            
        //        System.out.println("I am hetre");
                
                for(int j=0;j<node;j++){
                    
     if(dis[i][k] == Integer.MAX_VALUE || dis[k][j] == Integer.MAX_VALUE) {
     
         continue;
                    
     }
                    
        dis[i][j]=Math.min( dis[i][j], dis[i][k] + dis[k][j] );
                        
                
                }
                
            }
            
        } 
        
       System.out.println("\nThe matrix is: ");
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<node;j++){
                
                if( mat[i][j]==Integer.MAX_VALUE ){
                    
                    System.out.print("IN   ");
                    
                }else
                
                System.out.print(dis[i][j]+"    ");
                
            }
            
            System.out.println();
            
        }
       
    }
    
    public static void main(String[] args) {
        
          for(int i=0;i<ch.length;i++){
            
            nodes.add( ch[i] );
            
        }
        
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
            
           charA=scanner.next().toUpperCase().charAt(0);
            charB=scanner.next().toUpperCase().charAt(0);
            
            a=nodes.indexOf( charA );
            b=nodes.indexOf( charB );
            
            weight=scanner.nextInt();
            
            try{
            
            mat[a][b]=weight;
            
            }catch(Exception e){
                
                
            }
            
        try{
            
            mat[b][a]=weight;
        
        }catch(Exception e){
            
            
        }
            
        }
     
        detect(mat);
               
    }
    
}
/*5 7
A B 6
A D 1
D E 1
D B 2
B E 2
B C 5
C E 5*/