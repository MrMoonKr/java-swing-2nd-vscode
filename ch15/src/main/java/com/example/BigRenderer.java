// BigRenderer.java
// A renderer for numbers that shows an icon in front of big numbers.
//
package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class BigRenderer extends DefaultTableCellRenderer {
    
    private double threshold;
    private Icon bang = IconLoader.loadIcon( "bang.gif" );

    public BigRenderer( double t ) {
        threshold = t;
        setHorizontalAlignment( JLabel.RIGHT );
        setHorizontalTextPosition( SwingConstants.RIGHT );
    }

    public Component getTableCellRendererComponent( JTable table, Object value, 
            boolean isSelected, boolean hasFocus,
            int row, int col ) 
    {
        // be a little paranoid about where the user tries to use this renderer
        if ( value instanceof Number ) {
            if ( ( ( Number )value ).doubleValue() > threshold ) {
                setIcon( bang );
            } 
            else {
                setIcon( null );
            }
        } 
        else {
            setIcon( null );
        }

        return super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, col );
    }
}
