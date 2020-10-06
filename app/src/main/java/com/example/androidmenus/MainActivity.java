package com.example.androidmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ActionMode mActionMode;

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.action_mode_context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.amenuItem1:
                    Toast.makeText(MainActivity.this, "Action mode Menu item 1 Clicked", Toast.LENGTH_SHORT).show();
                    //mode needs to be ended before it can be started again
                    mode.finish();
                    return true;
                case R.id.amenuItem2:
                    Toast.makeText(MainActivity.this, "Action mode  Menu item 2 Clicked", Toast.LENGTH_SHORT).show();
                    //mode needs to be ended before it can be started again
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)findViewById(R.id.helloText);
        //register textView for the context menu so that when long pressed the context menu shows up
        this.registerForContextMenu(tv);

        //Bind item to view
        Button button = (Button) findViewById(R.id.button);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Instantiate action mode object so that its set before it builds onto the activity
                if(mActionMode != null){
                    return false;
                }
                else
                    mActionMode = startActionMode(mActionModeCallback);
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mu4enuItem1:
                Toast.makeText(this, "Menu item 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mu4enuItem2:
                Toast.makeText(this, "Menu item 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mu4enuItem3:
                Toast.makeText(this, "Menu item 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fmu4enuItem1:
                Toast.makeText(this, "Context Menu item 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fmu4enuItem2:
                Toast.makeText(this, "Context Menu item 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fmu4enuItem3:
                Toast.makeText(this, "Context Menu item 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
            return super.onContextItemSelected(item);
        }
    }

    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popupMenuItem1:
                Toast.makeText(this, "Popup Menu item 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popupMenuItem2:
                Toast.makeText(this, "Popup Menu item 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popupMenuItem3:
                Toast.makeText(this, "Popup Menu item 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}