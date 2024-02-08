
package ProjectCode;

import java.util.Arrays;
import java.util.Scanner;

public class Travelling_Sales_Problem {

    static int nodes,finalRes=Integer.MAX_VALUE;
    
    static Scanner scanner=new Scanner(System.in);
    
    static boolean []visited;
    
    static int finalPath[];
    
    static int firstMin(int [][]adj,int k){
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<nodes;i++){
            
            if( adj[k][i]<min && i!=k ){
                
                min=adj[k][i];
                
            }
            
        }
        
        return min;
        
    }
    
    static int secondMin( int adj[][],int i ){
        
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        
        for(int j=0;j<nodes;j++){
            
            if( i==j ){
                
                continue;
                
            }
            if( adj[i][j]<=first ){
                
                second=first;
                
                first=adj[i][j];
                
            }else if( adj[i][j]<=second && adj[i][j]!=first ){
                
                second=adj[i][j];
                
            }
            
            
        }
        
        return second;
        
    }
    
    static void TSPRec( int adj[][],int currentBound,int currentWeight,int level,int currentPath[] ){
        
        if( level==nodes ){
            
            if( adj[ currentPath[level-1] ][ currentPath[0] ]!=0 ){
                
                int currentRes=currentWeight+ adj[ currentPath[level-1] ][ currentPath[0] ] ;
                
        //        System.out.println("curentres: "+currentRes+" = "+(currentWeight+adj[ currentPath[level-1] ][ currentPath[0] ] )+" + "+currentWeight);
                
                if( currentRes<finalRes ){
                    
                    for(int i=0;i< nodes;i++){
                        
                        finalPath[i]=currentPath[i];
                        
                    }
                    
                    finalPath[nodes]=currentPath[0];
                    
                    finalRes=currentRes;
                    
          //          System.out.println("final res: "+finalRes);
                
            //        System.out.println("path array: "+Arrays.toString(currentPath));
                    
              //      System.out.println("final path: "+Arrays.toString(finalPath));
                    
                }
            }
            
            return;
            
        }
        
        for(int i=0;i<nodes;i++){
            
            if( adj[ currentPath[ level-1 ] ][i]!=0 && !visited[i] ){
                
                int temp=currentBound;
                
                currentWeight+=adj[ currentPath[ level-1 ] ][i];
                
                if( level==1 ){
                    
                    currentBound-=(firstMin( adj,currentPath[ level-1 ] )+
                            firstMin( adj,i ))/2;
                    
                }else{
                    
                    currentBound-=(secondMin( adj,currentPath[level-1] )+
                            firstMin( adj,i ))/2;
                    
                }
                
                if( currentBound+currentWeight<finalRes ){
                    
                    currentPath[level]=i;
                    
                    visited[i]=true;
                    
                    TSPRec( adj,currentBound,currentWeight,level+1,currentPath );
                    
                }
                
                currentWeight-=adj[ currentPath[level-1] ][i];
                
                currentBound=temp;
                
                Arrays.fill(visited, false);
                
                for(int j=0;j<=level-1;j++){
                    
                    visited[ currentPath[j] ]=true;
                    
                }
                
            }
            
        }
        
    }
    
    static void TSP( int [][]adj ){
        
        int []currentPath=new int[nodes+1];
        
        int currentBound=0;
        
        Arrays.fill(currentPath, -1);
        
        for(int i=0;i<nodes;i++){
            
            currentBound+=firstMin( adj,i )+secondMin( adj,i );
            
        }
   
   //     System.out.println("initial currentBound: "+currentBound);
        
        currentBound=(currentBound==1)?currentBound/2+1:currentBound/2 ;
      
     //   System.out.println("after current bound: "+currentBound);
        
        visited[0]=true;
        
        currentPath[0]=0;
        
       // System.out.println("current path now: "+Arrays.toString(currentPath));
        
        TSPRec( adj,currentBound,0,1,currentPath );
        
    }
    
    public static void main(String[] args) {
        
        nodes=scanner.nextInt();
        
        visited=new boolean[nodes];
        
        finalPath=new int[nodes+1];
        
        int adj[][]=new int[nodes][nodes];
        
        for(int i=0;i<nodes;i++){
            
            for(int j=0;j<nodes;j++){
                
                adj[i][j]=scanner.nextInt();
                
            }
            
        }
        
        TSP( adj );
        
        System.out.println("minimum cost: "+finalRes);
        
        for(int i=0;i<=nodes;i++){
            
            System.out.print( (finalPath[i]+1)+"  ");
            
        }
        
    }
    
}
/*4
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0*/

/*4
0 4 1 3
4 0 2 1
1 2 0 5
3 1 5 0*/

/*5
0 20 30 10 11
15 0 16 4 2
3  5 0 2 4
19 6 18 0 3
16 4 7 16 0*/