package com.example.star.checkbeauty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button showBtn;
    private ImageView showImg;
    private ArrayList<String> urls;
    private int curPos = 0;
    private int maxPos;
    private PictureLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = new PictureLoader();
        initData();
        initUI();
    }

    private void initData(){
        urls = new ArrayList<>();
        urls.add("http://pic1.win4000.com/pic/9/89/348a902ec5.jpg");
        urls.add("http://pic1.win4000.com/pic/5/97/c748b0409f.jpg");
        urls.add("http://pic1.win4000.com/pic/5/97/4631e54404.jpg");
        urls.add("http://pic1.win4000.com/pic/3/36/8df433dc74.jpg");
        maxPos = urls.size();
    }

    private void initUI(){
        showBtn = (Button) findViewById(R.id.button);
        showImg = (ImageView) findViewById(R.id.imageView);
        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                if (curPos > maxPos){
                    curPos = 0;
                } else {
                    loader.load(showImg, urls.get(curPos));
                    curPos++;
                }
                break;
        }
    }
}
