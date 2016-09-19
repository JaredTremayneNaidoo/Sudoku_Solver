package com.company;

import java.util.LinkedList;

/*
Quick Notes
array[y][x] is defined as so...
Group Members: Jared, Krupa and Zayyan

*/
public class Main {

    public static void main(String[] args) {
	// write your code here/**
        int[][] board = new int[9][9];
        fillboard(board);
        System.out.println("Unsolved Sudoku Puzzle!");
        System.out.println();
        printboard(board);
        System.out.println();
        System.out.println("Solve Sudoku Puzzle Started!");
        System.out.println();
        solveboard(board);

    }
    //Solve Sudoku Backtracking Problem...
    public static void solveboard(int[][] board){

        int i = 0;
        int j = 0;


        if(fullboard(board) == true){
            System.out.println("Sudoku Puzzle Solved!");
            System.out.println();
            printboard(board);
        }else{
            //Found our first empty space (Contains a zero)
            A:for(int y = 0;y<9;y++){
                for(int x = 0;x<9;x++){
                    if(board[y][x] == 0){
                        i = y;
                        j = x;
                        break A;
                    }
                }
            }

            LinkedList<Integer> possibilities = possibleentries(board, i,j);

            int[] array = new int[possibilities.size()];
            for(int z = 0;z<array.length;z++){
              array[z] = possibilities.get(z);
            }
            array = mergeSort(array, 0, array.length-1);



            for(int k = 0; k<array.length;k++){
                if(array[k] != 0){
                    board[i][j] = array[k];
                    //System.out.println("Test: "+board[i][j]);
                    solveboard(board);
                }
            }
            board[i][j] = 0;


        }

    }
        //Checks if the board is full/complete...Returns true if full, false if it is not full i.e. Unsolved Sudoku.
    public static boolean fullboard(int[][] board){

        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++) {
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    //Checks if items are in the array...
    public static boolean inarray(LinkedList<Integer> list, int value){

        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == value || value == 0 ){
                return true;
            }

        }
        return false;
    }
    //Returns the possible entries in one cell of the board.
    public static LinkedList possibleentries(int[][] board,int i,int j){

        LinkedList<Integer> possibleentry = new LinkedList<>();
        LinkedList<Integer> alreadyin = new LinkedList<>();

        //Three checks
        //Check 1...Horizontal Line Check...
        for(int k = 0; k<9; k++){
            if(board[i][k] == 0){

            }else{
                alreadyin.add(board[i][k]);
            }
        }

        //Check 1...Verticle Line Check...
        for(int l = 0; l<9; l++) {
            if (board[l][j] == 0) {

            } else {
                if (inarray(alreadyin, board[l][j]) == false) {
                    alreadyin.add(board[l][j]);
                }
            }
        }

        int m = 0;
        int n = 0;
        //Top Row of blocks
        //1st sec
        if((i>-1 && i<3) && (j>-1 && j<3)){
            for(m = 0;m<3;m++){
                for(n = 0; n<3;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test1");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //2nd sec
        if((i>-1 && i<3) && (j>2 && j<6)){
            for(m = 0;m<3;m++){
                for(n = 3; n<6;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test2: "+board[m][n]+" n: "+n+" m: "+m);
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //3rd sec
        if((i>-1 && i<3) && (j>5 && j<9)){
            for(m = 0;m<3;m++){
                for(n = 6; n<9;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test3");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //Middle Row of Blocks
        //1st sec
        if((i>2 && i<6) && (j>-1 && j<3)){
            for(m = 3;m<6;m++){
                for(n = 0; n<3;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test4");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //2nd sec
        if((i>2 && i<6) && (j>2 && j<6)){
            for(m = 3;m<6;m++){
                for(n = 3; n<6;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test5");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //3rd sec
        if((i>2 && i<6) && (j>5 && j<9)){
            for(m = 3;m<6;m++){
                for(n = 6; n<9;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test6");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //Last Row of Blocks
        //1st sec
        if((i>5 && i<9) && (j>-1 && j<3)){
            for(m = 6;m<9;m++){
                for(n = 0; n<3;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test7");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //2nd sec
        if((i>5 && i<9) && (j>2 && j<6)){
            for(m = 6;m<9;m++){
                for(n = 3; n<6;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test8");
                        alreadyin.add(board[m][n]);
                    }
                }
            }
        }
        //3rd sec
        if((i>5 && i<9) && (j>5 && j<9)){
            for(m = 6;m<9;m++){
                for(n = 6; n<9;n++){
                    if (inarray(alreadyin, board[m][n]) == false) {
                        //System.out.println("Test9");
                        alreadyin.add(board[m][n]);
                    }
                }
            }

        }

        for(n = 1; n<10;n++){
            if(inarray(alreadyin, n)==false){
                possibleentry.add(n);
            }
        }


/*
        printboard(board);
        System.out.println("Invalid Entries: ");
        for(n = 0; n<alreadyin.size();n++){
            System.out.println(alreadyin.get(n));
            //System.out.println(possibleentry.get(n));

        }
        System.out.println("Valid Entries: ");
        for(n = 0; n<possibleentry.size();n++){
            //System.out.println(alreadyin.get(n));
            System.out.println(possibleentry.get(n));

        }
*/

        return possibleentry;
    }
    //Populates the board with numbers...
    public static int[][] fillboard(int[][] SudokuBoard){

        SudokuBoard[0][0] = 0;
        SudokuBoard[0][1] = 0;
        SudokuBoard[0][2] = 0;
        SudokuBoard[0][3] = 3;
        SudokuBoard[0][4] = 0;
        SudokuBoard[0][5] = 0;
        SudokuBoard[0][6] = 2;
        SudokuBoard[0][7] = 0;
        SudokuBoard[0][8] = 0;
        SudokuBoard[1][0] = 0;
        SudokuBoard[1][1] = 0;
        SudokuBoard[1][2] = 0;
        SudokuBoard[1][3] = 0;
        SudokuBoard[1][4] = 0;
        SudokuBoard[1][5] = 8;
        SudokuBoard[1][6] = 0;
        SudokuBoard[1][7] = 0;
        SudokuBoard[1][8] = 0;
        SudokuBoard[2][0] = 0;
        SudokuBoard[2][1] = 7;
        SudokuBoard[2][2] = 8;
        SudokuBoard[2][3] = 0;
        SudokuBoard[2][4] = 6;
        SudokuBoard[2][5] = 0;
        SudokuBoard[2][6] = 3;
        SudokuBoard[2][7] = 4;
        SudokuBoard[2][8] = 0;
        SudokuBoard[3][0] = 0;
        SudokuBoard[3][1] = 4;
        SudokuBoard[3][2] = 2;
        SudokuBoard[3][3] = 5;
        SudokuBoard[3][4] = 1;
        SudokuBoard[3][5] = 0;
        SudokuBoard[3][6] = 0;
        SudokuBoard[3][7] = 0;
        SudokuBoard[3][8] = 0;
        SudokuBoard[4][0] = 1;
        SudokuBoard[4][1] = 0;
        SudokuBoard[4][2] = 6;
        SudokuBoard[4][3] = 0;
        SudokuBoard[4][4] = 0;
        SudokuBoard[4][5] = 0;
        SudokuBoard[4][6] = 4;
        SudokuBoard[4][7] = 0;
        SudokuBoard[4][8] = 9;
        SudokuBoard[5][0] = 0;
        SudokuBoard[5][1] = 0;
        SudokuBoard[5][2] = 0;
        SudokuBoard[5][3] = 0;
        SudokuBoard[5][4] = 8;
        SudokuBoard[5][5] = 6;
        SudokuBoard[5][6] = 1;
        SudokuBoard[5][7] = 5;
        SudokuBoard[5][8] = 0;
        SudokuBoard[6][0] = 0;
        SudokuBoard[6][1] = 3;
        SudokuBoard[6][2] = 5;
        SudokuBoard[6][3] = 0;
        SudokuBoard[6][4] = 9;
        SudokuBoard[6][5] = 0;
        SudokuBoard[6][6] = 7;
        SudokuBoard[6][7] = 6;
        SudokuBoard[6][8] = 0;
        SudokuBoard[7][0] = 0;
        SudokuBoard[7][1] = 0;
        SudokuBoard[7][2] = 0;
        SudokuBoard[7][3] = 7;
        SudokuBoard[7][4] = 0;
        SudokuBoard[7][5] = 0;
        SudokuBoard[7][6] = 0;
        SudokuBoard[7][7] = 0;
        SudokuBoard[7][8] = 0;
        SudokuBoard[8][0] = 0;
        SudokuBoard[8][1] = 0;
        SudokuBoard[8][2] = 9;
        SudokuBoard[8][3] = 0;
        SudokuBoard[8][4] = 0;
        SudokuBoard[8][5] = 5;
        SudokuBoard[8][6] = 0;
        SudokuBoard[8][7] = 0;
        SudokuBoard[8][8] = 0;



        return SudokuBoard;
    }
    //Print outs a 9x9 board...
    public static void printboard(int[][] board){


        int j,i;

        for(i=0;i<9;i++) {
            for (j = 0; j < 9; j++) {
                if (j == 0) {
                    System.out.print(board[i][j]);
                } else {
                    if(j == 3 || j == 6){
                        System.out.print(" *");
                    }
                    System.out.print(" " + board[i][j]);
                }
            }
            if (i == 2 || i == 5) {
                System.out.println();
                for(int k = 0; k<9+2; k++){
                    System.out.print("* ");

                }
                System.out.println();
            }else{
                System.out.println();
            }
        }
        //System.out.println();
    }
    //Used to arrange the list of optional entries...
    public static int[] mergeSort(int[] array,int left, int right){

        int n = array.length;
        int[] temp = new int[n];
        int i,j;

        if(right - left >0){

            int mid = (int) Math.floor((left+right)/2);
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            for(i = mid;i >= left;i--){
                temp[i] = array[i];
            }
            for(j = mid+1; j <= right; j++ ){
                temp[right+mid+1-j] = array[j];
            }
            i = left;
            j = right;
            for(int k = left; k <= right; k++){
                if(temp[i]<temp[j]){
                    array[k] = temp[i];
                    i = i + 1;
                }else{
                    array[k] = temp[j];
                    j = j-1;
                }
            }
        }
        return array;

    }
}
