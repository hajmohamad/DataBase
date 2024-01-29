package view.database;

import Controller.dataBaseController;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
   static Scanner sc=new Scanner(System.in);
   static dataBaseController dBController;


   public static  void addTable(){
       System.out.println("Enter table name");
       String name=sc.nextLine();
       System.out.println("Enter table capital");
       String capital=sc.nextLine();
       System.out.println("Enter keyBase ");
       String keyBase=sc.nextLine();
       System.out.println( dBController.addTable(name,capital,keyBase));
       dBController.choseTable(name);

   }
   public static void choseTable(){
       System.out.println("Enter table name");
       String name=sc.nextLine();
       System.out.println( dBController.choseTable(name));
   }
   public static void addRow(){
       System.out.println(dBController.getCapital());
       System.out.println("enter new Data");
       String str=sc.nextLine();
       System.out.println(dBController.addRow(str));


   }



    public static void main(String[] args){
       dBController=dataBaseController.getDBController();
        addTable();
        choseTable();
        addRow();





    }




}
