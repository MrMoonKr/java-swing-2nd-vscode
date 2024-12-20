// BookCellRenderer.java
// A custom cell renderer for BookEntry objects.
//
package com.example;

import javax.swing.*;
import java.awt.*;

public class BookCellRenderer extends JLabel implements ListCellRenderer<Object> {
    private static final Color HIGHLIGHT_COLOR = new Color( 0, 0, 128 );

    public BookCellRenderer() {
        setOpaque( true );
        setIconTextGap( 12 );
    }

    @Override
    public Component getListCellRendererComponent( JList<? extends Object> list, 
            Object value, int index, boolean isSelected, boolean cellHasFocus ) 
    {
        BookEntry entry = ( BookEntry )value;
        setText( entry.getTitle() );
        setIcon( entry.getImage() );
        if ( isSelected ) {
            setBackground( HIGHLIGHT_COLOR );
            setForeground( Color.white );
        } else {
            setBackground( Color.white );
            setForeground( Color.black );
        }
        return this;
    }

}
