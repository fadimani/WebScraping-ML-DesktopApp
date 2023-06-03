package ML_part.ML;

import java.io.BufferedReader;
import java.io.FileReader;

import gui.TextAreaOutputStreamTest;
import weka.core.Instances;
import weka.clusterers.SimpleKMeans;

public class ClusteringTask {


    public static void main() throws Exception{

        //load data
        //Instances data = new Instances(new BufferedReader(new FileReader("src/main/java/org/example/bank-data.arff")));
        Instances data = new Instances(new BufferedReader(new FileReader("src/main/java/ML_part/data/dataFinale2.arff")));
        SimpleKMeans Kmodel = new SimpleKMeans();
        Kmodel.buildClusterer(data);
        //System.out.println(Kmodel);

        TextAreaOutputStreamTest.main("-----------------------K-means-----------------------\n"+Kmodel);


    }

}