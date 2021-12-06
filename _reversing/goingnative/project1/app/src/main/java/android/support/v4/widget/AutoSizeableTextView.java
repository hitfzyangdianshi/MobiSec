package android.support.v4.widget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface AutoSizeableTextView {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

    @Override // android.support.v4.widget.AutoSizeableTextView
    int getAutoSizeMaxTextSize();

    @Override // android.support.v4.widget.AutoSizeableTextView
    int getAutoSizeMinTextSize();

    @Override // android.support.v4.widget.AutoSizeableTextView
    int getAutoSizeStepGranularity();

    @Override // android.support.v4.widget.AutoSizeableTextView
    int[] getAutoSizeTextAvailableSizes();

    @Override // android.support.v4.widget.AutoSizeableTextView
    int getAutoSizeTextType();

    @Override // android.support.v4.widget.AutoSizeableTextView
    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException;

    @Override // android.support.v4.widget.AutoSizeableTextView
    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException;

    @Override // android.support.v4.widget.AutoSizeableTextView
    void setAutoSizeTextTypeWithDefaults(int i);

    static {
        PLATFORM_SUPPORTS_AUTOSIZE = Build.VERSION.SDK_INT >= 27;
    }
}
