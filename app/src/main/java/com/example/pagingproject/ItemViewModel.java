package com.example.pagingproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.pagingproject.pojo.Item;

public class ItemViewModel extends ViewModel {

    LiveData<PagedList<Item>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

    public ItemViewModel(){
        ItemDataSourceFactory itemDataSourceFactory  = new ItemDataSourceFactory();
        liveDataSource  = itemDataSourceFactory.getLiveDataSource();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20).build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory,pagedListConfig)).build();
    }
}
