/******************************************************************************\
 *  @authors Garrett Hedgecock, Sonia Akkiangadi, {more}                      *
 *  @instructor Chafic Bou-Saba                                               *
 *  @institution Guilford College                                             *
 *  @course CTIS-310                                                          *
 *                                                                            *
 *  Sorting Algorithms                                                        *
 *                                                                            *
 *  @instructions Each sorting algorithm should contain:                      *
 *  1.) 10 fields to insert the number to be sorted either manually or using  *
 *      the "Generate Random Numbers" button.                                 *
 *  2.) The number should be limited between 0 - 99.                          *
 *  3.) 3 buttons:                                                            *
 *      a.) "Generate Random Numbers"                                         *
 *      b.) "Start Sort"                                                      *
 *      c.) "Reset Numbers"                                                   *
 *                                                                            *
\******************************************************************************/

package sortingalgorithmsgroup5;

import java.util.ArrayList;
import java.util.Random;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class SortingAlgorithmsGroup5 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Initialize constants to hold window width and height
        final int SCENE_WIDTH = 800;
        final int SCENE_HEIGHT = 800;
        
        final double SPC_BTWN_CHLDRN = 15.00;
        
        // Initialize TabPane object
        TabPane tabPane = new TabPane();    // TabPane is a container control which
                                            // can contain multiple tabs (sections)
        
        // Initialize Tab objects to be contained in TabPane
        Tab tabSortingIntro = new Tab("Sorting Intro");
        Tab tabBubbleSort = new Tab("Bubble Sort");
        Tab tabSelectionSort = new Tab("Selection Sort");
        Tab tabInsertionSort = new Tab("Insertion Sort");
        Tab tabMergeSort = new Tab("Merge Sort");
        Tab tabQuickSort = new Tab("Quick Sort");
        
        // Disable option to close tabs
        tabSortingIntro.setClosable(false);
        tabBubbleSort.setClosable(false);
        tabSelectionSort.setClosable(false);
        tabInsertionSort.setClosable(false);
        tabMergeSort.setClosable(false);
        tabQuickSort.setClosable(false);
        
        // Make the text fields
        ArrayList<TextField> textFields = new ArrayList<TextField>();
        HBox textFieldsHBox = new HBox();
        
        for(int i = 0; i < 11; i++){
            TextField textField = new TextField();
            textFields.add(textField);
            textFieldsHBox.getChildren().add(textField);
        }
        
        // Make the buttons
        Button genRanNumsBtn = new Button("Generate Random Numbers");
        Button strtBubSrtBtn = new Button("Start Bubble Sort");
        Button strtSelSrtBtn = new Button("Start Selection Sort");
        Button strtInsSrtBtn = new Button("Start Insertion Sort");
        Button strtMerSrtBtn = new Button("Start Merge Sort");
        Button strtQuiSrtBtn = new Button("Start Quick Sort");
        Button rstNumsBtn = new Button("Reset Numbers");
        
        // Creating and adding images to the buttons
        FileInputStream quesMarkImgFile = new FileInputStream("qMark.jpg");
        Image quesMarkImage = new Image(quesMarkImgFile);
        ImageView quesMarkImageView = new ImageView(quesMarkImage);
        quesMarkImageView.setFitHeight(25);
        quesMarkImageView.setFitWidth(25);
        
        genRanNumsBtn.setGraphic(quesMarkImageView);
        
        // Setting up the first (default) tab
        String sortingIntroString = "Sorting Effeciency\n"
                + "\n"
                + "Two two main criterias to judge which algorithm is better than"
                + " the over have been:\n"
                + "\n"
                + "\t1- Time taken to sort the given data.\n"
                + "\t2- Memory Space required to do so.\n";
        
        Label sortingIntroLabel = new Label(sortingIntroString);
        HBox sortingIntroHBox = new HBox(sortingIntroLabel);
        sortingIntroHBox.setAlignment(Pos.CENTER);
        
        tabSortingIntro.setContent(sortingIntroHBox);

        // Set up the bubble sort tab
        VBox bubSrtVBox = new VBox();
        bubSrtVBox.setAlignment(Pos.TOP_CENTER);
        bubSrtVBox.setSpacing(SPC_BTWN_CHLDRN);
        
        String bubSrtString = "\tBubble Sort Description:\n"
                + "\n"
                + "Bubble Sort is the simplest sorting algorithm that works by "
                + "repeatedly swapping the adjacent elements if they are in the"
                + " wrong order.\n"
                + "\n";
        
        Label bubSrtLabel = new Label(bubSrtString);
        
        HBox bubSrtBtnsHBox = new HBox(genRanNumsBtn, strtBubSrtBtn, rstNumsBtn);
        bubSrtBtnsHBox.setAlignment(Pos.CENTER);
        
        bubSrtVBox.getChildren().addAll(bubSrtLabel, textFieldsHBox,
                bubSrtBtnsHBox);
        tabBubbleSort.setContent(bubSrtVBox);

        // Add Tab objects to the TabPane object
        tabPane.getTabs().add(tabSortingIntro);
        tabPane.getTabs().add(tabBubbleSort);
        tabPane.getTabs().add(tabSelectionSort);
        tabPane.getTabs().add(tabInsertionSort);
        tabPane.getTabs().add(tabMergeSort);
        tabPane.getTabs().add(tabQuickSort);
        
        // Initialize the Scene object
        Scene scene = new Scene(tabPane, SCENE_WIDTH, SCENE_HEIGHT);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("SORTING ALGORITHMS");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
