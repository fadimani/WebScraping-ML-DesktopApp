package ML_part.ML;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;


public class Classification {




  public static void main(String[] args) throws Exception {
      // Load the data
      DataSource sourceTraining = new DataSource("src/main/java/org/example/TrainingAndTestingData/train.arff");
      Instances trainingSet = sourceTraining.getDataSet();

      DataSource sourceTesting = new DataSource("src/main/java/org/example/TrainingAndTestingData/test.arff");
      Instances testingSet = sourceTesting.getDataSet();


      // Set Target class //
      trainingSet.setClassIndex(2);
      testingSet.setClassIndex(2);

     // Train the Naive Bayes classifier on the training set
      NaiveBayes nb = new NaiveBayes();

      nb.buildClassifier(trainingSet);


      // Test the Naive Bayes classifier on the testing set
      for (int i = 0; i < testingSet.numInstances(); i++) {
        double predictedClass = nb.classifyInstance(testingSet.instance(i));
        double actualClass = testingSet.instance(i).classValue();
        //System.out.println("Predicted class: " + predictedClass + ", actual class: " + actualClass);
      }

      // Evaluate the Naive Bayes classifier on the testing set
    System.out.println("Evaluate the Naive Bayes classifier on the testing set");
      Evaluation eval = new Evaluation(testingSet);
      eval.evaluateModel(nb, testingSet);
      System.out.println();
      System.out.println(eval.toSummaryString());



//      Save the classifier to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/naiveBayes.model", nb);
      // Save the evaluation to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/naiveBayesEvaluation.model", eval);


      ///////////////////////////////////////////////////////

    //k-Nearest Neighbors (kNN) classifier
    // Set the number of nearest neighbors to use
    int k = 5;
    IBk classifier = new IBk(k);


    classifier.buildClassifier(trainingSet);


    for (int i = 0; i < testingSet.numInstances(); i++) {
      double actualClass = testingSet.instance(i).classValue();
      double predictedClass = classifier.classifyInstance(testingSet.instance(i));
      System.out.println("Actual class: " + actualClass + ", Predicted class: " + predictedClass);
    }

    // Evaluate the k-Nearest Neighbors (kNN) classifier on the testing set
    System.out.println("Evaluate the k-Nearest Neighbors (kNN) classifier on the testing set");
      eval = new Evaluation(testingSet);
      eval.evaluateModel(classifier, testingSet);
      System.out.println(eval.toSummaryString());

      // Save the classifier to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/kNN.model", classifier);
      // Save the evaluation to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/kNNEvaluation.model", eval);


    ////////////////////////////////////////////////////////////

    //decision trees
    J48 tree = new J48();

    tree.buildClassifier(trainingSet);

    for(int i = 0; i < testingSet.numInstances(); i++) {
      double actualClass = testingSet.instance(i).classValue();
      double predictedClass = tree.classifyInstance(testingSet.instance(i));
      System.out.println("Actual class: " + actualClass + ", Predicted class: " + predictedClass);
    }

    // Evaluate the tree classifier on the testing set
    System.out.println("Evaluate the tree classifier on the testing set");
      eval = new Evaluation(testingSet);
      eval.evaluateModel(tree, testingSet);
      System.out.println(eval.toSummaryString());


      // Save the classifier to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/tree.model", tree);
      // Save the evaluation to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/treeEvaluation.model", eval);


    //Support Vector Machines (SVMs)

    SMO smo = new SMO();
    smo.buildClassifier(trainingSet);

    for (int i = 0; i < testingSet.numInstances(); i++) {
      double actualClass = testingSet.instance(i).classValue();
      double predictedClass = smo.classifyInstance(testingSet.instance(i));
      System.out.println("Actual class: " + actualClass + ", Predicted class: " + predictedClass);
    }

    // Evaluate the Support Vector Machines (SVMs) classifier on the testing set
    System.out.println("Evaluate the Support Vector Machines (SVMs) classifier on the testing set");
      eval = new Evaluation(testingSet);
      eval.evaluateModel(smo, testingSet);
      System.out.println(eval.toSummaryString());

      // Save the classifier to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/smo.model", smo);
      // Save the evaluation to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/smoEvaluation.model", eval);

      ///////////////////////////////////////////////////////

    //RandomForest

    RandomForest randomForest = new RandomForest();

    randomForest.buildClassifier(trainingSet);


    for (int i = 0; i < testingSet.numInstances(); i++) {
  double actualClass = testingSet.instance(i).classValue();
  double predictedClass = randomForest.classifyInstance(testingSet.instance(i));
  System.out.println("Actual class: " + actualClass + ", Predicted class: " + predictedClass);
                }


    // Evaluate the RandomForest classifier on the testing set
    System.out.println("Evaluate the RandomForest classifier on the testing set");
    eval = new Evaluation(testingSet);
      eval.evaluateModel(randomForest, testingSet);
      System.out.println(eval.toSummaryString());

      // Save the classifier to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/randomForest.model", randomForest);
      // Save the evaluation to a file
      SerializationHelper.write("src/main/java/org/example/ClassifierAndEvaluation/randomForestEvaluation.model", eval);











  }








}
