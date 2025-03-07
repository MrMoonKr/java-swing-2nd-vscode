// MarketDataModel.java
// A custom table model for use with the MYOSM enviornment.
//
package com.example;

import javax.swing.table.*;


public class MarketDataModel extends AbstractTableModel implements Runnable {

    private Thread runner;
    private MYOSM market;
    private int delay;

    public MarketDataModel( int initialDelay ) {
        market = new MYOSM();
        delay = initialDelay * 1000;
        runner = new Thread( this );
        runner.start();
    }

    private Stock[] stocks = new Stock[0];
    private int[] stockIndices = new int[0];
    private String[] headers = { "Symbol", "Price", "Change", "Last updated" };

    public int getRowCount() {
        return stocks.length;
    }

    public int getColumnCount() {
        return headers.length;
    }

    public String getColumnName( int c ) {
        return headers[c];
    }

    public Object getValueAt( int r, int c ) {
        switch ( c ) {
        case 0:
            return stocks[r].symbol;
        case 1:
            return Double.valueOf( stocks[r].price );
        case 2:
            return Double.valueOf( stocks[r].delta );
        case 3:
            return stocks[r].lastUpdate;
        }
        throw new IllegalArgumentException( "Bad cell (" + r + ", " + c + ")" );
    }

    public void setDelay( int seconds ) {
        delay = seconds * 1000;
    }

    public void setStocks( int[] indices ) {
        stockIndices = indices;
        updateStocks();
        fireTableDataChanged();
    }

    public void updateStocks() {
        stocks = new Stock[stockIndices.length];
        for ( int i = 0; i < stocks.length; i++ ) {
            stocks[i] = market.getQuote( stockIndices[i] );
        }
    }

    public void run() {
        while ( true ) {
            // Blind update . . . we could check for real deltas if necessary
            updateStocks();

            // We know there are no new columns, so don't fire a data change, only
            // fire a row update . . . this keeps the table from flashing
            fireTableRowsUpdated( 0, stocks.length - 1 );
            try {
                Thread.sleep( delay );
            } 
            catch ( InterruptedException ie ) {
            }
        }
    }
}
