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

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class SortingAlgorithmsGroup5 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize constants to hold window width and height
        final int SCENE_WIDTH = 800;
        final int SCENE_HEIGHT = 800;
        
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
        
        // Setting up the first (default) tab
        String sortingIntroString = "Sorting Effeciency\n"
                + "\n"
                + "Two two main criterias to judge which algorithm is better than"
                + " the over have been:\n"
                + "\n"
                + "\t1- Time taken to sort the given data.\n"
                + "\t2- Memory Space required to do so.\n";
        
        Label sortingIntroLabel = new Label(sortingIntroString);
        HBox hBoxSortingIntro = new HBox(sortingIntroLabel);
        hBoxSortingIntro.setAlignment(Pos.CENTER);
        
        tabSortingIntro.setContent(hBoxSortingIntro);
        
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
