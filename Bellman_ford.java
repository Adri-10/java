
package readyCopyForFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bellman_ford {
    
    static Scanner scanner=new Scanner(System.in);
    
    static int node,edges,a,b,w;
    
    static class Bellman{
        
        int a,b,w;

        public Bellman(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        public Bellman() {
        
            
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
        
    }
    
    static List<Bellman> list=new ArrayList<>();
    
    static Bellman bellman=new Bellman();
    
    static List<Integer> distance=new ArrayList<>();
    
     static char[]ch={ 'A','B','C','D','E','F',
    'G','H','I','J','K','L',
    'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
      static List< Character > nodes=new ArrayList<>();
     
       static char charA,charB;
      
    public static void main(String[] args) {
        
        node=scanner.nextInt();
        
         for(int i=0;i<ch.length;i++){
            
            nodes.add( ch[i] );
            
        }
        
        edges=scanner.nextInt();
        
        for(int i=0;i<edges;i++){
            
            charA=scanner.next().toUpperCase().charAt(0);
            charB=scanner.next().toUpperCase().charAt(0);
            
            a=nodes.indexOf( charA );
            b=nodes.indexOf( charB );
            
            w=scanner.nextInt();
         
            bellman=new Bellman(a,b,w);
            
            list.add(bellman);
            
        }
        
        char f=scanner.next().charAt(0);
        
        //distance.add( nodes.indexOf(f) );
        
        int r=nodes.indexOf(f);
        
        for(int i=0;i<node;i++){
            
            if( r==i ){
                
                distance.add(0);
                
            }else{
            
            distance.add(Integer.MAX_VALUE);
            
            }
            
        }
        
        System.out.println("distance array: "+String.valueOf(distance) );
        
        int dis[][]=new int[node*node][node*node];
        
        for(int i=0;i<node;i++){
            
            for(int j=0;j<edges;j++){
                
              if( distance.get( list.get(j).getA() )!=Integer.MAX_VALUE && distance.get( list.get(j).getA() )+list.get(j).getW()<distance.get( list.get(j).getB() )){
                  
                  distance.set(list.get(j).getB(), 
                          distance.get( list.get(j).getA() )+list.get(j).getW());
                  
              }
                
            }
            
        }
        
        System.out.println("\nVertex  Distance from source");
        
        for(int j=0;j<edges;j++){
            
            if( distance.get( list.get(j).getA() )!=Integer.MAX_VALUE
                  && distance.get( list.get(j).getA() )+list.get(j).getW()<distance.get( list.get(j).getB() )  ){
                
                System.out.println("The cycle exist");
                
                return;
                
            }
            
        }
        
        for(int i=0;i<node;i++){
            
            System.out.println( nodes.get(i) +"             "+distance.get(i));
            
        }
        
    }
    
}
/*5 8
0 1 -1
0 2 4
1 2 3
1 3 2
1 4 2
3 2 5
3 1 1
4 3 -3*/

/*5 11
A B -3
A D 2
B A 5
B C 3
D C 4
D A -1
C A 1
E A 0
E B 0
E C 0
E D 0
E*/