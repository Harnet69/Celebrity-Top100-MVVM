package com.harnet.mvvmtop100celebritities.repositories;

import androidx.lifecycle.MutableLiveData;

import com.harnet.mvvmtop100celebritities.models.NicePlace;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton pattern
 */
public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance(){
        if(instance == null){
            instance = new NicePlaceRepository();
        }
        return instance;
    }

    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet); // add usual list to observable MutableLiveData List
        return data;
    }

    private void setNicePlaces(){
        dataSet.add(
                new NicePlace("https://i.redd.it/lz69it7m5ly41.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/slt1sunr37351.png",
                        "Frozen Lake")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}











