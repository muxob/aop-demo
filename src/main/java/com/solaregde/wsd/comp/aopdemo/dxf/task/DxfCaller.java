package com.solaregde.wsd.comp.aopdemo.dxf.task;

import com.solaregde.wsd.comp.aopdemo.dxf.Request;
import com.solaregde.wsd.comp.aopdemo.dxf.services.ParsingService;

public class DxfCaller {

    public void callService(String dxf) {
        Request request = new Request();
        request.setDxf(dxf);
        ParsingService parsingService = new ParsingService();
        parsingService.parseDxf(request);
    }
}
