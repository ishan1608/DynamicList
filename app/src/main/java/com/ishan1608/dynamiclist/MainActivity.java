package com.ishan1608.dynamiclist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout sampleList;
    private ImageButton removeItemImageButton;
    private ImageButton addItemButton;
    private int itemCount = 0;
    private int maxCount = 6;
    private int minCount = 1;

    private LinearLayout[] listItems = new LinearLayout[maxCount];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Handles
        sampleList = (LinearLayout) findViewById(R.id.sample_list);
        addItemButton = (ImageButton) findViewById(R.id.add_item_image_button);
        removeItemImageButton = (ImageButton) findViewById(R.id.remove_item_image_button);
        // Adding first item
        listItems[0] = (LinearLayout) getLayoutInflater().inflate(R.layout.sample_list_item, null);
        ((TextView)listItems[0].findViewById(R.id.item_number)).setText("Item : " + (itemCount + 1));
        sampleList.addView(listItems[0]);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemCount < maxCount - 1) {
                    itemCount += 1;
                    listItems[itemCount] = (LinearLayout) getLayoutInflater().inflate(R.layout.sample_list_item, null);
                    ((TextView) listItems[itemCount].findViewById(R.id.item_number)).setText("Item : " + (itemCount + 1));
                    sampleList.addView(listItems[itemCount]);
                } else {
                    Toast.makeText(getApplicationContext(), "Can't add more than " + maxCount, Toast.LENGTH_SHORT).show();
                }
            }
        });
        removeItemImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemCount < minCount ) {
                    Toast.makeText(getApplicationContext(), "Must have at least " + minCount + " item", Toast.LENGTH_SHORT).show();
                } else {
                    sampleList.removeViewAt(itemCount);
                    itemCount -= 1;
                }
            }
        });
    }
}
