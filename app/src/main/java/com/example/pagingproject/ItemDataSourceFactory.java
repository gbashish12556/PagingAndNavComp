package com.example.pagingproject;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.pagingproject.pojo.Item;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Item>> mutableLiveData = new MutableLiveData();

    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        mutableLiveData.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Item>> getLiveDataSource(){
        return mutableLiveData;
    }
}
