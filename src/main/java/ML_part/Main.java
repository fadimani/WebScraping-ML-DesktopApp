package ML_part;

import ML_part.ML.ClusteringTask;
import weka.classifiers.Evaluation;
import weka.core.SerializationHelper;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------kNN-----------------------");
        Evaluation evaluation1 = (Evaluation) SerializationHelper.read("src/main/java/org/example/ClassifierAndEvaluation/kNNEvaluation.model");
        System.out.println(evaluation1.toSummaryString());

        System.out.println("-----------------------naiveBayes-----------------------");
        Evaluation evaluation2 = (Evaluation) SerializationHelper.read("src/main/java/org/example/ClassifierAndEvaluation/naiveBayesEvaluation.model");
        System.out.println(evaluation2.toSummaryString());


        System.out.println("-----------------------randomForest-----------------------");
        Evaluation evaluation3 = (Evaluation) SerializationHelper.read("src/main/java/org/example/ClassifierAndEvaluation/randomForestEvaluation.model");
        System.out.println(evaluation3.toSummaryString());


        System.out.println("-----------------------SMO-----------------------");
        Evaluation evaluation4 = (Evaluation) SerializationHelper.read("src/main/java/org/example/ClassifierAndEvaluation/smoEvaluation.model");
        System.out.println(evaluation4.toSummaryString());


        System.out.println("-----------------------treeEvaluation----------------------");
        Evaluation evaluation5 = (Evaluation) SerializationHelper.read("src/main/java/org/example/ClassifierAndEvaluation/treeEvaluation.model");
        System.out.println(evaluation5.toSummaryString());


        System.out.println("-----------------------K-means-clustering-----------------------");
        //ClusteringTask.main();


    }
}