package com.zzj.plan;

import java.util.List;

/**
 * Created by zhangzhoujian on 6/24/16.
 */
public interface FlightService {

    List<SpecialDeal> getSpecialDeals();

    List<Flight> findFlights(SearchFlights search);
}
