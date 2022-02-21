package com.bakuyuu;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author bakuyuu
 * @date 2022/2/21
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("localhost", 9090);
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            transport.open();
            String result = client.say("world");
            System.out.println(result);
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
