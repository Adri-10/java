
package ProjectCode;

import java.util.Arrays;
import java.util.Scanner;


public class N_Queen_Problem {

    static class Positions{
        
        int raw,coloumn;

        public Positions(int raw, int coloumn) {
            this.raw = raw;
            this.coloumn = coloumn;
        }

        public Positions() {
        
            
            
        }

        public int getRaw() {
            return raw;
        }

        public void setRaw(int raw) {
            this.raw = raw;
        }

        public int getColoumn() {
            return coloumn;
        }

        public void setColoumn(int coloumn) {
            this.coloumn = coloumn;
        }

        @Override
        public String toString() {
            return  "("+ raw + ", " + coloumn+" ) " ;
        }
                
    }
    
    static class Queen{
        
       int n; 

        public Queen() {
       
        }

        public Queen(int n) {
            this.n = n;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
        
        public boolean solveNQueens( int n,int raw,Positions []positions ){
            
            if( n==raw ){
                
                return true;
                
            }
            
            int col;
            
            for(col=0;col<n;col++){
                
                boolean foundSafe=true;
                
                for(int queen=0;queen<raw;queen++){
                    
                    if( positions[queen].getColoumn()==col || positions[queen].getRaw()-positions[queen].getColoumn()==raw-col
                       || positions[queen].getRaw()+positions[queen].getColoumn() == raw+col     ){
                        
                        foundSafe=false;
                        
                        break;
                        
                    }
                    
                }
                
                if( foundSafe ){
                    
                    positions[raw]=new Positions( raw,col );
                    
                    if( solveNQueens( n,raw+1,positions ) ){
                        
                        return true;
                        
                    }
                    
                }
                
            }
            
            return false;
        }
        
       public Positions[] SolveOneSolution(){
           
           Positions []positions=new Positions[n];
           
           boolean visited=solveNQueens( n,0,positions );
           
           if( visited ){
               
               return positions;
               
           }else{
           
           return new Positions[0];
           
       }
           
          // return positions;
           
       }
       
    }
    
    static Queen queen=new Queen();
 
    static int n;
    
    static Scanner scanner=new Scanner(System.in);
    
    public static void main(String[] args) {
        
       n=scanner.nextInt();
        
       queen=new Queen(n);
       
       Positions []position=queen.SolveOneSolution();
       
      for(Positions i: position){
          
          System.out.println(i.toString());
          
      }
       
    }
    
}
