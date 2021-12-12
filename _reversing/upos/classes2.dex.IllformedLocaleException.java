
/* WARNING: Removing unreachable block (ram,0x50011af0) */
/* WARNING: Removing unreachable block (ram,0x50011b22) */
/* WARNING: Removing unreachable block (ram,0x50011b1e) */
/* WARNING: Removing unreachable block (ram,0x50011b24) */
/* WARNING: Removing unreachable block (ram,0x50011c8c) */
/* WARNING: Removing unreachable block (ram,0x50011c96) */
/* WARNING: Removing unreachable block (ram,0x50011ca4) */
/* WARNING: Removing unreachable block (ram,0x50011cac) */
/* WARNING: Removing unreachable block (ram,0x50011cb4) */
/* WARNING: Removing unreachable block (ram,0x50011d14) */
/* WARNING: Removing unreachable block (ram,0x50011d16) */
/* WARNING: Removing unreachable block (ram,0x50011d1a) */
/* WARNING: Removing unreachable block (ram,0x50011d26) */
/* WARNING: Removing unreachable block (ram,0x50011dc4) */
/* WARNING: Removing unreachable block (ram,0x50011d70) */
/* WARNING: Removing unreachable block (ram,0x50011dc8) */
/* WARNING: Removing unreachable block (ram,0x50011dd4) */
/* WARNING: Removing unreachable block (ram,0x50011dd8) */
/* WARNING: Removing unreachable block (ram,0x50011dee) */
/* WARNING: Removing unreachable block (ram,0x50011e06) */
/* WARNING: Removing unreachable block (ram,0x50011e0a) */
/* WARNING: Removing unreachable block (ram,0x50011ddc) */
/* WARNING: Removing unreachable block (ram,0x50011de4) */
/* WARNING: Removing unreachable block (ram,0x50011de8) */
/* WARNING: Removing unreachable block (ram,0x50011ca0) */
/* WARNING: Removing unreachable block (ram,0x50011e0e) */
/* WARNING: Removing unreachable block (ram,0x50011e12) */
/* Class: Lcom/mobisec/upos/FC;
   Class Access Flags:
    ACC_PUBLIC
   
   Superclass: Ljava/lang/Object;
   Source File: FC.java
   
   Method Signature: Z( Landroid/content/Context;
    Ljava/lang/String;
     )
   Method Access Flags:
    ACC_PUBLIC
    ACC_STATIC
   
   Method Register Size: 30
   Method Incoming Size: 2
   Method Outgoing Size: 3
   Method Debug Info Offset: 0x13a43
   Method ID Offset: 0xccfc
    */

    undefined4 checkFlag(MainActivity ctx_00,String fl)

    {
      boolean bVar1;
      boolean bVar2;
      char cVar3;
      char cVar4;
      int iVar5;
      String ref;
      String pSVar6;
      String[] ppSVar7;
      PackageManager ref_00;
      List ref_01;
      Iterator ref_02;
      Object pOVar8;
      undefined4 uVar9;
      String pSVar10;
      BatchUpdateException ref_03;
      boolean[] pbVar11;
      Streamer ref_04;
      IllformedLocaleException ref_05;
      StringBuilder pSVar12;
      String pSVar13;
      
      pSVar10 = " ";
      checkCast(ctx_00,MainActivity);
      Activity.initActivity(ctx_00);
      FC.ctx = ctx_00;
      pbVar11 = new boolean[200];
      ref_04 = new Streamer();
      FC.lm(FC.m);
      iVar5 = fl.length();
      if (iVar5 != 69) {
        return 0;
      }
      bVar1 = fl.startsWith("MOBISEC{");
      pbVar11[0] = bVar1;
      ref = fl.substring(8);
      bVar1 = ref.endsWith("}");
      pbVar11[1] = bVar1;
      ref_04.step();
      if (MainActivity.g2 != false) {
        return 0;
      }
      ref_04.step();
      ref_04.step();
      bVar1 = ref.startsWith("this_is_");
      pbVar11[2] = bVar1;
      bVar1 = ref.endsWith("upos");
      pbVar11[3] = bVar1;
      cVar3 = ref.charAt(10);
      if ((cVar3 == 'c') || (cVar3 = ref.charAt(13), cVar3 == 'q')) {
        bVar1 = true;
      }
      else {
        bVar1 = false;
      }
      pbVar11[4] = bVar1;
      cVar3 = ref.charAt(3);
      cVar4 = ref.charAt(7);
      pbVar11[5] = (int)cVar3 + (int)cVar4 == 114;
      ref_04.step();
      bVar1 = ref.contains("really_");
      pbVar11[6] = bVar1;
      bVar1 = false;
      pSVar12 = new StringBuilder();
      pSVar6 = ctx_00.getString(2131427368);
      pSVar6 = FC.dec(pSVar6);
      pSVar12.append(pSVar6);
      pSVar12.append(pSVar10);
      pSVar6 = ctx_00.getString(2131427369);
      pSVar6 = FC.dec(pSVar6);
      pSVar12.append(pSVar6);
      pSVar6 = pSVar12.toString();
      pSVar6 = FC.ec(pSVar6);
      ppSVar7 = pSVar6.split("\n");
      iVar5 = 0;
      while (iVar5 < ppSVar7.length) {
        pSVar13 = ppSVar7[iVar5];
        pSVar12 = new StringBuilder();
        pSVar6 = ctx_00.getString(2131427370);
        pSVar6 = FC.dec(pSVar6);
        pSVar12.append(pSVar6);
        pSVar12.append(pSVar10);
        pSVar6 = ctx_00.getString(2131427369);
        pSVar6 = FC.dec(pSVar6);
        pSVar12.append(pSVar6);
        pSVar12.append("/");
        pSVar12.append(pSVar13);
        pSVar12.append("/maps");
        pSVar6 = pSVar12.toString();
        pSVar6 = FC.ec(pSVar6);
        pSVar13 = ctx_00.getString(2131427371);
        pSVar13 = FC.dec(pSVar13);
        bVar2 = pSVar6.contains(pSVar13);
        if (bVar2 != false) {
          bVar1 = true;
          break;
        }
        iVar5 = iVar5 + 1;
      }
      pbVar11[7] = bVar1;
      if (pbVar11[7] != false) {
        ref_03 = new(BatchUpdateException);
        uVar9 = ref_03.<init>();
        throwException(ref_03);
        return uVar9;
      }
      ref_04.step();
      pSVar10 = ref.substring(14);
      bVar1 = pSVar10.endsWith("_evil");
      pbVar11[8] = bVar1;
      pSVar10 = ref.substring(9,13);
      bVar1 = pSVar10.endsWith("bam");
      pbVar11[9] = bVar1;
      ref_04.step();
      if (MainActivity.g4 != false) {
        return 0;
      }
      ref_04.step();
      ref_00 = ctx_00.getPackageManager();
      ref_01 = ref_00.getInstalledApplications(128);
      bVar1 = false;
      ref_02 = ref_01.iterator();
      do {
        bVar2 = ref_02.hasNext();
        if (bVar2 == false) goto LAB_500117fa;
        pOVar8 = ref_02.next();
        checkCast(pOVar8,ApplicationInfo);
        pSVar6 = pOVar8.packageName;
        pSVar10 = ctx_00.getString(2131427372);
        pSVar10 = FC.dec(pSVar10);
        bVar2 = pSVar6.equals(pSVar10);
      } while (bVar2 == false);
      bVar1 = true;
    LAB_500117fa:
      pbVar11[10] = bVar1;
      ref_04.step();
      pSVar10 = ref.substring(4,10);
      pSVar10 = pSVar10.toLowerCase();
      bVar1 = pSVar10.equals("incred");
      pbVar11[11] = bVar1;
      if (MainActivity.g1 != false) {
        return 0;
      }
      ref_04.step();
      iVar5 = ref_04.step();
      if ((iVar5 < 1) && (MainActivity.g1 != false)) {
        ref_04.step();
        ref_04.step();
        ref_04.step();
        ref_04.step();
        ref_04.step();
        return 0;
      }
      ref_05 = new(IllformedLocaleException);
      uVar9 = ref_05.<init>();
      throwException(ref_05);
      return uVar9;
    }
    
    