package com.msport.clientmaster.util;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.msport.clientmaster.activity.YueqiuBisaiActivity;
import com.msport.clientmaster.constants.Constant;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * 动画工具框架
 *
 * @author like 2016-4-7
 */
public class AnimationUtil {

    private static AnimationUtil real;

    public static AnimationUtil getInstance() {
        if (real == null) {
            real = new AnimationUtil();
        }
        return real;
    }

    /**
     * 渐变动画
     */
    private final String ALPHA = "alpha";
    /**
     * 轴心点x坐标
     */
    private final String PIVOT_X = "pivotX";

    /**
     * 轴心点y坐标
     */
    private final String PIVOT_Y = "pivotY";

    /**
     * 动画View偏移量x
     */
    private final String TRANSLATION_X = "translationX";

    /**
     * 动画View偏移量y
     */
    private final String TRANSLATION_Y = "translationY";

    /**
     * 旋转动画
     */
    private final String ROTATION = "rotation";

    /**
     * 旋转中心点x
     */
    private final String ROTATION_X = "rotationX";
    /**
     * 旋转中心点y
     */
    private final String ROTATION_Y = "rotationY";

    /**
     * 缩放位移x
     */
    private final String SCALE_X = "scaleX";

    /**
     * 缩放位移y
     */
    private final String SCALE_Y = "scaleY";

    /**
     * 滑动位移x
     */
    private final String SCROLL_X = "scrollX";

    /**
     * 滑动位移y
     */
    private final String SCROLL_Y = "scrollY";

    /**
     * 显示位置坐标X
     */
    private final String SHOW_X = "x";

    /**
     * 显示位置坐标Y
     */
    private final String SHOW_Y = "y";

    /**
     * 打开菜单的动画
     *
     * @param view   执行动画的view
     * @param index  view在动画序列中的顺序
     * @param total  动画序列的个数
     * @param radius 动画半径
     */
    public void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 2) * 2);
        int translationX = (int) (radius * Math.cos(degree));
        int translationY = (int) (radius * Math.sin(degree));
        Log.d("TAG", String.format(
                "degree=%f, translationX=%d, translationY=%d", degree,
                translationX, translationY));
        final AnimatorSet set = new AnimatorSet();
        // 包含平移、缩放和透明度动画
        set.playTogether(ObjectAnimator.ofFloat(view, TRANSLATION_X, 0,
                translationX / 1.8f), ObjectAnimator.ofFloat(view,
                TRANSLATION_Y, 0, -translationY / 1.8f), ObjectAnimator
                .ofFloat(view, SCALE_X, 0f, 1f), ObjectAnimator.ofFloat(view,
                SCALE_Y, 0f, 1f), ObjectAnimator.ofFloat(view, ALPHA, 0f, 1));
        set.setDuration(1 * 500);
        set.start();

    }

    /**
     * 关闭菜单的动画
     *
     * @param view    执行动画的view
     * @param index   view在动画序列中的顺序
     * @param total   动画序列的个数
     * @param radius  动画半径
     * @param handler
     */
    public void doAnimateClose(final View view, int index, int total,
                               int radius, final Handler handler) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 2) * 2);
        int translationX = (int) (radius * Math.cos(degree));
        int translationY = (int) (radius * Math.sin(degree));
        Log.d("TAG", String.format(
                "degree=%f, translationX=%d, translationY=%d", degree,
                translationX, translationY));
        AnimatorSet set = new AnimatorSet();
        // 包含平移、缩放和透明度动画
        set.playTogether(ObjectAnimator.ofFloat(view, TRANSLATION_X,
                translationX / 1.8f, 0), ObjectAnimator.ofFloat(view,
                TRANSLATION_Y, -translationY / 1.8f, 0), ObjectAnimator
                .ofFloat(view, SCALE_X, 1f, 0f), ObjectAnimator.ofFloat(view,
                SCALE_Y, 1f, 0f), ObjectAnimator.ofFloat(view, ALPHA, 1f, 0f));
        // 为动画加上事件监听，当动画结束的时候，我们把当前view隐藏
        set.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }
        });

        set.setDuration(1 * 1000).start();
    }

    /**
     * 竖直从底部进入并显示
     */
    public void doButtomShow(View view, int transY) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(view, TRANSLATION_Y, 0f, -transY),
                ObjectAnimator.ofFloat(view, TRANSLATION_X, 0f, 0f),
                ObjectAnimator.ofFloat(view, SCALE_X, 0f, 1f),
                ObjectAnimator.ofFloat(view, SCALE_Y, 0f, 1f),
                ObjectAnimator.ofFloat(view, ALPHA, 0f, 1f));
        set.setDuration(1 * 600);
        set.start();
    }

    /**
     * 竖直从底部退出并消失
     */
    public void doButtomHide(final View view, final Handler handler, int transY) {
        AnimatorSet set = new AnimatorSet();
        // 包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, TRANSLATION_Y, -transY, 0f),
                ObjectAnimator.ofFloat(view, TRANSLATION_X, 0f, 0f),
                ObjectAnimator.ofFloat(view, SCALE_X, 1f, 0f),
                ObjectAnimator.ofFloat(view, SCALE_Y, 1f, 0f),
                ObjectAnimator.ofFloat(view, ALPHA, 1f, 0f));
        // 为动画加上事件监听，当动画结束的时候，我们把当前view隐藏
        set.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }
        });

        set.setDuration(1 * 600).start();
    }

    /**
     * 显示
     */
    public void showView(final View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ALPHA, 0f, 1f));
        set.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
