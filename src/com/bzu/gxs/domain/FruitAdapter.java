package com.bzu.gxs.domain;

import java.util.List;
import com.bzu.gxs.domain.*;
import android.content.Context;
import android.view.LayoutInflater;
import com.bzu.gxs.main.*;
import com.example.listview_gxs2.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
	private int resourceId;

	public FruitAdapter(Context context, int textViewResourceId,
			List<Fruit> data) {
		super(context,textViewResourceId, data);
		resourceId = textViewResourceId;
	}
	
	//这个方法在每个子项中滚屏幕内的时候
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Fruit fruit = getItem(position);
		View view=LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView ivFruit=(ImageView) view.findViewById(R.id.ivFruit);
		TextView tvFruit=(TextView) view.findViewById(R.id.tvFruit);
		ivFruit.setImageResource(fruit.getImageId());
		tvFruit.setText(fruit.getName());
		return view;
	}

}
