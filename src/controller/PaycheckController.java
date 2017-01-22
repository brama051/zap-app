package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import model.Paycheck;

public class PaycheckController {
	public ArrayList<Paycheck> paycheckList;
	private String fileName;
	
	public PaycheckController(String fileName){
		this.fileName = fileName;
		this.paycheckList = new ArrayList<Paycheck>();
	}
	
	public int lastIndex(){
		return this.paycheckList.size();
	}
	
	public void createPaycheck(Paycheck paycheck){
		this.paycheckList.add(paycheck);
		try {
			this.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			this.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletePaycheck(int id){
		int pCount = 0;
		for (Paycheck object: this.paycheckList){
			System.out.println(object.getId() + " : " + id);
		    if (object.getId() == id) { 
		    	this.paycheckList.remove(pCount);
		    	try {
					this.save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	return;
		    }
		    pCount ++;
		}
		
	}
	
	public int getNextID(){
		int id = 0;
		System.out.println(this.paycheckList.size());
		for (Paycheck p : this.paycheckList) {
			id = p.getId() + 1;
		}
		return id;
	}
	
	public void load() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(this.fileName));
	    String[] nextLine = new String[7];
	    while ((nextLine = reader.readNext()) != null) {
	        Paycheck paycheck = new Paycheck(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[2], 
	        		Integer.parseInt(nextLine[3]), Float.parseFloat(nextLine[4]), Float.parseFloat(nextLine[5]));
	        this.paycheckList.add(paycheck);
	    }
	}
	
	public void save() throws IOException{
		
		CSVWriter writer = new CSVWriter(new FileWriter(this.fileName, false));
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
		/*System.out.println("Hello novi dokument");
		PaycheckController pc = new PaycheckController("file.csv");
		/*pc.createPaycheck(new Paycheck(0,"Edi", "Ibriks", 1, 123, 123));
		pc.createPaycheck(new Paycheck(1,"Edi", "Ibriks2", 1, 123, 123));
		pc.createPaycheck(new Paycheck(2,"Edi", "Ibriks3", 1, 123, 123));*/
		/*try {
			//pc.save();
			pc.load();
			//Paycheck p = pc.readPaycheck(0);
			for (Paycheck p : pc.paycheckList) {
				System.out.println(p.getLastName());
			}
			
			pc.getNextID();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
}
