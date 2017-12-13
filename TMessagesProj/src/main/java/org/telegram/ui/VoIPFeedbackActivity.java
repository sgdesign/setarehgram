package org.ستاره گرام.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.zanbilapp.messenger.AndroidUtilities;
import org.zanbilapp.messenger.LocaleController;
import org.zanbilapp.messenger.MessagesController;
import org.zanbilapp.messenger.R;
import org.ستاره گرام.tgnet.ConnectionsManager;
import org.ستاره گرام.tgnet.RequestDelegate;
import org.ستاره گرام.tgnet.TLObject;
import org.ستاره گرام.tgnet.TLRPC;
import org.ستاره گرام.ui.ActionBar.AlertDialog;
import org.ستاره گرام.ui.ActionBar.Theme;
import org.ستاره گرام.ui.Components.BetterRatingView;
import org.ستاره گرام.ui.Components.LayoutHelper;
import org.ستاره گرام.ui.Components.voip.VoIPHelper;

public class VoIPFeedbackActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		super.onCreate(savedInstanceState);

		overridePendingTransition(0, 0);

		setContentView(new View(this));

		VoIPHelper.showRateAlert(this, new Runnable(){
			@Override
			public void run(){
				finish();
			}
		}, getIntent().getLongExtra("call_id", 0), getIntent().getLongExtra("call_access_hash", 0));
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, 0);
	}
}
