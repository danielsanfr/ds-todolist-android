package br.com.danielsan.dstodolist.widgets.behaviors;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import br.com.danielsan.dstodolist.R;

/**
 * Created by danielsan on 11/11/15.
 */
public class SlideScrollAwareBehavior extends FloatingActionButton.Behavior {

    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private boolean mIsAnimatingOut = false;

    private final Context context;

    public SlideScrollAwareBehavior(Context context, AttributeSet attrs) {
        super();
        this.context = context;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child, View directTargetChild,
                                       View target, int nestedScrollAxes) {
        return (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL) ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target,
                                          nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                               View target, int dxConsumed, int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && !this.mIsAnimatingOut && child.getVisibility() == View.VISIBLE) {
            // User scrolled down and the FAB is currently visible -> hide the FAB
            this.animateOut(child);
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            // User scrolled up and the FAB is currently not visible -> show the FAB
            this.animateIn(child);
        }
    }

    // Same animation that FloatingActionButton.Behavior uses to
    // hide the FAB when the AppBarLayout exits
    protected void animateOut(final View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            float verticalTranslation = view.getMeasuredHeight()
                    + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, context.getResources().getDisplayMetrics());
            ViewCompat.animate(view).translationY(verticalTranslation)
                    .setInterpolator(INTERPOLATOR).withLayer()
                    .setListener(new ViewPropertyAnimatorListener() {
                        public void onAnimationStart(View view) {
                            SlideScrollAwareBehavior.this.mIsAnimatingOut = true;
                        }
                        public void onAnimationCancel(View view) {
                            SlideScrollAwareBehavior.this.mIsAnimatingOut = false;
                        }
                        public void onAnimationEnd(View view) {
                            SlideScrollAwareBehavior.this.mIsAnimatingOut = false;
                            view.setVisibility(View.GONE);
                        }
                    }).start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_to_down);
            anim.setInterpolator(INTERPOLATOR);
            anim.setDuration(300L);
            anim.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                    SlideScrollAwareBehavior.this.mIsAnimatingOut = true;
                }
                public void onAnimationEnd(Animation animation) {
                    SlideScrollAwareBehavior.this.mIsAnimatingOut = false;
                    view.setVisibility(View.GONE);
                }
                @Override
                public void onAnimationRepeat(final Animation animation) { }
            });
            view.startAnimation(anim);
        }
    }

    // Same animation that FloatingActionButton.Behavior
    // uses to show the FAB when the AppBarLayout enters
    protected void animateIn(View view) {
        view.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            ViewCompat.animate(view).translationY(0).setInterpolator(INTERPOLATOR)
                    .withLayer().setListener(null).start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_from_down);
            anim.setDuration(300L);
            anim.setInterpolator(INTERPOLATOR);
            view.startAnimation(anim);
        }
    }

}
