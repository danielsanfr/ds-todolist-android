package br.com.danielsan.dstodolist.lists;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import br.com.danielsan.dstodolist.R;
import br.com.danielsan.dstodolist.tasks.TasksActivity;

/**
 * Created by daniel on 25/03/16.
 */
public class ListsFragment extends Fragment {

    private Drawer drawer;

    public static ListsFragment newInstance() {
        return new ListsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        drawer = new DrawerBuilder()
                .withActivity(getActivity())
                .withSavedInstance(savedInstanceState)
                .withDisplayBelowStatusBar(false)
                .withTranslucentStatusBar(false)
                .withDrawerLayout(R.layout.material_drawer_fits_not)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Daniel").withIcon(GoogleMaterial.Icon.gmd_list),
                        new PrimaryDrawerItem().withName("Erika").withIcon(GoogleMaterial.Icon.gmd_list)
                )
                .withOnDrawerItemClickListener(onDrawerItemClickListener).buildView();

        return drawer.getSlider();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.configList();
    }

    private void configList() {
        View slider = drawer.getSlider();

        if (slider.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) slider.getLayoutParams();
            layoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
            layoutParams.width = CoordinatorLayout.LayoutParams.MATCH_PARENT;
            layoutParams.height = CoordinatorLayout.LayoutParams.MATCH_PARENT;
            slider.setLayoutParams(layoutParams);
        }
    }

    private final Drawer.OnDrawerItemClickListener onDrawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            getActivity().startActivity(new Intent(getContext(), TasksActivity.class));
            getActivity().overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out);
            return true;
        }
    };

}
