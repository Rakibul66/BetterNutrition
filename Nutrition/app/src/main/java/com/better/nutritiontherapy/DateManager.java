package com.better.nutritiontherapy;

import java.util.Date;


public class DateManager {

    private Date mDateFrom;
    private Date mDateTo;

    private static DateManager ourInstance = new DateManager();

    public static DateManager getInstance() {
        return ourInstance;
    }

    private DateManager() {
        mDateFrom = DateUtils.getFirstDateOfCurrentMonth();
        mDateTo = DateUtils.getLastDateOfCurrentMonth();
    }

    public Date getDateFrom() {
        return mDateFrom;
    }

    public void setDateFrom(Date mDateFrom) {
        this.mDateFrom = mDateFrom;
    }

    public Date getDateTo() {
        return mDateTo;
    }

    public void setDateTo(Date mDateTo) {
        this.mDateTo = mDateTo;
    }

}
