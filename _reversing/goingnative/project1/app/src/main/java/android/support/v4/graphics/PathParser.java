package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String trim = str.substring(i2, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart + 1;
            i2 = nextStart;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (!(pathDataNodeArr[i].mType == pathDataNodeArr2[i].mType && pathDataNodeArr[i].mParams.length == pathDataNodeArr2[i].mParams.length)) {
                return false;
            }
        }
        return true;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[LOOP:0: B:3:0x0007->B:22:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private static void extract(java.lang.String r8, int r9, android.support.v4.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0035
            r6 = 69
            if (r5 == r6) goto L_0x0033
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0033
            switch(r5) {
                case 44: goto L_0x0035;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0031
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = r0
            r3 = r7
            goto L_0x0037
        L_0x0027:
            r10.mEndWithNegOrDot = r7
            goto L_0x0035
        L_0x002a:
            if (r1 == r9) goto L_0x0031
            if (r2 != 0) goto L_0x0031
            r10.mEndWithNegOrDot = r7
            goto L_0x0035
        L_0x0031:
            r2 = r0
            goto L_0x0037
        L_0x0033:
            r2 = r7
            goto L_0x0037
        L_0x0035:
            r2 = r0
            r4 = r7
        L_0x0037:
            if (r4 == 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003d:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.PathParser.extract(java.lang.String, int, android.support.v4.graphics.PathParser$ExtractFloatResult):void");
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public float[] mParams;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public char mType;

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = PathParser.copyOfRange(pathDataNode.mParams, 0, pathDataNode.mParams.length);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            for (int i = 0; i < pathDataNode.mParams.length; i++) {
                this.mParams[i] = (pathDataNode.mParams[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            int i3;
            char c3 = 0;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i3 = 7;
                    i = i3;
                    break;
                case 'C':
                case 'c':
                    i3 = 6;
                    i = i3;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i4 = 0;
            char c4 = c;
            while (i4 < fArr2.length) {
                float f19 = 0.0f;
                switch (c2) {
                    case 'A':
                        i2 = i4;
                        int i5 = i2 + 5;
                        int i6 = i2 + 6;
                        drawArc(path, f15, f16, fArr2[i5], fArr2[i6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f15 = fArr2[i5];
                        f16 = fArr2[i6];
                        f12 = f16;
                        f11 = f15;
                        break;
                    case 'C':
                        i2 = i4;
                        int i7 = i2 + 2;
                        int i8 = i2 + 3;
                        int i9 = i2 + 4;
                        int i10 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                        f15 = fArr2[i9];
                        float f20 = fArr2[i10];
                        float f21 = fArr2[i7];
                        float f22 = fArr2[i8];
                        f16 = f20;
                        f12 = f22;
                        f11 = f21;
                        break;
                    case 'H':
                        i2 = i4;
                        int i11 = i2 + 0;
                        path.lineTo(fArr2[i11], f16);
                        f15 = fArr2[i11];
                        break;
                    case 'L':
                        i2 = i4;
                        int i12 = i2 + 0;
                        int i13 = i2 + 1;
                        path.lineTo(fArr2[i12], fArr2[i13]);
                        f15 = fArr2[i12];
                        f16 = fArr2[i13];
                        break;
                    case 'M':
                        i2 = i4;
                        int i14 = i2 + 0;
                        f15 = fArr2[i14];
                        int i15 = i2 + 1;
                        f16 = fArr2[i15];
                        if (i2 <= 0) {
                            path.moveTo(fArr2[i14], fArr2[i15]);
                            f18 = f16;
                            f17 = f15;
                            break;
                        } else {
                            path.lineTo(fArr2[i14], fArr2[i15]);
                            break;
                        }
                    case 'Q':
                        i2 = i4;
                        int i16 = i2 + 0;
                        int i17 = i2 + 1;
                        int i18 = i2 + 2;
                        int i19 = i2 + 3;
                        path.quadTo(fArr2[i16], fArr2[i17], fArr2[i18], fArr2[i19]);
                        f2 = fArr2[i16];
                        f = fArr2[i17];
                        f15 = fArr2[i18];
                        f16 = fArr2[i19];
                        f11 = f2;
                        f12 = f;
                        break;
                    case 'S':
                        i2 = i4;
                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                            f4 = (f15 * 2.0f) - f11;
                            f3 = (f16 * 2.0f) - f12;
                        } else {
                            f4 = f15;
                            f3 = f16;
                        }
                        int i20 = i2 + 0;
                        int i21 = i2 + 1;
                        int i22 = i2 + 2;
                        int i23 = i2 + 3;
                        path.cubicTo(f4, f3, fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                        f2 = fArr2[i20];
                        f = fArr2[i21];
                        f15 = fArr2[i22];
                        f16 = fArr2[i23];
                        f11 = f2;
                        f12 = f;
                        break;
                    case 'T':
                        float f23 = f16;
                        float f24 = f15;
                        i2 = i4;
                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                            f24 = (f24 * 2.0f) - f11;
                            f23 = (f23 * 2.0f) - f12;
                        }
                        int i24 = i2 + 0;
                        int i25 = i2 + 1;
                        path.quadTo(f24, f23, fArr2[i24], fArr2[i25]);
                        f15 = fArr2[i24];
                        f16 = fArr2[i25];
                        f11 = f24;
                        f12 = f23;
                        break;
                    case 'V':
                        i2 = i4;
                        int i26 = i2 + 0;
                        path.lineTo(f15, fArr2[i26]);
                        f16 = fArr2[i26];
                        break;
                    case 'a':
                        int i27 = i4 + 5;
                        int i28 = i4 + 6;
                        i2 = i4;
                        drawArc(path, f15, f16, fArr2[i27] + f15, fArr2[i28] + f16, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                        f15 += fArr2[i27];
                        f16 += fArr2[i28];
                        f12 = f16;
                        f11 = f15;
                        break;
                    case 'c':
                        int i29 = i4 + 2;
                        int i30 = i4 + 3;
                        int i31 = i4 + 4;
                        int i32 = i4 + 5;
                        path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i29], fArr2[i30], fArr2[i31], fArr2[i32]);
                        f6 = fArr2[i29] + f15;
                        f5 = fArr2[i30] + f16;
                        f15 += fArr2[i31];
                        f16 += fArr2[i32];
                        f11 = f6;
                        f12 = f5;
                        i2 = i4;
                        break;
                    case 'h':
                        int i33 = i4 + 0;
                        path.rLineTo(fArr2[i33], 0.0f);
                        f15 += fArr2[i33];
                        i2 = i4;
                        break;
                    case 'l':
                        int i34 = i4 + 0;
                        int i35 = i4 + 1;
                        path.rLineTo(fArr2[i34], fArr2[i35]);
                        f15 += fArr2[i34];
                        f16 += fArr2[i35];
                        i2 = i4;
                        break;
                    case 'm':
                        int i36 = i4 + 0;
                        f15 += fArr2[i36];
                        int i37 = i4 + 1;
                        f16 += fArr2[i37];
                        if (i4 > 0) {
                            path.rLineTo(fArr2[i36], fArr2[i37]);
                        } else {
                            path.rMoveTo(fArr2[i36], fArr2[i37]);
                            f18 = f16;
                            f17 = f15;
                        }
                        i2 = i4;
                        break;
                    case 'q':
                        int i38 = i4 + 0;
                        int i39 = i4 + 1;
                        int i40 = i4 + 2;
                        int i41 = i4 + 3;
                        path.rQuadTo(fArr2[i38], fArr2[i39], fArr2[i40], fArr2[i41]);
                        f6 = fArr2[i38] + f15;
                        f5 = fArr2[i39] + f16;
                        f15 += fArr2[i40];
                        f16 += fArr2[i41];
                        f11 = f6;
                        f12 = f5;
                        i2 = i4;
                        break;
                    case 's':
                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                            f19 = f15 - f11;
                            f7 = f16 - f12;
                        } else {
                            f7 = 0.0f;
                        }
                        int i42 = i4 + 0;
                        int i43 = i4 + 1;
                        int i44 = i4 + 2;
                        int i45 = i4 + 3;
                        path.rCubicTo(f19, f7, fArr2[i42], fArr2[i43], fArr2[i44], fArr2[i45]);
                        f6 = fArr2[i42] + f15;
                        f5 = fArr2[i43] + f16;
                        f15 += fArr2[i44];
                        f16 += fArr2[i45];
                        f11 = f6;
                        f12 = f5;
                        i2 = i4;
                        break;
                    case 't':
                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                            f19 = f15 - f11;
                            f8 = f16 - f12;
                        } else {
                            f8 = 0.0f;
                        }
                        int i46 = i4 + 0;
                        int i47 = i4 + 1;
                        path.rQuadTo(f19, f8, fArr2[i46], fArr2[i47]);
                        float f25 = f19 + f15;
                        float f26 = f8 + f16;
                        f15 += fArr2[i46];
                        f16 += fArr2[i47];
                        f12 = f26;
                        f11 = f25;
                        i2 = i4;
                        break;
                    case 'v':
                        int i48 = i4 + 0;
                        path.rLineTo(0.0f, fArr2[i48]);
                        f16 += fArr2[i48];
                        i2 = i4;
                        break;
                    default:
                        i2 = i4;
                        break;
                }
                i4 = i2 + i;
                c4 = c2;
                c3 = 0;
            }
            fArr[c3] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f;
            double d4 = (double) f2;
            double d5 = (double) f5;
            double d6 = ((d3 * cos) + (d4 * sin)) / d5;
            double d7 = (double) f6;
            double d8 = ((((double) (-f)) * sin) + (d4 * cos)) / d7;
            double d9 = (double) f4;
            double d10 = ((((double) f3) * cos) + (d9 * sin)) / d5;
            double d11 = ((((double) (-f3)) * sin) + (d9 * cos)) / d7;
            double d12 = d6 - d10;
            double d13 = d8 - d11;
            double d14 = (d6 + d10) / 2.0d;
            double d15 = (d8 + d11) / 2.0d;
            double d16 = (d12 * d12) + (d13 * d13);
            if (d16 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d17 = (1.0d / d16) - 0.25d;
            if (d17 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d16);
                float sqrt = (float) (Math.sqrt(d16) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d17);
            double d18 = d12 * sqrt2;
            double d19 = sqrt2 * d13;
            if (z == z2) {
                d2 = d14 - d19;
                d = d15 + d18;
            } else {
                d2 = d14 + d19;
                d = d15 - d18;
            }
            double atan2 = Math.atan2(d8 - d, d6 - d2);
            double atan22 = Math.atan2(d11 - d, d10 - d2) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d20 = d2 * d5;
            double d21 = d * d7;
            arcToBezier(path, (d20 * cos) - (d21 * sin), (d20 * sin) + (d21 * cos), d5, d7, d3, d4, radians, atan2, atan22);
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ((double) ceil);
            int i = 0;
            double d19 = d6;
            double d20 = d5;
            double d21 = d8;
            while (i < ceil) {
                double d22 = d21 + d18;
                double sin3 = Math.sin(d22);
                double cos3 = Math.cos(d22);
                double d23 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d24 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d25 = (d12 * sin3) - (d13 * cos3);
                double d26 = (sin3 * d15) + (cos3 * d16);
                double d27 = d22 - d21;
                double tan = Math.tan(d27 / 2.0d);
                double sin4 = (Math.sin(d27) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d20 + (d14 * sin4)), (float) (d19 + (d17 * sin4)), (float) (d23 - (sin4 * d25)), (float) (d24 - (sin4 * d26)), (float) d23, (float) d24);
                i++;
                d19 = d24;
                d20 = d23;
                d15 = d15;
                d17 = d26;
                d14 = d25;
                d18 = d18;
                d16 = d16;
                d21 = d22;
                ceil = ceil;
                cos = cos;
                sin = sin;
                d10 = d3;
            }
        }
    }

    private PathParser() {
    }
}
