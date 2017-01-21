package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import model.Paycheck;

public class PaycheckController {
	public ArrayList<Paycheck> paycheckList;
	private String fileName;
	
	PaycheckController(String fileName){
		this.fileName = fileName;
		this.paycheckList = new ArrayList<Paycheck>();
	}
	
	public int lastIndex(){
		return this.paycheckList.size();
	}
	
	public void createPaycheck(Paycheck paycheck){
		this.paycheckList.add(paycheck);
	}
	
	public Paycheck readPaycheck(int id){
		for (Paycheck object: this.paycheckList)
		    if (object.getId() == id) return object;
		return null;
	}
	
	public void updatePaycheck(Paycheck paycheck){
		int i = 0;
		for (Paycheck object: this.paycheckList){
		    if (object.getId() == paycheck.getId()){
		    	this.paycheckList.get(i).setFirstName(paycheck.getFirstName());
		    	this.paycheckList.get(i).setLastName(paycheck.getLastName());
		    	this.paycheckList.get(i).setMonth(paycheck.getMonth());
		    	this.paycheckList.get(i).setPricePerHour(paycheck.getPricePerHour());
		    	this.paycheckList.get(i).setTotalHours(paycheck.getTotalHours());
		    }
		    i++;
		}
	}
	
	public void deletePaycheck(int id){
		for (Paycheck object: this.paycheckList)
		    if (object.getId() == id) this.paycheckList.remove(object);
	}
	
	public void load() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(this.fileName));
	    String[] nextLine = new String[7];
	    while ((nextLine = reader.readNext()) != null) {
	        Paycheck paycheck = new Paycheck(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[2], 
	        		Integer.parseInt(nextLine[3]), Float.parseFloat(nextLine[4]), Float.parseFloat(nextLine[5]));
	        paycheckList.add(paycheck);
	    }
	}
	
	public void save() throws IOException{
		CSVWriter writer = new CSVWriter(new FileWriter(this.fileName));
		//List<String> lines = new ArrayList<String>();
		for (Paycheck object: this.paycheckList){
			String[] entries = new String[7];
			entries[0] = Integer.toString(object.getId());
			entries[1] = object.getFirstName();
			entries[2] = object.getLastName();
			entries[3] = Integer.toString(object.getMonth());
			entries[4] = Float.toString(object.getPricePerHour());
			entries[5] = Float.toString(object.getTotalHours());
			entries[6] = Float.toString(object.getTotal());
			writer.writeNext(entries);	
		}
		writer.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello novi dokument");
	}
	
}
