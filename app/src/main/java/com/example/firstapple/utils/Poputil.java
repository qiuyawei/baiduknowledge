package com.example.firstapple.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class Poputil {
    private PopupWindow mPopupWindow;
    private Context mcContext;
    private View mContentView;
    public Poputil(Context context){
        this.mcContext=context;
    }



    private void innit(){
        mContentView= LayoutInflater.from(mcContext).inflate(null,null);
        mPopupWindow=new PopupWindow();
        mPopupWindow.setContentView(mContentView);
    }
}
