# orders_manager
Software for managing orders
package com.kdev.rackcodefinder;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RackCodeLookup {

    public static void main(String[] args) {

        String csvFile = "E:/Android_Development/rack.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        Map <Long, String> products = new HashMap <>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
        	int cnt = 0;
        	
            while ((line = br.readLine()) != null) {

                if(cnt==0) { cnt++; continue; }
            	// use comma as separator
                String[] product = line.split(cvsSplitBy);

                System.out.println("SKU: " + product[1] + " Rack_ID: " + product[2]);
                
                cnt++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
