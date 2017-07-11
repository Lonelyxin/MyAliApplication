package com.example.myaliapplication.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.R;
import com.suke.widget.SwitchButton;

public class ZiRanRenSheBaoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back, img_x, iv_shenglue;
    private TextView tv_title;
    private SwitchButton sb_button;
    private EditText edit_name, edit_num;
    private Button bt_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_ran_ren_she_bao);
        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("自然人缴纳社保费");
        img_back = (ImageView) findViewById(R.id.img_back);
        img_x = (ImageView) findViewById(R.id.img_x);
        img_x.setVisibility(View.VISIBLE);
        iv_shenglue = (ImageView) findViewById(R.id.iv_shenglue);
        iv_shenglue.setVisibility(View.INVISIBLE);
        img_back.setOnClickListener(this);
        img_x.setOnClickListener(this);

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_num = (EditText) findViewById(R.id.edit_num);

        sb_button = (SwitchButton) findViewById(R.id.sb_button);
        sb_button.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked) {
                    edit_name.setEnabled(true);
                    edit_num.setEnabled(true);
                } else {
                    edit_name.setEnabled(false);
                    edit_num.setEnabled(false);
                    edit_name.clearFocus();
                    edit_num.clearFocus();
                }
            }
        });

        initDialog();
    }

    public void initDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(ZiRanRenSheBaoActivity.this);
        final View dialogView = layoutInflater.inflate(R.layout.layout_dialog, null);
        final Dialog dialog = new Dialog(ZiRanRenSheBaoActivity.this);
        dialog.setContentView(dialogView);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        bt_confirm = (Button) findViewById(R.id.bt_confirm);
        bt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                View tv_confirm = dialogView.findViewById(R.id.tv_confirm);
                tv_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
            case R.id.img_x:
                finish();
                break;
            default:
                break;
        }
    }
}
