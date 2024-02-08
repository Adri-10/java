
package ProjectCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Hamiltonian_Cycle {

    static int nodes,edges,a,b,weight,start;
    
    static Scanner scanner=new Scanner(System.in);
     
   static class Edges{
        
        int src,neighbour,weight;

        public Edges(int src, int neighbour, int weight) {
            this.src = src;
            this.neighbour = neighbour;
            this.weight = weight;
        }

        public int getSrc() {
            return src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getNeighbour() {
            return neighbour;
        }

        public void setNeighbour(int neighbour) {
            this.neighbour = neighbour;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
        
    }
    
    static List<Edges> list[];
   
    static Set<Integer> visited=new HashSet<>();
    
    public static void main(String[] args) {
        
    nodes=scanner.nextInt();
         
    list=new ArrayList[nodes];
    
    for(int i=0;i<nodes;i++){
        
        list[i]=new ArrayList<>();
        
    }
    
    edges=scanner.nextInt();
    
    for(int i=0;i<edges;i++){
        
        a=scanner.nextInt()-1;
        b=scanner.nextInt()-1;
        
        weight=scanner.nextInt();
        
       try{
           
           list[a].add( new Edges( a,b,weight ) );
           
       }catch(Exception e){
           
           
       }
        
       try{
           
           list[b].add( new Edges( b,a,weight ) );
           
       }catch(Exception e){
           
           
       }
       
    }
    
    start=scanner.nextInt()-1;
    
    Hamilton(start,""+(start+1),start);
   
    }
   
    static void Hamilton(int start,String psf,int Orginalstart){
        
        if( visited.size()==list.length-1 ){
            
            System.out.print(psf);
            
            boolean closing=false;
            
            for(Edges i: list[start]){
                
                if( i.getNeighbour()==Orginalstart ){
                    
                    closing=true;
                    break;
                    
                }
                
            }
            
            if( closing==true ){
                
                System.out.println("*" );
                
            }else{
                
                System.out.println("."/*+(Orginalstart+1)*/);
                
            }
            
            return;
            
        }
        
        visited.add(start);
        
        for( Edges i: list[start] ){
            
            if( !visited.contains(i.getNeighbour()) ){
                
                Hamilton( i.getNeighbour(),psf+(i.getNeighbour()+1),Orginalstart );
                
            }
            
        }
        
        visited.remove(start);
        
    }
    
}
/*5 8
1 2 2
1 5 3
2 5 6
5 4 8
2 4 9
2 3 4
1 3 16
3 4 12
1*/

/*5 7
1 2 4
2 3 6
1 4 3
4 5 1
2 4 2
2 5 9
3 5 8
1*/