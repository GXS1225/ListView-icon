package com.bzu.gxs.main;
import java.util.ArrayList;
import java.util.List;

import com.bzu.gxs.domain.Fruit;
import com.bzu.gxs.domain.FruitAdapter;
import com.example.listview_gxs2.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends Activity {
	private ListView lvFruits;
	//1.准备好数据源
	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//1.准备好数据源
		initFruits();
		lvFruits = (ListView) findViewById(R.id.listView);
	
		//2.创建Adapter
        FruitAdapter adapter=new FruitAdapter(this, R.layout.item,fruitList);
                
        //3.绑定AdapterView和Adapter之间的关联
		lvFruits.setAdapter(adapter);
		lvFruits.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position,
					long id) {
			    Fruit fruit=	fruitList.get(position);
			    Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initFruits() {
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);

	}

}
