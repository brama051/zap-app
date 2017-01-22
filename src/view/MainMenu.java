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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;


public class MainMenu {
	public Shell shell; //window
	public PaycheckController paycheckController;
	//build interface
	public MainMenu(Display display, PaycheckController paycheckController) {
	     
	    this.paycheckController = paycheckController;
	    
	    this.initUI(display);
        
    }
	
	private void initUI(Display display){
		this.shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
        this.shell.setText("Glavni izbornik");
        this.shell.setSize(800, 600);
         

        //set layout
        GridLayout layout = new GridLayout(1, true);
        layout.marginTop = 50;
        layout.marginBottom = 50;
        layout.marginLeft = 100;
        layout.marginRight = 100;
        layout.verticalSpacing = 10;
        
        shell.setLayout(layout);
        
        
        //add buttons
        Button btnListPaychecks = new Button(this.shell, SWT.PUSH);
        btnListPaychecks.setText("Ispis");
        btnListPaychecks.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        btnListPaychecks.addSelectionListener(this.openListListener());
        
        Button btnCreatePaycheck = new Button(this.shell, SWT.PUSH);
        btnCreatePaycheck.setText("Unos");
        btnCreatePaycheck.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        btnCreatePaycheck.addSelectionListener(this.createNewListener());
        
        Button btnEditPaycheck = new Button(this.shell, SWT.PUSH);
        btnEditPaycheck.setText("Uređivanje");
        btnEditPaycheck.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        btnEditPaycheck.addSelectionListener(this.editListener());
        
        Button btnDeletePaycheck = new Button(this.shell, SWT.PUSH);
        btnDeletePaycheck.setText("Brisanje");
        btnDeletePaycheck.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        btnDeletePaycheck.addSelectionListener(this.deleteListener());
        
        //quit button
        Button quitBtn = new Button(shell, SWT.PUSH);
        quitBtn.setText("Izlaz");
        quitBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        quitBtn.addSelectionListener(this.setQuitListener());

        this.centerWindow(shell);
        this.shell.open();
        

        while (!this.shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
	}

    private void centerWindow(Shell shell) {

        Rectangle bds = shell.getDisplay().getBounds();

        Point p = shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
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
            }
    	};
    }
    
    private SelectionAdapter createNewListener(){
    	
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Display display = shell.getDisplay();
            	CreateNewView createNewView = new CreateNewView(display, paycheckController);
            }
    	};
    }
    
    private SelectionAdapter editListener(){
    	
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Display display = shell.getDisplay();
            	ModifyView modifyView = new ModifyView(display, paycheckController);
            }
    	};
    }
    
    private SelectionAdapter deleteListener(){
    	
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Display display = shell.getDisplay();
            	DeleteView deleteView = new DeleteView(display, paycheckController);
            }
    	};
    }
    
}
