package com.example.box.postpcex2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> messagesArrayList;
    private TodoItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        String[] messages = new String[]{"aaa","bbb","ccc","ddd"};

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(layoutManager);
        list.setItemAnimator(new DefaultItemAnimator());
        messagesArrayList = new ArrayList<String>(0);
        for (int i = 0; i < messages.length; ++i) {
            messagesArrayList.add(messages[i]);
        }

        adapter = new TodoItemAdapter(messagesArrayList);
//        list.setAdapter(adapter);
        list.setAdapter(adapter);
    }

    public void addTask(View view){
        EditText editText = (EditText)findViewById(R.id.edit);
        String task = editText.getText().toString();
        editText.setText("");
        messagesArrayList.add(task);
        adapter.notifyDataSetChanged();

        InputMethodManager manager = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.delete:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
