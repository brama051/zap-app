package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import controller.PaycheckController;
import model.Paycheck;

public class ListAllPaychecksView {

	private Label label;
	private PaycheckController paycheckController;

    public ListAllPaychecksView(Display display, PaycheckController paycheckController) {
    	this.paycheckController = paycheckController;
        initUI(display);
    }

    private void initUI(Display display) {

        Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
        shell.setLayout(new GridLayout(1, true));

        Table table = new Table(shell, SWT.BORDER);
        table.setHeaderVisible(true);
         table.setLinesVisible(true);

        String[] titles = { "ID", "Ime", "Prezime", "Mjesec", "Sati", "kn/hr", "Total" };

        for (int i = 0; i < titles.length; i++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[i]);
            column.setWidth(130);
        }

        int rowNumber = 0;
        for (Paycheck p : this.paycheckController.paycheckList) {
        	TableItem item = new TableItem(table, SWT.NULL);
            
            item.setText(0, Integer.toString(p.getId()));
            item.setText(1, p.getFirstName());
            item.setText(2, p.getLastName());
            item.setText(3, Integer.toString(p.getMonth()));
            item.setText(4, Float.toString(p.getTotalHours()));
            item.setText(5, Float.toString(p.getPricePerHour()));
            item.setText(6, Float.toString(p.getTotal()));
        	
        	rowNumber ++;
		}
        
        for (Paycheck p : this.paycheckController.paycheckList) {
			System.out.println(p.getLastName());
		}

        label = new Label(shell, SWT.NONE);

        table.addListener(SWT.Selection, event -> onTableItemSelected(table));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 800;
        gd.heightHint = 600;
        table.setLayoutData(gd);

        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        shell.setText("Table widget");
        shell.pack();
        this.centerWindow(shell);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    private void onTableItemSelected(Table table) {
        
        TableItem[] sel = table.getSelection();
        String msg = String.format("%s: %s", sel[0].getText(0), 
                sel[0].getText(1));
        
        label.setText(msg);
    }


    private void centerWindow(Shell shell) {

        Rectangle bds = shell.getDisplay().getBounds();

        Point p = shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
    }
}
