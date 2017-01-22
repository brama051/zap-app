package main;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;

import controller.PaycheckController;
import model.Paycheck;
import view.MainMenu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaycheckController paycheckController = new PaycheckController("file.csv");
		try {
			paycheckController.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello, brama");
		Display display = new Display();
        MainMenu mainMenu = new MainMenu(display, paycheckController);
        System.out.println("Created new window");
        display.dispose();
	}

}
