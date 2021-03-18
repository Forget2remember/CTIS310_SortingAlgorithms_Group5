/******************************************************************************\
 *  @authors Garrett Hedgecock {more}                                         *
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

public class SortingAlgos {
    
    int[] numbers;
    int length;
    boolean sorted;
    
    public SortingAlgos(int[] userNumbers){
        this.numbers = userNumbers;
        this.length = userNumbers.length;
        this.sorted = true;
    }
    
    public int[] BubbleSort(){
        this.sorted = true;
        int[] array = this.numbers.clone();
        int temp;
        
        for(int i = 0; i < this.length; i++){
            for(int j = 1; j < (this.length - i); j++){
                if(array[j - 1] > array[j]){
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    this.sorted = false;
                }
            }
            if(this.sorted){
                break;
            }
        }
        return array;
    }
}
