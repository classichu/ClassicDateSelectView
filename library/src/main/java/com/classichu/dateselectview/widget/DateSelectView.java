package com.classichu.dateselectview.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.classichu.dateselectview.R;
import com.classichu.dateselectview.tool.DateTool;
import com.classichu.dateselectview.tool.KeyBoardTool;
import com.classichu.dateselectview.tool.SizeTool;

import java.util.Date;

/**
 * Created by louisgeek on 2016/6/5.
 */
public class DateSelectView extends AppCompatTextView implements View.OnClickListener {
    private Context mContext;
    private String mNowDateText;
    private String startDateText;
    private String endDateText;
    private  final String DEFAULT_DATA_TIME="1970-01-01 00:00:00";
    public static final String DEFAULT_DATA="1970-01-01";
    public static final String DEFAULT_STR="请选择";
    private static final String TAG = "DateSelectView";
    public DateSelectView(Context context) {
        super(context);
        init(context);
    }

    public DateSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DateSelectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext=context;

        initDate();//初始化

        if (this.getPaddingTop()==0&&this.getPaddingBottom()==0&&this.getPaddingLeft()==0&&this.getPaddingRight()==0) {
            int paddingLeft_Right = SizeTool.dp2px(mContext, 10);
            int paddingTop_Bottom = SizeTool.dp2px(mContext, 6);
            this.setPadding(paddingLeft_Right, paddingTop_Bottom, paddingLeft_Right, paddingTop_Bottom);
        }
        this.setGravity(Gravity.CENTER_VERTICAL);
        this.setOnClickListener(this);
        this.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_expand_more_black_24dp,0);
        this.setBackgroundResource(R.drawable.selector_classic_text_item_bg);
    }


    @Override
    public void onClick(final View v) {
        //
        KeyBoardTool.hideKeyboard(v);

        DateSelectPopupWindow myPopupwindow=new DateSelectPopupWindow(mContext,mNowDateText,startDateText,endDateText);
        myPopupwindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,0);
        myPopupwindow.setOnDateSelectListener(new DateSelectPopupWindow.OnDateSelectListener() {
            @Override
            public void onDateSelect(int year, int monthOfYear, int dayOfMonth) {
               // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                if (year==0&&monthOfYear==0&&dayOfMonth==0){
                    if (mNowDateText.trim().equals("")||mNowDateText.trim().equals(DEFAULT_STR)) {
                        mNowDateText = DateTool.getChinaDate();
                    }
                }else{
                    mNowDateText=DateTool.getChinaDateFromCalendar(year,monthOfYear,dayOfMonth);
                }
                ((DateSelectView)v).setText(mNowDateText);
            }
        });
    }

    /**
     *
     * @param showDateText "yyyy-MM-dd"
     */
    public  void setupDateText(String showDateText){
        Log.i(TAG, "setupDateText  showDateText Only: showDateText:"+showDateText);
        setupDateText(showDateText,null,null);
    }

    /**
     *
     * @param showDateText  "yyyy-MM-dd"
     * @param startDateText  "yyyy-MM-dd"  or  null  or ""
     * @param endDateText  "yyyy-MM-dd"  or  null  or ""
     */
    public  void setupDateText(String showDateText, String startDateText, String endDateText){
        Log.i(TAG, "setupDateText: nowDateText:"+showDateText);
        Log.i(TAG, "setupDateText: startDateText:"+startDateText);
        Log.i(TAG, "setupDateText: endDateText:"+endDateText);
        if (showDateText==null||showDateText.trim().equals("")||showDateText.trim().equals("null")
                ||showDateText.contains(DEFAULT_DATA)||showDateText.equals(DEFAULT_STR))
        {
            mNowDateText=DEFAULT_STR;
        }else{
            //先转
            Date date=DateTool.parseStr2Date(showDateText,DateTool.FORMAT_DATE);
            if (date!=null) {
                mNowDateText = DateTool.parseDate2Str(date, DateTool.FORMAT_DATE);
            }else{
                mNowDateText=DEFAULT_STR;
            }
            if (mNowDateText.contains(DEFAULT_DATA)){
                mNowDateText=DEFAULT_STR;
            }
        }
        this.setText(mNowDateText);
        //
        this.startDateText=startDateText;
        this.endDateText=endDateText;
    }
    private   void initDate(){
        setupDateText(null);
    }

    @Deprecated
    public CharSequence getText() {
        return super.getText();
    }

    public String getNowSelectData(){
        String nowData="";
        if (this.getText() != null){
            nowData=this.getText().toString();
        }
       return  nowData.trim().equals("")||nowData.trim().equals(DEFAULT_STR)?DEFAULT_DATA:nowData;
    }

    /**
     * 未设置的返回当前时间
     * @return
     */
    public String getNowSelectDataFixedNowData(){
       return getNowSelectData()==null?DateTool.getChinaDate():getNowSelectData();
    }
}
