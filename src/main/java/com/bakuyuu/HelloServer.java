package com.bakuyuu;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author bakuyuu
 * @date 2022/2/21
 */
public class HelloServer {

    public static void main(String[] args) {
        try {
            HelloHandler handler = new HelloHandler();
            HelloService.Processor<HelloHandler> processor = new HelloService.Processor<>(handler);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer.Args params = new TServer.Args(serverTransport);
            params.processor(processor);
            params.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(params);
            System.out.println("Starting server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
