package com.springsecret;

/**
 * FXNewsProvider
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/7 16:19
 **/
public class FXNewsProvider {

    private IFXNewsListener listener;
    private IFXNewsPersister persister;

    public FXNewsProvider() {
        super();
    }

    public FXNewsProvider(IFXNewsListener listener, IFXNewsPersister persister) {
        this.listener = listener;
        this.persister = persister;
    }

    public IFXNewsListener setListener(IFXNewsListener newListener) {
        return this.listener = newListener;
    }


    public IFXNewsPersister setPersister(IFXNewsPersister newPersister) {
        return this.persister = newPersister;
    }

    void getAndPersistNews() {
        listener.getNews();
        persister.persisterNews();
    }
}
