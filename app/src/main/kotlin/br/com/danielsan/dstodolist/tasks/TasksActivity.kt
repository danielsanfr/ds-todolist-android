package br.com.danielsan.dstodolist.tasks

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity

import com.r0adkll.slidr.Slidr

import br.com.danielsan.dstodolist.R

/**
 * Created by daniel on 26/03/16.
 */
class TasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Slidr.attach(this)

        findViewById(android.R.id.content).setBackgroundColor(ContextCompat.getColor(this, R.color.drawer_background))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, TasksFragment.newInstance())
                    .commit()
        }
    }

    override fun onBackPressed() {
        val shouldOverride = !supportFragmentManager.popBackStackImmediate()
        super.onBackPressed()
        if (shouldOverride) overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out)
    }

}
