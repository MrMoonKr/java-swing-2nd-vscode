// SortingColumnModel.java
// A simple extension of the DefaultTableColumnModel class that sorts
// incoming columns alphabetically.  This version is case sensitive.
//
package com.example;

import javax.swing.table.*;

/**
 * DefaultTableColumnModel 클래스를 확장한 간단한 클래스로, 
 * 들어오는 열(Column)을 알파벳 순으로 정렬합니다.
 * 이 버전은 대소문자를 구분합니다.
 */
public class SortingColumnModel extends DefaultTableColumnModel {

    public void addColumn( TableColumn tc ) {
        super.addColumn( tc );

        int newIndex = sortedIndexOf( tc );
        if ( newIndex != tc.getModelIndex() ) {
            moveColumn( tc.getModelIndex(), newIndex );
        }
    }

    protected int sortedIndexOf( TableColumn tc ) {
        // just do a linear search for now
        int stop = getColumnCount();
        String name = tc.getHeaderValue().toString();

        for ( int i = 0; i < stop; i++ ) {
            if ( name.compareTo( getColumn( i ).getHeaderValue().toString() ) <= 0 ) {
                return i;
            }
        }
        return stop;
    }
}
