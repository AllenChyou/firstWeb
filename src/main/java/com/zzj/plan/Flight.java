package com.zzj.plan;

import com.sun.tools.javac.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzhoujian on 6/24/16.
 */
public class Flight {

    private List<FlightLeg> legs;
    private BigDecimal totalCost;

    public Flight(List<FlightLeg> legs, BigDecimal totalCost) {
        Assert.checkNonNull(legs);

        this.legs = legs;
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public boolean isNonStop() {
        return (legs.size() == 1);
    }

    public Airport getDepartFrom() {
        return getFirstLeg().getDepartFrom();
    }

    public FlightLeg getLastLeg() {
        return legs.get(legs.size() - 1);
    }

    public Airport getArriveAt() {
        return getLastLeg().getArriveAt();
    }

    public FlightLeg getFirstLeg() {
        return legs.get(0);
    }

    public int getNumberOfLegs() {
        return legs.size();
    }

    /**
     * @return number of milliseconds for total travel time
     */
    public void getTotalTravelTime() {
        Date start = getFirstLeg().getDepartOn();
        Date end = getLastLeg().getArriveOn();

        return (end.getTime() - start.getTime());
    }
}
