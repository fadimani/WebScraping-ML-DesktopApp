package ML_part.ML;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.instance.Resample;

import java.io.File;
import java.util.Random;


public class SplitData {

    DataSource source = new DataSource("src/main/java/org/example/data/dataFinale2.arff");
    Instances data = source.getDataSet();

    public SplitData() throws Exception {
        // Mix the instances
        data.randomize(new Random(0));

        // Set the class index to the last attribute
        data.setClassIndex(15);

        // Use the Resample filter to shuffle the data
        Resample resample = new Resample();
        resample.setNoReplacement(true);  // Do not allow sampling with replacement
        resample.setInputFormat(data);
        Instances shuffledData = Filter.useFilter(data, resample);

        // Split the shuffled data into a training set (80%) and a testing set (20%)
        int numInstances = shuffledData.numInstances();
        int trainingSize = (int) (numInstances * 0.8);  // 70% training

        Instances trainingSet = new Instances(shuffledData, 0, trainingSize);
        Instances testingSet = new Instances(shuffledData, trainingSize, numInstances - trainingSize);

        // Save the data as an arff file
          ArffSaver saver = new ArffSaver();
          saver.setInstances(trainingSet);
          saver.setFile(new File("src/main/java/org/example/TrainingAndTestingData/train.arff"));
          saver.writeBatch();
          saver.setInstances(testingSet);
          saver.setFile(new File("src/main/java/org/example/TrainingAndTestingData/test.arff"));
          saver.writeBatch();

    }

    public static void main(String[] args) throws Exception {
        SplitData splitData = new SplitData();
    }


}
