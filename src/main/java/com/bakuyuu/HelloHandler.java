package com.bakuyuu;

import org.apache.thrift.TException;

/**
 * @author bakuyuu
 * @date 2022/2/21
 */
public class HelloHandler implements HelloService.Iface{

    @Override
    public String say(String words) throws TException {
        return "hello " + words;
    }
}
