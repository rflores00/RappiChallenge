package com.adv.rappichallenge.Reader;


import com.adv.rappichallenge.interfaces.IDataRepository;
import com.adv.rappichallenge.interfaces.OnSelect_Listener;

/**
 * Created by Ruben Flores on 7/5/2016.
 */
public class ReaderService implements IDataRepository {
    private static ReaderService singleton;
    private IDataRepository _iDataRepository;

    private ReaderService() {

    }

    public static synchronized ReaderService getSingleton() {
        if (singleton == null) {
            singleton = new ReaderService();
        }

        return singleton;
    }

    public void set_iDataRepository(IDataRepository _iDataRepository) {
        this._iDataRepository = _iDataRepository;
    }

    @Override
    public void getFeeds(OnSelect_Listener listener) {
        listener.onStart();
        _iDataRepository.getFeeds(listener);
    }
}
