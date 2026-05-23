package com.learning.exp.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/learning/exp/model/ApiCallRetrofitService;", "", "getComputerList", "Ljava/util/ArrayList;", "Lcom/learning/exp/model/dataclasses/lahanga/LahangaResponseDataItem;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiCallRetrofitService {
    
    @retrofit2.http.GET(value = "objects")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComputerList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem>> $completion);
}