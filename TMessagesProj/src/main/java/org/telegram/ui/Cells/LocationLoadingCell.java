/*
 * This is the source code of ستاره گرام for Android v. 3.x.x
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2017.
 */

package org.ستاره گرام.ui.Cells;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.zanbilapp.messenger.AndroidUtilities;
import org.zanbilapp.messenger.LocaleController;
import org.zanbilapp.messenger.R;
import org.ستاره گرام.ui.ActionBar.Theme;
import org.ستاره گرام.ui.Components.LayoutHelper;
import org.ستاره گرام.ui.Components.RadialProgressView;

public class LocationLoadingCell extends FrameLayout {

    private RadialProgressView progressBar;
    private TextView textView;

    public LocationLoadingCell(Context context) {
        super(context);

        progressBar = new RadialProgressView(context);
        addView(progressBar, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER));

        textView = new TextView(context);
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        textView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        addView(textView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec((int) (AndroidUtilities.dp(56) * 2.5f), MeasureSpec.EXACTLY));
    }

    public void setLoading(boolean value) {
        progressBar.setVisibility(value ? VISIBLE : INVISIBLE);
        textView.setVisibility(value ? INVISIBLE : VISIBLE);
    }
}
