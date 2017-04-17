package nl.ictrek.ananas;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NewGroupActivity extends AppCompatActivity {
    private boolean mEnableEndToEndEncryption = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.create_group_main_menu);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_new_group, menu);

        // https://developer.android.com/training/search/setup.html#create-sc
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search_contacts).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.enable_encryption:
                mEnableEndToEndEncryption = !mEnableEndToEndEncryption;
                if (mEnableEndToEndEncryption) { // Encryption is enabled
                    item.setIcon(R.drawable.ic_lock_outline_black_24dp);
                    item.setTitle(R.string.disable_end_to_end_encryption);
                } else { // Encryption is disabled
                    item.setIcon(R.drawable.ic_lock_open_black_24dp);
                    item.setTitle(R.string.enable_end_to_end_encryption);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
