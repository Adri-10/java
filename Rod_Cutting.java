
package Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Rod_Cutting {
    
    static Scanner scanner=new Scanner(System.in);
    
    static int length,cuttingPoint;
    
    static List<Integer> price=new ArrayList<>();

static List<Boolean> alreadyCut=new ArrayList<>();
    
static List< List<Integer> > list=new ArrayList<>();

static int ans;

static int cuttingRod(int start,int end){

try{
    
    ans=list.get(start).get(end);
    
  //  System.out.println("ans: "+ans);
    
}catch(IndexOutOfBoundsException e){
    
    //System.out.println(e);
    
}
    
    if( ans!=Integer.MAX_VALUE ){
        
     //   System.out.println("return from here");
        
        return ans;
        
    }
    
    int minimumCost=Integer.MAX_VALUE;
    
    for(int i=start+1;i<end;i++){
        
        if(alreadyCut.get(i)){
        
        int len=end-start;
        
        int cost=len+cuttingRod(start,i)+cuttingRod(i,end);
        
        if( cost<minimumCost ){
            
            minimumCost=cost;
            
        }
        
        }
        
    }
    
    if( minimumCost==Integer.MAX_VALUE ){
        
        minimumCost=0;
        
    }
    
    list.get(start).set(end, minimumCost);
    
    return minimumCost;
}

    public static void main(String[] args) {
        
        length=scanner.nextInt();
        
        cuttingPoint=scanner.nextInt();
        
        for(int i=0;i<cuttingPoint;i++){
            
            price.add(i,scanner.nextInt());
            
        }
        
        for(int i=0;i<Collections.max(price)+1;i++){
            
            alreadyCut.add(false);
            
        }
        
        for(int i=0;i<cuttingPoint;i++){
            
            alreadyCut.set(price.get(i),true  );
            
        }
        
        for(int i=0;i<length+1;i++){
            
           List<Integer> l=new ArrayList<>();
            
            for(int j=0;j<length+1;j++){
                
                l.add(j,Integer.MAX_VALUE);
                
            }
            
            list.add(l);
            
        }
        
        System.out.println(cuttingRod(0,length) );
        
    }
    
}
