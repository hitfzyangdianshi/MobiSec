package android.support.constraint.solver;

import com.mobisec.gonative.BuildConfig;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    public int id;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        switch (type) {
            case UNRESTRICTED:
                StringBuilder sb = new StringBuilder();
                sb.append("U");
                int i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
                sb.append(i);
                return sb.toString();
            case CONSTANT:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("C");
                int i2 = uniqueConstantId + 1;
                uniqueConstantId = i2;
                sb2.append(i2);
                return sb2.toString();
            case SLACK:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("S");
                int i3 = uniqueSlackId + 1;
                uniqueSlackId = i3;
                sb3.append(i3);
                return sb3.toString();
            case ERROR:
                StringBuilder sb4 = new StringBuilder();
                sb4.append("e");
                int i4 = uniqueErrorId + 1;
                uniqueErrorId = i4;
                sb4.append(i4);
                return sb4.toString();
            case UNKNOWN:
                StringBuilder sb5 = new StringBuilder();
                sb5.append("V");
                int i5 = uniqueId + 1;
                uniqueId = i5;
                sb5.append(i5);
                return sb5.toString();
            default:
                throw new AssertionError(type.name());
        }
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mName = str;
        this.mType = type;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mType = type;
    }

    void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    String strengthsToString() {
        String str = this + "[";
        boolean z = true;
        boolean z2 = false;
        for (int i = 0; i < this.strengthVector.length; i++) {
            String str2 = str + this.strengthVector[i];
            if (this.strengthVector[i] > 0.0f) {
                z2 = false;
            } else if (this.strengthVector[i] < 0.0f) {
                z2 = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z = false;
            }
            if (i < this.strengthVector.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        if (z2) {
            str = str + " (-)";
        }
        if (!z) {
            return str;
        }
        return str + " (*)";
    }

    public final void addToRow(ArrayRow arrayRow) {
        for (int i = 0; i < this.mClientEquationsCount; i++) {
            if (this.mClientEquations[i] == arrayRow) {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        this.mClientEquationsCount++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r1 >= ((r0 - r2) - 1)) goto L_0x0021;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        r3 = r2 + r1;
        r6.mClientEquations[r3] = r6.mClientEquations[r3 + 1];
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        r6.mClientEquationsCount--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void removeFromRow(android.support.constraint.solver.ArrayRow r7) {
        /*
            r6 = this;
            int r0 = r6.mClientEquationsCount
            r1 = 0
            r2 = r1
        L_0x0004:
            if (r2 >= r0) goto L_0x002b
            android.support.constraint.solver.ArrayRow[] r3 = r6.mClientEquations
            r3 = r3[r2]
            if (r3 != r7) goto L_0x0028
        L_0x000c:
            int r7 = r0 - r2
            int r7 = r7 + -1
            if (r1 >= r7) goto L_0x0021
            android.support.constraint.solver.ArrayRow[] r7 = r6.mClientEquations
            int r3 = r2 + r1
            android.support.constraint.solver.ArrayRow[] r4 = r6.mClientEquations
            int r5 = r3 + 1
            r4 = r4[r5]
            r7[r3] = r4
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0021:
            int r7 = r6.mClientEquationsCount
            int r7 = r7 + -1
            r6.mClientEquationsCount = r7
            return
        L_0x0028:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.SolverVariable.removeFromRow(android.support.constraint.solver.ArrayRow):void");
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].variables.updateFromRow(this.mClientEquations[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String toString() {
        return BuildConfig.FLAVOR + this.mName;
    }
}
