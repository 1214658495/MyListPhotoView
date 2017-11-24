package com.bydauto.mylistphotoview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.gv_images)
    GridView gvImages;
    private List<String> mImgUrlsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mImgUrlsList = new ArrayList<>();
        mImgUrlsList.add("http://d.hiphotos.baidu.com/image/pic/item/f31fbe096b63f624f0d3ad2e8c44ebf81a4ca315.jpg");
        mImgUrlsList.add("http://d.hiphotos.baidu.com/image/pic/item/5fdf8db1cb134954b2fe01a75f4e9258d0094a15.jpg");
        mImgUrlsList.add("http://c.hiphotos.baidu.com/image/pic/item/9825bc315c6034a87ccffc42c2134954082376c7.jpg");
        mImgUrlsList.add("http://b.hiphotos.baidu.com/image/pic/item/f3d3572c11dfa9ecf333c4d46bd0f703908fc1d0.jpg");
        mImgUrlsList.add("http://upload.365jilin.com/2016/0820/1471686023587.jpg");
        mImgUrlsList.add("http://imgs.aixifan.com/content/2016_07_11/1468254644.gif");
        mImgUrlsList.add("http://i1.hdslb.com/bfs/archive/1d6f6483d6aab106dcf011c0be3243ab197505e3.jpg");
        mImgUrlsList.add("http://img0.imgtn.bdimg.com/it/u=393555490,627047088&fm=214&gp=0.jpg");
        mImgUrlsList.add("http://i2.hdslb.com/bfs/archive/0f2afafebf13691b3bdcbf5b81cf6f50c699f8d1.jpg");
        mImgUrlsList.add("http://imgsrc.baidu.com/forum/w=580/sign=3e2d233f982397ddd679980c6983b216/214a8f025aafa40f10eed405a264034f79f01973.jpg");
        mImgUrlsList.add("http://i1.hdslb.com/bfs/archive/aded071aa1479ac7302bd57d6cbcef761419e740.jpg");
        mImgUrlsList.add("http://d.hiphotos.baidu.com/image/pic/item/f31fbe096b63f624f0d3ad2e8c44ebf81a4ca315.jpg");
        mImgUrlsList.add("http://d.hiphotos.baidu.com/image/pic/item/5fdf8db1cb134954b2fe01a75f4e9258d0094a15.jpg");
        mImgUrlsList.add("http://c.hiphotos.baidu.com/image/pic/item/9825bc315c6034a87ccffc42c2134954082376c7.jpg");
        mImgUrlsList.add("http://b.hiphotos.baidu.com/image/pic/item/f3d3572c11dfa9ecf333c4d46bd0f703908fc1d0.jpg");
        mImgUrlsList.add("http://upload.365jilin.com/2016/0820/1471686023587.jpg");
        mImgUrlsList.add("http://imgs.aixifan.com/content/2016_07_11/1468254644.gif");
        mImgUrlsList.add("http://i1.hdslb.com/bfs/archive/1d6f6483d6aab106dcf011c0be3243ab197505e3.jpg");
        mImgUrlsList.add("http://img0.imgtn.bdimg.com/it/u=393555490,627047088&fm=214&gp=0.jpg");
        mImgUrlsList.add("http://i2.hdslb.com/bfs/archive/0f2afafebf13691b3bdcbf5b81cf6f50c699f8d1.jpg");
        mImgUrlsList.add("http://imgsrc.baidu.com/forum/w=580/sign=3e2d233f982397ddd679980c6983b216/214a8f025aafa40f10eed405a264034f79f01973.jpg");
        mImgUrlsList.add("http://i1.hdslb.com/bfs/archive/aded071aa1479ac7302bd57d6cbcef761419e740.jpg");

        gvImages.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mImgUrlsList.size();
            }

            @Override
            public Object getItem(int position) {
                return mImgUrlsList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView mImageView = new ImageView(MainActivity.this);
                Glide.with(MainActivity.this).load(mImgUrlsList.get(position)).into(mImageView);
                return mImageView;
            }
        });

        gvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyDialogFragment myDialogFragment = MyDialogFragment
                        .build();
                /**
                 * 添加图片数据进去
                 */
                myDialogFragment.addImages((ArrayList<String>) mImgUrlsList);
                /**
                 * 弹出Dialog
                 */
                myDialogFragment.show(getSupportFragmentManager(),"tag");
            }
        });
    }
}
