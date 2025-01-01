// SimpleLayers.java
// A demonstration of the JLayeredPane class.
//
package com.example;

import javax.swing.*;
import java.awt.Color;

public class SimpleLayers extends JFrame {
    public SimpleLayers() {
        super( "LayeredPane Demonstration" );
        setSize( 200, 150 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        JLayeredPane lp = getLayeredPane();

        // Create 3 buttons
        JButton top = new JButton();
        top.setBackground( Color.white );
        top.setBounds( 20, 20, 50, 50 );
        JButton middle = new JButton();
        middle.setBackground( Color.gray );
        middle.setBounds( 40, 40, 50, 50 );
        JButton bottom = new JButton();
        bottom.setBackground( Color.black );
        bottom.setBounds( 60, 60, 50, 50 );

        // Place the buttons in different layers
        lp.add( middle, Integer.valueOf( 2 ) );
        lp.add( top, Integer.valueOf( 3 ) );
        lp.add( bottom, Integer.valueOf( 1 ) );
    }

    public static void main( String[] args ) {
        SimpleLayers sl = new SimpleLayers();
        sl.setVisible( true );
    }
}
