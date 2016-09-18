package com.company;

import java.util.LinkedList;

/*
Quick Notes
array[y][x] is defined as so...

*/
public class Main {

    public static void main(String[] args) {
	// write your code here/**
        int[][] board = new int[9][9];
        fillboard(board);
        printboard(board);

        possibleentries(board,0,0);

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

    public static boolean inarray(LinkedList<Integer> list, int value){

        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == value){
                return true;
            }

        }
        return false;
    }

    //Returns the possible entries in one cell of the board.
    public static LinkedList possibleentries(int[][] board,int i,int j){

        LinkedList<Integer> entryarray = new LinkedList<>();
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

        //Top Row of blocks
        //1st sec
        if((i>-1 && i>3) && (i>-1 && i>3)){

        }
        //2nd sec
        if((i>-1 && i>3) && (j>2 && j<6)){

        }
        //3rd sec
        if((i>-1 && i>3) && (j>6 && j<9)){

        }
        //Middle Row of Blocks
        //1st sec
        if((i>2 && i<6) && (j>-1 && j<3)){

        }
        //2nd sec
        if((i>2 && i<6) && (j>2 && j<6)){

        }
        //3rd sec
        if((i>2 && i<6) && (j>6 && j<9)){

        }
        //Last Row of Blocks
        //1st sec
        if((i>6 && i<9) && (j>-1 && j<3)){

        }
        //2nd sec
        if((i>6 && i<9) && (j>2 && j<6)){

        }
        //3rd sec
        if((i>6 && i<9) && (j>6 && j<9)){

        }



        //System.out.println(alreadyin.get(3));


        return entryarray;
    }

    //Populates the board with numbers...
    public static int[][] fillboard(int[][] board){

        board[0][0] = 0;
        board[0][1] = 0;
        board[0][2] = 0;
        board[0][3] = 3;
        board[0][4] = 0;
        board[0][5] = 0;
        board[0][6] = 2;
        board[0][7] = 0;
        board[0][8] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[1][3] = 0;
        board[1][4] = 0;
        board[1][5] = 8;
        board[1][6] = 0;
        board[1][7] = 0;
        board[1][8] = 0;
        board[2][0] = 0;
        board[2][1] = 7;
        board[2][2] = 8;
        board[2][3] = 0;
        board[2][4] = 6;
        board[2][5] = 0;
        board[2][6] = 3;
        board[2][7] = 4;
        board[2][8] = 0;
        board[3][0] = 0;
        board[3][1] = 4;
        board[3][2] = 2;
        board[3][3] = 5;
        board[3][4] = 1;
        board[3][5] = 0;
        board[3][6] = 0;
        board[3][7] = 0;
        board[3][8] = 0;
        board[4][0] = 1;
        board[4][1] = 0;
        board[4][2] = 6;
        board[4][3] = 0;
        board[4][4] = 0;
        board[4][5] = 0;
        board[4][6] = 4;
        board[4][7] = 0;
        board[4][8] = 9;
        board[5][0] = 0;
        board[5][1] = 0;
        board[5][2] = 0;
        board[5][3] = 0;
        board[5][4] = 8;
        board[5][5] = 6;
        board[5][6] = 1;
        board[5][7] = 5;
        board[5][8] = 0;
        board[6][0] = 0;
        board[6][1] = 3;
        board[6][2] = 5;
        board[6][3] = 0;
        board[6][4] = 9;
        board[6][5] = 0;
        board[6][6] = 7;
        board[6][7] = 6;
        board[6][8] = 0;
        board[7][0] = 0;
        board[7][1] = 0;
        board[7][2] = 0;
        board[7][3] = 7;
        board[7][4] = 0;
        board[7][5] = 0;
        board[7][6] = 0;
        board[7][7] = 0;
        board[7][8] = 0;
        board[8][0] = 0;
        board[8][1] = 0;
        board[8][2] = 9;
        board[8][3] = 0;
        board[8][4] = 0;
        board[8][5] = 5;
        board[8][6] = 0;
        board[8][7] = 0;
        board[8][8] = 0;

        return board;
    }
    //Print outs a 9x9 board...
    public static void printboard(int[][] board){

        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++) {
                if (j==0) {
                    System.out.print(board[i][j]);
                }else{
                    System.out.print(" " + board[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Code Complete!");
    }
}
