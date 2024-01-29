package Controller;

import Model.BPlusTree;
import Model.Database;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
    public List<String> getCapital(){
        return table.getCapital();
    }
    public static Controller.dataBaseController getDBController() {
        if(dataBaseCo==null){
            base=new Database();
            dataBaseCo=new dataBaseController();
        }
        return dataBaseCo;}
    public String addRow(String str){
        String[] arr=str.split(" ");
        if(arr.length==table.getCapital().size()){
        String key=arr[table.getKeyBaseIndex()];
        table.insert(key,arr);
        return "row added"+"\n"+" data is :"+ Arrays.toString(table.search(key));}
        return "your input data isvalid";

    }
    public String deleteRow(String str){
        if(table.search(str)!=null){
            table.delete(str);
            return "row deleted";
        }else{
            return "row not found";
        }
    }
    public String keyBase(){
       return table.getKeyBase();
    }
    public String searchRow(String orderYouSearch){
        return Arrays.toString(table.search(orderYouSearch));

    }
   public String editRow(String key,String capital,String newData){
        String[] value = table.search(key);
        value[getCapital().indexOf(capital)]=newData;
        table.insert(key,value);
        return Arrays.toString(table.search(key));
    }
    public String query(String start, String end){
        String result="";
        for(String[] key:table.searchRange(start,end)){
            result+= Arrays.toString(key) +"\n";
        }
        return result;

    }
    public String allRows(){

        String result="";
        for(String[] key:table.getAllValues()){
            result+= Arrays.toString(key) +"\n";
        }
        return result;
    }





}
