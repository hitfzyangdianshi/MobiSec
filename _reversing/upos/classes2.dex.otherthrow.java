
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
   Method Debug Info Offset: 0x15ed
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
      undefined4 uVar16;
      GeneralSecurityException ref_07;
      CertificateEncodingException ref_08;
      RejectedExecutionException ref_09;
      int iVar17;
      String pSVar18;
      BatchUpdateException ref_10;
      String pSVar19;
      boolean[] pbVar20;
      Streamer ref_11;
      StringBuilder pSVar21;
      Class[] ppCVar22;
      Object[] ppOVar23;
      Signature ref_12;
      InputStream ref_13;
      String pSVar24;
      
      pSVar18 = " ";
      pSVar19 = "mayb";
      checkCast(ctx_00,MainActivity);
      Activity.initActivity(ctx_00);
      FC.ctx = ctx_00;
      pbVar20 = new boolean[200];
      ref_11 = new Streamer();
      FC.lm(FC.m);
      iVar7 = fl.length();
      if (iVar7 != 69) {
        return 0;
      }
      bVar2 = fl.startsWith("MOBISEC{");
      pbVar20[0] = bVar2;
      ref = fl.substring(8);
      bVar2 = ref.endsWith("}");
      pbVar20[1] = bVar2;
      bVar2 = true;
      ref_11.step();
      if (MainActivity.g2 != false) {
        return 0;
      }
      ref_11.step();
      ref_11.step();
      bVar3 = ref.startsWith("this_is_");
      pbVar20[2] = bVar3;
      bVar3 = ref.endsWith("upos");
      pbVar20[3] = bVar3;
      cVar5 = ref.charAt(10);
      if ((cVar5 == 'c') || (cVar5 = ref.charAt(13), cVar5 == 'q')) {
        bVar3 = true;
      }
      else {
        bVar3 = false;
      }
      pbVar20[4] = bVar3;
      cVar5 = ref.charAt(3);
      cVar6 = ref.charAt(7);
      pbVar20[5] = (int)cVar5 + (int)cVar6 == 114;
      ref_11.step();
      bVar3 = ref.contains("really_");
      pbVar20[6] = bVar3;
      bVar3 = false;
      pSVar21 = new StringBuilder();
      pSVar8 = ctx_00.getString(2131427368);
      pSVar8 = FC.dec(pSVar8);
      pSVar21.append(pSVar8);
      pSVar21.append(pSVar18);
      pSVar8 = ctx_00.getString(2131427369);
      pSVar8 = FC.dec(pSVar8);
      pSVar21.append(pSVar8);
      pSVar8 = pSVar21.toString();
      pSVar8 = FC.ec(pSVar8);
      ppSVar9 = pSVar8.split("\n");
      iVar7 = 0;
      while (iVar7 < ppSVar9.length) {
        pSVar24 = ppSVar9[iVar7];
        pSVar21 = new StringBuilder();
        pSVar8 = ctx_00.getString(2131427370);
        pSVar8 = FC.dec(pSVar8);
        pSVar21.append(pSVar8);
        pSVar21.append(pSVar18);
        pSVar8 = ctx_00.getString(2131427369);
        pSVar8 = FC.dec(pSVar8);
        pSVar21.append(pSVar8);
        pSVar21.append("/");
        pSVar21.append(pSVar24);
        pSVar21.append("/maps");
        pSVar8 = pSVar21.toString();
        pSVar8 = FC.ec(pSVar8);
        pSVar24 = ctx_00.getString(2131427371);
        pSVar24 = FC.dec(pSVar24);
        bVar4 = pSVar8.contains(pSVar24);
        if (bVar4 != false) {
          bVar3 = true;
          break;
        }
        iVar7 = iVar7 + 1;
      }
      pbVar20[7] = bVar3;
      if (pbVar20[7] != false) {
        ref_10 = new(BatchUpdateException);
        uVar16 = ref_10.<init>();
        throwException(ref_10);
        return uVar16;
      }
      ref_11.step();
      pSVar18 = ref.substring(14);
      bVar3 = pSVar18.endsWith("_evil");
      pbVar20[8] = bVar3;
      pSVar18 = ref.substring(9,13);
      bVar3 = pSVar18.endsWith("bam");
      pbVar20[9] = bVar3;
      ref_11.step();
      if (MainActivity.g4 != false) {
        return 0;
      }
      ref_11.step();
      pPVar10 = ctx_00.getPackageManager();
      ref_00 = pPVar10.getInstalledApplications(128);
      bVar3 = false;
      ref_01 = ref_00.iterator();
      do {
        bVar4 = ref_01.hasNext();
        if (bVar4 == false) goto LAB_50001fee;
        pOVar11 = ref_01.next();
        checkCast(pOVar11,ApplicationInfo);
        pSVar8 = pOVar11.packageName;
        pSVar18 = ctx_00.getString(2131427372);
        pSVar18 = FC.dec(pSVar18);
        bVar4 = pSVar8.equals(pSVar18);
      } while (bVar4 == false);
      bVar3 = true;
    LAB_50001fee:
      pbVar20[10] = bVar3;
      ref_11.step();
      iVar17 = 12;
      pSVar18 = ref.substring(4,10);
      pSVar18 = pSVar18.toLowerCase();
      bVar3 = pSVar18.equals("incred");
      iVar7 = (int)bVar3;
      pbVar20[11] = bVar3;
      if (MainActivity.g1 != false) {
        return 0;
      }
      ref_11.step();
      iVar12 = ref_11.step();
      if ((iVar12 < 1) && (MainActivity.g1 != false)) {
        ref_11.step();
        ref_11.step();
        ref_11.step();
        ref_11.step();
        ref_11.step();
      }
      else {
        pSVar18 = ref.substring(22);
        pSVar18 = pSVar18.toUpperCase();
        bVar2 = pSVar18.startsWith(pSVar19);
        pbVar20[iVar7] = bVar2;
        ref_11.step();
        if (pbVar20[iVar7 + -2] == false) {
          ref_09 = new(RejectedExecutionException);
          uVar16 = ref_09.<init>();
          throwException(ref_09);
          return uVar16;
        }
        if (MainActivity.g3 != false) {
          ref_11.step();
          return 0;
        }
        ref_11.step();
        pSVar18 = ctx_00.getString(2131427374);
        pSVar18 = FC.dec(pSVar18);
        ref_02 = Class.forName(pSVar18);
        pSVar18 = ctx_00.getString(2131427375);
        pSVar18 = FC.dec(pSVar18);
        ppCVar22 = new Class[0];
        ref_03 = ref_02.getMethod(pSVar18,ppCVar22);
        ppOVar23 = new Object[0];
        pOVar11 = ref_03.invoke(null,ppOVar23);
        checkCast(pOVar11,Boolean);
        bVar2 = pOVar11.booleanValue();
        pbVar20[iVar7 + 1] = bVar2;
        iVar17 = iVar7 + 2;
        if (pbVar20[iVar7 + 1] != false) {
          ref_08 = new(CertificateEncodingException);
          uVar16 = ref_08.<init>();
          throwException(ref_08);
          return uVar16;
        }
        bVar2 = false;
      }
      if (bVar2) {
        return 0;
      }
      pSVar18 = ref.toLowerCase();
      pSVar18 = pSVar18.substring(11,14);
      cVar5 = pSVar18.charAt(1);
      pbVar20[iVar17] = cVar5 == '4';
      pSVar18 = ref.substring(22);
      pSVar18 = pSVar18.toUpperCase();
      bVar2 = pSVar18.startsWith(pSVar19);
      pbVar20[iVar17 + 1] = bVar2;
      pPVar10 = ctx_00.getPackageManager();
      pSVar18 = ctx_00.getPackageName();
      pPVar13 = pPVar10.getPackageInfo(pSVar18,64);
      ref_12 = pPVar13.signatures[0];
      pbVar14 = ref_12.toByteArray();
      ref_13 = new InputStream(pbVar14);
      ref_04 = CertificateFactory.getInstance("X509");
      ref_05 = ref_04.generateCertificate(ref_13);
      checkCast(ref_05,X509Certificate);
      ref_06 = MessageDigest.getInstance("SHA1");
      pbVar14 = ref_05.getEncoded();
      pbVar14 = ref_06.digest(pbVar14);
      pSVar18 = FC.th(pbVar14);
      pSVar19 = ctx_00.getString(2131427373);
      bVar2 = pSVar18.equals(pSVar19);
      pbVar20[iVar17 + 2] = bVar2;
      if (pbVar20[iVar17 + 2] != false) {
        if ((pbVar20[0] != false) && (pbVar20[1] != false)) {
          iVar7 = 0;
          iVar17 = 100;
          while (iVar7 < 30) {
            pbVar20[iVar17] = true;
            pSVar21 = new StringBuilder();
            cVar5 = ref.charAt(iVar7 * 2);
            pSVar18 = Character.toString(cVar5);
            pSVar21.append(pSVar18);
            cVar5 = ref.charAt(iVar7 * 2 + 1);
            pSVar18 = Character.toString(cVar5);
            pSVar21.append(pSVar18);
            pSVar18 = pSVar21.toString();
            bVar2 = FC.ip(iVar7);
            if (bVar2 != false) {
              iVar12 = 0;
              while (iVar12 < iVar7) {
                ref_11.step();
                iVar12 = iVar12 + 1;
              }
            }
            iVar12 = ref_11.g2();
            iVar15 = ref_11.g2();
            pSVar18 = FC.r(pSVar18);
            lVar1 = FC.sq(pSVar18);
            if (lVar1 != FC.m[iVar12 & 255][(iVar15 & 65280) >> 8]) {
              pbVar20[iVar17] = false;
            }
            iVar17 = iVar17 + 1;
            iVar7 = iVar7 + 1;
          }
          iVar7 = iVar17 + -30;
          while( true ) {
            if (iVar17 <= iVar7) {
              pSVar18 = FC.h(fl);
              bVar2 =pSVar18.equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12")
              ;
              if (bVar2 == false) {
                return 0;
              }
              return 1;
            }
            if (pbVar20[iVar7] == false) break;
            iVar7 = iVar7 + 1;
          }
          return 0;
        }
        return 0;
      }
      ref_07 = new(GeneralSecurityException);
      uVar16 = ref_07.<init>();
      throwException(ref_07);
      return uVar16;
    }
    
    