package com.example.firstapple;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.firstapple.adapter.TestAdapter;
import com.example.firstapple.bean.TestBean;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.center_button)
    Button centerButton;

    @BindView(R.id.recycleView)
    RecyclerView myRecycleView;

    private TestAdapter testAdapter;
    private List<TestBean> testBeans = new ArrayList<>();
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            testAdapter.loadMoreComplete();
            testAdapter.notifyItemInserted(testBeans.size()-1);
//            testAdapter.notifyDataSetChanged();
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        for (int i = 0; i < 20; i++) {
            TestBean testBean = new TestBean();
            testBean.setName("name" + i);
            testBean.setType(String.valueOf(i));
            testBeans.add(testBean);
        }
        testAdapter = new TestAdapter(R.layout.item_test, testBeans);
        testAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(TestActivity.this);
        myRecycleView.addItemDecoration(new DividerItemDecoration(TestActivity.this, DividerItemDecoration.VERTICAL));
        myRecycleView.setLayoutManager(new LinearLayoutManager(TestActivity.this));
        myRecycleView.setAdapter(testAdapter);
        testAdapter.setOnItemClickListener((adapter, view, position) -> Toast.makeText(TestActivity.this, "Click Position:" + position, Toast.LENGTH_SHORT).show());

        testAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.bt_delete) {
                testBeans.remove(position);
                adapter.notifyItemRemoved(position);
//                        adapter.notifyItemRangeRemoved(position,m);
            }
        });

        testAdapter.setOnLoadMoreListener(() -> {
            testAdapter.notifyLoadMoreToLoading();
            new Thread(this::run).start();
        }, myRecycleView);

    }


    @OnClick({R.id.center_button})
    public void onClick(View view) {
        if (view.getId() == R.id.center_button) {
            Snackbar.make(centerButton, "test snackBar", Snackbar.LENGTH_LONG).show();
        }

    }

    private void run() {
        try {
            TestBean testBean = new TestBean();
            int value = new Random().nextInt(100);
            testBean.setName("myName is " + value);
            testBean.setType(String.valueOf(value));
            testBeans.add(testBean);
            Thread.sleep(2000);
            mHandler.obtainMessage().sendToTarget();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
