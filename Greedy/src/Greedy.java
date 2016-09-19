/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author Zayyan
 */
public class Greedy {

   public static int GreedIsGood1(int amount)
   {
       int change = 0;
       int one = 1;
       int two = 2;
       int five = 5;
       int ten = 10;
       int twenty = 20;
       int fifty = 50;
       
       
       if (amount >= fifty)
       {
           change = fifty;
       }
       else if (amount < fifty && amount >=20)
       {
           change = twenty;
       }
       else if (amount < twenty && amount >= ten)
       {
           change = ten;
       }
       else if (amount < ten && amount >= five)
       {
           change = five;
       }
       else if (amount < five && amount >= two)
       {
           change = two;
       }
       else if (amount < two && amount >= one)
       {
           change = one;
       }
       else if (amount < 1)
       {
           change = -1;
       }        
       
       
       return change;
   }
    
   public static int GreedIsGood2(int amount)
   {
       int change = 0;
       int one = 1;
       int three = 3;
       int five = 5;
       int twenty = 20;
              
       if (amount >= 20)
       {
           change = 20;
       }
       else if (amount < 20 && amount >=5)
       {
           change = 5;
       }
       else if (amount < 5 && amount >=3)
       {
           change = 3;
       }
       else if (amount < 3 && amount >=1)
       {
           change = 1;
       }
       else if (amount < 1)
       {
           change = -1;
       }
       return change;
               
   }
       public static int GreedIsGood3(int amount)
       {
        int change = 0;
        int one = 1;
        int three = 3;
        int four = 4;
        int nine = 9;
        int thirty = 30;
          
        if (amount >= 30)
        {
            change = thirty;
        }
        else if (amount < 30 && amount >= 9)
        {
            change = nine;
        }
        else if (amount < 9 && amount >= 4)
        {
            change = four;
        }
        else if (amount < 4 && amount > three)
        {
            change = three;
        }
        else if (amount < 3 && amount >= 1)
        {
            change = one;
        }
        else if (amount < 1)
                {
                change = -1;
                }
   return change;
           }
       
    public static void main(String[] args) 
    {
    
        System.out.println("Enter amount");
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        for (int i = 0;i < 5; i++)
        {

        int amount = rand.nextInt(300) + 1;
        System.out.println("The amount is:" + " " + amount);
        int amount2 = amount;
        int amount3 = amount;
        int amount4 = amount;
        
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        
        int change1 = 0;
        int change2 = 0;
        int change3 = 0;
        int change4 = 0;
        
        //coinset1
        while (amount >= 1)
        {
            change1 = GreedIsGood1(amount); //first coin set
            //System.out.print(change1 + " ");
            amount = amount - change1; 
            count++; 
        }

        //coinset2
        while (amount2 >= 1)
        {
        change2 = GreedIsGood2(amount2);
       // System.out.print(change2 + " ");
        amount2 = amount2 - change2;
        count2++;
        }
        
        //cointset3
        while (amount3 >= 1)
        {
            change3 = GreedIsGood3(amount3);
           // System.out.print(change3+ " ");
            amount3 = amount3 - change3;
            count3++;
        }
        
        System.out.println("Amount of coins from changeset 1:" + " " + count);
        System.out.println("Amount of coins from changeset 2:" + " " + count2);
        System.out.println("Amount of coins from changeset 3:" + " " + count3);
        
        
    }
    }
}
