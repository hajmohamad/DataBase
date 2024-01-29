package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Database{

    //key is name // value is tree
    public HashMap<String,BPlusTree<String,String[]>> Tables;

    public Set<String> getKeyTables() {
        return Tables.keySet();
    }
    public BPlusTree<String,String[]> getTable(String key){
        return Tables.get(key);
    }

    public void addTable(String key, BPlusTree<String,String[]> table) {
        Tables.put(key,table);
    }

    public Database() {
        Tables = new HashMap<>();
    }
}




