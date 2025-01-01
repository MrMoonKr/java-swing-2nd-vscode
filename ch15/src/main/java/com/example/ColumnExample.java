// ColumnExample.java
// A test of JTable with a custom column model.  The model used is a sorting
// model that keeps columns in alphabetical order.
// (see SortingColumnModel.java)
//
package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColumnExample extends JFrame {

    public ColumnExample() {
        super( "Abstract Model JTable Test" );

        DefaultTableModel dtm = new DefaultTableModel( new String[][] { 
            { "1", "2", "3" }, 
            { "4", "5", "6" } 
        }, new String[] { "Names", "In", "Order" } );

        SortingColumnModel scm = new SortingColumnModel();

        JTable table = new JTable( dtm, scm );
        table.createDefaultColumnsFromModel();

        JScrollPane scrollPane = new JScrollPane( table );
        
        this.getContentPane().add( scrollPane, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        ColumnExample mainFrame = new ColumnExample();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
