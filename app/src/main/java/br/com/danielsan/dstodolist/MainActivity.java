package br.com.danielsan.dstodolist;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import br.com.danielsan.dstodolist.databinding.ActivityMainBinding;
import br.com.danielsan.dstodolist.lists.ListsFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean isPortrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        isPortrait = binding.famAdd.getVisibility() == View.VISIBLE;

        this.setSupportActionBar(binding.toolbar);

        if (savedInstanceState == null) {
            this.getSupportFragmentManager().beginTransaction().add(R.id.container, ListsFragment.newInstance()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.mn_search).setIcon(new IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_search).colorRes(R.color.white).sizeDp(24));

        menu.findItem(R.id.mn_send).setVisible(!isPortrait);
        menu.findItem(R.id.mn_print).setVisible(!isPortrait);
        menu.findItem(R.id.mn_edit_list).setVisible(!isPortrait);
        menu.findItem(R.id.mn_duplicate_list).setVisible(!isPortrait);

        MenuItem sort = menu.findItem(R.id.mn_sort);
        sort.setVisible(!isPortrait);
        sort.setIcon(new IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_sort).colorRes(R.color.white).sizeDp(24));

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.container.removeView(binding.famAdd);
        if (isPortrait) {
            binding.container.addView(binding.famAdd);

            binding.fabAddTask.setImageDrawable(new IconicsDrawable(this)
                    .icon(GoogleMaterial.Icon.gmd_assignment_turned_in).color(Color.WHITE).sizeDp(18));
            binding.fabAddList.setImageDrawable(new IconicsDrawable(this)
                    .icon(GoogleMaterial.Icon.gmd_playlist_add).color(Color.WHITE).sizeDp(18));

            binding.fabAddTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.famAdd.collapse();
                }
            });
            binding.fabAddList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.famAdd.collapse();
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_search:
                return true;
            case R.id.mn_sort:
                return true;
            case R.id.mn_send:
                return true;
            case R.id.mn_print:
                return true;
            case R.id.mn_edit_list:
                return true;
            case R.id.mn_duplicate_list:
                return true;
            case R.id.mn_about:
                return true;
            case R.id.mn_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
