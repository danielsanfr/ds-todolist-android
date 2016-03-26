package br.com.danielsan.dstodolist.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import br.com.danielsan.dstodolist.R;

/**
 * Created by daniel on 29/12/15.
 */
public class ShadowView extends AppCompatImageView {

    public ShadowView(Context context) {
        super(context);
        this.setupView();
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setupView();
    }

    public ShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setupView();
    }

    private void setupView() {
        this.setImageResource(R.drawable.shape_shadow_down);
    }

}
