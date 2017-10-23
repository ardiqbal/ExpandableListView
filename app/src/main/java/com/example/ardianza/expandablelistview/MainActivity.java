package com.example.ardianza.expandablelistview;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class MainActivity extends AppCompatActivity {

    ContactCategoryAdapter mAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<ListItem>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();

        mAdapter = new ContactCategoryAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(mAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                ImageView arrow = (ImageView)view.findViewById(R.id.list_arrow);
                if(!expandableListView.isGroupExpanded(i)) {
                    expandableListView.expandGroup(i);
                    arrow.setImageResource(R.drawable.ic_arrow_drop_down);
                    arrow.setColorFilter(ContextCompat.getColor(view.getContext(), R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                    return true;
                }else{
                    arrow.setColorFilter(null);
                    RotateAnimation rotate = new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    arrow.setAnimation(rotate);
                    return false;
                }
            }
        });

        // preparing list data
        prepareListData();
    }

    private void prepareListData() {
        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<ListItem> top250 = new ArrayList<>();
        top250.add(new ListItem("The Shawshank Redemption", ""));
        top250.add(new ListItem("The Godfather", ""));
        top250.add(new ListItem("The Godfather: Part II", ""));
        top250.add(new ListItem("Pulp Fiction", ""));
        top250.add(new ListItem("The Good, the Bad and the Ugly", ""));
        top250.add(new ListItem("The Dark Knight", ""));
        top250.add(new ListItem("12 Angry Men", ""));

        List<ListItem> nowShowing = new ArrayList<>();
        nowShowing.add(new ListItem("The Conjuring", ""));
        nowShowing.add(new ListItem("Despicable Me 2", ""));
        nowShowing.add(new ListItem("Turbo", ""));
        nowShowing.add(new ListItem("Grown Ups 2", ""));
        nowShowing.add(new ListItem("Red 2", ""));
        nowShowing.add(new ListItem("The Wolverine", ""));

        List<ListItem> comingSoon = new ArrayList<>();
        comingSoon.add(new ListItem("2 Guns",""));
        comingSoon.add(new ListItem("The Smurfs 2",""));
        comingSoon.add(new ListItem("The Spectacular Now",""));
        comingSoon.add(new ListItem("The Canyons",""));
        comingSoon.add(new ListItem("Europa Report",""));

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
