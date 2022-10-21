
package deepnn;

import deepnn.Activationfunction;
import java.util.concurrent.Callable;

public class Matrix_multiplication {
    /**
    * <b>customizable:</b><br>
    * if you want to change no. of neurons in the layer<br>
    * do so by adjusting no of rows in (weight)a 2d vector<br>
    * <br>
    * <b>Explanation:</b>
    * <br> 
    * res row - no. of neurons in the layer<br>
    * res col - no of layers, always = 1<br>
    * <br>
    * (input)b row - no. of input(a) neurons<br>
    * (input)b column - no. of layers of res<br>
    * <br>
    * (weight)a column: no. of input(b) neurons<br>
    * (weight)a row: no. of neurons in the res layer<br>
    * <br>
    * res row: no. of neurons in the weight(a) layer<br>
    * res col: equals to 1 always<br>
    * <br>
    * <b>rule:</b><br>
    * if matrix a(input) = mxn and matrix b(weight) = nx1<br>
    * then res = mx1<br>
    * this states that no. of a col = no. of b row <br>
    * <br>
    * <br>
    * <br>
    * @param a weight(2D vector)
    * @param b input(1D vector)
    * @param b input(1D vector)
    * @return res 2D matrix with linear transformation
    **/
    public double[] multiply_axb(double[] b, double[][] a, Activationfunction activationfunc){ 
        double[] res = new double[a.length];
        
        System.out.println(a.length+"x"+a[0].length+"x"+b.length); 
        if (a[0].length!=b.length){
            throw new ArrayIndexOutOfBoundsException("Matrix dimension not compatible");  
        }else{
            // matrix format: res = nn x n1
            double sum;
            
            for(int r=0; r<a.length;r++){ // for each row
                sum=0;
                for(int rc=0; rc<b.length;rc++){ // for each col in the row
                    sum+=a[r][rc]*b[rc]; 
                } 
                res[r] = activationfunc.activate(sum);
                System.out.println(res[r]);
            }
        }
        return res;
    }
    
    public double[][] multiply_exo(double[] e,double[] o, double learningrate){
        double[][] output = new double[e.length][o.length];
        
        System.out.println("error"+e[2]);
        for(int r=0; r<e.length;r++){
            for(int c=0; c<o.length;c++){
                output[r][c] = output[r][c]- (-learningrate*(e[r]*o[c]));
                System.out.println("der"+output[r][c]);
            }
        }
        
        return output;
    }
}
