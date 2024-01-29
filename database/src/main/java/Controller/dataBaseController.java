package Controller;

import Model.BPlusTree;
import Model.Database;

import java.util.Arrays;
import java.util.Objects;

public class dataBaseController {

    private static dataBaseController dataBaseCo;
    private   BPlusTree<String,String[]> table;
    private static    Database base;
////////////////////////////////////////
    public  String addTable(String name, String capital,String keyBase) {
        base.addTable(name, new BPlusTree<>(4,capital,name,keyBase));
        return "table by "+name+" is created"+"\n"+ "capital is " +capital;
    }
    public  String choseTable(String name){
        table= base.getTable(name);
        if(Objects.equals(table.getTableName(), name)){
            return  "table by "+name+" is chose";

        }else{
            return "table not found";
        }


    }
    public  String getCapital(){
        return table.getCapital().toString();
    }
    public static Controller.dataBaseController getDBController() {
        if(dataBaseCo==null){
            base=new Database();
            dataBaseCo=new dataBaseController();
        }
        return dataBaseCo;}
    public String addRow(String str){
        String[] arr=str.split(" ");
        String key=arr[table.getKeyBaseIndex()];
        table.insert(key,arr);
        return "row added"+"\n"+" data is :"+ Arrays.toString(table.search(key));

    }




}
