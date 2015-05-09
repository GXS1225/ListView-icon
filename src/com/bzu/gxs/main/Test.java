package com.bzu.gxs.main;

/*

1.首先我们需要建立两个 xml文件 
      在activity_main.xml中创建一个ListView
      图 片  
      代码：
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" >
    
    <ListView 
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        ></ListView>

</RelativeLayout>      

    在fruit_item中创建一个 ImageView 和一个TestView 组件
    图片
   代码：
<?xml version="1.0" encoding="utf-8"?><LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal" >

    <ImageView
        android:id="@+id/ivFruit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/apple_pic" />

    <TextView
        android:id="@+id/tvFruit"
        android:layout_gravity="center"
        android:layout_margin="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Apple" />
</LinearLayout>



二，java代码

在MainActivity.java
（1）我们要准备好 数据源，这里的数据源指的是我们要用到的一些图片和文字信息，我们把它封装到了List中，方便使用
（2）创建Adapter适配器   FruitAdapter adapter=new FruitAdapter( 当前文本 , fruit_item布局 , 存放信息的List容器 );
（3）绑定AdapterView和Adapter  
注意：
Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
这是一个点击事件，显示当前一列水果的名称，利用 吐丝 点击显示水果的名称
FruitAdapter 是一个自定义的Adapter
代码如下：
package com.example.ui_listview01;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.example.ui_listview01.adpater.FruitAdapter;
import com.example.ui_listview01.model.Fruit;
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
		
		lvFruits = (ListView) findViewById(R.id.lvFruits);
		
		//2.创建Adapter
        FruitAdapter adapter=new FruitAdapter(this, R.layout.fruit_item,fruitList);
        
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


FruitAdapter.java
（1）FruitAdapter方法继承ArrayAdapter 需要重写getView方法
（2）getView()这个方法在每个子项被滚动到屏幕内的时候会被调用 getView( 当前位置, View convertView, ViewGroup parent)

注意：在FruitAdapter的getView()方法中每次都将布局重新加载了一遍，当ListView快速滚动的时候这就会成为性能的瓶颈
代码如下：
package com.example.ui_listview01.adpater;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ui_listview01.R;
import com.example.ui_listview01.model.Fruit;

public class FruitAdapter extends ArrayAdapter<Fruit> {
	private int resourceId;
	public FruitAdapter(Context context, int textViewResourceId,List<Fruit> data) {
		super(context, textViewResourceId, data);
		resourceId=textViewResourceId;
	}

	
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

*/