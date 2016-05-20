package com.cmbb.smartmarket.widget;

import android.content.Context;

import com.aigestudio.wheelpicker.view.WheelCurvedPicker;
import com.aigestudio.wheelpicker.widget.IDigital;

import java.util.List;

public class WheelPublishClassAPicker extends WheelCurvedPicker implements IDigital {

    public WheelPublishClassAPicker(Context context) {
        super(context);
    }

    @Override
    public void setDigitType(int type) {

    }

    @Override
    public void setData(List<String> data) {
        super.setData(data);
    }
}