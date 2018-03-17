package com.danny.addressselector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.danny.addressselector.bean.CityBean;
import com.danny.addressselector.bean.DistrictBean;
import com.danny.addressselector.bean.ProvinceBean;
import com.danny.addressselector.callback.OnCityItemClickListener;
import com.danny.addressselector.view.CityPickerView;
import com.danny.addressselector.view.citywhell.CityConfig;

/**
 * Created by steve on 3/17/18.
 */

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = findViewById(R.id.city);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheel();
            }
        });
    }

    /**
     * 地址选择器
     */
    private void wheel() {
        CityConfig cityConfig = new CityConfig.Builder(TestActivity.this)
                .title("city")
                .confirmText("ok")
                .cancelText("cancel")
                .province("广东省")
                .city("深圳")
                .district("深圳")
                .build();

        CityPickerView.getInstance().setConfig(cityConfig);
        CityPickerView.getInstance().setOnCityItemClickListener(new OnCityItemClickListener() {

            /**
             * 选择城市回调
             * @param province 选择省对应bean
             * @param city 选择市对应bean
             * @param district 选择县（区）对应bean
             */
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                if (province != null && city != null && district != null) {
                    Log.d(TAG, "onSelected: 选择省:" + province.getName() + ",选择市:" + city.getName() + ",选择区:" + district.getName());
                }
            }

            /**
             * 取消选择城市
             */
            @Override
            public void onCancel() {
                Toast.makeText(TestActivity.this, "取消了城市选择", Toast.LENGTH_SHORT).show();
            }
        });
        CityPickerView.getInstance().showCityPicker(TestActivity.this);
    }
}
