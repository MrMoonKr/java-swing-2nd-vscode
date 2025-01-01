// DatabaseTest.java
// Let's try to make one of these databases work with a JTable for ouptut.
//
package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DatabaseTest extends JFrame {

    private JTextField hostField;
    private JTextField queryField;
    private QueryTableModel qtm;

    public DatabaseTest() {
        super( "Database Test Frame" );

        qtm = new QueryTableModel();
        JTable table = new JTable( qtm );
        JScrollPane scrollpane = new JScrollPane( table );
        JPanel p1 = new JPanel();
        p1.setLayout( new GridLayout( 3, 2 ) );
        p1.add( new JLabel( "Enter the Host URL: " ) );
        p1.add( hostField = new JTextField() );
        p1.add( new JLabel( "Enter your query: " ) );
        p1.add( queryField = new JTextField() );
        p1.add( new JLabel( "Click here to send: " ) );

        JButton jb = new JButton( "Search" );
        jb.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                qtm.setHostURL( hostField.getText().trim() );
                qtm.setQuery( queryField.getText().trim() );
            }
        } );
        p1.add( jb );
        getContentPane().add( p1, BorderLayout.NORTH );
        getContentPane().add( scrollpane, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        DatabaseTest mainFrame = new DatabaseTest();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
