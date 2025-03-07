//  ProgressBarExample.java
// A demonstration of the JProgressBar component.  The component tracks the
// progress of a for loop.
//
package com.example;

//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class ProgressBarExample extends JPanel {

    JProgressBar pbar;
    static final int MY_MINIMUM = 0;
    static final int MY_MAXIMUM = 100;

    public ProgressBarExample() {
        pbar = new JProgressBar();
        pbar.setMinimum( MY_MINIMUM );
        pbar.setMaximum( MY_MAXIMUM );
        add( pbar );
    }

    public void updateBar( int newValue ) {
        pbar.setValue( newValue );
    }

    public static void main( String args[] ) {

        final ProgressBarExample it = new ProgressBarExample();

        JFrame frame = new JFrame( "Progress Bar Example" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setContentPane( it );
        frame.pack();
        frame.setVisible( true );

        for ( int i = MY_MINIMUM; i <= MY_MAXIMUM; i++ ) {
            final int percent = i;
            try {
                SwingUtilities.invokeLater( new Runnable() {
                    public void run() {
                        it.updateBar( percent );
                    }
                } );
                java.lang.Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                ;
            }
        }
    }
}
