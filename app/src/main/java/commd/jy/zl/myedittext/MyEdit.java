package commd.jy.zl.myedittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("AppCompatCustomView")
public class MyEdit extends EditText {

    private Context mContext;
    public final Date mDate;

    public MyEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        //获取当前时间
        mDate = new Date(System.currentTimeMillis());
    }

    public void onClick() {
        String localText = getText().toString();
        if (!TextUtils.isEmpty(localText)) {
            if (localText.length() >= 6 && localText.length() <= 8) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String localYear = splitText(localText, 0, 4);
                switch (localText.length()) {
                    case 6:
                        String localMonth6 = splitText(localText, 4, 5);
                        String localDay6 = splitText(localText, 5, 6);
                        String Date6 = localYear + "-0" + localMonth6 + "-0" + localDay6;
                        try {
                            Date date6 = format.parse(Date6);
                            if (mDate.getTime() > date6.getTime()) {
                                setText(localYear + "年" + localMonth6 + "月" + localDay6 + "日");
                            } else Toast.makeText(mContext, "你还没出生呢", Toast.LENGTH_SHORT).show();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        String localMonth7 = splitText(localText, 4, 6);
                        String localDay7 = splitText(localText, 6, 7);
                        String Date7 = localYear + "-" + localMonth7 + "-0" + localDay7;
                        try {
                            Date date7 = format.parse(Date7);
                            if (mDate.getTime() > date7.getTime()) {
                                int localMonth = date7.getMonth();
                                Log.i("tag", "onClick: "+localMonth+1);
                                if (date7.getMonth()+1 <= 12)
                                    setText(localYear + "年" + localMonth7 + "月" + localDay7 + "日");
                                else Toast.makeText(mContext, "请输入正确的出生月份", Toast.LENGTH_SHORT).show();
                            } else Toast.makeText(mContext, "你还没出生呢", Toast.LENGTH_SHORT).show();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 8:
                        String localMonth8 = splitText(localText, 4, 6);
                        String localDay8 = splitText(localText, 6, 8);
                        String Date8 = localYear + "-" + localMonth8 + "-" + localDay8;
                        try {
                            Date date8 = format.parse(Date8);
                            if (mDate.getTime() > date8.getTime()) {
                                setText(localYear + "年" + localMonth8 + "月" + localDay8 + "日");
                            } else Toast.makeText(mContext, "你还没出生呢", Toast.LENGTH_SHORT).show();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } else Toast.makeText(mContext, "输入格式错误", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(mContext, "不能为空", Toast.LENGTH_SHORT).show();

    }

    private String splitText(String text, int head, int trail) {
        return text.subSequence(head, trail).toString();
    }
}
