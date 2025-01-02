// FileTable2.java
// A test frame for the custom table model, FileModel.  This version uses a
// custom renderer (BigRenderer.java) to flag large files with an exclamation
// point icon.
package com.example;

import java.awt.*;
import javax.swing.*;


public class FileTable2 extends JFrame {

    public FileTable2() {
        super( "Custom TableModel Test" );

        FileModel fm = new FileModel();
        JTable jt = new JTable( fm );
        jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        jt.setColumnSelectionAllowed( true );
        jt.setDefaultRenderer( Number.class, new BigRenderer( 1000 ) );

        JScrollPane jsp = new JScrollPane( jt );
        getContentPane().add( jsp, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        FileTable2 mainFrame = new FileTable2();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
