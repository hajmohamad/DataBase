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
       System.out.println("enter which row do you want to delete : (base search is) "+dBController.keyBase());
       String key=sc.nextLine();
       System.out.println(dBController.getCapital());
       if(dBController.searchRow(key)!=null){
       System.out.println(Arrays.toString(dBController.searchRow(key)));
       System.out.println("which Capital Do you want to edit ?");
       String capt=sc.nextLine();
       System.out.println("enter new data : ");
       String newData=sc.nextLine();
       System.out.println("new data is : "+dBController.editRow(key,capt,newData));}
       else{
           System.out.println("row not found");
       }





   }
   public static void searchRow(){
       System.out.println("enter which row do you want to search : (base search is) "+dBController.keyBase());
       String key=sc.nextLine();
       System.out.println(dBController.searchRow(key));
   }
   public static void Query(){
       System.out.println("rang you locking for :");
       System.out.println("start key");
       String startKey=sc.nextLine();
       System.out.println("end key");
       String endKey=sc.nextLine();
       System.out.println("result is :");
       System.out.println(dBController.query(startKey,endKey));



   }
   public static void allRows(){
       System.out.println(dBController.allRows());
   }
   public static void changeBase(){
       System.out.println("the keybase is : "+dBController.keyBase());
       System.out.println(dBController.getCapital());
       System.out.println("enter new keybase");
       String newKeyBase=sc.nextLine();
       System.out.println(dBController.changeBase(newKeyBase));

   }
   public static void printBPtree(){
       System.out.println(dBController.printBPtree());
   }




    public static void main(String[] args){
       dBController=dataBaseController.getDBController();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Table");
            System.out.println("2. Choose Table");
            System.out.println("3. Add Row");
            System.out.println("4. Delete Row");
            System.out.println("5. Edit Row");
            System.out.println("6. Search Row");
            System.out.println("7. query");
            System.out.println("8. All Rows");
            System.out.println("9. Change Base");
            System.out.println("10. print bplustree");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTable();
                    break;
                case 2:
                    choseTable();
                    break;
                case 3:
                    addRow();
                    break;
                case 4:
                    deleteRow();
                    break;
                case 5:
                    editRow();
                    break;
                case 6:
                    searchRow();
                    break;
                case 7:
                    Query();
                    break;
                case 8:
                    allRows();
                    break;
                case 9:
                  changeBase();
                    break;
                case 10 :
                    printBPtree();
                    break;
                case 11 :
                    System.out.println("Exiting...");
                       exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
