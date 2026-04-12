import java.util.Scanner;

public class Matrix {

    int row, column;  // store number of rows and columns
    float mat[][];    // 2D array to store matrix elements

    // Constructor 1 - default 3x3 empty matrix
    Matrix() {
        row = 3;
        column = 3;
        mat = new float[row][column]; // create empty 3x3 matrix
    }

    // Constructor 2 - custom size matrix
    Matrix(int r, int col) {
        row = r;        // set row size
        column = col;   // set column size
        mat = new float[row][column]; // create empty matrix of given size
    }

    // Constructor 3 - fill matrix with given 2D array
    Matrix(int a[][]) {
        row = a.length;         // get rows from given array
        column = a[0].length;   // get columns from first row
        mat = new float[row][column];
        for(int i = 0; i < row; i++) {          // loop through rows
            for(int j = 0; j < column; j++) {   // loop through columns
                mat[i][j] = a[i][j];            // copy each value
            }
        }
    }

    // readMatrix() - take input from user for each element
    void readMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + row*column + " elements:");
        for(int i = 0; i < row; i++) {          // loop through rows
            for(int j = 0; j < column; j++) {   // loop through columns
                mat[i][j] = sc.nextFloat();      // store each element
                
            }
        }
    }

    // displayMatrix(float[][]) - display any given matrix
    void displayMatrix(float[][] a) {
        for(int i = 0; i < a.length; i++) {         // loop through rows
            for(int j = 0; j < a[i].length; j++) {  // loop through columns
                System.out.print(a[i][j] + "  ");   // print element
            }
            System.out.println(); // new line after each row
        }
    }

    // displayMatrix() - display own matrix
    void displayMatrix() {
        displayMatrix(mat); // reuse above function with own array
    }

    // transpose() - swap rows and columns of matrix
    float[][] transpose() {
        float result[][] = new float[column][row]; // swapped size!
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                result[j][i] = mat[i][j]; // put [i][j] into [j][i]
            }
        }
        return result; // return new transposed matrix
    }

    // matrixMultiplication() - multiply this matrix with second matrix
    float[][] matrixMultiplication(Matrix second) {
        float result[][] = new float[row][second.column]; // result size
        for(int i = 0; i < row; i++) {               // rows of first
            for(int j = 0; j < second.column; j++) { // cols of second
                result[i][j] = 0;                    // start from 0
                for(int k = 0; k < column; k++) {    // multiply and add
                    result[i][j] += mat[i][k] * second.mat[k][j];
                }
            }
        }
        return result; // return multiplied result
    }

    // maximum_of_array() - find biggest element in matrix
    float maximum_of_array() {
        float max = mat[0][0]; // assume first element is biggest
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(mat[i][j] > max) { // found bigger element?
                    max = mat[i][j];  // update max
                }
            }
        }
        return max; // return biggest element found
    }

    // average_of_array() - find average of all elements
    float average_of_array() {
        float sum = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                sum += mat[i][j]; // add every element
            }
        }
        return sum / (row * column); // divide by total elements
    }

    public static void main(String[] args) {

        // Object 1 - Constructor 1 (default 3x3)
        Matrix m1 = new Matrix();
        System.out.println("Enter elements for m1 (3x3):");
        m1.readMatrix();
        System.out.println("Matrix m1:");
        m1.displayMatrix();
        System.out.println("Maximum of m1: " + m1.maximum_of_array());
        System.out.println("Average of m1: " + m1.average_of_array());
        System.out.println("Transpose of m1:");
        m1.displayMatrix(m1.transpose());

        // Object 2 - Constructor 2 (custom 2x2)
        Matrix m2 = new Matrix(2, 2);
        System.out.println("Enter elements for m2 (2x2):");
        m2.readMatrix();
        System.out.println("Matrix m2:");
        m2.displayMatrix();

        // Object 3 - Constructor 3 (pre-filled array)
        int[][] d = {{1, 2}, {3, 4}};
        Matrix m3 = new Matrix(d);
        System.out.println("Matrix m3 (pre-filled):");
        m3.displayMatrix();

        // Multiply m2 x m3
        System.out.println("m2 x m3 result:");
        m2.displayMatrix(m2.matrixMultiplication(m3));
    }
}