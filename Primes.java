
package readyCopyForFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Primes {

    static Scanner scanner=new Scanner(System.in);
    
    static int a,b,weight,n,e;

 static char[]ch={ 'A','B','C','D','E','F',
    'G','H','I','J','K','L',
    'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
      static List< Character > nodes=new ArrayList<>();
     
       static char charA,charB;
    
    static class Edges{
        
        int src,weight,neighbour;

        public Edges(int src, int neighbour, int weight) {
            this.src = src;
            this.weight = weight;
            this.neighbour = neighbour;
        }

        public Edges() {
        
            
        }

        public int getSrc() {
            return src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getNeighbour() {
            return neighbour;
        }

        public void setNeighbour(int neighbour) {
            this.neighbour = neighbour;
        }
         
    }
    
    static class Pair implements Comparable<Pair> {
        
        int vertex,appearing_vertex,weight;

        public Pair(int vertex, int appearing_vertex, int weight) {
            this.vertex = vertex;
            this.appearing_vertex = appearing_vertex;
            this.weight = weight;
        }

        public Pair() {
        
        
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getAppearing_vertex() {
            return appearing_vertex;
        }

        public void setAppearing_vertex(int appearing_vertex) {
            this.appearing_vertex = appearing_vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair t) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
      //  return this.getWeight()-t.getWeight();
        
      if( this.getWeight()>t.getWeight() ){
          
          return 1;
          
      }else if( this.getWeight()<t.getWeight() ){
          
          return -1;
          
      }
      
      return 0;
      
        }
       
    }
    
    static Edges edges=new Edges();
    static Pair pair=new Pair();
    
    static ArrayList<Edges> arrayList[];
    
    public static void main(String[] args) {
        
         for(int i=0;i<ch.length;i++){
            
            nodes.add( ch[i] );
            
        }
        
        n=scanner.nextInt();
        
        e=scanner.nextInt();
        
        arrayList=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            
            arrayList[i]=new ArrayList<>();
            
        }
        
        for(int i=0;i<e;i++){
            
             charA=scanner.next().toUpperCase().charAt(0);
            charB=scanner.next().toUpperCase().charAt(0);
            
            a=nodes.indexOf( charA );
            b=nodes.indexOf( charB );
            
            weight=scanner.nextInt();
            
            try{
            
            arrayList[a].add( new Edges(a,b,weight) );
            
            }catch(Exception e){
                
                
            }
            
            try{
                
                arrayList[b].add( new Edges(b,a,weight) );
                
            }catch(Exception e){
                
                
            }
            
        }
        
        PriorityQueue< Pair > pq=new PriorityQueue<>(); 
        
        pq.add( new Pair( 0,-1,0 ) );
        
        boolean []visited=new boolean[n+1];
     
        int sum=0;
    
        System.out.println("neighbour  source  weight\n");
        
        while( !pq.isEmpty() ){
            
            Pair rem=pq.remove();
            
            if( visited[rem.getVertex()] ){
                
                continue;
                
            }
                
            visited[rem.getVertex()]=true;
            
            if( rem.getAppearing_vertex()!=-1 ){
            
            System.out.println(rem.getVertex()+"     -      "+rem.getAppearing_vertex()+"       "+rem.getWeight());
            
            sum+=rem.getWeight();
            
            }
            
            try{
            
            for( Edges e: arrayList[ rem.getVertex() ] ){
                
                if( !visited[ e.getNeighbour() ] ){
                    
                    pq.add( new Pair( e.getNeighbour(),rem.getVertex(),e.getWeight() ) );
                    
                }
                
            }
            
            }catch(Exception e){
                
                
            }
            
        }
        
        System.out.println("\nsum: "+sum);
        
    }
    
}
/*9 14
1 2 4
1 8 8
8 7 1
8 9 7
8 2 11
2 3 8
3 9 2
9 7 6
7 6 2
3 6 4
3 4 7
4 6 14
4 5 9
6 5 10*/

/*6 8
3 5 1
2 4 2
1 6 6
1 2 9
4 5 10
4 6 11
2 3 14
5 6 14*/

/*6 8
3 5 1
2 4 2
1 6 6
1 2 9
4 5 10
4 6 11
2 3 14
5 6 15*/

//sir er ta

/*9 14
1 2 4
1 8 8
8 7 1
8 9 7
8 2 11
2 3 8
3 9 2
9 7 6
7 6 2
3 6 4
3 4 7
4 6 14
4 5 9
6 5 10*/