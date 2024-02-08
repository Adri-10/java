
package Classwork2;


public class Total_Coin_Changing_Problem {
    
    public static void main(String[] args) {

int a[]={2,3,5,10};
int m=15;
        
int ans[][]=new int[a.length][m+1];

for(int i=0;i<a.length;i++){
    
   ans[i][0]=1;
    
}

for(int i=0;i<a.length;i++){
    
    for(int j=1;j<=m;j++){
        
        if( j%a[i]==0 ){
            
            ans[i][j]=1;
            
        }else{
            
            ans[i][j]=0;
            
        }
        
    }
    
}

for(int i=1;i<a.length;i++){
    
    for(int j=1;j<=m;j++){
        
        if( ans[i][j]>j ){
            
            ans[i][j]=ans[i-1][j];
            
        }else{
            
            ans[i][j]=ans[i-1][j]+ans[i][ Math.abs(j-a[i]) ];
            
        }
        
    }
    
}

        System.out.println("The array is: ");

        for(int i=0;i<a.length;i++){
            
            for(int j=0;j<=m;j++){
                
                System.out.print(ans[i][j]+" ");    
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("total way: "+ans[a.length-1][m] );
        
    }
    
}
