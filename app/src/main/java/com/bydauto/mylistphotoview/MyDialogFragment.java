package com.bydauto.mylistphotoview;

//import android.app.DialogFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by byd_tw on 2017/11/23.
 */

public class MyDialogFragment extends DialogFragment {
    @BindView(R.id.vp_viewpager)
    MyImagesViewPager vpViewpager;
    @BindView(R.id.tv_index)
    TextView tvIndex;

    private static MyImagesPagerAdapter myImagesPagerAdapter;
    Unbinder unbinder;
    private ViewPager mViewPager;
    private List<String> mImgUrlsList = new ArrayList<>();

    private int currentItem;


    private static MyDialogFragmentCreator myDialogFragmentCreator;

    static{
        myDialogFragmentCreator = new MyDialogFragmentCreator();
    }



    static class Instance {
        static MyDialogFragment instance = new MyDialogFragment();
    }

//    private MyDialogFragment() {
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.fragment_viewpager, container,false);
        unbinder = ButterKnife.bind(this, view);
        myImagesPagerAdapter = new MyImagesPagerAdapter(this, mImgUrlsList);
        vpViewpager.setAdapter(myImagesPagerAdapter);
        vpViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvIndex.setText(1 + position + "/" + mImgUrlsList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }


    public static MyDialogFragment build() {
        return myDialogFragmentCreator.build();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

//    /   添加图片数据集合
    public void addImages(ArrayList<String> images) {
        mImgUrlsList.clear();
        mImgUrlsList.addAll(images);
    }

    private void initData() {

        //获得我们创建对象时设置的属性
        currentItem = myDialogFragmentCreator.currentItem;

        //设置相关属性

        tvIndex.setText(1 + currentItem + "/" + mImgUrlsList.size());
        myImagesPagerAdapter.notifyDataSetChanged();
        vpViewpager.setCurrentItem(currentItem);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }




    public static class MyDialogFragmentCreator {
        int currentItem;

        public MyDialogFragmentCreator current(int i) {
            this.currentItem = i;
            return this;
        }

        public MyDialogFragment build() {
            return Instance.instance;
        }
    }
}
