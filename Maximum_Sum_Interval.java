
package ProjectCode;

import java.util.Scanner;


public class Maximum_Sum_Interval {

    static int n;
    
    static Scanner scanner=new Scanner(System.in);
    
    public static void main(String[] args) {
        
        n=scanner.nextInt();
        
        int a[]=new int[n];
        
        for(int i=0;i<n;i++){
            
            a[i]=scanner.nextInt();
            
        }
        
        int max_Current=a[0],max_Global=a[0];
        
        for(int i=1;i<n;i++){
            
            max_Current=Math.max(a[i], max_Current+a[i] );
            
            if( max_Current>max_Global ){
                
                max_Global=max_Current;
                
            }
            
        }
        
        System.out.println( max_Global );
        
    }
    
}
/*7
-5 6 7 1 4 -8 16*/