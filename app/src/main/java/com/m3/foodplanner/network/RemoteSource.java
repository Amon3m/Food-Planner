package com.m3.foodplanner.network;

public interface RemoteSource {
    public void enqueueCallFilter(NetworkDelegate networkDelegate, char c, String f);
    public void enqueueCallList(NetworkDelegate networkDelegate, char c);

    public void enqueueCallSelectedItem(NetworkDelegate networkDelegate, String f);

    public void enqueueCallSearched(NetworkDelegate networkDelegate, char c, String f);


//    public void enqueueCall(NetworkDelegate networkDelegate);
}
