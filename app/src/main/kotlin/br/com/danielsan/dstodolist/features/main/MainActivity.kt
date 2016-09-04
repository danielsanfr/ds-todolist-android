package br.com.danielsan.dstodolist.features.main

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.com.danielsan.dstodolist.R
import br.com.danielsan.dstodolist.databinding.ActivityMainBinding

/**
 * Created by daniel on 04/09/16.
 */

class MainActivity : AppCompatActivity(), MainView {

    private val presenter: MainPresenter by lazy { MainPresenter() }
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
        presenter.attachView(this)
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