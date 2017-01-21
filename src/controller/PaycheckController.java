package controller;

import java.util.ArrayList;

import model.Paycheck;

public class PaycheckController {
	public ArrayList<Paycheck> paycheckList;
	private String fileName;
	
	PaycheckController(String fileName){
		this.fileName = fileName;
		this.paycheckList = new ArrayList<Paycheck>();
	}
	
	public void createPaycheck(Paycheck placa){}
	
	public void readPaycheck(int id){}
	
	public void updatePaycheck(Paycheck paycheck){}
	
	public void deletePaycheck(int id){}
	
	public void load(){}
	
	public void save(){}
	
	
	
}
