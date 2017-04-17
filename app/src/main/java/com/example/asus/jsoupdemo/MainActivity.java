package com.example.asus.jsoupdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jsoupdemo.bean.MovieData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.tv_director)
    TextView tvDirector;
    @BindView(R.id.tv_scriptwriter)
    TextView tvScriptwriter;
    @BindView(R.id.tv_leader)
    TextView tvLeader;
    @BindView(R.id.tv_type)
    TextView tvType;

    String nameMovie;
    String URL = "https://movie.douban.com/";
    String URL1 = "https://book.douban.com/";
    String imageUrl;
    String detailUrl;
    @BindView(R.id.tv_name)
    TextView tvName;
    private MovieData movieData;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ivPic = (ImageView) findViewById(R.id.iv_pic);

        movieData = new MovieData();

        datas = new ArrayList<>();

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    //获取HTML
                    Document document = Jsoup.connect(URL1).get();
                    //.代表class，cover代表class的值
                    Elements a = document.select(".cover").select("a");
                    LogUtils.e("href   :   "+a.attr("href"));
                    LogUtils.e("title   :   "+a.attr("title"));
                    LogUtils.e("img   :   "+a.select("img").attr("src"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //执行事件
                subscriber.onNext(nameMovie);
                //结束事件
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

                LogUtils.e("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError");
                LogUtils.e(e.toString());
            }

            @Override
            public void onNext(String s) {
                LogUtils.e("onNext");
//                Glide.with(MainActivity.this).load(imageUrl).into(ivPic);

            }
        };

        observable.subscribeOn(Schedulers.io())//订阅的操作在io线程完成
                .observeOn(AndroidSchedulers.mainThread())//订阅者的操作在主线程中完成
                .subscribe(subscriber);

    }
}
