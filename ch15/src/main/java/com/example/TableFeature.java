// TableFeature.java
// A test of the JTable class using default table models and a convenience 
// constructor.  Resizing and selection defaults are altered.
//
package com.example;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.io.File;

public class TableFeature extends JFrame {

    private String titles[] = new String[] { "Directory?", "File Name", "Read?", "Write?", "Size", "Last Modified" };

    public TableFeature() {
        super( "Simple JTable Test" );

        File pwd = new File( "." );
        Object[][] stats = getFileStats( pwd );

        JTable table = new JTable( stats, titles );
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        table.setColumnSelectionAllowed( true );

        JScrollPane scrollPane = new JScrollPane( table );
        this.getContentPane().add( scrollPane, BorderLayout.CENTER );
    }

    public Object[][] getFileStats( File dir ) {
        String files[] = dir.list();
        Object[][] results = new Object[files.length][titles.length];

        for ( int i = 0; i < files.length; i++ ) {
            File tmp = new File( files[i] );
            results[i][0] = Boolean.valueOf( tmp.isDirectory() );   // Directory?
            results[i][1] = tmp.getName();                          // File Name
            results[i][2] = Boolean.valueOf( tmp.canRead() );       // Read?
            results[i][3] = Boolean.valueOf( tmp.canWrite() );      // Write?
            results[i][4] = Long.valueOf( tmp.length() );           // Size
            results[i][5] = new Date( tmp.lastModified() );         // Last Modified
        }
        return results;
    }

    public static void main( String args[] ) {
        TableFeature mainFrame = new TableFeature();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
