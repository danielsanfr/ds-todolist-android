package br.com.danielsan.dstodolist.tasks;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;

import br.com.danielsan.dstodolist.R;

/**
 * Created by daniel on 26/03/16.
 */
public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Slidr.attach(this);

        //noinspection ConstantConditions
        this.findViewById(android.R.id.content).setBackgroundColor(ContextCompat.getColor(this, R.color.drawer_background));
        if (savedInstanceState == null) {
            this.getSupportFragmentManager().beginTransaction().add(android.R.id.content, TasksFragment.newInstance()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        boolean shouldOverride = !this.getSupportFragmentManager().popBackStackImmediate();
        super.onBackPressed();
        if (shouldOverride) {
            overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out);
        }
    }
}
