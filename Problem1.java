
package LabExam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
    
    static Scanner scanner=new Scanner(System.in);
    
    static int node,edges,a,b,w;
    
    static char[]ch={ 'A','B','C','D','E','F',
    'G','H','I','J','K','L',
    'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    static List< Character > nodes=new ArrayList<>();
    
    static char charA,charB;
    
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
     
    static void printList(int par[],int node,int length,List<Character> ch ){

        if(node==-1){

             return;

        }

        printList(par,par[node],length+1,ch  );

        System.out.print( ch.get(node)+" " );

        if( length!=0 ){

            System.out.print(", ");

        }

    }
    
    public static void main(String[] args) {
        
         for(int i=0;i<ch.length;i++){
            
            nodes.add( ch[i] );
            
        }
        
        node=scanner.nextInt();
        
       int []parent=new int[node];
        
        edges=scanner.nextInt();
        
        for(int i=0;i<edges;i++){
            
            charA=scanner.next().toUpperCase().charAt(0);
            charB=scanner.next().toUpperCase().charAt(0);
            
            a=nodes.indexOf( charA );
            b=nodes.indexOf( charB );
            
            w=scanner.nextInt();
         
            bellman=new Bellman(a,b,w);
           
            list.add(bellman);
           
            /*bellman=new Bellman( b,a,w );
            
            list.add(bellman);*/
            
        }
        
        for(int i=0;i<node;i++){
            
            distance.add(-1);
            
        }
        
        for(int i=0;i<node;i++){
            
            parent[i]=-1;
            
        }
        
        //start
        
       int source=0;
        
      //  for(int h=0;h<node;h++){
        
        //distance.set(0);
        
        for(int i=0;i<node;i++){
        
            if( i==source ){
                
                distance.set(i, 0);
                
            }else{
            
            distance.set(i,Integer.MAX_VALUE);
            
            }
        
            parent[i]=-1;
            
        }
        
        int dis[][]=new int[node*node][node*node];
        
        for(int i=0;i<node;i++){
            
           // if(i!=h){
            
            for(int j=0;j<edges;j++){
                
              if( distance.get( list.get(j).getA() )!=Integer.MAX_VALUE && distance.get( list.get(j).getA() )+list.get(j).getW()<distance.get( list.get(j).getB() )){
                  
                  distance.set(list.get(j).getB(), 
                          distance.get( list.get(j).getA() )+list.get(j).getW());
                  
                  parent[ list.get(j).getB() ]=list.get(j).getA();
                  
              }
                
            }
            
            //}
            
        }
     
            System.out.print(" source: "+nodes.get(source)+" " );
        
        System.out.println("Vertex  Distance from source   path");
        
        for(int j=0;j<edges;j++){
            
            if( distance.get( list.get(j).getA() )!=Integer.MAX_VALUE
                  && distance.get( list.get(j).getA() )+list.get(j).getW()<distance.get( list.get(j).getB() )  ){
                
                System.out.println("The cycle exist");
                
                return;
                
            }
            
        }
        
        for(int i=0;i<node;i++){

            if( distance.get(i)!=Integer.MAX_VALUE ){
            
            System.out.print( nodes.get(i) +"             "+distance.get(i)+" " );

            System.out.print("path: ");

      //      System.out.print( ch.get( list.get(0).getA() )+" ");

            //for(int j=0;j<node ;j++){

     /*           if( par[j]==-1 ){

                    break;

                }*/

                //System.out.print( ch.get( par[/*list.get(j).getB()*/ j ] ) +" ");

                printList( parent,i,0,nodes );

            //}

System.out.println();

            }

        }
        
     distance=new ArrayList<>();
       
     for(int i=0;i<node;i++){
            
            distance.add(-1);
            
        }
     
        //}
        //end
    }
    
}
/*4 6
A B 5
A C 8
A D 9
B C 3
B D 4
C D 1*/

/*5 7
A B 6
A D 1
D E 1
D B 2
B E 2
B C 5
C E 5*/

/*20 9
S A 5
S C -2
C A 2
A B 1
C B 4
C D 4
B D -1
D T 1
B T 3*/