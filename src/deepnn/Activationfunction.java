
package deepnn;


public class Activationfunction {
    
    String type; 
 
    
    public Activationfunction(String type){
       this.type=type; 
    }
    
    public double activate(double val){ 
        if (type.equals("sigmoid")){
            return sigmoid(val);
        }
        return 0;
    }
    
    public double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }
}
