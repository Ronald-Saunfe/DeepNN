
package deepnn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Neuralnetwork {
    List<Layer> layerlist = new ArrayList();
    double costfunction=0;
    int m = 2;
    double learningrate = 0.001;
    
    Matrix_multiplication multiply = new Matrix_multiplication();
    
    public void addLayer(Layer lay, int pos){
        if (pos==-1){
            layerlist.add(lay);
        }else{
            layerlist.add(pos, lay);
        }
    }
    
    // calculate the linear transformation of each neuron in 1 layer
    // this function does one forward pass
    public void feedForwad(double[] inputs){ 
        List<Integer> output = new ArrayList();
        double[] outputvalue;
        for(int i=1; i<layerlist.size(); i++){ 
            outputvalue = multiply.multiply_axb(
                    layerlist.get(i-1).getNeuronvalue(),
                    layerlist.get(i).getWeights(),
                    layerlist.get(i).getActivationfunction()
            );
            layerlist.get(i).setNeuronsValue(outputvalue);  
        }
        
        backpropagation_and_gradient_descent();
    }
    
    public void calculateCostfunction(){
        double[] outputval = layerlist.get(layerlist.size()-1).getNeuronvalue();
        double[] targetthresholds = layerlist.get(layerlist.size()-1).getTargetthreshold();
        
        for(int i=0; i<outputval.length;i++){
            costfunction += (1/m)*Math.pow( (targetthresholds[i]-outputval[i]) ,2);
        } 
        //System.out.println(costfunction);
    }
    
    // update the weights
    public void backpropagation_and_gradient_descent(){
       
        //// derivative of the output layer
        // Calc error term of output
        double[] a = layerlist.get(layerlist.size()-1).getNeuronvalue();
        double[] y = layerlist.get(layerlist.size()-1).targetthreshold;
        
        double[] errorterm = new double[a.length];
        for(int i=0; i<a.length;i++){
            errorterm[i] = 1/m*(y[i]-a[i]);
            System.out.println("errorterm "+errorterm[i]);
        }
        layerlist.get(layerlist.size()-1).setWeights(
                multiply.multiply_exo(
                        errorterm,
                        layerlist.get(layerlist.size()-2).getNeuronvalue(),
                        learningrate
                )
        );
        
        // derivative on hidden layers
        
    }
    
    public void trainNetwork(){
        
    }
    
    public void predict(){
        
    }
}
