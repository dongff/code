package com.zjs.pddstate.config;

import java.text.*;
import java.util.Date;

class MyDateFormat extends DateFormat {

    private DateFormat dateFormat;
    private DateFormat formatNew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public MyDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return this.dateFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        Date date;
        try {
            date = this.formatNew.parse(source, pos);
        } catch (Exception var5) {
            date = this.dateFormat.parse(source, pos);
        }

        return date;
    }

    @Override
    public Date parse(String source) throws ParseException {
        Date date;
        try {
            date = this.formatNew.parse(source);
        } catch (Exception var4) {
            date = this.dateFormat.parse(source);
        }

        return date;
    }

    @Override
    public Object clone() {
        Object format = this.dateFormat.clone();
        return new MyDateFormat((DateFormat)format);
    }
}
