package com.solaregde.wsd.comp.aopdemo.dxf.services;

import com.solaregde.wsd.comp.aopdemo.dxf.Request;
import com.solaregde.wsd.comp.aopdemo.dxf.Response;

public class ParsingService {

   public Response parseDxf(Request request) {
        int moules = parseModules(request);
        parseRoof(request.getDxf());
        Response response = new Response();
        response.setModules(moules);
        return response;
    }

    private int parseModules(Request dxf) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dxf.getDxf().length();
    }

    private int parseRoof(String dxf) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dxf.length();
    }
}
