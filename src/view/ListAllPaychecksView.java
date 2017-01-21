package view;

import org.eclipse.swt.SWT;
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

public class ListAllPaychecksView {

	private Label label;
    private final String data[][] = { { "Ferarri", "33333" },
            { "Skoda", "22000" }, { "Volvo", "18000" }, { "Mazda", "15000" },
            { "Mercedes", "38000" } };

    public ListAllPaychecksView(Display display, PaycheckController paycheckController) {

        initUI(display);
    }

    private void initUI(Display display) {

        Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
        shell.setLayout(new GridLayout(1, true));

        Table table = new Table(shell, SWT.BORDER);
        table.setHeaderVisible(true);
         table.setLinesVisible(true);

        String[] titles = { "Car", "Price" };

        for (int i = 0; i < titles.length; i++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[i]);
            column.setWidth(130);
        }

        for (int i = 0; i < data.length; i++) {

            TableItem item = new TableItem(table, SWT.NULL);
            item.setText(0, data[i][0]);
            item.setText(1, data[i][1]);
        }

        label = new Label(shell, SWT.NONE);

        table.addListener(SWT.Selection, event -> onTableItemSelected(table));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 360;
        gd.heightHint = 300;
        table.setLayoutData(gd);

        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        shell.setText("Table widget");
        shell.pack();
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


    /*@SuppressWarnings("unused")
    public static void main(String[] args) {
        
        Display display = new Display();
        GridLayoutEx ex = new GridLayoutEx(display);
        display.dispose();
    }*/
}
