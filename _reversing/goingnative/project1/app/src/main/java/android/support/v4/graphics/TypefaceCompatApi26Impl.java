package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD;
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD;
    private static final String ADD_FONT_FROM_BUFFER_METHOD;
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD;
    private static final String DEFAULT_FAMILY;
    private static final String FONT_FAMILY_CLASS;
    private static final String FREEZE_METHOD;
    private static final int RESOLVE_BY_FONT_TABLE;
    private static final String TAG;
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class mFontFamily;
    protected final Constructor mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor constructor;
        Class cls = null;
        try {
            Class obtainFontFamily = obtainFontFamily();
            constructor = obtainFontFamilyCtor(obtainFontFamily);
            method5 = obtainAddFontFromAssetManagerMethod(obtainFontFamily);
            method4 = obtainAddFontFromBufferMethod(obtainFontFamily);
            method3 = obtainFreezeMethod(obtainFontFamily);
            method2 = obtainAbortCreationMethod(obtainFontFamily);
            method = obtainCreateFromFamiliesWithDefaultMethod(obtainFontFamily);
            cls = obtainFontFamily;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method5;
        this.mAddFontFromBuffer = method4;
        this.mFreeze = method3;
        this.mAbortCreation = method2;
        this.mCreateFromFamiliesWithDefault = method;
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.mAddFontFromAssetManager != null;
    }

    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.mAddFontFromBuffer.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void abortCreation(Object obj) {
        try {
            this.mAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : entries) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompatBaseImpl
    /* Code decompiled incorrectly, please refer to instructions dump */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r12, @android.support.annotation.Nullable android.os.CancellationSignal r13, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r14, int r15) {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0006
            return r2
        L_0x0006:
            boolean r0 = r11.isFontFamilyPrivateAPIAvailable()
            if (r0 != 0) goto L_0x0064
            android.support.v4.provider.FontsContractCompat$FontInfo r11 = r11.findBestInfo(r14, r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r14 = r11.getUri()     // Catch: IOException -> 0x0063
            java.lang.String r15 = "r"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r14, r15, r13)     // Catch: IOException -> 0x0063
            if (r12 != 0) goto L_0x0026
            if (r12 == 0) goto L_0x0025
            r12.close()     // Catch: IOException -> 0x0063
        L_0x0025:
            return r2
        L_0x0026:
            android.graphics.Typeface$Builder r13 = new android.graphics.Typeface$Builder     // Catch: Throwable -> 0x004c, all -> 0x0049
            java.io.FileDescriptor r14 = r12.getFileDescriptor()     // Catch: Throwable -> 0x004c, all -> 0x0049
            r13.<init>(r14)     // Catch: Throwable -> 0x004c, all -> 0x0049
            int r14 = r11.getWeight()     // Catch: Throwable -> 0x004c, all -> 0x0049
            android.graphics.Typeface$Builder r13 = r13.setWeight(r14)     // Catch: Throwable -> 0x004c, all -> 0x0049
            boolean r11 = r11.isItalic()     // Catch: Throwable -> 0x004c, all -> 0x0049
            android.graphics.Typeface$Builder r11 = r13.setItalic(r11)     // Catch: Throwable -> 0x004c, all -> 0x0049
            android.graphics.Typeface r11 = r11.build()     // Catch: Throwable -> 0x004c, all -> 0x0049
            if (r12 == 0) goto L_0x0048
            r12.close()     // Catch: IOException -> 0x0063
        L_0x0048:
            return r11
        L_0x0049:
            r11 = move-exception
            r13 = r2
            goto L_0x0052
        L_0x004c:
            r11 = move-exception
            throw r11     // Catch: all -> 0x004e
        L_0x004e:
            r13 = move-exception
            r10 = r13
            r13 = r11
            r11 = r10
        L_0x0052:
            if (r12 == 0) goto L_0x0062
            if (r13 == 0) goto L_0x005f
            r12.close()     // Catch: Throwable -> 0x005a, IOException -> 0x0063
            goto L_0x0062
        L_0x005a:
            r12 = move-exception
            r13.addSuppressed(r12)     // Catch: IOException -> 0x0063
            goto L_0x0062
        L_0x005f:
            r12.close()     // Catch: IOException -> 0x0063
        L_0x0062:
            throw r11     // Catch: IOException -> 0x0063
        L_0x0063:
            return r2
        L_0x0064:
            java.util.Map r12 = android.support.v4.provider.FontsContractCompat.prepareFontData(r12, r14, r13)
            java.lang.Object r13 = r11.newFamily()
            int r0 = r14.length
            r3 = 0
            r9 = r3
        L_0x006f:
            if (r9 >= r0) goto L_0x009c
            r4 = r14[r9]
            android.net.Uri r5 = r4.getUri()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L_0x0080
            goto L_0x0099
        L_0x0080:
            int r6 = r4.getTtcIndex()
            int r7 = r4.getWeight()
            boolean r8 = r4.isItalic()
            r3 = r11
            r4 = r13
            boolean r3 = r3.addFontFromBuffer(r4, r5, r6, r7, r8)
            if (r3 != 0) goto L_0x0098
            r11.abortCreation(r13)
            return r2
        L_0x0098:
            r3 = r1
        L_0x0099:
            int r9 = r9 + 1
            goto L_0x006f
        L_0x009c:
            if (r3 != 0) goto L_0x00a2
            r11.abortCreation(r13)
            return r2
        L_0x00a2:
            boolean r12 = r11.freeze(r13)
            if (r12 != 0) goto L_0x00a9
            return r2
        L_0x00a9:
            android.graphics.Typeface r11 = r11.createFromFamiliesWithDefault(r13)
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r15)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1, null)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }

    protected Class obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor obtainFontFamilyCtor(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method obtainAddFontFromBufferMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method obtainFreezeMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(FREEZE_METHOD, new Class[0]);
    }

    protected Method obtainAbortCreationMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
