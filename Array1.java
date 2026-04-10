/* 1. Define a class Array with following member  
 
 
Field: 
int data[]; 
Function: 
Array( )                                        //create array data of size 10 
Array(int size)                           // create array of size size 
Array(int data[])                       // initialize array with parameter array 
void Reverse _an _array ()     //reverse element of an array 
int Maximum _of _array ()     // find  maximum element of array 
int Average_of _array()          //find average of  element of array 
void Sorting ()                         //sort element of array 
void display()                          //display element of array 
int search(int no)    //search element and return index else  return -1  
int size();                           //return size of an array 
 
Use all the function in main method. Create different objects with different 
constructors. */

public class MyArray {
    
    int data[]; // array field to store numbers (like a row of lockers)

    // Constructor 1 - when no size is given, create 10 lockers by default
    MyArray() {
        data = new int[10]; // create array of size 10
    }

    // Constructor 2 - when size is given, create that many lockers
    MyArray(int size) {
        data = new int[size]; // create array of given size
    }

    // Constructor 3 - when array is given, use it directly
    MyArray(int d[]) {
        data = d; // store the given array into data
    }

    // display() - print all elements of array
    void display() {
        for(int i = 0; i < data.length; i++) { // loop through every locker
            System.out.print(data[i] + " ");    // print value inside locker
        }
        System.out.println(); // move to next line after printing
    }

    // size() - return how many elements are in array
    int size() {
        return data.length; // data.length gives total number of lockers
    }

    // Maximum_of_array() - find the biggest number in array
    int Maximum_of_array() {
        int max = data[0]; // assume first element is the biggest
        for(int i = 1; i < data.length; i++) { // check every other element
            if(data[i] > max) { // if current element is bigger than max
                max = data[i];  // update max with new bigger value
            }
        }
        return max; // return the biggest number found
    }

    // Average_of_array() - find average of all elements
    int Average_of_array() {
        int sum = 0; // start with sum = 0
        for(int i = 0; i < data.length; i++) { // loop through every element
            sum = sum + data[i]; // add each element to sum
        }
        return sum / data.length; // divide sum by total count to get average
    }

    // Reverse_an_array() - reverse all elements of array
    void Reverse_an_array() {
        int start = 0;              // start pointer at beginning
        int end = data.length - 1;  // end pointer at last element
        while(start < end) {        // keep swapping until pointers meet in middle
            int temp = data[start]; // save start value in temp box
            data[start] = data[end];// put end value into start
            data[end] = temp;       // put saved temp value into end
            start++;                // move start pointer forward
            end--;                  // move end pointer backward
        }
    }

    // Sorting() - sort elements from smallest to biggest (Bubble Sort)
    void Sorting() {
        for(int i = 0; i < data.length - 1; i++) {         // outer loop - number of rounds
            for(int j = 0; j < data.length - i - 1; j++) { // inner loop - compare neighbors
                if(data[j] > data[j+1]) {   // if left element is bigger than right
                    int temp = data[j];      // save left value in temp
                    data[j] = data[j+1];     // put right value into left
                    data[j+1] = temp;        // put saved temp into right
                }
            }
        }
    }

    // search() - find a number and return its index, return -1 if not found
    int search(int no) {
        for(int i = 0; i < data.length; i++) { // check every locker one by one
            if(data[i] == no) { // if current element matches the number
                return i;       // return its position (index)
            }
        }
        return -1; // number not found anywhere, return -1
    }

    public static void main(String[] args) {

        // Object 1 - using Constructor 1 (default size 10)
        MyArray a1 = new MyArray();
        System.out.println("Size of a1: " + a1.size()); // prints 10

        // Object 2 - using Constructor 2 (custom size 5)
        MyArray a2 = new MyArray(5);
        System.out.println("Size of a2: " + a2.size()); // prints 5

        // Object 3 - using Constructor 3 (pre-filled array)
        int[] d = {5, 2, 8, 1, 9};  // create array with values
        MyArray a3 = new MyArray(d) ; // pass array to constructor

        System.out.print("Original: ");
        a3.display(); // prints: 5 2 8 1 9

        System.out.println("Max: " + a3.Maximum_of_array()); // prints: 9

        System.out.println("Average: " + a3.Average_of_array()); // prints: 5

        a3.Reverse_an_array(); // reverse the array
        System.out.print("Reversed: ");
        a3.display(); // prints: 9 1 8 2 5

        a3.Sorting(); // sort the array
        System.out.print("Sorted: ");
        a3.display(); // prints: 1 2 5 8 9

        System.out.println("Search 8: " + a3.search(8));  // prints index of 8
        System.out.println("Search 99: " + a3.search(99)); // prints -1 (not found)
    }
}