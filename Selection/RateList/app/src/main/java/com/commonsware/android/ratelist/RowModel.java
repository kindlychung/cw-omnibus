package com.commonsware.android.ratelist;

class RowModel {
    String label;
    float rating = 2.0f;

    RowModel(String label) {
        this.label = label;
    }

    public String toString() {
        if (rating >= 3.0) {
            return (label.toUpperCase());
        }

        return (label);
    }
}
