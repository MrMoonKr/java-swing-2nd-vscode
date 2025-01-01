// SimpleFrame.java
// A simple example of the JFrame class.
//
package com.example;

import javax.swing.*;

public class SimpleFrame {
    public static void main( String args[] ) {
        JFrame f = new JFrame( "Simple Frame" );
        f.setSize( 200, 100 );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setVisible( true );
    }
}
