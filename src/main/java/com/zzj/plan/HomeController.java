package com.zzj.plan;

import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Created by zhangzhoujian on 6/24/16.
 */
public class HomeController extends AbstractController {

    private static final int FIVE_MINUTES = 5*60;
    private FlightService flights;

    public HomeController() {
        setSupportedMethods(new String[]{METHOD_GET});
        setCacheSeconds(FIVE_MINUTES);
    }

    public void setFlights(FlightService flights) {
        this.flights = flights;
    }

    @Override
    protected ModelAndView handleRequestInternal(StandardMultipartHttpServletRequest)
}
