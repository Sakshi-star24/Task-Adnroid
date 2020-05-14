package com.example.internshipproject;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
public class DynamicViews {
    Context ctx;

    public DynamicViews(Context ctx){
        this.ctx=ctx;
    }
    static int count=0;

    public CheckBox descriptionCheckbox(Context context){
        count++;
        String c=String.valueOf(count);
        final ViewGroup.LayoutParams lparams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final CheckBox cb=new CheckBox(context);
        cb.setLayoutParams(lparams);
        cb.setText(c);
        return cb;
    }
}
