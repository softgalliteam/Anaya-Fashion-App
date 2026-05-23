package com.learning.exp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/learning/exp/viewmodel/ApiCallViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_detailScreenState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/learning/exp/viewmodel/ApiCallState;", "_screenState", "detailScreenState", "getDetailScreenState", "()Landroidx/lifecycle/MutableLiveData;", "repository", "Lcom/learning/exp/model/ApiCalRepository;", "screenState", "getScreenState", "getLahangaDetails", "", "id", "", "getLahangaList", "app_debug"})
public final class ApiCallViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.learning.exp.viewmodel.ApiCallState> _screenState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.learning.exp.viewmodel.ApiCallState> _detailScreenState = null;
    @org.jetbrains.annotations.NotNull()
    private final com.learning.exp.model.ApiCalRepository repository = null;
    
    public ApiCallViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.learning.exp.viewmodel.ApiCallState> getScreenState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.learning.exp.viewmodel.ApiCallState> getDetailScreenState() {
        return null;
    }
    
    public final void getLahangaList() {
    }
    
    public final void getLahangaDetails(int id) {
    }
}