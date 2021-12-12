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
        Method abortCreation;
        Method freeze;
        Method addFontFromBuffer;
        Method addFontFromAssetManager;
        Method addFontFromAssetManager2;
        Constructor fontFamilyCtor;
        Class fontFamily;
        try {
            fontFamily = obtainFontFamily();
            fontFamilyCtor = obtainFontFamilyCtor(fontFamily);
            addFontFromAssetManager2 = obtainAddFontFromAssetManagerMethod(fontFamily);
            addFontFromAssetManager = obtainAddFontFromBufferMethod(fontFamily);
            addFontFromBuffer = obtainFreezeMethod(fontFamily);
            freeze = obtainAbortCreationMethod(fontFamily);
            abortCreation = obtainCreateFromFamiliesWithDefaultMethod(fontFamily);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            abortCreation = null;
            fontFamily = null;
            fontFamilyCtor = null;
            addFontFromAssetManager2 = null;
            addFontFromAssetManager = null;
            addFontFromBuffer = null;
            freeze = null;
        }
        this.mFontFamily = fontFamily;
        this.mFontFamilyCtor = fontFamilyCtor;
        this.mAddFontFromAssetManager = addFontFromAssetManager2;
        this.mAddFontFromBuffer = addFontFromAssetManager;
        this.mFreeze = addFontFromBuffer;
        this.mAbortCreation = freeze;
        this.mCreateFromFamiliesWithDefault = abortCreation;
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

    private boolean addFontFromAssetManager(Context context, Object family, String fileName, int ttcIndex, int weight, int style, @Nullable FontVariationAxis[] axes) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(family, context.getAssets(), fileName, 0, false, Integer.valueOf(ttcIndex), Integer.valueOf(weight), Integer.valueOf(style), axes)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromBuffer(Object family, ByteBuffer buffer, int ttcIndex, int weight, int style) {
        try {
            return ((Boolean) this.mAddFontFromBuffer.invoke(family, buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Integer.valueOf(style))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface createFromFamiliesWithDefault(Object family) {
        try {
            Object familyArray = Array.newInstance(this.mFontFamily, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, familyArray, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean freeze(Object family) {
        try {
            return ((Boolean) this.mFreeze.invoke(family, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void abortCreation(Object family) {
        try {
            this.mAbortCreation.invoke(family, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, Resources resources, int style) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, entry, resources, style);
        }
        Object fontFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = entry.getEntries();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFile : entries) {
            if (!addFontFromAssetManager(context, fontFamily, fontFile.getFileName(), fontFile.getTtcIndex(), fontFile.getWeight(), fontFile.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFile.getVariationSettings()))) {
                abortCreation(fontFamily);
                return null;
            }
        }
        if (!freeze(fontFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(fontFamily);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompatBaseImpl
    /* Code decompiled incorrectly, please refer to instructions dump */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r20, @android.support.annotation.Nullable android.os.CancellationSignal r21, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r22, int r23) {
        /*
            r19 = this;
            r7 = r19
            r8 = r21
            r9 = r22
            r10 = r23
            int r0 = r9.length
            r1 = 1
            r11 = 0
            if (r0 >= r1) goto L_0x000e
            return r11
        L_0x000e:
            boolean r0 = r19.isFontFamilyPrivateAPIAvailable()
            if (r0 != 0) goto L_0x0073
            android.support.v4.provider.FontsContractCompat$FontInfo r1 = r7.findBestInfo(r9, r10)
            android.content.ContentResolver r2 = r20.getContentResolver()
            android.net.Uri r0 = r1.getUri()     // Catch: IOException -> 0x0071
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r0 = r2.openFileDescriptor(r0, r3, r8)     // Catch: IOException -> 0x0071
            r3 = r0
            if (r3 != 0) goto L_0x0032
            if (r3 == 0) goto L_0x0031
            r3.close()     // Catch: IOException -> 0x0071
        L_0x0031:
            return r11
        L_0x0032:
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder     // Catch: Throwable -> 0x0059, all -> 0x0055
            java.io.FileDescriptor r4 = r3.getFileDescriptor()     // Catch: Throwable -> 0x0059, all -> 0x0055
            r0.<init>(r4)     // Catch: Throwable -> 0x0059, all -> 0x0055
            int r4 = r1.getWeight()     // Catch: Throwable -> 0x0059, all -> 0x0055
            android.graphics.Typeface$Builder r0 = r0.setWeight(r4)     // Catch: Throwable -> 0x0059, all -> 0x0055
            boolean r4 = r1.isItalic()     // Catch: Throwable -> 0x0059, all -> 0x0055
            android.graphics.Typeface$Builder r0 = r0.setItalic(r4)     // Catch: Throwable -> 0x0059, all -> 0x0055
            android.graphics.Typeface r0 = r0.build()     // Catch: Throwable -> 0x0059, all -> 0x0055
            if (r3 == 0) goto L_0x0054
            r3.close()     // Catch: IOException -> 0x0071
        L_0x0054:
            return r0
        L_0x0055:
            r0 = move-exception
            r4 = r0
            r5 = r11
            goto L_0x005f
        L_0x0059:
            r0 = move-exception
            r4 = r0
            throw r4     // Catch: all -> 0x005c
        L_0x005c:
            r0 = move-exception
            r5 = r4
            r4 = r0
        L_0x005f:
            if (r3 == 0) goto L_0x0070
            if (r5 == 0) goto L_0x006d
            r3.close()     // Catch: Throwable -> 0x0067, IOException -> 0x0071
            goto L_0x0070
        L_0x0067:
            r0 = move-exception
            r6 = r0
            r5.addSuppressed(r6)     // Catch: IOException -> 0x0071
            goto L_0x0070
        L_0x006d:
            r3.close()     // Catch: IOException -> 0x0071
        L_0x0070:
            throw r4     // Catch: IOException -> 0x0071
        L_0x0071:
            r0 = move-exception
            return r11
        L_0x0073:
            r12 = r20
            java.util.Map r0 = android.support.v4.provider.FontsContractCompat.prepareFontData(r12, r9, r8)
            java.lang.Object r13 = r19.newFamily()
            r1 = 0
            int r14 = r9.length
            r2 = 0
            r16 = r1
            r15 = 0
        L_0x0083:
            if (r15 >= r14) goto L_0x00b8
            r17 = r9[r15]
            android.net.Uri r1 = r17.getUri()
            java.lang.Object r1 = r0.get(r1)
            r18 = r1
            java.nio.ByteBuffer r18 = (java.nio.ByteBuffer) r18
            if (r18 != 0) goto L_0x0096
            goto L_0x00b5
        L_0x0096:
            int r4 = r17.getTtcIndex()
            int r5 = r17.getWeight()
            boolean r6 = r17.isItalic()
            r1 = r19
            r2 = r13
            r3 = r18
            boolean r1 = r1.addFontFromBuffer(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x00b2
            r7.abortCreation(r13)
            return r11
        L_0x00b2:
            r2 = 1
            r16 = r2
        L_0x00b5:
            int r15 = r15 + 1
            goto L_0x0083
        L_0x00b8:
            if (r16 != 0) goto L_0x00be
            r7.abortCreation(r13)
            return r11
        L_0x00be:
            boolean r1 = r7.freeze(r13)
            if (r1 != 0) goto L_0x00c5
            return r11
        L_0x00c5:
            android.graphics.Typeface r1 = r7.createFromFamiliesWithDefault(r13)
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r1, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int style) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, id, path, style);
        }
        Object fontFamily = newFamily();
        if (!addFontFromAssetManager(context, fontFamily, path, 0, -1, -1, null)) {
            abortCreation(fontFamily);
            return null;
        } else if (!freeze(fontFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(fontFamily);
        }
    }

    protected Class obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor obtainFontFamilyCtor(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getConstructor(new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method obtainAddFontFromBufferMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(ADD_FONT_FROM_BUFFER_METHOD, ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method obtainFreezeMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(FREEZE_METHOD, new Class[0]);
    }

    protected Method obtainAbortCreationMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class fontFamily) throws NoSuchMethodException {
        Method m = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(fontFamily, 1).getClass(), Integer.TYPE, Integer.TYPE);
        m.setAccessible(true);
        return m;
    }
}
