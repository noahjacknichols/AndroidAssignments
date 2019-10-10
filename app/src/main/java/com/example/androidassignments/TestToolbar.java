package com.example.androidassignments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class TestToolbar extends AppCompatActivity {
    public String optionText = "You selected item 1.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Look Morty, I'm Button Rick!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu m){
        getMenuInflater().inflate(R.menu.toolbar_menu , m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        switch(mi.getItemId()) {
            case R.id.action_one:
                Log.d("Toolbar", "Option 1 selected");
                Snackbar.make(findViewById(R.id.action_one), optionText, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.action_two:
                Log.d("Toolbar", "Option 2 selected");

                AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);
                builder
                        .setTitle(R.string.testToolbarTitle)
                        .setPositiveButton(R.string.toolbarPositive, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.toolbarNegative, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                break;
            case R.id.action_three:
                Log.d("Toolbar", "Option 3 selected");
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                // Get the layout inflater
                LayoutInflater inflater = this.getLayoutInflater();
                final View dialog_layout = inflater.inflate(R.layout.dialog_signin, null);
                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder2.setView(dialog_layout)
                        // Add action buttons
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                optionText =((EditText)dialog_layout.findViewById(R.id.newMessage)).getText().toString();

                                System.out.println("optionText is" +optionText);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                builder2.create().show();
                break;
            case R.id.About:
                Log.d("Toolbar", "About selected");
                CharSequence text = "Version 1.0, by Noah Nichols";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(getApplicationContext() ,text ,duration);
                toast.show();
                break;

        }

        return true;
    }

}
