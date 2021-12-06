package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ConstraintWidgetGroup {
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions;
    int mGroupHeight;
    int mGroupWidth;
    public boolean mSkipSolver;
    List<ConstraintWidget> mStartHorizontalWidgets;
    List<ConstraintWidget> mStartVerticalWidgets;
    List<ConstraintWidget> mUnresolvedWidgets;
    HashSet<ConstraintWidget> mWidgetsToSetHorizontal;
    HashSet<ConstraintWidget> mWidgetsToSetVertical;
    List<ConstraintWidget> mWidgetsToSolve;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.mGroupWidth = -1;
        this.mGroupHeight = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{this.mGroupWidth, this.mGroupHeight};
        this.mStartHorizontalWidgets = new ArrayList();
        this.mStartVerticalWidgets = new ArrayList();
        this.mWidgetsToSetHorizontal = new HashSet<>();
        this.mWidgetsToSetVertical = new HashSet<>();
        this.mWidgetsToSolve = new ArrayList();
        this.mUnresolvedWidgets = new ArrayList();
        this.mConstrainedGroup = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.mGroupWidth = -1;
        this.mGroupHeight = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{this.mGroupWidth, this.mGroupHeight};
        this.mStartHorizontalWidgets = new ArrayList();
        this.mStartVerticalWidgets = new ArrayList();
        this.mWidgetsToSetHorizontal = new HashSet<>();
        this.mWidgetsToSetVertical = new HashSet<>();
        this.mWidgetsToSolve = new ArrayList();
        this.mUnresolvedWidgets = new ArrayList();
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }

    public List<ConstraintWidget> getStartWidgets(int i) {
        if (i == 0) {
            return this.mStartHorizontalWidgets;
        }
        if (i == 1) {
            return this.mStartVerticalWidgets;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<ConstraintWidget> getWidgetsToSet(int i) {
        if (i == 0) {
            return this.mWidgetsToSetHorizontal;
        }
        if (i == 1) {
            return this.mWidgetsToSetVertical;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addWidgetsToSet(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            this.mWidgetsToSetHorizontal.add(constraintWidget);
        } else if (i == 1) {
            this.mWidgetsToSetVertical.add(constraintWidget);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ConstraintWidget> getWidgetsToSolve() {
        if (!this.mWidgetsToSolve.isEmpty()) {
            return this.mWidgetsToSolve;
        }
        int size = this.mConstrainedGroup.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i);
            if (!constraintWidget.mOptimizerMeasurable) {
                getWidgetsToSolveTraversal((ArrayList) this.mWidgetsToSolve, constraintWidget);
            }
        }
        this.mUnresolvedWidgets.clear();
        this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
        this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
        return this.mWidgetsToSolve;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (!constraintWidget.mGroupsToSolver) {
            arrayList.add(constraintWidget);
            constraintWidget.mGroupsToSolver = true;
            if (!constraintWidget.isFullyResolved()) {
                if (constraintWidget instanceof Helper) {
                    Helper helper = (Helper) constraintWidget;
                    int i = helper.mWidgetsCount;
                    for (int i2 = 0; i2 < i; i2++) {
                        getWidgetsToSolveTraversal(arrayList, helper.mWidgets[i2]);
                    }
                }
                int length = constraintWidget.mListAnchors.length;
                for (int i3 = 0; i3 < length; i3++) {
                    ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3].mTarget;
                    if (constraintAnchor != null) {
                        ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
                        if (!(constraintAnchor == null || constraintWidget2 == constraintWidget.getParent())) {
                            getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateUnresolvedWidgets() {
        int size = this.mUnresolvedWidgets.size();
        for (int i = 0; i < size; i++) {
            updateResolvedDimension(this.mUnresolvedWidgets.get(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private void updateResolvedDimension(android.support.constraint.solver.widgets.ConstraintWidget r7) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetGroup.updateResolvedDimension(android.support.constraint.solver.widgets.ConstraintWidget):void");
    }
}
