/***
 Copyright (c) 2008-2012 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain	a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 Covered in detail in the book _The Busy Coder's Guide to Android Development_
 https://commonsware.com/Android
 */

package com.commonsware.android.ratelist;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class RateListDemo extends ListActivity {
    private static final String[] items = {"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        ArrayList<RowModel> list = new ArrayList<>();
        for (String s : items) {
            list.add(new RowModel(s));
        }
        setListAdapter(new RatingAdapter(this, list));
    }

    public RowModel getModel(int position) {
        return (
                (RatingAdapter) getListAdapter()
        ).getItem(position);
    }

}
