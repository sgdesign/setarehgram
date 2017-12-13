/*
 * This is the source code of ستاره گرام for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2017.
 */

package org.ستاره گرام.ui.Cells;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.zanbilapp.messenger.AndroidUtilities;
import org.zanbilapp.messenger.LocaleController;
import org.zanbilapp.messenger.R;
import org.ستاره گرام.ui.ActionBar.Theme;
import org.ستاره گرام.ui.Components.LayoutHelper;

public class StickerSetGroupInfoCell extends LinearLayout {

    private TextView addButton;
    private boolean isLast;

    public StickerSetGroupInfoCell(Context context) {
        super(context);
        setOrientation(VERTICAL);

        TextView infoTextView = new TextView(context);
        infoTextView.setTextColor(Theme.getColor(Theme.key_chat_emojiPanelTrendingDescription));
        infoTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        infoTextView.setText(LocaleController.getString("GroupStickersInfo", R.string.GroupStickersInfo));
        addView(infoTextView, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.TOP | Gravity.LEFT, 17, 4, 17, 0));

        addButton = new TextView(context);
        addButton.setPadding(AndroidUtilities.dp(17), 0, AndroidUtilities.dp(17), 0);
        addButton.setGravity(Gravity.CENTER);
        addButton.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        addButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        addButton.setTypeface(AndroidUtilities.getTypeface("fonts/rmedium.ttf"));
        addButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        addButton.setText(LocaleController.getString("ChooseStickerSet", R.string.ChooseStickerSet).toUpperCase());
        addView(addButton, LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT, 28, Gravity.TOP | Gravity.LEFT, 17, 10, 14, 8));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), heightMeasureSpec);
        if (isLast) {
            View parent = (View) getParent();
            if (parent != null) {
                int height = parent.getMeasuredHeight() - parent.getPaddingBottom() - parent.getPaddingTop() - AndroidUtilities.dp(24);
                if (getMeasuredHeight() < height) {
                    setMeasuredDimension(getMeasuredWidth(), height);
                }
            }
        }
    }

    public void setAddOnClickListener(OnClickListener onClickListener) {
        addButton.setOnClickListener(onClickListener);
    }

    public void setIsLast(boolean last) {
        isLast = last;
        requestLayout();
    }
}
