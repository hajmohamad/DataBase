package Controller;

import Model.BPlusTree;
import Model.Database;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class dataBaseController {

    private static dataBaseController dataBaseCo;
    private   BPlusTree<String,String[]> table;
    private static    Database base;
    boolean tableExists;
    public boolean tableExists(){
       return tableExists;
    }
    public String getTableName(){
        return table.getTableName();
    }

    public  String addTable(String name, String capital,String keyBase) {
        base.addTable(name, new BPlusTree<>(4,capital,name,keyBase));
      tableExists=true;
      choseTable(name);
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
    public static dataBaseController getDBController() {
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
    public String[] searchRow(String orderYouSearch){
        return table.search(orderYouSearch);

    }
    public void editRow(String key,String[] newData){
        table.insert(key,newData);
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
        for(String[] key:table.getAllValues()
        ){
            result+= Arrays.toString(key) +"\n";
        }
        return result;
    }
    public String changeBase(String newBase){
        int newIndex = getCapital().indexOf(newBase);
        String oldBase=table.getKeyBase();
        if(newIndex<0){
            return "base not found";
        }
       String capitals="";
       for(String str:table.getCapital()){
           capitals+=str+" ";
       }

        BPlusTree<String,String[]> newTable=new BPlusTree<>(4,capitals,table.getTableName(),newBase);
      for(String str:table.allKeys()){
              String[] arr=table.search(str);
          newTable.insert(arr[newIndex],arr);
      }
      tableExists=true;
       table=newTable;
       base.addTable(table.getTableName(),newTable);
       return "base changed from "+oldBase+" to "+newBase;
    }
    public String printBPtree(){

        return table.toString();

    }
public Set<String> getTables(){
        return base.getKeyTables();

}
public List<String> getAllKey(){

    return table.allKeys();
    }





}
