


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wiese_ko8fa
 */
public class CSV {

    private static final ResourceBundle bundle_CSV = ResourceBundle.getBundle("bundle_CSV");
    private Map<String, LinkedList<String>> map = new TreeMap<>();
    

    public CSV() {
    }

    public Map<String, LinkedList<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, LinkedList<String>> map) {
        this.map = map;
    }
    
    private void add_product(String group, String product)
    {
        if(map.containsKey(group))
        {
            map.get(group).add(product);
        }
        else
        {
            LinkedList<String> list = new LinkedList<>();
            list.add(product);
            map.put(group, list);
        }
    }
    
    public void load() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(bundle_CSV.getString("PRODUKTE.CSV")));
        while(reader.readLine() != null)
        {
            String line = reader.readLine();
            String[] arr = line.split(";");
            this.add_product(arr[0], arr[1]);
        }
    }
}
