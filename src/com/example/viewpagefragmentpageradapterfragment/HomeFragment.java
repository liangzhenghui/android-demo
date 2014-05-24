package com.example.viewpagefragmentpageradapterfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class HomeFragment extends Fragment implements OnItemClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_fragment, container, false);
		ListView listView = (ListView) view.findViewById(R.id.listViewForMine);
		CommonAdapter adapter = new CommonAdapter(getActivity(), getData());
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		return view;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("textInfo", "购买过的奶粉");
		map.put("img", R.drawable.point_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("textInfo", "购买过的零售商");
		map.put("img", R.drawable.point_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("textInfo", "购买过的品牌");
		map.put("img", R.drawable.point_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("textInfo", "最近浏览");
		map.put("img", R.drawable.point_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("textInfo", "设置");
		map.put("img", R.drawable.point_normal);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("textInfo", "帮助");
		map.put("img", R.drawable.point_normal);
		list.add(map);
		return list;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (position == 0) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), TestActivity.class);
			startActivity(intent);
			getActivity().overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
		}

	}

	
}