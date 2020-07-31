package com.harnet.mvvmtop100celebritities.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.harnet.mvvmtop100celebritities.models.NicePlace;
import com.harnet.mvvmtop100celebritities.repositories.NicePlacesFromSiteRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces; // keep an observable list of places
//    private NicePlaceRepository mRepo; // link to places repository
    private NicePlacesFromSiteRepository m2Repo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNicePlaces != null){
            return;
        }
//        mRepo = NicePlaceRepository.getInstance();
//        mNicePlaces = mRepo.getNicePlaces();

        m2Repo = NicePlacesFromSiteRepository.getInstance();
        mNicePlaces = m2Repo.getNicePlaces();
    }

    @SuppressLint("StaticFieldLeak")
    public void addNewValue(final NicePlace nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNicePlaces.getValue();
                assert currentPlaces != null;
                currentPlaces.add(nicePlace);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mNicePlaces;
    }


    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}