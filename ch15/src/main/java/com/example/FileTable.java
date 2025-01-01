// FileTable.java
// A test frame for the custom table model, FileModel.
//
package com.example;

import java.awt.*;
import javax.swing.*;


public class FileTable extends JFrame {

    public FileTable() {
        super( "Custom TableModel Test" );

        FileModel tableModel = new FileModel();
        JTable table = new JTable( tableModel );
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        table.setColumnSelectionAllowed( true );

        JScrollPane scrollPane = new JScrollPane( table );
        
        this.getContentPane().add( scrollPane, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        FileTable mainFrame = new FileTable();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
