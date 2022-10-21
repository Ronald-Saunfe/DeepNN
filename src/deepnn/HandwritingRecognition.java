
package deepnn;

import deepnn.Activationfunction;
import java.util.Random;


public class HandwritingRecognition {
     
    public HandwritingRecognition(){
        
    }

    private void initialize_parameters(){
        
    }
    
    private void TrainNetwork(){
        
    }
    
    private void predict(){
        
    } 

    public static void main(String[] args) { 
       
        Neuralnetwork neuralnet = new Neuralnetwork();
        // create input layer
        double[] in = new double[784];
        Random r = new Random();
        for(int i=0; i<784;i++){
            in[i] = r.nextGaussian();
        }
        Layer inputlayer = new Layer(784,784,1); 
        inputlayer.setActivationfunction(new Activationfunction("sigmoid"));
        neuralnet.addLayer(inputlayer, 0); 
        
        // create hidden layers
        int p=784, n;
        int[] l ={2,5,1,3};
        for(int i=0; i<4; i++){  
            n = l[i]; 
            Layer layer = new Layer(n,p,i);
            layer.setActivationfunction(new Activationfunction("sigmoid"));
            neuralnet.addLayer(layer, -1);
            p =n; 
        }
        
        // create output layer
        Layer outputlayer = new Layer(10,3,6);
        outputlayer.setActivationfunction(new Activationfunction("sigmoid"));
        outputlayer.targetthreshold = new double[]{0.1,0.1,0.1,0.1,0.1,0.9,0.1,0.1,0.1,0.1};
        neuralnet.addLayer(outputlayer, -1);
        
        // do forward pass
        inputlayer.setNeuronsValue(in);
        neuralnet.feedForwad(in); 
    }
    
    
}