// PagingTester.java
// A quick application that demonstrates the PagingModel.
//
package com.example;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.table.*;

public class PagingTester extends JFrame {

    public PagingTester() {
        super( "Paged JTable Test" );
        setSize( 300, 200 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        PagingModel pm = new PagingModel();
        JTable jt = new JTable( pm );

        // Use our own custom scrollpane.
        JScrollPane jsp = PagingModel.createPagingScrollPaneForTable( jt );
        getContentPane().add( jsp, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        PagingTester mainFrame = new PagingTester();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
