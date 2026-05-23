package com.learning.exp.view.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B1\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0017J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/learning/exp/view/adapter/LahangaRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/learning/exp/view/adapter/LahangaRecyclerViewAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/learning/exp/model/dataclasses/lahanga/LahangaResponseDataItem;", "Lkotlin/collections/ArrayList;", "onClickListener", "Lkotlin/Function1;", "", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "newList", "", "ViewHolder", "app_debug"})
public final class LahangaRecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.learning.exp.view.adapter.LahangaRecyclerViewAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem> list = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClickListener = null;
    
    public LahangaRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem> list, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClickListener) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.learning.exp.view.adapter.LahangaRecyclerViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.learning.exp.view.adapter.LahangaRecyclerViewAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem> newList) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/learning/exp/view/adapter/LahangaRecyclerViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "compIamge", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCompIamge", "()Landroid/widget/ImageView;", "compNameTextView", "Landroid/widget/TextView;", "getCompNameTextView", "()Landroid/widget/TextView;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView compIamge = null;
        private final android.widget.TextView compNameTextView = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final android.widget.ImageView getCompIamge() {
            return null;
        }
        
        public final android.widget.TextView getCompNameTextView() {
            return null;
        }
    }
}