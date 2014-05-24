package com.example.viewpagefragmentpageradapterfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PagerContentFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// ���Ƚ����½�Fragmentʱ�򴫹����Ĳ���
		Bundle args = getArguments();
		int layoutId = args.getInt("layoutId");
		int imageId = args.getInt("image");
		View view = inflater.inflate(layoutId, container, false);

		ImageView image = (ImageView) view.findViewById(R.id.image);
		image.setImageResource(imageId);
		return view;
	}

}