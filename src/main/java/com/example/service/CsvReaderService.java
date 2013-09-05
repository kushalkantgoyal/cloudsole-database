package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CsvReaderService {

	private BufferedReader br;
	private static String line = "";
	private static String csvSplitBy=",";
	
	public Map<String, String> readCsv(File csvFile) throws IOException{
		Map<String, String> mapOfFile = new HashMap<String, String>();
		try{
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine())!=null){
				String[] columns = line.split(csvSplitBy);
				mapOfFile.put(columns[0], columns[1]) ;
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			if (br!=null){
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		
		}
		return mapOfFile;
	}
	
	/*public List<Customer> readAndMapCsvFile(){
		List<Customer> listOfCustomers = new ArrayList<Customer>();
		for (String customer : customers){
			Customer newCustomer = new Customer();
			newCustomer.setFirstName(customer);
			newCustomer.setLastName(customer);
			listOfCustomers.add(newCustomer);
		}
	}*/
}
