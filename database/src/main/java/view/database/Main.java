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
       System.out.println(dBController.getCapital().toString());
       System.out.println("enter new Data");
       String addOrder =sc.nextLine();
       System.out.println(dBController.addRow(addOrder));
   }
   public static void deleteRow(){
       System.out.println("enter row to delete"+" based delete is "+dBController.keyBase());
       String deleteOrder=sc.nextLine();
       System.out.println(dBController.deleteRow(deleteOrder));
   }



    public static void main(String[] args){
       dBController=dataBaseController.getDBController();
        addTable();
        choseTable();
        addRow();
        deleteRow();






    }




}
