package br.com.danielsan.dstodolist.widgets.behaviors;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import java.util.List;

import br.com.danielsan.dstodolist.R;

/**
 * Created by daniel on 26/03/16.
 */
public class AbstractSnackbarAndScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    private static final boolean SNACKBAR_BEHAVIOR_ENABLED = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private boolean isAnimatingOut = false;

    private float fabTranslationY;
    private final Context context;
    private ValueAnimator fabTranslationYAnimator;

    public AbstractSnackbarAndScrollBehavior(Context context, AttributeSet attrs) {
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency) {
        return SNACKBAR_BEHAVIOR_ENABLED && dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final V child, View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            final float targetTransY = getFabTranslationYForSnackbar(parent, child);
            if (fabTranslationY == targetTransY) {
                return false;
            }

            final float currentTransY = ViewCompat.getTranslationY(child);

            // Make sure that any current animation is cancelled
            if (fabTranslationYAnimator != null && fabTranslationYAnimator.isRunning()) {
                fabTranslationYAnimator.cancel();
            }

            if (child.isShown()
                    && Math.abs(currentTransY - targetTransY) > (child.getHeight() * 0.667f)) {
                if (fabTranslationYAnimator == null) {
                    fabTranslationYAnimator = ValueAnimator.ofFloat(currentTransY, targetTransY);
                    fabTranslationYAnimator.setInterpolator(INTERPOLATOR);
                    fabTranslationYAnimator.addListener(new SimpleAnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            onStartTranslation(child);
                        }
                    });
                    fabTranslationYAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animator) {
                            ViewCompat.setTranslationY(child, (float) animator.getAnimatedValue());
                        }
                    });
                }
                fabTranslationYAnimator.start();
            } else {
                this.onStartTranslation(child);
                ViewCompat.setTranslationY(child, targetTransY);
            }

            fabTranslationY = targetTransY;
        }
        return false;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL) ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target,
                                          nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && !isAnimatingOut && child.getVisibility() == View.VISIBLE) {
            this.animateOut(child);
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            this.animateIn(child);
        }
    }

    protected void onStartTranslation(V child) { }

    protected void animateOut(final V child) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            float verticalTranslation = child.getMeasuredHeight()
                    + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, context.getResources().getDisplayMetrics());
            ViewCompat.animate(child).translationY(verticalTranslation)
                    .setInterpolator(INTERPOLATOR).withLayer()
                    .setListener(new ViewPropertyAnimatorListener() {
                        public void onAnimationStart(View view) {
                            onStartTranslation(child);
                            AbstractSnackbarAndScrollBehavior.this.isAnimatingOut = true;
                        }

                        public void onAnimationCancel(View view) {
                            AbstractSnackbarAndScrollBehavior.this.isAnimatingOut = false;
                        }

                        public void onAnimationEnd(View view) {
                            AbstractSnackbarAndScrollBehavior.this.isAnimatingOut = false;
                            view.setVisibility(View.GONE);
                        }
                    }).start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(child.getContext(), R.anim.slide_to_down);
            anim.setInterpolator(INTERPOLATOR);
            anim.setDuration(300L);
            anim.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                    onStartTranslation(child);
                    AbstractSnackbarAndScrollBehavior.this.isAnimatingOut = true;
                }

                public void onAnimationEnd(Animation animation) {
                    AbstractSnackbarAndScrollBehavior.this.isAnimatingOut = false;
                    child.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(final Animation animation) {
                }
            });
            child.startAnimation(anim);
        }
    }

    protected void animateIn(final V child) {
        child.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            ViewCompat.animate(child).translationY(0).setInterpolator(INTERPOLATOR)
                    .withLayer().setListener(new SimpleViewPropertyAnimatorListener() {
                @Override
                public void onAnimationStart(View view) {
                    onStartTranslation(child);
                }
            }).start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(child.getContext(), R.anim.slide_from_down);
            anim.setDuration(300L);
            anim.setInterpolator(INTERPOLATOR);
            anim.setAnimationListener(new SimpleAnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    onStartTranslation(child);
                }
            });
            child.startAnimation(anim);
        }
    }

    private float getFabTranslationYForSnackbar(CoordinatorLayout parent, V fab) {
        float minOffset = 0;
        final List<View> dependencies = parent.getDependencies(fab);
        for (int i = 0, z = dependencies.size(); i < z; i++) {
            final View view = dependencies.get(i);
            if (view instanceof Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
                minOffset = Math.min(minOffset, ViewCompat.getTranslationY(view) - view.getHeight());
            }
        }

        return minOffset;
    }

    private static class SimpleAnimatorListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationStart(Animator animation) { }
        @Override
        public void onAnimationEnd(Animator animation) { }
        @Override
        public void onAnimationCancel(Animator animation) { }
        @Override
        public void onAnimationRepeat(Animator animation) { }
    }

    private static class SimpleAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) { }
        @Override
        public void onAnimationEnd(Animation animation) { }
        @Override
        public void onAnimationRepeat(Animation animation) { }
    }

    private static class SimpleViewPropertyAnimatorListener implements ViewPropertyAnimatorListener {
        @Override
        public void onAnimationStart(View view) { }
        @Override
        public void onAnimationEnd(View view) { }
        @Override
        public void onAnimationCancel(View view) { }
    }

}
