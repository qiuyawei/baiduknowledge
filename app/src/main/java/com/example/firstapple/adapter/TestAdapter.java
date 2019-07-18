package com.example.firstapple.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.firstapple.R;
import com.example.firstapple.bean.TestBean;

import java.util.List;

public class TestAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {

    public TestAdapter(int itemLayout, List<TestBean> testBeanList){
        super(itemLayout,testBeanList);
    }


    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {
        helper.setText(R.id.tv_title,item.getName());
        helper.addOnClickListener(R.id.bt_delete);
    }
}
