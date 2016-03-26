package br.com.danielsan.dstodolist;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import br.com.danielsan.dstodolist.databinding.ActivityMainBinding;
import br.com.danielsan.dstodolist.lists.ListsFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (savedInstanceState == null) {
            this.getSupportFragmentManager().beginTransaction().add(R.id.container, ListsFragment.newInstance()).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.container.removeView(binding.fabAddTask);
        if (binding.fabAddTask.getVisibility() == View.VISIBLE) {
            binding.container.addView(binding.fabAddTask);
            binding.fabAddTask.setImageDrawable(new IconicsDrawable(this)
                    .icon(GoogleMaterial.Icon.gmd_add).color(Color.WHITE).sizeDp(48));
        }
    }
}
