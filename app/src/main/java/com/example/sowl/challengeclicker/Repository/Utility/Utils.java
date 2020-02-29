package com.example.sowl.challengeclicker.Repository.Utility;

import android.widget.Toast;

import com.example.sowl.challengeclicker.Utilities.TApplication;

public class Utils {
//    public static String[] PROVIENCE = new String[]{"مازندران"};
//    public static String[] CITY = new String[]{"سوادکوه شمالی", "چالوس", "تنکابن", "آمل", "بهشهر", "نور", "عباس‌آباد", "نکا", "قائم‌شهر", "نوشهر", "محمودآباد", "بابلسر", "رودسر", "رامسر", "جویبار", "فریدونکنار", "سی‌مرغ", "کلاردشت", "ساری", "گلوگاه", "میاندورود", "بابل", "سوادکوه"};

//    public static Typeface MyFont(Context context) {
//        return Typeface.createFromAsset(context.getAssets(), "fonts/IRANSansNum_Medium.ttf");
//    }

    public static Toast ShowToast(String msg) {
        return Toast.makeText(TApplication.applicationContext, msg, Toast.LENGTH_SHORT);
    }
}
