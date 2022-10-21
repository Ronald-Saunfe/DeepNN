
package deepnn;

import deepnn.Activationfunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Layer {  
    double[][] weights; 
    double[] inputs;
    double[] neurons_val;
    double[] targetthreshold;
    double[] errorterm;
    Activationfunction activationFunc;
    
    // generate weights with random gaussian range(0-1)
    // seed makes the weights values unique from other neurons
    public Layer(int neurons_size, int inputs_size, int seed){
        Random gen = new Random(seed);
        double[][] weightsMatrix = new double[neurons_size][inputs_size];
        // initialize the weight with gaussian random 0-1
        for(int i=0; i< neurons_size; i++){
            for(int j=0; j< inputs_size; j++){
                weightsMatrix[i][j] = gen.nextGaussian();
            }
        }
        weights = weightsMatrix;
    }
    
    public void setActivationfunction(Activationfunction activationFunc){
       this.activationFunc = activationFunc; 
    }
    
    public Activationfunction getActivationfunction(){
        return activationFunc;
    }
    
    public void setInputs( double[] input_vector){
        inputs = input_vector;
    }
    
    public double[] getInput(){
        return inputs;
    }
    
    public void setWeights(double[][] weights){
        this.weights =weights;
    }
    
    public double[][] getWeights(){
        return weights;
    }
    
    public void setNeuronsValue(double[] neurons_val){
        this.neurons_val = neurons_val;
    }
    
    public double[] getNeuronvalue(){
        return neurons_val;
    }
    
    public double[] getTargetthreshold(){
        return targetthreshold;
    }
}
