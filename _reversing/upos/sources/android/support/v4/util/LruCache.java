package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public void resize(int maxSize) {
        if (maxSize > 0) {
            synchronized (this) {
                this.maxSize = maxSize;
            }
            trimToSize(maxSize);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    @Nullable
    public final V get(@NonNull K key) {
        V mapValue;
        if (key != null) {
            synchronized (this) {
                try {
                    try {
                        V mapValue2 = this.map.get(key);
                        if (mapValue2 != null) {
                            this.hitCount++;
                            return mapValue2;
                        }
                        this.missCount++;
                        V createdValue = create(key);
                        if (createdValue == null) {
                            return null;
                        }
                        synchronized (this) {
                            this.createCount++;
                            mapValue = this.map.put(key, createdValue);
                            if (mapValue != null) {
                                this.map.put(key, mapValue);
                            } else {
                                this.size += safeSizeOf(key, createdValue);
                            }
                        }
                        if (mapValue != null) {
                            entryRemoved(false, key, createdValue, mapValue);
                            return mapValue;
                        }
                        trimToSize(this.maxSize);
                        return createdValue;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            throw new NullPointerException("key == null");
        }
    }

    @Nullable
    public final V put(@NonNull K key, @NonNull V value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                try {
                    this.putCount++;
                    this.size += safeSizeOf(key, value);
                    V previous = this.map.put(key, value);
                    if (previous != null) {
                        this.size -= safeSizeOf(key, previous);
                    }
                    if (previous != null) {
                        entryRemoved(false, key, previous, value);
                    }
                    trimToSize(this.maxSize);
                    return previous;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void trimToSize(int r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0003:
            monitor-enter(r6)
            int r3 = r6.size     // Catch: all -> 0x0075
            if (r3 < 0) goto L_0x0056
            java.util.LinkedHashMap<K, V> r3 = r6.map     // Catch: all -> 0x0075
            boolean r3 = r3.isEmpty()     // Catch: all -> 0x0075
            if (r3 == 0) goto L_0x0014
            int r3 = r6.size     // Catch: all -> 0x0075
            if (r3 != 0) goto L_0x0056
        L_0x0014:
            int r3 = r6.size     // Catch: all -> 0x0075
            if (r3 <= r7) goto L_0x0054
            java.util.LinkedHashMap<K, V> r3 = r6.map     // Catch: all -> 0x0075
            boolean r3 = r3.isEmpty()     // Catch: all -> 0x0075
            if (r3 == 0) goto L_0x0021
            goto L_0x0054
        L_0x0021:
            java.util.LinkedHashMap<K, V> r3 = r6.map     // Catch: all -> 0x0075
            java.util.Set r3 = r3.entrySet()     // Catch: all -> 0x0075
            java.util.Iterator r3 = r3.iterator()     // Catch: all -> 0x0075
            java.lang.Object r3 = r3.next()     // Catch: all -> 0x0075
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: all -> 0x0075
            java.lang.Object r1 = r3.getKey()     // Catch: all -> 0x0075
            java.lang.Object r2 = r3.getValue()     // Catch: all -> 0x0052
            java.util.LinkedHashMap<K, V> r4 = r6.map     // Catch: all -> 0x0078
            r4.remove(r1)     // Catch: all -> 0x0078
            int r4 = r6.size     // Catch: all -> 0x0078
            int r5 = r6.safeSizeOf(r1, r2)     // Catch: all -> 0x0078
            int r4 = r4 - r5
            r6.size = r4     // Catch: all -> 0x0078
            int r4 = r6.evictionCount     // Catch: all -> 0x0078
            r5 = 1
            int r4 = r4 + r5
            r6.evictionCount = r4     // Catch: all -> 0x0078
            monitor-exit(r6)     // Catch: all -> 0x0078
            r6.entryRemoved(r5, r1, r2, r0)
            goto L_0x0003
        L_0x0052:
            r0 = move-exception
            goto L_0x0076
        L_0x0054:
            monitor-exit(r6)     // Catch: all -> 0x0075
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: all -> 0x0075
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: all -> 0x0075
            r3.<init>()     // Catch: all -> 0x0075
            java.lang.Class r4 = r6.getClass()     // Catch: all -> 0x0075
            java.lang.String r4 = r4.getName()     // Catch: all -> 0x0075
            r3.append(r4)     // Catch: all -> 0x0075
            java.lang.String r4 = ".sizeOf() is reporting inconsistent results!"
            r3.append(r4)     // Catch: all -> 0x0075
            java.lang.String r3 = r3.toString()     // Catch: all -> 0x0075
            r0.<init>(r3)     // Catch: all -> 0x0075
            throw r0     // Catch: all -> 0x0075
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            monitor-exit(r6)     // Catch: all -> 0x0078
            throw r0
        L_0x0078:
            r0 = move-exception
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.trimToSize(int):void");
    }

    @Nullable
    public final V remove(@NonNull K key) {
        if (key != null) {
            synchronized (this) {
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    V previous = this.map.remove(key);
                    if (previous != null) {
                        this.size -= safeSizeOf(key, previous);
                    }
                    if (previous != null) {
                        entryRemoved(false, key, previous, null);
                    }
                    return previous;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } else {
            throw new NullPointerException("key == null");
        }
    }

    protected void entryRemoved(boolean evicted, @NonNull K key, @NonNull V oldValue, @Nullable V newValue) {
    }

    @Nullable
    protected V create(@NonNull K key) {
        return null;
    }

    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result >= 0) {
            return result;
        }
        throw new IllegalStateException("Negative size: " + key + "=" + value);
    }

    protected int sizeOf(@NonNull K key, @NonNull V value) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int accesses;
        accesses = this.hitCount + this.missCount;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(accesses != 0 ? (this.hitCount * 100) / accesses : 0));
    }
}
