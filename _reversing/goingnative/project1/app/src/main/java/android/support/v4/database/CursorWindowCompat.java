package android.support.v4.database;

import android.database.CursorWindow;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* loaded from: classes.dex */
public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CursorWindow(str, j);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            return new CursorWindow(str);
        }
        return new CursorWindow(false);
    }
}
