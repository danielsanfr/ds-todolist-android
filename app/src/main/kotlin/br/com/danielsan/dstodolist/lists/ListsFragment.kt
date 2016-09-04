package br.com.danielsan.dstodolist.lists

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

import br.com.danielsan.dstodolist.R
import br.com.danielsan.dstodolist.tasks.TasksActivity

/**
 * Created by daniel on 25/03/16.
 */
class ListsFragment : Fragment() {

    private var drawer: Drawer? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        drawer = DrawerBuilder().withActivity(activity)
                .withSavedInstance(savedInstanceState)
                .withDisplayBelowStatusBar(false)
                .withTranslucentStatusBar(false)
                .withDrawerLayout(R.layout.material_drawer_fits_not)
                .addDrawerItems(
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list))
                .withOnDrawerItemClickListener(onDrawerItemClickListener)
                .buildView()

        return drawer!!.slider
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configList()
    }

    private fun configList() {
        val slider = drawer!!.slider

        if (slider.layoutParams is CoordinatorLayout.LayoutParams) {
            val layoutParams = slider.layoutParams as CoordinatorLayout.LayoutParams
            layoutParams.behavior = AppBarLayout.ScrollingViewBehavior()
            layoutParams.width = CoordinatorLayout.LayoutParams.MATCH_PARENT
            layoutParams.height = CoordinatorLayout.LayoutParams.MATCH_PARENT
            slider.layoutParams = layoutParams
        }
    }

    private val onDrawerItemClickListener = Drawer.OnDrawerItemClickListener { view, position, drawerItem ->
        activity.startActivity(Intent(context, TasksActivity::class.java))
        activity.overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out)
        true
    }

    companion object {
        fun newInstance(): ListsFragment {
            return ListsFragment()
        }
    }

}
