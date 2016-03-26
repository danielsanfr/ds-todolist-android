package br.com.danielsan.dstodolist.widgets.behaviors;

import android.content.Context;
import android.util.AttributeSet;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by daniel on 26/03/16.
 */
public class FabSnackbarAndScrollBehavior extends AbstractSnackbarAndScrollBehavior<FloatingActionsMenu> {

    public FabSnackbarAndScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onStartTranslation(FloatingActionsMenu child) {
        child.collapse();
    }

}
