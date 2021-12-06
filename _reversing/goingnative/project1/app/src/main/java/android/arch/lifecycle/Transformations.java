package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: android.arch.lifecycle.Transformations.1
            @Override // android.arch.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                MediatorLiveData.this.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }

    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: android.arch.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // android.arch.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                LiveData<Y> liveData2 = (LiveData) Function.this.apply(x);
                if (this.mSource != liveData2) {
                    if (this.mSource != null) {
                        mediatorLiveData.removeSource(this.mSource);
                    }
                    this.mSource = liveData2;
                    if (this.mSource != null) {
                        mediatorLiveData.addSource(this.mSource, new Observer<Y>() { // from class: android.arch.lifecycle.Transformations.2.1
                            @Override // android.arch.lifecycle.Observer
                            public void onChanged(@Nullable Y y) {
                                mediatorLiveData.setValue(y);
                            }
                        });
                    }
                }
            }
        });
        return mediatorLiveData;
    }
}
