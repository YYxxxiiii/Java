import java.util.ArrayList; 
public class Solution {    
public int[] multiply(int[] A) {       
int length=A.length;      
  int[] B=new int[length];        
if(A.length==0){           
return B;      
  }       
 B[0]=1;//初始置为1       
 //下三角       
 for(int i=1;i<length;i++){           
B[i]=B[i-1]*A[i-1];        
}        
//上三角        
int tmp=1;        
for(int i=length-1;i>=0;i--){          
  B[i]*=tmp;           
 tmp*=A[i];       
 }        
return B;
    }
 }