//				v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
            set.setDuration(800).start();
    }

    /**
     * 隐藏
     *
     * @param v
     */
    public void hintView(final View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ALPHA, 1f, 0f));

        set.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator arg0) {

            }

            @Override
            public void onAnimationRepeat(Animator arg0) {

            }

            @Override
            public void onAnimationEnd(Animator arg0) {
//				v.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator arg0) {

            }
        });
            set.setDuration(800).start();
    }

    /**
     * 顺时针旋转
     */
    public void rotate_LIKE_ZHAILIJUAN(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ROTATION, 0, 225),
                ObjectAnimator.ofFloat(v, ALPHA, 0f, 1f));
        set.setDuration(800).start();
    }

    /**
     * 逆时针旋转
     */
    public void rotate_ZHAILIJUAN_LIKE(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ROTATION, 225, 0),
                ObjectAnimator.ofFloat(v, ALPHA, 1f, 0f));
        set.setDuration(600).start();
    }

    /**
     * 顺时针90°旋转
     */
    public void rolate_90_do(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ROTATION, 0, 90));
        set.setDuration(200).start();
    }

    /**
     * 逆时针90°旋转
     */
    public void rolate_90_redo(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ROTATION, 90, 0));
        set.setDuration(200).start();
    }



    /**
     * 顺时针180°旋转
     */
    public void rolate_180_do(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ROTATION, 0, 180));
        set.setDuration(200).start();
    }

    /**
     * 逆时针180°旋转
     */
    public void rolate_180_redo(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, ROTATION, 180, 0));
        set.setDuration(200).start();
    }


    /**
     * 点击放大
     */
    public void scaleBIG(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, SCALE_X, 1f, 1.4f),
                ObjectAnimator.ofFloat(v, SCALE_Y, 1f, 1.4f));
        set.setDuration(300).start();
    }

    /**
     * 点击缩小
     *
     * @param type
     * @param handler
     */
    public void scaleSHORT(View v, final String type, final Context context,
                           final Handler handler) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(v, SCALE_X, 1.4f, 1f), ObjectAnimator.ofFloat(v, SCALE_Y, 1.4f, 1f));
        set.setDuration(200).start();
        set.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator arg0) {

            }

            @Override
            public void onAnimationRepeat(Animator arg0) {

            }

            @Override
            public void onAnimationEnd(Animator arg0) {
                if (type.equals("2")) {
                    CustomToast.createToast().showFaild(context, "敬请期待");
                    if (handler!=null) {
                        handler.obtainMessage(Constant.HIDE_LAYOUT).sendToTarget();
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(context, YueqiuBisaiActivity.class);
                intent.putExtra(Constant.COURSE_CHOOSE_TYPE,type);
                context.startActivity(intent);
                if (handler != null) {
                    handler.obtainMessage(Constant.HIDE_LAYOUT).sendToTarget();
                }
            }

            @Override
            public void onAnimationCancel(Animator arg0) {

            }
        });
    }

}
