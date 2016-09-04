package br.com.danielsan.dstodolist

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.iconics.IconicsDrawable

import br.com.danielsan.dstodolist.databinding.ActivityMainBinding
import br.com.danielsan.dstodolist.lists.ListsFragment

class MainActivity : AppCompatActivity() {

    private var isPortrait: Boolean = false
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isPortrait = binding.famAdd.visibility == View.VISIBLE
        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, ListsFragment.newInstance())
                    .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        menu.findItem(R.id.mn_search).icon = IconicsDrawable(this)
                .icon(GoogleMaterial.Icon.gmd_search)
                .colorRes(R.color.white)
                .sizeDp(24)

        menu.findItem(R.id.mn_send).isVisible = !isPortrait
        menu.findItem(R.id.mn_print).isVisible = !isPortrait
        menu.findItem(R.id.mn_edit_list).isVisible = !isPortrait
        menu.findItem(R.id.mn_duplicate_list).isVisible = !isPortrait

        val sort = menu.findItem(R.id.mn_sort)
        sort.isVisible = !isPortrait
        sort.icon = IconicsDrawable(this)
                .icon(GoogleMaterial.Icon.gmd_sort)
                .colorRes(R.color.white)
                .sizeDp(24)

        return true
    }

    override fun onStart() {
        super.onStart()

        binding.container.removeView(binding.famAdd)
        if (isPortrait) {
            binding.container.addView(binding.famAdd)

            binding.fabAddTask.setImageDrawable(IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_assignment_turned_in).color(Color.WHITE).sizeDp(18))
            binding.fabAddList.setImageDrawable(IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_playlist_add).color(Color.WHITE).sizeDp(18))

            binding.fabAddTask.setOnClickListener { binding.famAdd.collapse() }
            binding.fabAddList.setOnClickListener { binding.famAdd.collapse() }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mn_search -> return true
            R.id.mn_sort -> return true
            R.id.mn_send -> return true
            R.id.mn_print -> return true
            R.id.mn_edit_list -> return true
            R.id.mn_duplicate_list -> return true
            R.id.mn_about -> return true
            R.id.mn_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
