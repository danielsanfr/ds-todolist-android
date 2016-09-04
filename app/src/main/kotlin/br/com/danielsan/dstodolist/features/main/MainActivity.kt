package br.com.danielsan.dstodolist.features.main

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

import br.com.danielsan.dstodolist.R
import br.com.danielsan.dstodolist.daoSession
import br.com.danielsan.dstodolist.databinding.ActivityMainBinding
import br.com.danielsan.dstodolist.models.TaskList

/**
 * Created by daniel on 04/09/16.
 */

class MainActivity : AppCompatActivity(), MainView {

    private var drawer: Drawer? = null
    private val presenter: MainPresenter by lazy { MainPresenter(application.daoSession().taskListDao) }
    private val progress: ProgressDialog by lazy {
        val progressDialog = ProgressDialog(this)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setMessage(getText(R.string.message_wait_a_moment))
        progressDialog
    }
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)

        drawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(binding.toolbar)
                .withOnDrawerItemClickListener { view, position, drawerItem -> false }
                .build()

        presenter.attachView(this)
    }

    override fun showLists(lists: List<TaskList>) {
        for (taskList in lists) {
            drawer?.addItem(PrimaryDrawerItem().withName(taskList.title).withIcon(GoogleMaterial.Icon.gmd_list))
        }
    }

    override fun showLoading() {
        progress.show()
    }

    override fun dismissLoading() {
        progress.dismiss()
    }

    override fun showMessage(messageRes: Int) {
        Snackbar.make(binding.root, messageRes, Snackbar.LENGTH_LONG).show()
    }

}