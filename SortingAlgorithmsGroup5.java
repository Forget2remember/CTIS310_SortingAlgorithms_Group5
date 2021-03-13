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
        // CONSTANT INITIALIZATIONS
        final int NUM_ALGOS = 5;
        final int NUM_TXT_FIELDS = 11;
        final int SCENE_WIDTH = 800;
        final int SCENE_HEIGHT = 800;
        final double SPC_BTWN_CHLDRN = 15.00;
        
        // OBJECT INSTANTIATIONS
        TabPane tabPane = new TabPane();
        Tab tabSortingIntro = new Tab("Sorting Intro");
        Tab tabBubbleSort = new Tab("Bubble Sort");
        Tab tabSelectionSort = new Tab("Selection Sort");
        Tab tabInsertionSort = new Tab("Insertion Sort");
        Tab tabMergeSort = new Tab("Merge Sort");
        Tab tabQuickSort = new Tab("Quick Sort");
        Label defaultTabLabel = new Label();
        HBox defaultTabHBox = new HBox();
        ArrayList<VBox> masterVBoxes = new ArrayList<VBox>();
        ArrayList<String> descriptionStrings = new ArrayList<String>();
        ArrayList<Label> descriptionLabels = new ArrayList<Label>();
        ArrayList<HBox> textFieldHBoxes = new ArrayList<HBox>();
        ArrayList<Image> genNumBtnImages = new ArrayList<Image>();
        ArrayList<ImageView> genNumBtnImageViews = new ArrayList<ImageView>();
        ArrayList<FileInputStream> genNumBtnFiles = new ArrayList<FileInputStream>();
        ArrayList<FileInputStream> startButtonImgFiles = new ArrayList<FileInputStream>();
        ArrayList<Image> startButtonImages = new ArrayList<Image>();
        ArrayList<ImageView> startButtonImageViews = new ArrayList<ImageView>();
        ArrayList<Button> genNumButtons = new ArrayList<Button>();
        ArrayList<Button> resetButtons = new ArrayList<Button>();
        ArrayList<Button> startButtons = new ArrayList<Button>();
        ArrayList<HBox> buttonHBoxes = new ArrayList<HBox>();
        String defaultTabStr, bStr, sStr, iStr, mStr, qStr;
        
        // Setting custom options for the tabs.
        tabSortingIntro.setClosable(false);
        tabBubbleSort.setClosable(false);
        tabSelectionSort.setClosable(false);
        tabInsertionSort.setClosable(false);
        tabMergeSort.setClosable(false);
        tabQuickSort.setClosable(false);
        
        
        // Creating the first (default) tab.
        // 
        // The default tab is the first tab that the user sees when starting the
        // app. It does not contain the same graphical components as the other
        // (sorting algorithm) tabs.
        //
        // It is featured in the source first, as it is distinct from the other 
        // tabs.
        
        defaultTabStr = "Sorting Effeciency\n"
                + "\n"
                + "Two two main criterias to judge which algorithm is better than"
                + " the over have been:\n"
                + "\n"
                + "\t1- Time taken to sort the given data.\n"
                + "\t2- Memory Space required to do so.\n";
        
        defaultTabLabel.setText(defaultTabStr);
        defaultTabHBox.getChildren().add(defaultTabLabel);
        defaultTabHBox.setAlignment(Pos.CENTER);
        
        
        // Initializing 5 master VBox objects total.
        // Each sorting algorithm tab will contain its own master VBox, which
        // will contain the rest of that tab's graphical components.
        
        for(int i = 0; i < NUM_ALGOS; i++){
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.setSpacing(SPC_BTWN_CHLDRN);
            masterVBoxes.add(vBox);
        }
        
        
        // Defining the String objects to hold each sorting algorithm's
        // respective description. There will be one String object per Label
        // object, and one Label object per sorting algorithm tab.
        //
        // Defines the "descriptionStrings" and "descriptionLabels"
        // ArrayList objects.
        
        bStr = "\tBubble Sort Description:\n"
                + "\n"
                + "Bubble Sort is the simplest sorting algorithm that works by "
                + "repeatedly swapping the adjacent elements if they are in the"
                + " wrong order.\n"
                + "\n";
        
        sStr = "\tSelection Sort Description:\n"
                + "\n"
                + "Selection sort sorts an array by repeatedly finding the "
                + "minimum element from the unsorted part, and placing it at "
                + "the beginning.\n"
                + "\n";
        
        iStr = "\tInsertion Sort Description:\n"
                + "Insertion sort is a simple sorting algorithm that works "
                + "by splitting an array into a \"sorted\" and \"unsorted\" "
                + "part. \nValues from the unsorted part are picked and placed "
                + "into the correct position in the sorted part.\n"
                + "\n";
        
        mStr = "\tMerge Sort Description:\n"
                + "Merge sort is a divide-and-conquer algorithm. It divides the "
                + "array in half, recursively calls itself for each half,\n"
                + "and then merges the two sorted halves.\n"
                + "\n";
        
        qStr = "\tQuick Sort Description:\n"
                + "Quick sort is also a divide-and-conquer algorithm. It "
                + "selects an element as a pivot and partitions the array "
                + "around the pivot.\n"
                + "\n";
        
        descriptionStrings.add(bStr);
        descriptionStrings.add(sStr);
        descriptionStrings.add(iStr);
        descriptionStrings.add(mStr);
        descriptionStrings.add(qStr);
        
        for(int i = 0; i < NUM_ALGOS; i++){
            descriptionLabels.add(new Label(descriptionStrings.get(i)));
        }
        
        
        // Instantiating 5 HBox objects, with 11 TextField objects per HBox.
        // Each sorting algorithm tab will contain 1 HBox consisting of
        // 11 text fields for outputting the randomly-generated numbers.
        //
        // Defines the "textFieldBoxes" ArrayList object.
        
        for(int i = 0; i < NUM_ALGOS; i++){
            HBox hBox = new HBox();
            for(int j = 0; j < NUM_TXT_FIELDS; j++){
                hBox.getChildren().add(new TextField());
            }
            textFieldHBoxes.add(hBox);
        }
        
        
        // Instantiating 5 FileInputStream, Image, and ImageView objects.
        // Each button on each sorting algorithm tab will contain its own
        // image. (So far only have the "genNumBtnImageViews" ArrayList
        // defined with images.)
        //
        // Defines the "genNumBtnFiles", "genNumBtnImages", and
        // "genNumBtnImageViews" ArrayList objects.
        
        for(int i = 0; i < NUM_ALGOS; i++){
            FileInputStream generateNumImgFile = 
                    new FileInputStream("qMark.jpg");
            FileInputStream startButtonImgFile = 
                    new FileInputStream("checkmark.png");
            genNumBtnFiles.add(generateNumImgFile);
            startButtonImgFiles.add(startButtonImgFile);
            
            Image genNumButtonImage = 
                    new Image(genNumBtnFiles.get(i));
            Image startButtonImage = 
                    new Image(startButtonImgFiles.get(i));
            genNumBtnImages.add(genNumButtonImage);
            startButtonImages.add(startButtonImage);
            
            ImageView genNumButtonImageView = 
                    new ImageView(genNumBtnImages.get(i));
            ImageView startButtonImageView =
                    new ImageView(startButtonImages.get(i));
            
            genNumButtonImageView.setFitHeight(25);
            genNumButtonImageView.setFitWidth(25);
            startButtonImageView.setFitHeight(25);
            startButtonImageView.setFitWidth(25);
            
            genNumBtnImageViews.add(genNumButtonImageView);
            startButtonImageViews.add(startButtonImageView);
        }
        
        
        // Each tab's "Start ___ Sort" Button object is added individually.
        // 
        // Instantiates 2 Button objects per sorting algorithm tab.
        // Defines the "genNumButtons" and "resetButtons" ArrayList objects.
        //
        // Sets the graphics of the "start sort" button of each algorithm tab.
        
        startButtons.add(new Button("Start Bubble Sort"));
        startButtons.add(new Button("Start Selection Sort"));
        startButtons.add(new Button("Start Insertion Sort"));
        startButtons.add(new Button("Start Merge Sort"));
        startButtons.add(new Button("Start Quick Sort"));
        
        for(int i = 0; i < NUM_ALGOS; i++){
            Button button = new Button("Generate Random Numbers");
            button.setGraphic(genNumBtnImageViews.get(i));
            genNumButtons.add(button);
            
            Button button1 = new Button("Reset Numbers");
            resetButtons.add(button1);
            
            startButtons.get(i).setGraphic(startButtonImageViews.get(i));
        }
        
        
        // Instantiates 5 HBox objects, one per sorting algorithm tab.
        // Each HBox holds 3 Button objects.
        // Custom settings are set for each HBox.
        //
        // Defines the "buttonHBoxes" ArrayList object.
        
        for(int i = 0; i < NUM_ALGOS; i++){
            HBox hBox = new HBox();
            hBox.getChildren().addAll(genNumButtons.get(i), startButtons.get(i),
                    resetButtons.get(i));
            hBox.setAlignment(Pos.CENTER);
            buttonHBoxes.add(hBox);
        }
        
        
        // Each sorting algorithm tab's description, text field boxes, and
        // buttons are added to their respective VBox object.
        //
        // There are 5 master VBoxes total.
        //
        // Defines the "masterVBoxes" ArrayList object.
        
        for(int i = 0; i < NUM_ALGOS; i++){
            masterVBoxes.get(i).getChildren().addAll(descriptionLabels.get(i),
                    textFieldHBoxes.get(i),
                    buttonHBoxes.get(i));
        }
        
        
        // Set the master VBoxes and HBox as the content of each tab.
        tabSortingIntro.setContent(defaultTabHBox);
        tabBubbleSort.setContent(masterVBoxes.get(0));
        tabSelectionSort.setContent(masterVBoxes.get(1));
        tabInsertionSort.setContent(masterVBoxes.get(2));
        tabMergeSort.setContent(masterVBoxes.get(3));
        tabQuickSort.setContent(masterVBoxes.get(4));

        // Add the Tab objects to the TabPane object
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
