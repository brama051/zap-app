package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.PaycheckController;
import model.Paycheck;


public class CreateNewView {
	
	private  PaycheckController paycheckController;
	private Text firstName;
	private Text lastName;
	private Text month;
	private Text totalHours;
	private Text pricePerHour;
	private Shell shell;
	
    public CreateNewView(Display display, PaycheckController paycheckController) {
        this.paycheckController = paycheckController;
    	initUI(display);
    }
    
    private void initUI(Display display) {
        
    	shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    	shell.setText("Novi unos");
        shell.setSize(800, 600);

        
        GridLayout layout = new GridLayout(2, true);
        layout.marginTop = 50;
        layout.marginBottom = 50;
        layout.marginLeft = 100;
        layout.marginRight = 100;
        layout.verticalSpacing = 10;
        shell.setLayout(layout);
        
        
        //first row
        Label lbl1 = new Label(shell, SWT.NONE);
        lbl1.setText("Ime");
        this.firstName = new Text(shell, SWT.FILL);
        this.firstName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        //second row
        Label lbl2 = new Label(shell, SWT.NONE);
        lbl2.setText("Prezime");
        this.lastName = new Text(shell, SWT.FILL);
        this.lastName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        
        //third row
        Label lbl3 = new Label(shell, SWT.NONE);
        lbl3.setText("Mjesec");
        this.month = new Text(shell, SWT.FILL);
        this.month.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        //fourth row
        Label lbl4 = new Label(shell, SWT.NONE);
        lbl4.setText("Sati");
        this.totalHours = new Text(shell, SWT.FILL);
        this.totalHours.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        //fifth row
        Label lbl5 = new Label(shell, SWT.NONE);
        lbl5.setText("Cijena sata");
        this.pricePerHour = new Text(shell, SWT.FILL);
        this.pricePerHour.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        
        //fifth row
        Button btnCancel = new Button(shell, SWT.PUSH);
        btnCancel.setText("Odustani");
        btnCancel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        btnCancel.addSelectionListener(this.setCancelListener());
        Button btnSave = new Button(shell, SWT.PUSH);
        btnSave.setText("Spremi");
        btnSave.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        btnSave.addSelectionListener(this.setSaveListener());

        
        //shell.pack();
        shell.open();
        
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
    
    private SelectionAdapter setCancelListener(){
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.close();
            }
    	};
    }
    
    private SelectionAdapter setSaveListener(){
    	return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	int id = paycheckController.getNextID();
                paycheckController.createPaycheck(
                		new Paycheck(
                				id, 
                				firstName.getText(),
                				lastName.getText(),
                				Integer.parseInt(month.getText()),
                				Float.parseFloat(totalHours.getText()),
                				Float.parseFloat(pricePerHour.getText())
                		)
                );
            	shell.close();
            }
    	};
    }
    
}