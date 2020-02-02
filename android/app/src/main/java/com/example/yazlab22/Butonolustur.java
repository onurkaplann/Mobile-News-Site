package com.example.yazlab22;

import android.content.Context;

public class Butonolustur extends android.support.v7.widget.AppCompatButton{

    String veri;

    public Butonolustur(Context context, String veri){
        super(context);
        this.setText(""+veri);
    }
    public String getVeri(){return veri;}
    public void setVeri(){ this.veri = veri; }
}
