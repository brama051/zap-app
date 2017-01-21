package view;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import controller.PaycheckController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;


public class MainMenu {
	public Display display; //screen
	public Shell shell; //window
	public PaycheckController paycheckController;
	//build interface
	public MainMenu(Display display, PaycheckController paycheckController) {
	    this.display = display;  
	    this.paycheckController = paycheckController;
	    this.initUI();
        
    }
	
	private void initUI(){
		this.shell = new Shell(this.display);
        this.shell.setText("Paycheck Application - Main Menu");
        this.shell.setSize(250, 500);
         

        //set layout
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 10;
        this.shell.setLayout(rowLayout);
        

        //add buttons
        Button btnListPaychecks = new Button(this.shell, SWT.PUSH);
        btnListPaychecks.setText("Ispis");
        btnListPaychecks.setLayoutData(new RowData(100, 30));
        btnListPaychecks.addSelectionListener(this.openListListener());
        
        Button btnCreatePaycheck = new Button(this.shell, SWT.PUSH);
        btnCreatePaycheck.setText("Unos");
        btnCreatePaycheck.setLayoutData(new RowData(100, 30));

        Button btnEditPaycheck = new Button(this.shell, SWT.PUSH);
        btnEditPaycheck.setText("Uređivanje");
        btnEditPaycheck.setLayoutData(new RowData(100, 30));
        
        Button btnDeletePaycheck = new Button(this.shell, SWT.PUSH);
        btnDeletePaycheck.setText("Brisanje");
        btnDeletePaycheck.setLayoutData(new RowData(100, 30));
        
        
        //quit button
        Button quitBtn = new Button(shell, SWT.PUSH);
        quitBtn.setText("Izlaz");
        quitBtn.setLayoutData(new RowData(100, 30));
        quitBtn.addSelectionListener(this.setQuitListener());
        	
        this.shell.pack();
        this.centerWindow();
        this.shell.open();
        
        
        
        
        
        
        ///////////////

        while (!this.shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            this.display.sleep();
          }
        }
	}

    private void centerWindow() {

        Rectangle bds = this.shell.getDisplay().getBounds();

        Point p = this.shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        this.shell.setBounds(nLeft, nTop, p.x, p.y);
    }
    
    private SelectionAdapter setQuitListener(){
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.getDisplay().dispose();
                System.exit(0);
            }
    	};
    }
    
    
    private SelectionAdapter openListListener(){
    	
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Display display = shell.getDisplay();
            	ListAllPaychecksView listAllPaychecksView = new ListAllPaychecksView(display, paycheckController);
            	display.dispose();
            }
    	};
    }
    
    
}
