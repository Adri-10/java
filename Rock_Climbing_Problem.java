
package Mid2PreparetionDynamic;


public class Rock_Climbing_Problem {

    public static void main(String[] args) {
        
         int wedth=5,height=4;
        
    int c[][]={ {2,8,9,5,8},{4,4,6,2,3},{5,7,5,6,1},{3,2,5,4,8} };
        
    int ans[][]=new int[wedth+1][ wedth+2 ];
        
for(int i=0;i<=wedth;i++){
    
    ans[i][0]=Integer.MIN_VALUE;
    
}    
    
for(int i=0;i<=wedth;i++){
    
    ans[i][wedth+1]=Integer.MIN_VALUE;
    
}

for(int i=1;i<=wedth;i++){
    
   ans[wedth-1][i]=c[height-1][i-1];
    
}

for(int i=wedth-1;i>=0;i--){
    
    for(int j=1;j<=wedth;j++){

try{
        
        ans[i][j]=c[i-1][j-1]+Math.max( ans[i+1][j] , Math.max(ans[i+1][j+1], ans[i+1][j-1]) );
    
}catch(Exception e ){
    
    
}
        
    }
    
}

        System.out.println("The matrix is: ");

        for(int i=0;i<=wedth;i++){
            
            for(int j=0;j<=wedth+1;j++){
                
                System.out.print(ans[i][j]+" ");
                
            }
            
            System.out.println();
            
        }
        
        int max=Integer.MIN_VALUE;
        
        for(int i=1;i<=wedth;i++){
            
            if( max<=ans[1][i] ){
                
                max=ans[1][i];
                
            }
            
        }
        
        System.out.println("maximum: "+max);
        
    }
    
}
