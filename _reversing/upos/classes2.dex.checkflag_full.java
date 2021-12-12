
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
   Method Debug Info Offset: 0x15cd
   Method ID Offset: 0x7b8
    */

    undefined4 checkFlag(MainActivity ctx_00,String fl)

    {
      long lVar1;
      boolean bVar2;
      boolean bVar3;
      boolean bVar4;
      char cVar5;
      char cVar6;
      int iVar7;
      String ref;
      String pSVar8;
      String[] ppSVar9;
      PackageManager pPVar10;
      List ref_00;
      Iterator ref_01;
      Object pOVar11;
      int iVar12;
      Class ref_02;
      Method ref_03;
      PackageInfo pPVar13;
      byte[] pbVar14;
      CertificateFactory ref_04;
      Certificate ref_05;
      MessageDigest ref_06;
      int iVar15;
      int iVar16;
      String pSVar17;
      String pSVar18;
      boolean[] pbVar19;
      Streamer ref_07;
      StringBuilder pSVar20;
      Class[] ppCVar21;
      Object[] ppOVar22;
      Signature ref_08;
      InputStream ref_09;
      String pSVar23;
      
      pSVar17 = " ";
      pSVar18 = "mayb";
      checkCast(ctx_00,MainActivity);
      Activity.initActivity(ctx_00);
      FC.ctx = ctx_00;
      pbVar19 = new boolean[200];
      ref_07 = new Streamer();
      FC.lm(FC.m);
      iVar7 = fl.length();
      if (iVar7 != 69) {
        return 0;
      }
      bVar2 = fl.startsWith("MOBISEC{");
      pbVar19[0] = bVar2;
      ref = fl.substring(8);
      bVar2 = ref.endsWith("}");
      pbVar19[1] = bVar2;
      bVar2 = true;
      ref_07.step();
      if (MainActivity.g2 != false) {
        return 0;
      }
      ref_07.step();
      ref_07.step();
      bVar3 = ref.startsWith("this_is_");
      pbVar19[2] = bVar3;
      bVar3 = ref.endsWith("upos");
      pbVar19[3] = bVar3;
      cVar5 = ref.charAt(10);
      if ((cVar5 == 'c') || (cVar5 = ref.charAt(13), cVar5 == 'q')) {
        bVar3 = true;
      }
      else {
        bVar3 = false;
      }
      pbVar19[4] = bVar3;
      cVar5 = ref.charAt(3);
      cVar6 = ref.charAt(7);
      pbVar19[5] = (int)cVar5 + (int)cVar6 == 114;
      ref_07.step();
      bVar3 = ref.contains("really_");
      pbVar19[6] = bVar3;
      bVar3 = false;
      pSVar20 = new StringBuilder();
      pSVar8 = ctx_00.getString(2131427368);
      pSVar8 = FC.dec(pSVar8);
      pSVar20.append(pSVar8);
      pSVar20.append(pSVar17);
      pSVar8 = ctx_00.getString(2131427369);
      pSVar8 = FC.dec(pSVar8);
      pSVar20.append(pSVar8);
      pSVar8 = pSVar20.toString();
      pSVar8 = FC.ec(pSVar8);
      ppSVar9 = pSVar8.split("\n");
      iVar7 = 0;
      while (iVar7 < ppSVar9.length) {
        pSVar23 = ppSVar9[iVar7];
        pSVar20 = new StringBuilder();
        pSVar8 = ctx_00.getString(2131427370);
        pSVar8 = FC.dec(pSVar8);
        pSVar20.append(pSVar8);
        pSVar20.append(pSVar17);
        pSVar8 = ctx_00.getString(2131427369);
        pSVar8 = FC.dec(pSVar8);
        pSVar20.append(pSVar8);
        pSVar20.append("/");
        pSVar20.append(pSVar23);
        pSVar20.append("/maps");
        pSVar8 = pSVar20.toString();
        pSVar8 = FC.ec(pSVar8);
        pSVar23 = ctx_00.getString(2131427371);
        pSVar23 = FC.dec(pSVar23);
        bVar4 = pSVar8.contains(pSVar23);
        if (bVar4 != false) {
          bVar3 = true;
          break;
        }
        iVar7 = iVar7 + 1;
      }
      pbVar19[7] = bVar3;
      if (pbVar19[7] != false) {
        MainActivity.g2 = pbVar19[7];
        return 0;
      }
      ref_07.step();
      pSVar17 = ref.substring(14);
      bVar3 = pSVar17.endsWith("_evil");
      pbVar19[8] = bVar3;
      pSVar17 = ref.substring(9,13);
      bVar3 = pSVar17.endsWith("bam");
      pbVar19[9] = bVar3;
      ref_07.step();
      if (MainActivity.g4 != false) {
        return 0;
      }
      ref_07.step();
      pPVar10 = ctx_00.getPackageManager();
      ref_00 = pPVar10.getInstalledApplications(128);
      bVar3 = false;
      ref_01 = ref_00.iterator();
      do {
        bVar4 = ref_01.hasNext();
        if (bVar4 == false) goto LAB_50001fc6;
        pOVar11 = ref_01.next();
        checkCast(pOVar11,ApplicationInfo);
        pSVar8 = pOVar11.packageName;
        pSVar17 = ctx_00.getString(2131427372);
        pSVar17 = FC.dec(pSVar17);
        bVar4 = pSVar8.equals(pSVar17);
      } while (bVar4 == false);
      bVar3 = true;
    LAB_50001fc6:
      pbVar19[10] = bVar3;
      ref_07.step();
      iVar16 = 12;
      pSVar17 = ref.substring(4,10);
      pSVar17 = pSVar17.toLowerCase();
      bVar3 = pSVar17.equals("incred");
      iVar7 = (int)bVar3;
      pbVar19[11] = bVar3;
      if (MainActivity.g1 != false) {
        return 0;
      }
      ref_07.step();
      iVar12 = ref_07.step();
      if ((iVar12 < 1) && (MainActivity.g1 != false)) {
        ref_07.step();
        ref_07.step();
        ref_07.step();
        ref_07.step();
        ref_07.step();
      }
      else {
        pSVar17 = ref.substring(22);
        pSVar17 = pSVar17.toUpperCase();
        bVar2 = pSVar17.startsWith(pSVar18);
        pbVar19[iVar7] = bVar2;
        ref_07.step();
        if (pbVar19[iVar7 + -2] == false) {
          MainActivity.g3 = false;
          return 0;
        }
        if (MainActivity.g3 != false) {
          ref_07.step();
          return 0;
        }
        ref_07.step();
        pSVar17 = ctx_00.getString(2131427374);
        pSVar17 = FC.dec(pSVar17);
        ref_02 = Class.forName(pSVar17);
        pSVar17 = ctx_00.getString(2131427375);
        pSVar17 = FC.dec(pSVar17);
        ppCVar21 = new Class[0];
        ref_03 = ref_02.getMethod(pSVar17,ppCVar21);
        ppOVar22 = new Object[0];
        pOVar11 = ref_03.invoke(null,ppOVar22);
        checkCast(pOVar11,Boolean);
        bVar2 = pOVar11.booleanValue();
        pbVar19[iVar7 + 1] = bVar2;
        iVar16 = iVar7 + 2;
        if (pbVar19[iVar7 + 1] != false) {
          MainActivity.g1 = pbVar19[iVar7 + 1];
          return 0;
        }
        bVar2 = false;
      }
      if (bVar2) {
        return 0;
      }
      pSVar17 = ref.toLowerCase();
      pSVar17 = pSVar17.substring(11,14);
      cVar5 = pSVar17.charAt(1);
      pbVar19[iVar16] = cVar5 == '4';
      pSVar17 = ref.substring(22);
      pSVar17 = pSVar17.toUpperCase();
      bVar2 = pSVar17.startsWith(pSVar18);
      pbVar19[iVar16 + 1] = bVar2;
      pPVar10 = ctx_00.getPackageManager();
      pSVar17 = ctx_00.getPackageName();
      pPVar13 = pPVar10.getPackageInfo(pSVar17,64);
      ref_08 = pPVar13.signatures[0];
      pbVar14 = ref_08.toByteArray();
      ref_09 = new InputStream(pbVar14);
      ref_04 = CertificateFactory.getInstance("X509");
      ref_05 = ref_04.generateCertificate(ref_09);
      checkCast(ref_05,X509Certificate);
      ref_06 = MessageDigest.getInstance("SHA1");
      pbVar14 = ref_05.getEncoded();
      pbVar14 = ref_06.digest(pbVar14);
      pSVar17 = FC.th(pbVar14);
      pSVar18 = ctx_00.getString(2131427373);
      bVar2 = pSVar17.equals(pSVar18);
      pbVar19[iVar16 + 2] = bVar2;
      if (pbVar19[iVar16 + 2] == false) {
        MainActivity.g4 = true;
        return 0;
      }
      if ((pbVar19[0] != false) && (pbVar19[1] != false)) {
        iVar7 = 0;
        iVar16 = 100;
        while (iVar7 < 30) {
          pbVar19[iVar16] = true;
          pSVar20 = new StringBuilder();
          cVar5 = ref.charAt(iVar7 * 2);
          pSVar17 = Character.toString(cVar5);
          pSVar20.append(pSVar17);
          cVar5 = ref.charAt(iVar7 * 2 + 1);
          pSVar17 = Character.toString(cVar5);
          pSVar20.append(pSVar17);
          pSVar17 = pSVar20.toString();
          bVar2 = FC.ip(iVar7);
          if (bVar2 != false) {
            iVar12 = 0;
            while (iVar12 < iVar7) {
              ref_07.step();
              iVar12 = iVar12 + 1;
            }
          }
          iVar12 = ref_07.g2();
          iVar15 = ref_07.g2();
          pSVar17 = FC.r(pSVar17);
          lVar1 = FC.sq(pSVar17);
          if (lVar1 != FC.m[iVar12 & 255][(iVar15 & 65280) >> 8]) {
            pbVar19[iVar16] = false;
          }
          iVar16 = iVar16 + 1;
          iVar7 = iVar7 + 1;
        }
        iVar7 = iVar16 + -30;
        while( true ) {
          if (iVar16 <= iVar7) {
            pSVar17 = FC.h(fl);
            bVar2 =pSVar17.equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12");
            if (bVar2 != false) {
              return 1;
            }
            return 0;
          }
          if (pbVar19[iVar7] == false) break;
          iVar7 = iVar7 + 1;
        }
        return 0;
      }
      return 0;
    }
    
    