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
    
    public int[] bubbleSort(){
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
    
    public int[] selectionSort(){
        this.sorted = true;
        int[] numbersArray = this.numbers.clone();
        int temp, index, smallerNumber;
        
        for(int i = 0; i < (this.length - 1); i++){
            index = i;
            
            for(int j = (i + 1); i < this.length; j++){
                if(numbersArray[j] < numbersArray[index]){
                    index = j;
                }
            }
            smallerNumber = numbersArray[index];
            numbersArray[index] = numbersArray[i];
            numbersArray[i] = smallerNumber;
        }
        return numbersArray;
    }
    
    public int[] insertionSort(){
        int[] numbersArray = this.numbers.clone();
        int temp;
        
        for(int i = 1; i < (this.length); i++){
            for(int j = 1; j > 0; j--){
                if(numbersArray[j] < numbersArray[j - 1]){
                    temp = numbersArray[j];
                    numbersArray[j] = numbersArray[j - 1];
                    numbersArray[j - 1] = temp;
                }
            }
        }
        return numbersArray;
    }
}
