package com.springsecret.chapter78;

/**
 * IRequestProxy
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 18:51
 **/
public class IRequestProxy implements IRequest{

    private IRequest iRequest;

    public IRequestProxy(IRequest iRequest) {
        this.iRequest = iRequest;
    }

    @Override
    public void request() {
        System.out.println("Arrived IRequestProxy!");
        iRequest.request();
    }

    public static void main(String[] args) {
        IRequest iRequest = new MyRequest();
        IRequest iRequestProxy = new IRequestProxy(iRequest);
        iRequestProxy.request();
    }
}
