package com.bydauto.mylistphotoview;

//import android.app.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by byd_tw on 2017/11/23.
 */

public class MyImagesPagerAdapter extends PagerAdapter {

    private Fragment mContext;

    private List<PhotoView> mPhotoViewsList = new ArrayList<>();
    private List<String> mImgUrlsList;

    public MyImagesPagerAdapter(Fragment mContext, List<String> mImgUrlsList) {
        this.mContext = mContext;
        this.mImgUrlsList = mImgUrlsList;
        initPhoto();
    }

    private void initPhoto() {
        List<PhotoView> photoViewsList = new ArrayList<>();
        PhotoView photoView;
//       如下可用viewgroup代替
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        params.width = ViewPager.LayoutParams.MATCH_PARENT;
        params.height = ViewPager.LayoutParams.WRAP_CONTENT;

        for (int i = mPhotoViewsList.size(); i < mImgUrlsList.size(); i++) {
            photoView = new PhotoView(mContext.getContext());
            photoView.setLayoutParams(params);

            photoViewsList.add(photoView);
            Glide.with(mContext.getContext()).load(mImgUrlsList.get(i)).into(photoView);
        }

        mPhotoViewsList.addAll(photoViewsList);
        photoViewsList.clear();
    }

    @Override
    public int getCount() {
        return mImgUrlsList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mPhotoViewsList.get(position));
        return mPhotoViewsList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mPhotoViewsList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void notifyDataSetChanged() {
        initPhoto();
        super.notifyDataSetChanged();
    }
}
