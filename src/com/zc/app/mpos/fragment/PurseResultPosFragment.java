package com.zc.app.mpos.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zc.app.bootstrap.BootstrapButton;
import com.zc.app.mpos.R;

public class PurseResultPosFragment extends Fragment implements OnClickListener {

	public static final String TAG = PurseResultPosFragment.class
			.getSimpleName();

	public static final String AMOUNT = "amount";
	public static final String BALANCE = "balance";
	public static final String HINT = "hint";

	private OnPurseResultPosPageListener mCallback;

	private Bundle bundle;

	private TextView amountTextView;
	private TextView balancetTextView;
	private TextView resultHinTextView;
	private BootstrapButton purseResultBootstrapButton;

	@Override
	public void onAttach(Activity activity) {
		Log.e(TAG, "onAttach");
		try {
			mCallback = (OnPurseResultPosPageListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnLoginPageListener");
		}
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e(TAG, "onCreateView");

		View view = inflater.inflate(R.layout.activity_purse_card_page,
				container, false);
		findView(view);

		mCallback.setTag(TAG);

		return view;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated");

	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");

		if (bundle != null) {
			updateView(this.bundle);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d(TAG, "onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d(TAG, "onDetach");
	}

	public void setBundle(Bundle bundle) {
		Log.e(TAG, "setBundle");

		this.bundle = bundle;
	}

	private void findView(View view) {
		Log.e(TAG, "findView");

		TextView titleView = (TextView) getActivity().findViewById(
				R.id.iv_title_text);
		titleView.setText(R.string.resultTitle);

		// amountTextView = (TextView) view
		// .findViewById(R.id.purse_result_pos_amount_edit);
		//
		// balancetTextView = (TextView) view
		// .findViewById(R.id.purse_result_pos_balance_edit);
		//
		// resultHinTextView = (TextView) view
		// .findViewById(R.id.purse_result_pos_hint_txt);
		//
		// purseResultBootstrapButton = (BootstrapButton) view
		// .findViewById(R.id.purse_result_pos_button);

		purseResultBootstrapButton.setOnClickListener(this);
	}

	private void updateView(Bundle bundle) {
		String amountString = bundle.getString(AMOUNT, "0.00");
		String balanceString = bundle.getString(BALANCE, "000");
		String hintString = bundle.getString(HINT, "");

		amountTextView.setText(amountString + " 元");

		String endString = "."
				+ balanceString.substring(balanceString.length() - 2);
		StringBuffer buffer = new StringBuffer();
		buffer.append(balanceString.substring(0, balanceString.length() - 2));
		buffer.append(endString);

		balancetTextView.setText(buffer.toString() + " 元");

		resultHinTextView.setText(hintString);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// case R.id.purse_result_pos_button: {
		// Log.i(TAG, "purse_result_pos_button");
		// mCallback.onFinish();
		// break;
		// }
		//
		// default:
		// break;
		}
	}

	public interface OnPurseResultPosPageListener {
		public void setTag(String tag);

		public void onFinish();
	}
}
