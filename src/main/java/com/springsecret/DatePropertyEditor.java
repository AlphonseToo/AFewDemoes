package com.springsecret;

import java.beans.PropertyEditorSupport;

/**
 * DatePropertyEditor
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/26 09:15
 **/
public class DatePropertyEditor extends PropertyEditorSupport {

    private String datePattern;

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
//        DateTimeFormatter formatter = DateTimeFormat.forPattern(getDatePattern());
//        Date date = formatter.parseDateTime(text).toDate();
        setValue(text);
    }

    public String getDatePattern() {
        return "yyyy/MM/dd";
    }
}
