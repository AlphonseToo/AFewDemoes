package com.springsecret.chapter78;

/**
 * ISubjectProxy
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/3/16 18:55
 **/
public class ISubjectProxy implements ISubject {

    private ISubject iSubject;

    public ISubjectProxy(ISubject iSubject) {
        this.iSubject = iSubject;
    }

    @Override
    public void request() {
        System.out.println("Arrived ISubjectProxy!");
        iSubject.request();
    }

    public static void main(String[] args) {
        ISubject iSubject = new MySubject();
        ISubject iSubjectProxy = new ISubjectProxy(iSubject);
        iSubjectProxy.request();
    }
}
