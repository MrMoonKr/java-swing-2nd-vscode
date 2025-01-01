// SimpleTable.java
// A test of the JTable class using default table models and a convenience 
// constructor.
//
package com.example;

import java.awt.*;
import javax.swing.*;

public class SimpleTable extends JFrame {

    public SimpleTable() {
        super( "Simple JTable Test" );
        setSize( 640, 480 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        String[] columnNames = { "Column", "Header" };
        String[][] rowData = { 
            { "This", "is" }, 
            { "a", "Test" } ,
            { "of", "JTable" }
        };

        // JTable table = new JTable( new String[][] { { "This", "is" }, { "a", "Test" } },
        //         new String[] { "Column", "Header" } );

        JTable table = new JTable( rowData, columnNames );
        JScrollPane scrollPane = new JScrollPane( table );
        this.getContentPane().add( scrollPane, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        SimpleTable mainFrame = new SimpleTable();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
