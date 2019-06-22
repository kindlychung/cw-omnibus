package com.commonsware.android.ratelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

class RatingAdapter extends ArrayAdapter<RowModel> {
    private RateListDemo rateListDemo;

    RatingAdapter(RateListDemo rateListDemo, ArrayList<RowModel> list) {
        super(rateListDemo, R.layout.row, R.id.label, list);
        this.rateListDemo = rateListDemo;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View row = super.getView(position, convertView, parent);
        RatingBar bar = (RatingBar) row.getTag();

        if (bar == null) {
            bar = row.findViewById(R.id.rate);
            row.setTag(bar);
            bar.setOnRatingBarChangeListener((ratingBar, v, b) -> {
                Integer myPosition = (Integer) ratingBar.getTag();
                RowModel model = rateListDemo.getModel(myPosition);
                model.rating = v;
                LinearLayout ratingBarParent = (LinearLayout) ratingBar.getParent();
                TextView label = ratingBarParent.findViewById(R.id.label);
                label.setText(model.toString());
            });
        }

        RowModel model = rateListDemo.getModel(position);

        bar.setTag(position);
        bar.setRating(model.rating);

        return (row);
    }
}
