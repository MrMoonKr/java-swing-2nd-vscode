// RowHeaderTable.java
// A simple application that demonstrates the use of the TableColumnModel
// class to build a row header column that scrolls with the regular data
// rows.
//
package com.example;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class RowHeaderTable extends JFrame {

    public RowHeaderTable() {
        super( "Row Header Test" );
        //setSize( 300, 200 );
        //setDefaultCloseOperation( EXIT_ON_CLOSE );

        TableModel tm = new AbstractTableModel() {
            
            String data[] = { "", "a", "b", "c", "d", "e" };
            String headers[] = { "Row #", "Column 1", "Column 2", "Column 3", "Column 4", "Column 5" };

            public int getColumnCount() {
                return data.length;
            }

            public int getRowCount() {
                return 1000;
            }

            public String getColumnName( int col ) {
                return headers[col];
            }

            // Synthesize some entries using the data values & the row #
            public Object getValueAt( int row, int col ) {
                return data[col] + row;
            }
        };

        // Create a column model for the main table. This model ignores the first
        // column added, and sets a minimum width of 150 pixels for all others.
        TableColumnModel cm = new DefaultTableColumnModel() {
            boolean first = true;

            public void addColumn( TableColumn tc ) {
                // Drop the first column . . . that’ll be the row header
                if ( first ) {
                    first = false;
                    return;
                }
                tc.setMinWidth( 150 ); // just for looks, really...
                super.addColumn( tc );
            }
        };

        // Create a column model that will serve as our row header table. This
        // model picks a maximum width and only stores the first column.
        TableColumnModel rowHeaderModel = new DefaultTableColumnModel() {
            boolean first = true;

            public void addColumn( TableColumn tc ) {
                if ( first ) {
                    tc.setMaxWidth( tc.getPreferredWidth() );
                    super.addColumn( tc );
                    first = false;
                }
                // Drop the rest of the columns . . . this is the header column only
            }
        };

        JTable table = new JTable( tm, cm );

        // Set up the header column and get it hooked up to everything
        JTable headerColumn = new JTable( tm, rowHeaderModel );
        table.createDefaultColumnsFromModel();
        headerColumn.createDefaultColumnsFromModel();

        // Make sure that selections between the main table and the header stay
        // in sync (by sharing the same model)
        table.setSelectionModel( headerColumn.getSelectionModel() );

        // Make the header column look pretty
        // headerColumn.setBorder(BorderFactory.createEtchedBorder());
        headerColumn.setBackground( Color.lightGray );
        headerColumn.setColumnSelectionAllowed( false );
        headerColumn.setCellSelectionEnabled( false );

        // Put it in a viewport that we can control a bit
        JViewport viewPort = new JViewport();
        viewPort.setView( headerColumn );
        viewPort.setPreferredSize( headerColumn.getMaximumSize() );

        // With out shutting off autoResizeMode, our tables won’t scroll
        // correctly (horizontally, anyway)
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

        // We have to manually attach the row headers, but after that, the scroll
        // pane keeps them in sync
        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setRowHeader( viewPort );
        scrollPane.setCorner( ScrollPaneConstants.UPPER_LEFT_CORNER, headerColumn.getTableHeader() );

        this.getContentPane().add( scrollPane, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        RowHeaderTable mainFrame = new RowHeaderTable();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }
}
