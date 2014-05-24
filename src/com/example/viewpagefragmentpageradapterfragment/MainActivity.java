package com.example.viewpagefragmentpageradapterfragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity implements OnClickListener,OnPageChangeListener{
	private ViewPager viewPager;
	 //�ײ��˵�ͼƬ
    private ImageView[] menusImageViews;
  //����ͼƬ��Դ
    private static final int[] menImgs = {R.drawable.all,R.drawable.near,R.drawable.map};
  //��¼��ǰѡ��λ��
    private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) this.findViewById(R.id.pager);
		initial();
		initMenu();
		viewPager.setOnPageChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initial() {
		int[] scroll_img = new int[] { R.drawable.hy1,
				R.drawable.hy2, R.drawable.hy3 };
		menusImageViews = new ImageView[menImgs.length];
		List<Fragment> contents = new ArrayList<Fragment>();
		for (int i = 0; i < scroll_img.length; i++) {
			if(i==0) {
				Fragment content = new HomeFragment();
				contents.add(content);
				continue;
			}
			// �½�Fragment��ʵ�����󣬲����ò������ݵ�Fragment��
			Bundle args = new Bundle();
			args.putInt("layoutId", R.layout.fragment_content);
			args.putInt("image", scroll_img[i]);
			Fragment content = new PagerContentFragment();
			content.setArguments(args);
			contents.add(content);
		}
		// ���getSupportFragmentManagerֻ��activity�̳�FragmentActivity�Ż���
		MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(
				getSupportFragmentManager(), contents);
		viewPager.setAdapter(adapter);
	}
	
	/**
	 * ��ʼ���ײ�С��
	 */
	private void initMenu(){
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tabMenu);  
		int menuCount = menImgs.length;
        //ѭ��ȡ��С��ͼƬ
        for (int i = 0; i < menuCount; i++) {
        	//�õ�һ��LinearLayout�����ÿһ����Ԫ��
        	RelativeLayout relativeLayout = (RelativeLayout) linearLayout.getChildAt(i);
        	ImageView imageView = (ImageView)relativeLayout.getChildAt(0);
        	menusImageViews[i]=imageView;
        	//Ĭ�϶���Ϊ��ɫ
        	imageView.setEnabled(true);
            //imageView.setOnClickListener(this);
        	//�����ò����������¼�
            relativeLayout.setOnClickListener(this);
        	//����λ��tag������ȡ���뵱ǰλ�ö�Ӧ
            relativeLayout.setTag(i);
        }
        //���õ���Ĭ�ϵ�λ��
        currentIndex = 0;
        //����Ϊ��ɫ����ѡ��״̬
        menusImageViews[currentIndex].setEnabled(false);
	}

	private class MyFragmentPageAdapter extends FragmentPagerAdapter {
		private List<Fragment> mContents;

		public MyFragmentPageAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		public MyFragmentPageAdapter(FragmentManager fm, List<Fragment> contents) {
			super(fm);
			mContents = contents;
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return mContents.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mContents.size();
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		//���õײ�С��ѡ��״̬
        setCurDot(position);
		
	}

	@Override
	public void onClick(View v) {
		 int position = (Integer)v.getTag();
         setCurView(position);
         setCurDot(position);	
	}
	
	/**
	 * ���õ�ǰҳ���λ��
	 */
	private void setCurView(int position){
         if (position < 0 || position >= menImgs.length) {
             return;
         }
         viewPager.setCurrentItem(position);
     }

     /**
     * ���õ�ǰ��С���λ��
     */
    private void setCurDot(int positon){
         if (positon < 0 || positon > menImgs.length - 1 || currentIndex == positon) {
             return;
         }
         menusImageViews[positon].setEnabled(false);
         menusImageViews[currentIndex].setEnabled(true);

         currentIndex = positon;
     }
}
