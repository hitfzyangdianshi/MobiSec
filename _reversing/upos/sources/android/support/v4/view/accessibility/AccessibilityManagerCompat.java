package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* loaded from: classes.dex */
public final class AccessibilityManagerCompat {

    @Deprecated
    /* loaded from: classes.dex */
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean z);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    /* loaded from: classes.dex */
    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z);
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager, AccessibilityStateChangeListener listener) {
        if (listener == null) {
            return false;
        }
        return manager.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(listener));
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager, AccessibilityStateChangeListener listener) {
        if (listener == null) {
            return false;
        }
        return manager.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(listener));
    }

    /* loaded from: classes.dex */
    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityStateChangeListener listener) {
            this.mListener = listener;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper) o).mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean enabled) {
            this.mListener.onAccessibilityStateChanged(enabled);
        }
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager manager) {
        return manager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager manager, int feedbackTypeFlags) {
        return manager.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return manager.isTouchExplorationEnabled();
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager manager, TouchExplorationStateChangeListener listener) {
        if (Build.VERSION.SDK_INT < 19 || listener == null) {
            return false;
        }
        return manager.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(listener));
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager manager, TouchExplorationStateChangeListener listener) {
        if (Build.VERSION.SDK_INT < 19 || listener == null) {
            return false;
        }
        return manager.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(listener));
    }

    @RequiresApi(19)
    /* loaded from: classes.dex */
    private static class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(@NonNull TouchExplorationStateChangeListener listener) {
            this.mListener = listener;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper) o).mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean enabled) {
            this.mListener.onTouchExplorationStateChanged(enabled);
        }
    }

    private AccessibilityManagerCompat() {
    }
}
