package com.zzj.plan;

import com.sun.tools.javac.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhangzhoujian on 6/24/16.
 */
public class SpecialDeal {

    private Airport departFrom;
    private Airport arriveAt;
    private BigDecimal cost;
    private Date beginOn;
    private Date endOn;

    public SpecialDeal(Airport departFrom, Airport arriveAt, BigDecimal cost, Date beginOn, Date endOn) {
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.cost = cost;
        this.beginOn = beginOn;
        this.endOn = endOn;
    }

    public Airport getDepartFrom() {
        return departFrom;
    }

    public Airport getArriveAt() {
        return arriveAt;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public boolean isValidNow() {
        return isValidOn(new Date());
    }

    public boolean isValidOn(Date date) {
        Assert.checkNonNull(date, "Date must be not null");
        Date dateCopy = new Date(date.getTime());
        return ((dateCopy.equals(beginOn) || dateCopy.after(beginOn)) &&
                (dateCopy.equals(endOn) || dateCopy.before(endOn)));
    }
}
