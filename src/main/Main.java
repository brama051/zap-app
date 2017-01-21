package main;

import org.eclipse.swt.widgets.Display;

import controller.PaycheckController;
import view.MainMenu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaycheckController paycheckController = null;
		System.out.println("Hello, brama");
		Display display = new Display();
        MainMenu mainMenu = new MainMenu(display, paycheckController);
        System.out.println("Created new window");
        display.dispose();
	}

}
