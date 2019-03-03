package com.main;



//import the packages for using the classes in them into the program

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Vector;

public class PrintingReciept extends JInternalFrame implements Printable {
	/***************************************************************************
	 ***      declaration of the private variables used in the program       ***
	 ***************************************************************************/
	//for creating the text area
	private JTextArea textArea = new JTextArea();
	//for creating the vector to use it in the print
	private Vector lines;
	public static final int TAB_SIZE = 10;

	//constructor of JLibrary
        CustInfo main;
	public PrintingReciept(CustInfo main) {
		super("Printing Members", false, true, false, true);
                DBConnect.connect();
                this.main=main;
		//for getting the graphical user interface components display area
		Container cp = getContentPane();
		//for setting the font
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 9));
		//for adding the textarea to the container
		cp.add(textArea);
		/***************************************************************
		 * for making the connection,creating the statement and update *
		 * the table in the database. After that,closing the statmenet *
		 * and connection. There is catch block SQLException for error *
		 ***************************************************************/
                java.util.Date today= new java.util.Date();
                SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
                String date= ft.format(today);
                
		try{
                    textArea.append("=============== Sales Reciept ===============\n\n");
                    textArea.append("::Customer Information::\n\n");
                    textArea.append("         \tDate: "+date+"\n");
                    textArea.append("\tCustomer Name: "+main.getName()+" \n");
                    textArea.append("   \tCustomer #: "+main.getNumber()+"\n\n");
                    textArea.append("::Transaction Information::\n\n");
                    
                    double total=0;
                    
                    String sql="select * from tempSalesTbl";
                    DBConnect.rs=DBConnect.st.executeQuery(sql);
                    int i=1;
                    textArea.append(
                        "\t"+String.format("%1$-3s","#")+
                        "\t"+String.format("%1$-30s","Product Name") +
                        "\t"+String.format("%1$-8s","Quantity") +
                        "\t"+String.format("%1$-15s","Amount") + "\n\n");
                    while (DBConnect.rs.next()) {
                        textArea.append(
                            "\t"+String.format("%1$-3s"," "+i)+
                            "\t"+String.format("%1$-30s",DBConnect.rs.getString("name")) +
                            "\t"+String.format("%8s",DBConnect.rs.getString("quantity")) +
                            "\t"+String.format("%15s",DBConnect.rs.getString("amount")) + "\n");
                        total+=Double.parseDouble(DBConnect.rs.getString("Amount"));
                        i++;
                    }
                    textArea.append("\n\n\tGrand Total: "+total+"\n");
		}
		catch (SQLException SQLe) {
			System.out.println(SQLe.toString());
		}
		//for setting the visible to true
		setVisible(true);
		//to show the frame
		pack();
	}

	public int print(Graphics pg, PageFormat pageFormat, int pageIndex) throws PrinterException {
		pg.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
		int wPage = (int) pageFormat.getImageableWidth();
		int hPage = (int) pageFormat.getImageableHeight();
		pg.setClip(0, 0, wPage, hPage);

		pg.setColor(textArea.getBackground());
		pg.fillRect(0, 0, wPage, hPage);
		pg.setColor(textArea.getForeground());

		Font font = textArea.getFont();
		pg.setFont(font);
		FontMetrics fm = pg.getFontMetrics();
		int hLine = fm.getHeight();

		if (lines == null)
			lines = getLines(fm, wPage);

		int numLines = lines.size();
		int linesPerPage = Math.max(hPage / hLine, 1);
		int numPages = (int) Math.ceil((double) numLines / (double) linesPerPage);
		if (pageIndex >= numPages) {
			lines = null;
			return NO_SUCH_PAGE;
		}
		int x = 0;
		int y = fm.getAscent();
		int lineIndex = linesPerPage * pageIndex;
		while (lineIndex < lines.size() && y < hPage) {
			String str = (String) lines.get(lineIndex);
			pg.drawString(str, x, y);
			y += hLine;
			lineIndex++;
		}
		return PAGE_EXISTS;
	}

	protected Vector getLines(FontMetrics fm, int wPage) {
		Vector v = new Vector();

		String text = textArea.getText();
		String prevToken = "";
		StringTokenizer st = new StringTokenizer(text, "\n\r", true);
		while (st.hasMoreTokens()) {
			String line = st.nextToken();
			if (line.equals("\r"))
				continue;
			// StringTokenizer will ignore empty lines, so it's a bit tricky to get them...
			if (line.equals("\n") && prevToken.equals("\n"))
				v.add("");
			prevToken = line;
			if (line.equals("\n"))
				continue;

			StringTokenizer st2 = new StringTokenizer(line, " \t", true);
			String line2 = "";
			while (st2.hasMoreTokens()) {
				String token = st2.nextToken();
				if (token.equals("\t")) {
					int numSpaces = TAB_SIZE - line2.length() % TAB_SIZE;
					token = "";
					for (int k = 0; k < numSpaces; k++)
						token += " ";
				}
				int lineLength = fm.stringWidth(line2 + token);
				if (lineLength > wPage && line2.length() > 0) {
					v.add(line2);
					line2 = token.trim();
					continue;
				}
				line2 += token;
			}
			v.add(line2);
		}
		return v;
	}
}