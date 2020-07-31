package com.harnet.mvvmtop100celebritities.repositories;

import androidx.lifecycle.MutableLiveData;

import com.harnet.mvvmtop100celebritities.models.NicePlace;
import com.harnet.mvvmtop100celebritities.services.webService.WebContentController;

import java.util.ArrayList;
import java.util.List;

public class NicePlacesFromSiteRepository {
    private static NicePlacesFromSiteRepository instance = null;

    private ArrayList<NicePlace> celebrityDataSet = new ArrayList<>();

    private WebContentController webContentController = new WebContentController();

    private NicePlacesFromSiteRepository() {
    }

    public static NicePlacesFromSiteRepository getInstance(){
        if(instance == null){
            instance = new NicePlacesFromSiteRepository();
        }
        return instance;
    }

    // TODO only for test purpose
    public ArrayList<NicePlace> getCelebrityDataSet() {
        return celebrityDataSet;
    }

    // Get data from a site
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setCelebrityDataSet();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(celebrityDataSet); // add usual list to observable MutableLiveData List
        return data;
    }

    // fill a list of celebrities
    private void setCelebrityDataSet(){
        makeCelebrityList();
    }

    // generate staff list from webController data
    private void makeCelebrityList(){
        for(int i = 0; i< webContentController.getStaffNames().size(); i++){
            addCelebrity(webContentController.getStaffNames().get(i), webContentController.getStaffPhotoLink().get(i));
        }
    }

    // add person to staff
    private void addCelebrity(String name, String photoLink){
        celebrityDataSet.add(new NicePlace(photoLink, name));
    }
}