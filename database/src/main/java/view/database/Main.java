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
   public static void editRow(){
       System.out.println("enter which row do you want to delete : (base delete is) "+dBController.keyBase());
       String key=sc.nextLine();
       System.out.println(dBController.getCapital());
       System.out.println(dBController.searchRow(key));
       System.out.println("which Capital Do you want to edit ?");
       String capt=sc.nextLine();
       System.out.println("enter new data : ");
       String newData=sc.nextLine();
       System.out.println("new data is : "+dBController.editRow(key,capt,newData));





   }



    public static void main(String[] args){
       dBController=dataBaseController.getDBController();
        addTable();
        choseTable();
        addRow();
        deleteRow();
        editRow();






    }




}
