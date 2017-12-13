/*
 * This is the source code of ستاره گرام for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2017.
 */

package org.ستاره گرام.ui.Cells;

import android.content.Context;
import android.view.View;

import org.zanbilapp.messenger.AndroidUtilities;
import org.zanbilapp.messenger.R;
import org.ستاره گرام.ui.ActionBar.Theme;

public class ShadowSectionCell extends View {

    private int size = 12;

    public ShadowSectionCell(Context context) {
        super(context);
        setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
    }

    public void setSize(int value) {
        size = value;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(size), MeasureSpec.EXACTLY));
    }
}
