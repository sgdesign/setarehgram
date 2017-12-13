/*
 * This is the source code of ستاره گرام for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2017.
 */

package org.ستاره گرام.ui.Cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.zanbilapp.messenger.AndroidUtilities;
import org.zanbilapp.messenger.R;
import org.ستاره گرام.ui.Components.LayoutHelper;

@SuppressLint("NewApi")
public class PhotoAttachCameraCell extends FrameLayout {

    public PhotoAttachCameraCell(Context context) {
        super(context);

        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.instant_camera);
        imageView.setBackgroundColor(0xff000000);
        addView(imageView, LayoutHelper.createFrame(80, 80));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(86), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80), MeasureSpec.EXACTLY));
    }
}
