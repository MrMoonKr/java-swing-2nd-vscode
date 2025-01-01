// ColorTable.java
// A table that allows the user to pick a color from a pulldown list.  This
// is accomplished by using the DefaultCellRenderer and DefaultCellEditor
// classes.
// 
package com.example;

import javax.swing.*;
import javax.swing.table.*;


/**
 * 테이블(JTable)내 셀의 색상 선택을 위한 커스텀 셀에디터를 사용하는 테이블
 */
public class ColorTable extends JFrame {

    ColorName colors[] = { 
        new ColorName( "Red" ), 
        new ColorName( "Green" ), 
        new ColorName( "Blue" ),
        new ColorName( "Black" ), 
        new ColorName( "White" ) 
    };

    public ColorTable() {
        super( "Table With DefaultCellEditor Example" );

        JTable table = new JTable( new AbstractTableModel() {

            ColorName data[] = { 
                colors[0], colors[1], colors[2], colors[3], colors[4], 
                colors[0], colors[1], colors[2], colors[3], colors[4] 
            };

            public int getColumnCount() {
                return 3;
            }

            public int getRowCount() {
                return 10;
            }

            public Object getValueAt( int rowIndex, int columnIndex ) {
                switch ( columnIndex ) {
                case 0:
                    return ( rowIndex + 1 ) + ".";
                case 1:
                    return "Some pithy quote #" + rowIndex;
                case 2:
                    return data[rowIndex];
                }
                return "Bad Column";
            }

            public Class<?> getColumnClass( int columnIndex ) {
                if ( columnIndex == 2 )
                    return ColorName.class;
                return String.class;
            }

            // Make Column 2 editable...
            public boolean isCellEditable( int rowIndex, int columnIndex ) {
                return columnIndex == 2;
            }

            public void setValueAt( Object value, int rowIndex, int columnIndex ) {
                data[rowIndex] = ( ColorName )value;
            }
        } );

        table.setDefaultEditor( ColorName.class, new DefaultCellEditor( new JComboBox<ColorName>( colors ) ) );
        table.setDefaultRenderer( ColorName.class, new DefaultTableCellRenderer() );
        table.setRowHeight( 24 );

        this.getContentPane().add( new JScrollPane( table ) );
    }

    /**
     * 메인 진입점 메소드
     * @param args
     */
    public static void main( String args[] ) {
        ColorTable mainFrame = new ColorTable();
        mainFrame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setVisible( true );
    }

    /**
     * 색상 이름
     */
    public class ColorName {

        String cname;

        public ColorName( String name ) {
            cname = name;
        }

        public String toString() {
            return cname;
        }
    }
}
