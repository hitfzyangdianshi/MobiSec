package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = i5;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x0037;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x0037;
     */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r46, android.support.constraint.solver.LinearSystem r47, int r48, int r49, android.support.constraint.solver.widgets.ChainHead r50) {
        /*
        // Method dump skipped, instructions count: 1379
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
