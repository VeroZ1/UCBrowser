package com.zibuyuqing.ucbrowser.widget.favorite;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zibuyuqing.common.utils.*;
import com.zibuyuqing.common.utils.ViewUtil;
import com.zibuyuqing.ucbrowser.R;
import com.zibuyuqing.ucbrowser.model.bean.favorite.ItemInfo;

/**
 * Created by xijun.wang on 2017/12/22.
 */

public abstract class FavoriteItemView extends FrameLayout {
    public static final String TAG ="FavoriteItemView";
    protected Bitmap mIcon;
    protected int mIconSize;
    protected String mDescription;
    protected Context mContext;
    protected Resources mRes;
    protected ImageView ivIcon;
    protected TextView tvDescription;
    protected ItemInfo mInfo;
    protected int mWidth;
    public FavoriteItemView(Context context) {
        this(context,null);
    }

    public FavoriteItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FavoriteItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawOthers(canvas);
    }

    protected void drawOthers(Canvas canvas){

    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ivIcon = (ImageView) findViewById(R.id.ivIcon);
        tvDescription = (TextView)findViewById(R.id.tvDescription);
    }

    protected void init() {
        mContext = getContext();
        mRes = getResources();
        mIconSize = mRes.getDimensionPixelSize(R.dimen.dimen_54dp);
        mWidth = ViewUtil.getScreenSize(mContext).x / 4;
    }


    public void applyFromItemInfo(ItemInfo itemInfo){
        Log.e(TAG,"applyFromItemInfo itemInfo =:" + itemInfo);
        setTag(itemInfo);
        mInfo = itemInfo;
        setIcon(itemInfo.icon);
        setDescription(itemInfo.description);
    }

    public void setIcon(Bitmap icon){
        mIcon = icon;
        ivIcon.setImageBitmap(icon);
    }
    public void setDescription(String des){
        mDescription = des;
        tvDescription.setText(des);
    }
}
