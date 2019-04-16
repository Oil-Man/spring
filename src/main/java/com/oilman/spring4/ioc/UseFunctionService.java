package com.oilman.spring4.ioc;

import org.springframework.stereotype.Service;

/**
 * 描述：service
 * Created by wangcw on 2019/4/8.
 */
@Service
public class UseFunctionService {
    //@Autowired
    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public void useFun(){
        functionService.fun();
    }
}
