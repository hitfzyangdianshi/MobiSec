###### Class com.mobisec.upos.FC (com.mobisec.upos.FC)
.class public Lcom/mobisec/upos/FC;
.super Ljava/lang/Object;
.source "FC.java"


# static fields
.field public static ctx:Landroid/content/Context;

.field public static m:[[J


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .line 36
    const/4 v0, 0x0

    sput-object v0, Lcom/mobisec/upos/FC;->ctx:Landroid/content/Context;

    .line 38
    const/16 v0, 0x100

    filled-new-array {v0, v0}, [I

    move-result-object v0

    const-class v1, J

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[J

    sput-object v0, Lcom/mobisec/upos/FC;->m:[[J

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkFlag(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 30
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "fl"    # Ljava/lang/String;

    .line 43
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    const-string v3, " "

    const-string v4, "mayb"

    move-object v5, v1

    check-cast v5, Lcom/mobisec/upos/MainActivity;

    invoke-static {v5}, Landroid/support/v7/app/Activity;->initActivity(Lcom/mobisec/upos/MainActivity;)V

    .line 45
    sput-object v1, Lcom/mobisec/upos/FC;->ctx:Landroid/content/Context;

    .line 47
    const/16 v5, 0xc8

    new-array v5, v5, [Z

    .line 49
    .local v5, "fs":[Z
    new-instance v6, Lcom/mobisec/upos/Streamer;

    invoke-direct {v6}, Lcom/mobisec/upos/Streamer;-><init>()V

    .line 68
    .local v6, "s":Lcom/mobisec/upos/Streamer;
    const/4 v7, 0x0

    .line 73
    .local v7, "idx":I
    const/4 v8, 0x0

    :try_start_1b
    sget-object v10, Lcom/mobisec/upos/FC;->m:[[J
    :try_end_1d
    .catch Ljava/sql/BatchUpdateException; {:try_start_1b .. :try_end_1d} :catch_552
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_1b .. :try_end_1d} :catch_54b
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1b .. :try_end_1d} :catch_544
    .catch Ljava/security/GeneralSecurityException; {:try_start_1b .. :try_end_1d} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_1b .. :try_end_1d} :catch_538

    :try_start_1d
    invoke-static {v10}, Lcom/mobisec/upos/FC;->lm([[J)V

    .line 75
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v10
    :try_end_24
    .catch Ljava/sql/BatchUpdateException; {:try_start_1d .. :try_end_24} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_1d .. :try_end_24} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1d .. :try_end_24} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_1d .. :try_end_24} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_1d .. :try_end_24} :catch_538

    const/16 v11, 0x45

    if-eq v10, v11, :cond_29

    .line 76
    return v8

    .line 79
    :cond_29
    add-int/lit8 v10, v7, 0x1

    .end local v7    # "idx":I
    .local v10, "idx":I
    :try_start_2b
    const-string v11, "MOBISEC{"

    invoke-virtual {v2, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v11

    aput-boolean v11, v5, v7

    .line 81
    const/16 v7, 0x8

    invoke-virtual {v2, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v11
    :try_end_39
    .catch Ljava/sql/BatchUpdateException; {:try_start_2b .. :try_end_39} :catch_524
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_2b .. :try_end_39} :catch_51f
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2b .. :try_end_39} :catch_51a
    .catch Ljava/security/GeneralSecurityException; {:try_start_2b .. :try_end_39} :catch_516
    .catch Ljava/lang/Exception; {:try_start_2b .. :try_end_39} :catch_512

    .line 83
    .local v11, "core":Ljava/lang/String;
    add-int/lit8 v12, v10, 0x1

    .end local v10    # "idx":I
    .local v12, "idx":I
    :try_start_3b
    const-string v13, "}"

    invoke-virtual {v11, v13}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v13

    aput-boolean v13, v5, v10
    :try_end_43
    .catch Ljava/sql/BatchUpdateException; {:try_start_3b .. :try_end_43} :catch_50c
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_3b .. :try_end_43} :catch_506
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3b .. :try_end_43} :catch_500
    .catch Ljava/security/GeneralSecurityException; {:try_start_3b .. :try_end_43} :catch_4fb
    .catch Ljava/lang/Exception; {:try_start_3b .. :try_end_43} :catch_4f6

    .line 85
    const/4 v10, 0x1

    .line 89
    .local v10, "f":Z
    :try_start_44
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 94
    sget-boolean v15, Lcom/mobisec/upos/MainActivity;->g2:Z

    if-eqz v15, :cond_4c

    .line 96
    return v8

    .line 99
    :cond_4c
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 100
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I
    :try_end_52
    .catch Ljava/util/IllformedLocaleException; {:try_start_44 .. :try_end_52} :catch_2b2
    .catch Ljava/lang/NullPointerException; {:try_start_44 .. :try_end_52} :catch_2ad
    .catch Ljava/sql/BatchUpdateException; {:try_start_44 .. :try_end_52} :catch_50c
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_44 .. :try_end_52} :catch_506
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_44 .. :try_end_52} :catch_500
    .catch Ljava/security/GeneralSecurityException; {:try_start_44 .. :try_end_52} :catch_4fb
    .catch Ljava/lang/Exception; {:try_start_44 .. :try_end_52} :catch_4f6

    .line 103
    add-int/lit8 v15, v12, 0x1

    .end local v12    # "idx":I
    .local v15, "idx":I
    :try_start_54
    const-string v7, "this_is_"

    invoke-virtual {v11, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    aput-boolean v7, v5, v12
    :try_end_5c
    .catch Ljava/util/IllformedLocaleException; {:try_start_54 .. :try_end_5c} :catch_2a9
    .catch Ljava/lang/NullPointerException; {:try_start_54 .. :try_end_5c} :catch_2a5
    .catch Ljava/sql/BatchUpdateException; {:try_start_54 .. :try_end_5c} :catch_29f
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_54 .. :try_end_5c} :catch_299
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_54 .. :try_end_5c} :catch_293
    .catch Ljava/security/GeneralSecurityException; {:try_start_54 .. :try_end_5c} :catch_28e
    .catch Ljava/lang/Exception; {:try_start_54 .. :try_end_5c} :catch_289

    .line 105
    add-int/lit8 v7, v15, 0x1

    .end local v15    # "idx":I
    .restart local v7    # "idx":I
    :try_start_5e
    const-string v12, "upos"

    invoke-virtual {v11, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    aput-boolean v12, v5, v15
    :try_end_66
    .catch Ljava/util/IllformedLocaleException; {:try_start_5e .. :try_end_66} :catch_285
    .catch Ljava/lang/NullPointerException; {:try_start_5e .. :try_end_66} :catch_281
    .catch Ljava/sql/BatchUpdateException; {:try_start_5e .. :try_end_66} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_5e .. :try_end_66} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_5e .. :try_end_66} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_5e .. :try_end_66} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_5e .. :try_end_66} :catch_538

    .line 109
    add-int/lit8 v12, v7, 0x1

    .end local v7    # "idx":I
    .restart local v12    # "idx":I
    const/16 v15, 0xa

    :try_start_6a
    invoke-virtual {v11, v15}, Ljava/lang/String;->charAt(I)C

    move-result v9

    const/16 v14, 0x63

    const/16 v15, 0xd

    if-eq v9, v14, :cond_7f

    invoke-virtual {v11, v15}, Ljava/lang/String;->charAt(I)C

    move-result v9

    const/16 v14, 0x71

    if-ne v9, v14, :cond_7d

    goto :goto_7f

    :cond_7d
    const/4 v9, 0x0

    goto :goto_80

    :cond_7f
    :goto_7f
    const/4 v9, 0x1

    :goto_80
    aput-boolean v9, v5, v7
    :try_end_82
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_6a .. :try_end_82} :catch_27c
    .catch Ljava/util/IllformedLocaleException; {:try_start_6a .. :try_end_82} :catch_2b2
    .catch Ljava/lang/NullPointerException; {:try_start_6a .. :try_end_82} :catch_2ad
    .catch Ljava/sql/BatchUpdateException; {:try_start_6a .. :try_end_82} :catch_50c
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_6a .. :try_end_82} :catch_506
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_6a .. :try_end_82} :catch_500
    .catch Ljava/security/GeneralSecurityException; {:try_start_6a .. :try_end_82} :catch_4fb
    .catch Ljava/lang/Exception; {:try_start_6a .. :try_end_82} :catch_4f6

    .line 111
    add-int/lit8 v7, v12, 0x1

    .end local v12    # "idx":I
    .restart local v7    # "idx":I
    const/4 v9, 0x3

    :try_start_85
    invoke-virtual {v11, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    const/4 v14, 0x7

    invoke-virtual {v11, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    add-int/2addr v9, v14

    const/16 v14, 0x72

    if-ne v9, v14, :cond_95

    const/4 v9, 0x1

    goto :goto_96

    :cond_95
    const/4 v9, 0x0

    :goto_96
    aput-boolean v9, v5, v12

    .line 113
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I
    :try_end_9b
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_85 .. :try_end_9b} :catch_278
    .catch Ljava/util/IllformedLocaleException; {:try_start_85 .. :try_end_9b} :catch_285
    .catch Ljava/lang/NullPointerException; {:try_start_85 .. :try_end_9b} :catch_281
    .catch Ljava/sql/BatchUpdateException; {:try_start_85 .. :try_end_9b} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_85 .. :try_end_9b} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_85 .. :try_end_9b} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_85 .. :try_end_9b} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_85 .. :try_end_9b} :catch_538

    .line 115
    add-int/lit8 v9, v7, 0x1

    .end local v7    # "idx":I
    .local v9, "idx":I
    :try_start_9d
    const-string v12, "really_"

    invoke-virtual {v11, v12}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v12

    aput-boolean v12, v5, v7

    .line 119
    const/4 v7, 0x0

    .line 120
    .local v7, "found":Z
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const v14, 0x7f0b0028

    invoke-virtual {v1, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const v14, 0x7f0b0029

    invoke-virtual {v1, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v12, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/mobisec/upos/FC;->ec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const-string v12, "\n"

    invoke-virtual {v8, v12}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 121
    .local v8, "lines":[Ljava/lang/String;
    array-length v12, v8

    const/4 v15, 0x0

    :goto_da
    if-ge v15, v12, :cond_138

    aget-object v22, v8, v15

    move-object/from16 v23, v22

    .line 122
    .local v23, "line":Ljava/lang/String;
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const v14, 0x7f0b002a

    invoke-virtual {v1, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const v14, 0x7f0b0029

    invoke-virtual {v1, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v24 .. v24}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v14, "/"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object/from16 v14, v23

    .end local v23    # "line":Ljava/lang/String;
    .local v14, "line":Ljava/lang/String;
    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "/maps"

    invoke-virtual {v13, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 124
    .local v2, "maps":Ljava/lang/String;
    invoke-static {v2}, Lcom/mobisec/upos/FC;->ec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 125
    .local v13, "out":Ljava/lang/String;
    move-object/from16 v23, v2

    .end local v2    # "maps":Ljava/lang/String;
    .local v23, "maps":Ljava/lang/String;
    const v2, 0x7f0b002b

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v13, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2
    :try_end_12c
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_9d .. :try_end_12c} :catch_275
    .catch Ljava/util/IllformedLocaleException; {:try_start_9d .. :try_end_12c} :catch_271
    .catch Ljava/lang/NullPointerException; {:try_start_9d .. :try_end_12c} :catch_26d
    .catch Ljava/sql/BatchUpdateException; {:try_start_9d .. :try_end_12c} :catch_267
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_9d .. :try_end_12c} :catch_261
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_9d .. :try_end_12c} :catch_25b
    .catch Ljava/security/GeneralSecurityException; {:try_start_9d .. :try_end_12c} :catch_256
    .catch Ljava/lang/Exception; {:try_start_9d .. :try_end_12c} :catch_251

    if-eqz v2, :cond_130

    .line 126
    const/4 v7, 0x1

    .line 127
    goto :goto_138

    .line 121
    .end local v13    # "out":Ljava/lang/String;
    .end local v14    # "line":Ljava/lang/String;
    .end local v23    # "maps":Ljava/lang/String;
    :cond_130
    add-int/lit8 v15, v15, 0x1

    move-object/from16 v2, p1

    const v14, 0x7f0b0029

    goto :goto_da

    .line 131
    :cond_138
    :goto_138
    add-int/lit8 v2, v9, 0x1

    .end local v9    # "idx":I
    .local v2, "idx":I
    :try_start_13a
    aput-boolean v7, v5, v9

    .line 134
    add-int/lit8 v3, v2, -0x1

    aget-boolean v3, v5, v3

    if-nez v3, :cond_23d

    .line 136
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I
    :try_end_145
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_13a .. :try_end_145} :catch_24d
    .catch Ljava/util/IllformedLocaleException; {:try_start_13a .. :try_end_145} :catch_248
    .catch Ljava/lang/NullPointerException; {:try_start_13a .. :try_end_145} :catch_243
    .catch Ljava/sql/BatchUpdateException; {:try_start_13a .. :try_end_145} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_13a .. :try_end_145} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_13a .. :try_end_145} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_13a .. :try_end_145} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_13a .. :try_end_145} :catch_4d3

    .line 138
    add-int/lit8 v3, v2, 0x1

    const/16 v9, 0xe

    .end local v2    # "idx":I
    .local v3, "idx":I
    :try_start_149
    invoke-virtual {v11, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v12

    const-string v9, "_evil"

    invoke-virtual {v12, v9}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    aput-boolean v9, v5, v2
    :try_end_155
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_149 .. :try_end_155} :catch_238
    .catch Ljava/util/IllformedLocaleException; {:try_start_149 .. :try_end_155} :catch_233
    .catch Ljava/lang/NullPointerException; {:try_start_149 .. :try_end_155} :catch_22e
    .catch Ljava/sql/BatchUpdateException; {:try_start_149 .. :try_end_155} :catch_228
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_149 .. :try_end_155} :catch_222
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_149 .. :try_end_155} :catch_21c
    .catch Ljava/security/GeneralSecurityException; {:try_start_149 .. :try_end_155} :catch_217
    .catch Ljava/lang/Exception; {:try_start_149 .. :try_end_155} :catch_212

    .line 140
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "idx":I
    .restart local v2    # "idx":I
    const/16 v9, 0x9

    const/16 v12, 0xd

    :try_start_15b
    invoke-virtual {v11, v9, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    const-string v12, "bam"

    invoke-virtual {v9, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    aput-boolean v9, v5, v3

    .line 142
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 145
    sget-boolean v3, Lcom/mobisec/upos/MainActivity;->g4:Z

    if-eqz v3, :cond_170

    .line 146
    const/4 v3, 0x0

    return v3

    .line 149
    :cond_170
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I
    :try_end_173
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_15b .. :try_end_173} :catch_24d
    .catch Ljava/util/IllformedLocaleException; {:try_start_15b .. :try_end_173} :catch_248
    .catch Ljava/lang/NullPointerException; {:try_start_15b .. :try_end_173} :catch_243
    .catch Ljava/sql/BatchUpdateException; {:try_start_15b .. :try_end_173} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_15b .. :try_end_173} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_15b .. :try_end_173} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_15b .. :try_end_173} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_15b .. :try_end_173} :catch_4d3

    .line 153
    nop

    .line 160
    .end local v8    # "lines":[Ljava/lang/String;
    :try_start_174
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const/16 v8, 0x80

    invoke-virtual {v3, v8}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v3

    .line 161
    .local v3, "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v7, 0x0

    .line 162
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_183
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1a5

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    .line 164
    .local v9, "info":Landroid/content/pm/ApplicationInfo;
    iget-object v12, v9, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const v13, 0x7f0b002c

    invoke-virtual {v1, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12
    :try_end_1a0
    .catch Ljava/util/IllformedLocaleException; {:try_start_174 .. :try_end_1a0} :catch_248
    .catch Ljava/lang/NullPointerException; {:try_start_174 .. :try_end_1a0} :catch_243
    .catch Ljava/sql/BatchUpdateException; {:try_start_174 .. :try_end_1a0} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_174 .. :try_end_1a0} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_174 .. :try_end_1a0} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_174 .. :try_end_1a0} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_174 .. :try_end_1a0} :catch_4d3

    if-eqz v12, :cond_1a4

    .line 165
    const/4 v7, 0x1

    .line 166
    goto :goto_1a5

    .line 168
    .end local v9    # "info":Landroid/content/pm/ApplicationInfo;
    :cond_1a4
    goto :goto_183

    .line 169
    :cond_1a5
    :goto_1a5
    add-int/lit8 v8, v2, 0x1

    .end local v2    # "idx":I
    .local v8, "idx":I
    :try_start_1a7
    aput-boolean v7, v5, v2

    .line 173
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I
    :try_end_1ac
    .catch Ljava/util/IllformedLocaleException; {:try_start_1a7 .. :try_end_1ac} :catch_20d
    .catch Ljava/lang/NullPointerException; {:try_start_1a7 .. :try_end_1ac} :catch_208
    .catch Ljava/sql/BatchUpdateException; {:try_start_1a7 .. :try_end_1ac} :catch_202
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_1a7 .. :try_end_1ac} :catch_1fc
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1a7 .. :try_end_1ac} :catch_1f6
    .catch Ljava/security/GeneralSecurityException; {:try_start_1a7 .. :try_end_1ac} :catch_1f1
    .catch Ljava/lang/Exception; {:try_start_1a7 .. :try_end_1ac} :catch_1ec

    .line 175
    add-int/lit8 v2, v8, 0x1

    .end local v8    # "idx":I
    .restart local v2    # "idx":I
    const/4 v9, 0x4

    const/16 v12, 0xa

    :try_start_1b1
    invoke-virtual {v11, v9, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    const-string v12, "incred"

    invoke-virtual {v9, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    aput-boolean v9, v5, v8

    .line 178
    sget-boolean v8, Lcom/mobisec/upos/MainActivity;->g1:Z

    if-eqz v8, :cond_1c7

    .line 179
    const/4 v4, 0x0

    return v4

    .line 182
    :cond_1c7
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 185
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    move-result v8

    if-gtz v8, :cond_1e6

    sget-boolean v8, Lcom/mobisec/upos/MainActivity;->g1:Z

    if-eqz v8, :cond_1e6

    .line 189
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 190
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 191
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 192
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 193
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 234
    nop

    .end local v3    # "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    goto/16 :goto_31c

    .line 186
    .restart local v3    # "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    :cond_1e6
    new-instance v8, Ljava/util/IllformedLocaleException;

    invoke-direct {v8}, Ljava/util/IllformedLocaleException;-><init>()V

    .end local v2    # "idx":I
    .end local v5    # "fs":[Z
    .end local v6    # "s":Lcom/mobisec/upos/Streamer;
    .end local p0    # "ctx":Landroid/content/Context;
    .end local p1    # "fl":Ljava/lang/String;
    throw v8
    :try_end_1ec
    .catch Ljava/util/IllformedLocaleException; {:try_start_1b1 .. :try_end_1ec} :catch_248
    .catch Ljava/lang/NullPointerException; {:try_start_1b1 .. :try_end_1ec} :catch_243
    .catch Ljava/sql/BatchUpdateException; {:try_start_1b1 .. :try_end_1ec} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_1b1 .. :try_end_1ec} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1b1 .. :try_end_1ec} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_1b1 .. :try_end_1ec} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_1b1 .. :try_end_1ec} :catch_4d3

    .line 352
    .end local v3    # "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .end local v7    # "found":Z
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .restart local v5    # "fs":[Z
    .restart local v6    # "s":Lcom/mobisec/upos/Streamer;
    .restart local v8    # "idx":I
    .restart local p0    # "ctx":Landroid/content/Context;
    .restart local p1    # "fl":Ljava/lang/String;
    :catch_1ec
    move-exception v0

    move-object v1, v0

    move v2, v8

    goto/16 :goto_53b

    .line 348
    :catch_1f1
    move-exception v0

    move-object v1, v0

    move v2, v8

    goto/16 :goto_540

    .line 344
    :catch_1f6
    move-exception v0

    move-object v1, v0

    move v2, v8

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_1fc
    move-exception v0

    move-object v1, v0

    move v2, v8

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_202
    move-exception v0

    move-object v1, v0

    move v2, v8

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 232
    .restart local v10    # "f":Z
    .restart local v11    # "core":Ljava/lang/String;
    :catch_208
    move-exception v0

    move-object v2, v0

    move v9, v8

    goto/16 :goto_2b0

    .line 195
    :catch_20d
    move-exception v0

    move-object v2, v0

    move v9, v8

    goto/16 :goto_2b5

    .line 352
    .end local v8    # "idx":I
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .local v3, "idx":I
    :catch_212
    move-exception v0

    move-object v1, v0

    move v2, v3

    goto/16 :goto_53b

    .line 348
    :catch_217
    move-exception v0

    move-object v1, v0

    move v2, v3

    goto/16 :goto_540

    .line 344
    :catch_21c
    move-exception v0

    move-object v1, v0

    move v2, v3

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_222
    move-exception v0

    move-object v1, v0

    move v2, v3

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_228
    move-exception v0

    move-object v1, v0

    move v2, v3

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 232
    .restart local v10    # "f":Z
    .restart local v11    # "core":Ljava/lang/String;
    :catch_22e
    move-exception v0

    move-object v2, v0

    move v9, v3

    goto/16 :goto_2b0

    .line 195
    :catch_233
    move-exception v0

    move-object v2, v0

    move v9, v3

    goto/16 :goto_2b5

    .line 151
    :catch_238
    move-exception v0

    move-object v2, v0

    move v9, v3

    goto/16 :goto_27f

    .line 134
    .end local v3    # "idx":I
    .restart local v2    # "idx":I
    .restart local v7    # "found":Z
    .local v8, "lines":[Ljava/lang/String;
    :cond_23d
    :try_start_23d
    new-instance v3, Ljava/sql/BatchUpdateException;

    invoke-direct {v3}, Ljava/sql/BatchUpdateException;-><init>()V

    .end local v2    # "idx":I
    .end local v5    # "fs":[Z
    .end local v6    # "s":Lcom/mobisec/upos/Streamer;
    .end local p0    # "ctx":Landroid/content/Context;
    .end local p1    # "fl":Ljava/lang/String;
    throw v3
    :try_end_243
    .catch Ljava/util/IllegalFormatCodePointException; {:try_start_23d .. :try_end_243} :catch_24d
    .catch Ljava/util/IllformedLocaleException; {:try_start_23d .. :try_end_243} :catch_248
    .catch Ljava/lang/NullPointerException; {:try_start_23d .. :try_end_243} :catch_243
    .catch Ljava/sql/BatchUpdateException; {:try_start_23d .. :try_end_243} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_23d .. :try_end_243} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_23d .. :try_end_243} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_23d .. :try_end_243} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_23d .. :try_end_243} :catch_4d3

    .line 232
    .end local v7    # "found":Z
    .end local v8    # "lines":[Ljava/lang/String;
    .restart local v2    # "idx":I
    .restart local v5    # "fs":[Z
    .restart local v6    # "s":Lcom/mobisec/upos/Streamer;
    .restart local p0    # "ctx":Landroid/content/Context;
    .restart local p1    # "fl":Ljava/lang/String;
    :catch_243
    move-exception v0

    move v9, v2

    move-object v2, v0

    goto/16 :goto_2b0

    .line 195
    :catch_248
    move-exception v0

    move v9, v2

    move-object v2, v0

    goto/16 :goto_2b5

    .line 151
    :catch_24d
    move-exception v0

    move v9, v2

    move-object v2, v0

    goto :goto_27f

    .line 352
    .end local v2    # "idx":I
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .local v9, "idx":I
    :catch_251
    move-exception v0

    move-object v1, v0

    move v2, v9

    goto/16 :goto_53b

    .line 348
    :catch_256
    move-exception v0

    move-object v1, v0

    move v2, v9

    goto/16 :goto_540

    .line 344
    :catch_25b
    move-exception v0

    move-object v1, v0

    move v2, v9

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_261
    move-exception v0

    move-object v1, v0

    move v2, v9

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_267
    move-exception v0

    move-object v1, v0

    move v2, v9

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 232
    .restart local v10    # "f":Z
    .restart local v11    # "core":Ljava/lang/String;
    :catch_26d
    move-exception v0

    move-object v2, v0

    goto/16 :goto_2b0

    .line 195
    :catch_271
    move-exception v0

    move-object v2, v0

    goto/16 :goto_2b5

    .line 151
    :catch_275
    move-exception v0

    move-object v2, v0

    goto :goto_27f

    .end local v9    # "idx":I
    .local v7, "idx":I
    :catch_278
    move-exception v0

    move-object v2, v0

    move v9, v7

    goto :goto_27f

    .end local v7    # "idx":I
    .restart local v12    # "idx":I
    :catch_27c
    move-exception v0

    move-object v2, v0

    move v9, v12

    .line 152
    .end local v12    # "idx":I
    .local v2, "e":Ljava/util/IllegalFormatCodePointException;
    .restart local v9    # "idx":I
    :goto_27f
    const/4 v3, 0x0

    return v3

    .line 232
    .end local v2    # "e":Ljava/util/IllegalFormatCodePointException;
    .end local v9    # "idx":I
    .restart local v7    # "idx":I
    :catch_281
    move-exception v0

    move-object v2, v0

    move v9, v7

    goto :goto_2b0

    .line 195
    :catch_285
    move-exception v0

    move-object v2, v0

    move v9, v7

    goto :goto_2b5

    .line 352
    .end local v7    # "idx":I
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .restart local v15    # "idx":I
    :catch_289
    move-exception v0

    move-object v1, v0

    move v2, v15

    goto/16 :goto_53b

    .line 348
    :catch_28e
    move-exception v0

    move-object v1, v0

    move v2, v15

    goto/16 :goto_540

    .line 344
    :catch_293
    move-exception v0

    move-object v1, v0

    move v2, v15

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_299
    move-exception v0

    move-object v1, v0

    move v2, v15

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_29f
    move-exception v0

    move-object v1, v0

    move v2, v15

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 232
    .restart local v10    # "f":Z
    .restart local v11    # "core":Ljava/lang/String;
    :catch_2a5
    move-exception v0

    move-object v2, v0

    move v9, v15

    goto :goto_2b0

    .line 195
    :catch_2a9
    move-exception v0

    move-object v2, v0

    move v9, v15

    goto :goto_2b5

    .line 232
    .end local v15    # "idx":I
    .restart local v12    # "idx":I
    :catch_2ad
    move-exception v0

    move-object v2, v0

    move v9, v12

    .line 233
    .end local v12    # "idx":I
    .local v2, "e":Ljava/lang/NullPointerException;
    .restart local v9    # "idx":I
    :goto_2b0
    const/4 v3, 0x0

    return v3

    .line 195
    .end local v2    # "e":Ljava/lang/NullPointerException;
    .end local v9    # "idx":I
    .restart local v12    # "idx":I
    :catch_2b2
    move-exception v0

    move-object v2, v0

    move v9, v12

    .line 196
    .end local v12    # "idx":I
    .local v2, "e":Ljava/util/IllformedLocaleException;
    .restart local v9    # "idx":I
    :goto_2b5
    add-int/lit8 v7, v9, 0x1

    const/16 v3, 0x16

    .end local v9    # "idx":I
    .restart local v7    # "idx":I
    :try_start_2b9
    invoke-virtual {v11, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    aput-boolean v3, v5, v9

    .line 198
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 200
    add-int/lit8 v3, v7, -0x3

    aget-boolean v3, v5, v3

    if-eqz v3, :cond_4f0

    .line 202
    sget-boolean v3, Lcom/mobisec/upos/MainActivity;->g3:Z

    if-eqz v3, :cond_2d9

    .line 203
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 204
    const/4 v3, 0x0

    return v3

    .line 207
    :cond_2d9
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I
    :try_end_2dc
    .catch Ljava/sql/BatchUpdateException; {:try_start_2b9 .. :try_end_2dc} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_2b9 .. :try_end_2dc} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2b9 .. :try_end_2dc} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_2b9 .. :try_end_2dc} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_2b9 .. :try_end_2dc} :catch_538

    .line 213
    const v3, 0x7f0b002e

    :try_start_2df
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    .line 214
    .local v3, "c":Ljava/lang/Class;
    const v8, 0x7f0b002f

    invoke-virtual {v1, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    new-array v12, v9, [Ljava/lang/Class;

    invoke-virtual {v3, v8, v12}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v8

    .line 215
    .local v8, "m":Ljava/lang/reflect/Method;
    const/4 v12, 0x0

    new-array v13, v9, [Ljava/lang/Object;

    invoke-virtual {v8, v12, v13}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Boolean;

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    .line 216
    .local v9, "res":Z
    aput-boolean v9, v5, v7
    :try_end_30c
    .catch Ljava/lang/Exception; {:try_start_2df .. :try_end_30c} :catch_30d
    .catch Ljava/sql/BatchUpdateException; {:try_start_2df .. :try_end_30c} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_2df .. :try_end_30c} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2df .. :try_end_30c} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_2df .. :try_end_30c} :catch_53d

    .line 223
    .end local v3    # "c":Ljava/lang/Class;
    .end local v8    # "m":Ljava/lang/reflect/Method;
    .end local v9    # "res":Z
    goto :goto_312

    .line 218
    :catch_30d
    move-exception v0

    move-object v3, v0

    .line 222
    .local v3, "ex":Ljava/lang/Exception;
    const/4 v8, 0x0

    :try_start_310
    aput-boolean v8, v5, v7

    .line 224
    .end local v3    # "ex":Ljava/lang/Exception;
    :goto_312
    add-int/lit8 v7, v7, 0x1

    .line 228
    add-int/lit8 v3, v7, -0x1

    aget-boolean v3, v5, v3

    if-nez v3, :cond_4ea

    .line 230
    const/4 v10, 0x0

    .line 234
    .end local v2    # "e":Ljava/util/IllformedLocaleException;
    move v2, v7

    .line 236
    .end local v7    # "idx":I
    .local v2, "idx":I
    :goto_31c
    if-eqz v10, :cond_320

    const/4 v3, 0x0

    return v3

    .line 238
    :cond_320
    add-int/lit8 v7, v2, 0x1

    .end local v2    # "idx":I
    .restart local v7    # "idx":I
    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    const/16 v8, 0xb

    const/16 v9, 0xe

    invoke-virtual {v3, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    const/4 v8, 0x1

    invoke-virtual {v3, v8}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v8, 0x34

    if-ne v3, v8, :cond_339

    const/4 v3, 0x1

    goto :goto_33a

    :cond_339
    const/4 v3, 0x0

    :goto_33a
    aput-boolean v3, v5, v2
    :try_end_33c
    .catch Ljava/sql/BatchUpdateException; {:try_start_310 .. :try_end_33c} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_310 .. :try_end_33c} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_310 .. :try_end_33c} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_310 .. :try_end_33c} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_310 .. :try_end_33c} :catch_538

    .line 240
    add-int/lit8 v2, v7, 0x1

    const/16 v3, 0x16

    .end local v7    # "idx":I
    .restart local v2    # "idx":I
    :try_start_340
    invoke-virtual {v11, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    aput-boolean v3, v5, v7

    .line 246
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 247
    .local v3, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4
    :try_end_356
    .catch Ljava/sql/BatchUpdateException; {:try_start_340 .. :try_end_356} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_340 .. :try_end_356} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_340 .. :try_end_356} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_340 .. :try_end_356} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_340 .. :try_end_356} :catch_4d3

    .line 248
    .local v4, "packageName":Ljava/lang/String;
    const/16 v7, 0x40

    .line 249
    .local v7, "flags":I
    const/4 v8, 0x0

    .line 251
    .local v8, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_359
    invoke-virtual {v3, v4, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v9
    :try_end_35d
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_359 .. :try_end_35d} :catch_35f
    .catch Ljava/sql/BatchUpdateException; {:try_start_359 .. :try_end_35d} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_359 .. :try_end_35d} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_359 .. :try_end_35d} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_359 .. :try_end_35d} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_359 .. :try_end_35d} :catch_4d3

    move-object v8, v9

    .line 254
    goto :goto_364

    .line 252
    :catch_35f
    move-exception v0

    move-object v9, v0

    .line 253
    .local v9, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_361
    invoke-virtual {v9}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 255
    .end local v9    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :goto_364
    iget-object v9, v8, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    .line 256
    .local v9, "signatures":[Landroid/content/pm/Signature;
    const/4 v12, 0x0

    aget-object v13, v9, v12

    invoke-virtual {v13}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v12

    .line 257
    .local v12, "cert2":[B
    new-instance v13, Ljava/io/ByteArrayInputStream;

    invoke-direct {v13, v12}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_372
    .catch Ljava/sql/BatchUpdateException; {:try_start_361 .. :try_end_372} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_361 .. :try_end_372} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_361 .. :try_end_372} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_361 .. :try_end_372} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_361 .. :try_end_372} :catch_4d3

    .line 258
    .local v13, "input":Ljava/io/InputStream;
    const/4 v14, 0x0

    .line 260
    .local v14, "cf":Ljava/security/cert/CertificateFactory;
    :try_start_373
    const-string v15, "X509"

    invoke-static {v15}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v15
    :try_end_379
    .catch Ljava/security/cert/CertificateException; {:try_start_373 .. :try_end_379} :catch_37b
    .catch Ljava/sql/BatchUpdateException; {:try_start_373 .. :try_end_379} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_373 .. :try_end_379} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_373 .. :try_end_379} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_373 .. :try_end_379} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_373 .. :try_end_379} :catch_4d3

    move-object v14, v15

    .line 263
    goto :goto_380

    .line 261
    :catch_37b
    move-exception v0

    move-object v15, v0

    .line 262
    .local v15, "e":Ljava/security/cert/CertificateException;
    :try_start_37d
    invoke-virtual {v15}, Ljava/security/cert/CertificateException;->printStackTrace()V
    :try_end_380
    .catch Ljava/sql/BatchUpdateException; {:try_start_37d .. :try_end_380} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_37d .. :try_end_380} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_37d .. :try_end_380} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_37d .. :try_end_380} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_37d .. :try_end_380} :catch_4d3

    .line 264
    .end local v15    # "e":Ljava/security/cert/CertificateException;
    :goto_380
    const/4 v15, 0x0

    .line 266
    .local v15, "c":Ljava/security/cert/X509Certificate;
    :try_start_381
    invoke-virtual {v14, v13}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v18

    check-cast v18, Ljava/security/cert/X509Certificate;
    :try_end_387
    .catch Ljava/security/cert/CertificateException; {:try_start_381 .. :try_end_387} :catch_38a
    .catch Ljava/sql/BatchUpdateException; {:try_start_381 .. :try_end_387} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_381 .. :try_end_387} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_381 .. :try_end_387} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_381 .. :try_end_387} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_381 .. :try_end_387} :catch_4d3

    move-object/from16 v15, v18

    .line 269
    goto :goto_390

    .line 267
    :catch_38a
    move-exception v0

    move-object/from16 v18, v0

    .line 268
    .local v18, "e":Ljava/security/cert/CertificateException;
    :try_start_38d
    invoke-virtual/range {v18 .. v18}, Ljava/security/cert/CertificateException;->printStackTrace()V
    :try_end_390
    .catch Ljava/sql/BatchUpdateException; {:try_start_38d .. :try_end_390} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_38d .. :try_end_390} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_38d .. :try_end_390} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_38d .. :try_end_390} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_38d .. :try_end_390} :catch_4d3

    .line 270
    .end local v18    # "e":Ljava/security/cert/CertificateException;
    :goto_390
    const/16 v18, 0x0

    .line 272
    .local v18, "hexString":Ljava/lang/String;
    :try_start_392
    const-string v19, "SHA1"

    invoke-static/range {v19 .. v19}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v19
    :try_end_398
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_392 .. :try_end_398} :catch_3cb
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_392 .. :try_end_398} :catch_3c1
    .catch Ljava/sql/BatchUpdateException; {:try_start_392 .. :try_end_398} :catch_4e5
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_392 .. :try_end_398} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_392 .. :try_end_398} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_392 .. :try_end_398} :catch_4d3

    move-object/from16 v20, v19

    .line 273
    .local v20, "md":Ljava/security/MessageDigest;
    move-object/from16 v19, v3

    .end local v3    # "pm":Landroid/content/pm/PackageManager;
    .local v19, "pm":Landroid/content/pm/PackageManager;
    :try_start_39c
    invoke-virtual {v15}, Ljava/security/cert/X509Certificate;->getEncoded()[B

    move-result-object v3
    :try_end_3a0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_39c .. :try_end_3a0} :catch_3bc
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_39c .. :try_end_3a0} :catch_3b7
    .catch Ljava/sql/BatchUpdateException; {:try_start_39c .. :try_end_3a0} :catch_4e5
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_39c .. :try_end_3a0} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_39c .. :try_end_3a0} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_39c .. :try_end_3a0} :catch_4d3

    move-object/from16 v22, v4

    move-object/from16 v4, v20

    .end local v20    # "md":Ljava/security/MessageDigest;
    .local v4, "md":Ljava/security/MessageDigest;
    .local v22, "packageName":Ljava/lang/String;
    :try_start_3a4
    invoke-virtual {v4, v3}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v3

    .line 274
    .local v3, "publicKey":[B
    invoke-static {v3}, Lcom/mobisec/upos/FC;->th([B)Ljava/lang/String;

    move-result-object v20
    :try_end_3ac
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_3a4 .. :try_end_3ac} :catch_3b4
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_3a4 .. :try_end_3ac} :catch_3b1
    .catch Ljava/sql/BatchUpdateException; {:try_start_3a4 .. :try_end_3ac} :catch_4e5
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3a4 .. :try_end_3ac} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_3a4 .. :try_end_3ac} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_3a4 .. :try_end_3ac} :catch_4d3

    move-object/from16 v18, v20

    .line 279
    .end local v3    # "publicKey":[B
    .end local v4    # "md":Ljava/security/MessageDigest;
    move-object/from16 v3, v18

    goto :goto_3d7

    .line 277
    :catch_3b1
    move-exception v0

    move-object v3, v0

    goto :goto_3c7

    .line 275
    :catch_3b4
    move-exception v0

    move-object v3, v0

    goto :goto_3d1

    .line 277
    .end local v22    # "packageName":Ljava/lang/String;
    .local v4, "packageName":Ljava/lang/String;
    :catch_3b7
    move-exception v0

    move-object/from16 v22, v4

    move-object v3, v0

    .end local v4    # "packageName":Ljava/lang/String;
    .restart local v22    # "packageName":Ljava/lang/String;
    goto :goto_3c7

    .line 275
    .end local v22    # "packageName":Ljava/lang/String;
    .restart local v4    # "packageName":Ljava/lang/String;
    :catch_3bc
    move-exception v0

    move-object/from16 v22, v4

    move-object v3, v0

    .end local v4    # "packageName":Ljava/lang/String;
    .restart local v22    # "packageName":Ljava/lang/String;
    goto :goto_3d1

    .line 277
    .end local v19    # "pm":Landroid/content/pm/PackageManager;
    .end local v22    # "packageName":Ljava/lang/String;
    .local v3, "pm":Landroid/content/pm/PackageManager;
    .restart local v4    # "packageName":Ljava/lang/String;
    :catch_3c1
    move-exception v0

    move-object/from16 v19, v3

    move-object/from16 v22, v4

    move-object v3, v0

    .line 278
    .end local v4    # "packageName":Ljava/lang/String;
    .local v3, "e":Ljava/security/cert/CertificateEncodingException;
    .restart local v19    # "pm":Landroid/content/pm/PackageManager;
    .restart local v22    # "packageName":Ljava/lang/String;
    :goto_3c7
    :try_start_3c7
    invoke-virtual {v3}, Ljava/security/cert/CertificateEncodingException;->printStackTrace()V

    goto :goto_3d5

    .line 275
    .end local v19    # "pm":Landroid/content/pm/PackageManager;
    .end local v22    # "packageName":Ljava/lang/String;
    .local v3, "pm":Landroid/content/pm/PackageManager;
    .restart local v4    # "packageName":Ljava/lang/String;
    :catch_3cb
    move-exception v0

    move-object/from16 v19, v3

    move-object/from16 v22, v4

    move-object v3, v0

    .line 276
    .end local v4    # "packageName":Ljava/lang/String;
    .local v3, "e1":Ljava/security/NoSuchAlgorithmException;
    .restart local v19    # "pm":Landroid/content/pm/PackageManager;
    .restart local v22    # "packageName":Ljava/lang/String;
    :goto_3d1
    invoke-virtual {v3}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V
    :try_end_3d4
    .catch Ljava/sql/BatchUpdateException; {:try_start_3c7 .. :try_end_3d4} :catch_4e5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_3c7 .. :try_end_3d4} :catch_4e0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3c7 .. :try_end_3d4} :catch_4db
    .catch Ljava/security/GeneralSecurityException; {:try_start_3c7 .. :try_end_3d4} :catch_4d7
    .catch Ljava/lang/Exception; {:try_start_3c7 .. :try_end_3d4} :catch_4d3

    .line 279
    .end local v3    # "e1":Ljava/security/NoSuchAlgorithmException;
    nop

    .line 280
    :goto_3d5
    move-object/from16 v3, v18

    .end local v18    # "hexString":Ljava/lang/String;
    .local v3, "hexString":Ljava/lang/String;
    :goto_3d7
    add-int/lit8 v4, v2, 0x1

    move/from16 v18, v7

    .end local v2    # "idx":I
    .end local v7    # "flags":I
    .local v4, "idx":I
    .local v18, "flags":I
    const v7, 0x7f0b002d

    :try_start_3de
    invoke-virtual {v1, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    aput-boolean v7, v5, v2

    .line 284
    add-int/lit8 v2, v4, -0x1

    aget-boolean v2, v5, v2

    if-eqz v2, :cond_4b1

    .line 290
    const/4 v2, 0x0

    aget-boolean v7, v5, v2

    if-eqz v7, :cond_4af

    const/4 v2, 0x1

    aget-boolean v7, v5, v2
    :try_end_3f6
    .catch Ljava/sql/BatchUpdateException; {:try_start_3de .. :try_end_3f6} :catch_4cd
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_3de .. :try_end_3f6} :catch_4c7
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3de .. :try_end_3f6} :catch_4c1
    .catch Ljava/security/GeneralSecurityException; {:try_start_3de .. :try_end_3f6} :catch_4bc
    .catch Ljava/lang/Exception; {:try_start_3de .. :try_end_3f6} :catch_4b7

    if-nez v7, :cond_3fa

    goto/16 :goto_4af

    .line 292
    :cond_3fa
    const/16 v2, 0x64

    .line 294
    .end local v4    # "idx":I
    .restart local v2    # "idx":I
    const/4 v4, 0x0

    move v7, v2

    .end local v2    # "idx":I
    .local v4, "i":I
    .local v7, "idx":I
    :goto_3fe
    const/16 v2, 0x1e

    if-ge v4, v2, :cond_492

    .line 295
    const/4 v2, 0x1

    :try_start_403
    aput-boolean v2, v5, v7

    .line 297
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    mul-int/lit8 v1, v4, 0x2

    invoke-virtual {v11, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    mul-int/lit8 v1, v4, 0x2

    const/16 v17, 0x1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v11, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 299
    .local v1, "curr":Ljava/lang/String;
    invoke-static {v4}, Lcom/mobisec/upos/FC;->ip(I)Z

    move-result v2

    if-eqz v2, :cond_43b

    .line 300
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_433
    if-ge v2, v4, :cond_43b

    .line 301
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->step()I

    .line 300
    add-int/lit8 v2, v2, 0x1

    goto :goto_433

    .line 305
    .end local v2    # "j":I
    :cond_43b
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->g2()I

    move-result v2

    and-int/lit16 v2, v2, 0xff

    .line 306
    .local v2, "mX":I
    invoke-virtual {v6}, Lcom/mobisec/upos/Streamer;->g2()I

    move-result v20

    const v23, 0xff00

    and-int v20, v20, v23

    const/16 v16, 0x8

    shr-int/lit8 v20, v20, 0x8

    .line 312
    .local v20, "mY":I
    invoke-static {v1}, Lcom/mobisec/upos/FC;->r(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Lcom/mobisec/upos/FC;->sq(Ljava/lang/String;)J

    move-result-wide v23

    sget-object v25, Lcom/mobisec/upos/FC;->m:[[J

    aget-object v25, v25, v2

    aget-wide v26, v25, v20
    :try_end_45c
    .catch Ljava/sql/BatchUpdateException; {:try_start_403 .. :try_end_45c} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_403 .. :try_end_45c} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_403 .. :try_end_45c} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_403 .. :try_end_45c} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_403 .. :try_end_45c} :catch_538

    cmp-long v25, v23, v26

    if-eqz v25, :cond_48a

    .line 314
    add-int/lit8 v23, v7, 0x1

    const/16 v21, 0x0

    .end local v7    # "idx":I
    .local v23, "idx":I
    :try_start_464
    aput-boolean v21, v5, v7
    :try_end_466
    .catch Ljava/sql/BatchUpdateException; {:try_start_464 .. :try_end_466} :catch_483
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_464 .. :try_end_466} :catch_47c
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_464 .. :try_end_466} :catch_475
    .catch Ljava/security/GeneralSecurityException; {:try_start_464 .. :try_end_466} :catch_46f
    .catch Ljava/lang/Exception; {:try_start_464 .. :try_end_466} :catch_469

    move/from16 v7, v23

    goto :goto_48c

    .line 352
    .end local v1    # "curr":Ljava/lang/String;
    .end local v2    # "mX":I
    .end local v3    # "hexString":Ljava/lang/String;
    .end local v4    # "i":I
    .end local v8    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v9    # "signatures":[Landroid/content/pm/Signature;
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .end local v12    # "cert2":[B
    .end local v13    # "input":Ljava/io/InputStream;
    .end local v14    # "cf":Ljava/security/cert/CertificateFactory;
    .end local v15    # "c":Ljava/security/cert/X509Certificate;
    .end local v18    # "flags":I
    .end local v19    # "pm":Landroid/content/pm/PackageManager;
    .end local v20    # "mY":I
    .end local v22    # "packageName":Ljava/lang/String;
    :catch_469
    move-exception v0

    move-object v1, v0

    move/from16 v2, v23

    goto/16 :goto_53b

    .line 348
    :catch_46f
    move-exception v0

    move-object v1, v0

    move/from16 v2, v23

    goto/16 :goto_540

    .line 344
    :catch_475
    move-exception v0

    move-object v1, v0

    move/from16 v2, v23

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_47c
    move-exception v0

    move-object v1, v0

    move/from16 v2, v23

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_483
    move-exception v0

    move-object v1, v0

    move/from16 v2, v23

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 316
    .end local v23    # "idx":I
    .restart local v1    # "curr":Ljava/lang/String;
    .restart local v2    # "mX":I
    .restart local v3    # "hexString":Ljava/lang/String;
    .restart local v4    # "i":I
    .restart local v7    # "idx":I
    .restart local v8    # "packageInfo":Landroid/content/pm/PackageInfo;
    .restart local v9    # "signatures":[Landroid/content/pm/Signature;
    .restart local v10    # "f":Z
    .restart local v11    # "core":Ljava/lang/String;
    .restart local v12    # "cert2":[B
    .restart local v13    # "input":Ljava/io/InputStream;
    .restart local v14    # "cf":Ljava/security/cert/CertificateFactory;
    .restart local v15    # "c":Ljava/security/cert/X509Certificate;
    .restart local v18    # "flags":I
    .restart local v19    # "pm":Landroid/content/pm/PackageManager;
    .restart local v20    # "mY":I
    .restart local v22    # "packageName":Ljava/lang/String;
    :cond_48a
    add-int/lit8 v7, v7, 0x1

    .line 294
    .end local v1    # "curr":Ljava/lang/String;
    .end local v2    # "mX":I
    .end local v20    # "mY":I
    :goto_48c
    add-int/lit8 v4, v4, 0x1

    move-object/from16 v1, p0

    goto/16 :goto_3fe

    .line 322
    .end local v4    # "i":I
    :cond_492
    add-int/lit8 v1, v7, -0x1e

    .local v1, "i":I
    :goto_494
    if-ge v1, v7, :cond_49f

    .line 324
    :try_start_496
    aget-boolean v2, v5, v1

    if-nez v2, :cond_49c

    const/4 v2, 0x0

    return v2

    .line 322
    :cond_49c
    add-int/lit8 v1, v1, 0x1

    goto :goto_494

    .line 330
    .end local v1    # "i":I
    :cond_49f
    invoke-static/range {p1 .. p1}, Lcom/mobisec/upos/FC;->h(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1
    :try_end_4a9
    .catch Ljava/sql/BatchUpdateException; {:try_start_496 .. :try_end_4a9} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_496 .. :try_end_4a9} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_496 .. :try_end_4a9} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_496 .. :try_end_4a9} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_496 .. :try_end_4a9} :catch_538

    if-nez v1, :cond_4ad

    .line 331
    const/4 v1, 0x0

    return v1

    .line 334
    :cond_4ad
    const/4 v1, 0x1

    return v1

    .line 290
    .end local v7    # "idx":I
    .local v4, "idx":I
    :cond_4af
    :goto_4af
    const/4 v1, 0x0

    return v1

    .line 284
    :cond_4b1
    :try_start_4b1
    new-instance v1, Ljava/security/GeneralSecurityException;

    invoke-direct {v1}, Ljava/security/GeneralSecurityException;-><init>()V

    .end local v4    # "idx":I
    .end local v5    # "fs":[Z
    .end local v6    # "s":Lcom/mobisec/upos/Streamer;
    .end local p0    # "ctx":Landroid/content/Context;
    .end local p1    # "fl":Ljava/lang/String;
    throw v1
    :try_end_4b7
    .catch Ljava/sql/BatchUpdateException; {:try_start_4b1 .. :try_end_4b7} :catch_4cd
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_4b1 .. :try_end_4b7} :catch_4c7
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_4b1 .. :try_end_4b7} :catch_4c1
    .catch Ljava/security/GeneralSecurityException; {:try_start_4b1 .. :try_end_4b7} :catch_4bc
    .catch Ljava/lang/Exception; {:try_start_4b1 .. :try_end_4b7} :catch_4b7

    .line 352
    .end local v3    # "hexString":Ljava/lang/String;
    .end local v8    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v9    # "signatures":[Landroid/content/pm/Signature;
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .end local v12    # "cert2":[B
    .end local v13    # "input":Ljava/io/InputStream;
    .end local v14    # "cf":Ljava/security/cert/CertificateFactory;
    .end local v15    # "c":Ljava/security/cert/X509Certificate;
    .end local v18    # "flags":I
    .end local v19    # "pm":Landroid/content/pm/PackageManager;
    .end local v22    # "packageName":Ljava/lang/String;
    .restart local v4    # "idx":I
    .restart local v5    # "fs":[Z
    .restart local v6    # "s":Lcom/mobisec/upos/Streamer;
    .restart local p0    # "ctx":Landroid/content/Context;
    .restart local p1    # "fl":Ljava/lang/String;
    :catch_4b7
    move-exception v0

    move-object v1, v0

    move v2, v4

    goto/16 :goto_53b

    .line 348
    :catch_4bc
    move-exception v0

    move-object v1, v0

    move v2, v4

    goto/16 :goto_540

    .line 344
    :catch_4c1
    move-exception v0

    move-object v1, v0

    move v2, v4

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_4c7
    move-exception v0

    move-object v1, v0

    move v2, v4

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_4cd
    move-exception v0

    move-object v1, v0

    move v2, v4

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 352
    .end local v4    # "idx":I
    .local v2, "idx":I
    :catch_4d3
    move-exception v0

    move-object v1, v0

    goto/16 :goto_53b

    .line 348
    :catch_4d7
    move-exception v0

    move-object v1, v0

    goto/16 :goto_540

    .line 344
    :catch_4db
    move-exception v0

    move-object v1, v0

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_4e0
    move-exception v0

    move-object v1, v0

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_4e5
    move-exception v0

    move-object v1, v0

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 228
    .local v2, "e":Ljava/util/IllformedLocaleException;
    .restart local v7    # "idx":I
    .restart local v10    # "f":Z
    .restart local v11    # "core":Ljava/lang/String;
    :cond_4ea
    :try_start_4ea
    new-instance v1, Ljava/security/cert/CertificateEncodingException;

    invoke-direct {v1}, Ljava/security/cert/CertificateEncodingException;-><init>()V

    .end local v5    # "fs":[Z
    .end local v6    # "s":Lcom/mobisec/upos/Streamer;
    .end local v7    # "idx":I
    .end local p0    # "ctx":Landroid/content/Context;
    .end local p1    # "fl":Ljava/lang/String;
    throw v1

    .line 200
    .restart local v5    # "fs":[Z
    .restart local v6    # "s":Lcom/mobisec/upos/Streamer;
    .restart local v7    # "idx":I
    .restart local p0    # "ctx":Landroid/content/Context;
    .restart local p1    # "fl":Ljava/lang/String;
    :cond_4f0
    new-instance v1, Ljava/util/concurrent/RejectedExecutionException;

    invoke-direct {v1}, Ljava/util/concurrent/RejectedExecutionException;-><init>()V

    .end local v5    # "fs":[Z
    .end local v6    # "s":Lcom/mobisec/upos/Streamer;
    .end local v7    # "idx":I
    .end local p0    # "ctx":Landroid/content/Context;
    .end local p1    # "fl":Ljava/lang/String;
    throw v1
    :try_end_4f6
    .catch Ljava/sql/BatchUpdateException; {:try_start_4ea .. :try_end_4f6} :catch_533
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_4ea .. :try_end_4f6} :catch_52e
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_4ea .. :try_end_4f6} :catch_529
    .catch Ljava/security/GeneralSecurityException; {:try_start_4ea .. :try_end_4f6} :catch_53d
    .catch Ljava/lang/Exception; {:try_start_4ea .. :try_end_4f6} :catch_538

    .line 352
    .end local v2    # "e":Ljava/util/IllformedLocaleException;
    .end local v10    # "f":Z
    .end local v11    # "core":Ljava/lang/String;
    .restart local v5    # "fs":[Z
    .restart local v6    # "s":Lcom/mobisec/upos/Streamer;
    .local v12, "idx":I
    .restart local p0    # "ctx":Landroid/content/Context;
    .restart local p1    # "fl":Ljava/lang/String;
    :catch_4f6
    move-exception v0

    move-object v1, v0

    move v2, v12

    goto/16 :goto_53b

    .line 348
    :catch_4fb
    move-exception v0

    move-object v1, v0

    move v2, v12

    goto/16 :goto_540

    .line 344
    :catch_500
    move-exception v0

    move-object v1, v0

    move v2, v12

    const/4 v3, 0x1

    goto/16 :goto_548

    .line 340
    :catch_506
    move-exception v0

    move-object v1, v0

    move v2, v12

    const/4 v3, 0x1

    goto/16 :goto_54f

    .line 336
    :catch_50c
    move-exception v0

    move-object v1, v0

    move v2, v12

    const/4 v3, 0x1

    goto/16 :goto_556

    .line 352
    .end local v12    # "idx":I
    .local v10, "idx":I
    :catch_512
    move-exception v0

    move-object v1, v0

    move v2, v10

    goto :goto_53b

    .line 348
    :catch_516
    move-exception v0

    move-object v1, v0

    move v2, v10

    goto :goto_540

    .line 344
    :catch_51a
    move-exception v0

    move-object v1, v0

    move v2, v10

    const/4 v3, 0x1

    goto :goto_548

    .line 340
    :catch_51f
    move-exception v0

    move-object v1, v0

    move v2, v10

    const/4 v3, 0x1

    goto :goto_54f

    .line 336
    :catch_524
    move-exception v0

    move-object v1, v0

    move v2, v10

    const/4 v3, 0x1

    goto :goto_556

    .line 344
    .end local v10    # "idx":I
    .restart local v7    # "idx":I
    :catch_529
    move-exception v0

    move-object v1, v0

    move v2, v7

    const/4 v3, 0x1

    goto :goto_548

    .line 340
    :catch_52e
    move-exception v0

    move-object v1, v0

    move v2, v7

    const/4 v3, 0x1

    goto :goto_54f

    .line 336
    :catch_533
    move-exception v0

    move-object v1, v0

    move v2, v7

    const/4 v3, 0x1

    goto :goto_556

    .line 352
    :catch_538
    move-exception v0

    move-object v1, v0

    move v2, v7

    .line 354
    .end local v7    # "idx":I
    .local v1, "e":Ljava/lang/Exception;
    .local v2, "idx":I
    :goto_53b
    const/4 v3, 0x0

    return v3

    .line 348
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "idx":I
    .restart local v7    # "idx":I
    :catch_53d
    move-exception v0

    move-object v1, v0

    move v2, v7

    .line 350
    .end local v7    # "idx":I
    .local v1, "e":Ljava/security/GeneralSecurityException;
    .restart local v2    # "idx":I
    :goto_540
    const/4 v3, 0x1

    sput-boolean v3, Lcom/mobisec/upos/MainActivity;->g4:Z

    .end local v1    # "e":Ljava/security/GeneralSecurityException;
    goto :goto_558

    .line 344
    .end local v2    # "idx":I
    .restart local v7    # "idx":I
    :catch_544
    move-exception v0

    const/4 v3, 0x1

    move-object v1, v0

    move v2, v7

    .line 346
    .end local v7    # "idx":I
    .local v1, "e":Ljava/util/concurrent/RejectedExecutionException;
    .restart local v2    # "idx":I
    :goto_548
    sput-boolean v3, Lcom/mobisec/upos/MainActivity;->g3:Z

    .end local v1    # "e":Ljava/util/concurrent/RejectedExecutionException;
    goto :goto_558

    .line 340
    .end local v2    # "idx":I
    .restart local v7    # "idx":I
    :catch_54b
    move-exception v0

    const/4 v3, 0x1

    move-object v1, v0

    move v2, v7

    .line 342
    .end local v7    # "idx":I
    .local v1, "e":Ljava/security/cert/CertificateEncodingException;
    .restart local v2    # "idx":I
    :goto_54f
    sput-boolean v3, Lcom/mobisec/upos/MainActivity;->g1:Z

    .end local v1    # "e":Ljava/security/cert/CertificateEncodingException;
    goto :goto_558

    .line 336
    .end local v2    # "idx":I
    .restart local v7    # "idx":I
    :catch_552
    move-exception v0

    const/4 v3, 0x1

    move-object v1, v0

    move v2, v7

    .line 338
    .end local v7    # "idx":I
    .local v1, "e":Ljava/sql/BatchUpdateException;
    .restart local v2    # "idx":I
    :goto_556
    sput-boolean v3, Lcom/mobisec/upos/MainActivity;->g2:Z

    .line 355
    .end local v1    # "e":Ljava/sql/BatchUpdateException;
    :goto_558
    nop

    .line 357
    const/4 v1, 0x0

    return v1
.end method

.method public static dec(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .param p0, "x"    # Ljava/lang/String;

    .line 450
    new-instance v0, Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {p0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([B)V

    return-object v0
.end method

.method public static ec(Ljava/lang/String;)Ljava/lang/String;
    .registers 9
    .param p0, "cmd"    # Ljava/lang/String;

    .line 455
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 458
    .local v0, "out":Ljava/lang/String;
    :try_start_5
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v1

    .line 460
    .local v1, "p":Ljava/lang/Process;
    invoke-virtual {v1}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    .line 461
    .local v2, "stdout":Ljava/io/InputStream;
    const v3, 0x19000

    new-array v4, v3, [B

    .line 464
    .local v4, "buffer":[B
    :cond_16
    :goto_16
    invoke-virtual {v2, v4}, Ljava/io/InputStream;->read([B)I

    move-result v5

    .line 465
    .local v5, "read":I
    if-lez v5, :cond_35

    if-gt v5, v3, :cond_35

    .line 466
    new-instance v6, Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct {v6, v4, v7, v5}, Ljava/lang/String;-><init>([BII)V

    .line 468
    .local v6, "line":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    move-object v0, v7

    .line 469
    .end local v6    # "line":Ljava/lang/String;
    goto :goto_16

    .line 470
    :cond_35
    invoke-virtual {v2}, Ljava/io/InputStream;->available()I

    move-result v6

    if-gtz v6, :cond_16

    .line 471
    nop

    .line 475
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_3f
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_3f} :catch_40

    .line 480
    .end local v1    # "p":Ljava/lang/Process;
    .end local v2    # "stdout":Ljava/io/InputStream;
    .end local v4    # "buffer":[B
    .end local v5    # "read":I
    goto :goto_41

    .line 478
    :catch_40
    move-exception v1

    .line 482
    :goto_41
    return-object v0
.end method

.method private static h(Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .param p0, "flag"    # Ljava/lang/String;

    .line 362
    :try_start_0
    const-string v0, "SHA-256"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 363
    .local v0, "md":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->update([B)V

    .line 364
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v1

    .line 365
    .local v1, "digest":[B
    invoke-static {v1}, Lcom/mobisec/upos/FC;->th([B)Ljava/lang/String;

    move-result-object v2
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_15} :catch_16

    return-object v2

    .line 366
    .end local v0    # "md":Ljava/security/MessageDigest;
    .end local v1    # "digest":[B
    :catch_16
    move-exception v0

    .line 367
    .local v0, "e":Ljava/lang/Exception;
    const/4 v1, 0x0

    return-object v1
.end method

.method public static ip(I)Z
    .registers 3
    .param p0, "x"    # I

    .line 421
    const/4 v0, 0x2

    .local v0, "i":I
    :goto_1
    if-ge v0, p0, :cond_c

    .line 422
    rem-int v1, p0, v0

    if-nez v1, :cond_9

    .line 423
    const/4 v1, 0x0

    return v1

    .line 421
    :cond_9
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 426
    .end local v0    # "i":I
    :cond_c
    const/4 v0, 0x1

    return v0
.end method

.method private static lm([[J)V
    .registers 15
    .param p0, "matrix"    # [[J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 386
    const/4 v0, 0x0

    .line 388
    .local v0, "reader":Ljava/io/BufferedReader;
    :try_start_1
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/InputStreamReader;

    sget-object v3, Lcom/mobisec/upos/FC;->ctx:Landroid/content/Context;

    .line 389
    invoke-virtual {v3}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    const-string v4, "lotto.dat"

    invoke-virtual {v3, v4}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    move-object v0, v1

    .line 393
    const/4 v1, 0x0

    move v2, v1

    .line 394
    .local v2, "rowIdx":I
    :goto_1a
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3
    :try_end_1e
    .catchall {:try_start_1 .. :try_end_1e} :catchall_5a

    move-object v4, v3

    .local v4, "row":Ljava/lang/String;
    const-string v5, "error"

    const/16 v6, 0x100

    if-eqz v3, :cond_4d

    .line 395
    :try_start_25
    const-string v3, " "

    invoke-virtual {v4, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 396
    .local v3, "elems":[Ljava/lang/String;
    const/4 v7, 0x0

    .line 397
    .local v7, "colIdx":I
    array-length v8, v3

    move v9, v7

    const/4 v7, 0x0

    .end local v7    # "colIdx":I
    .local v9, "colIdx":I
    :goto_2f
    if-ge v7, v8, :cond_41

    aget-object v10, v3, v7

    .line 398
    .local v10, "elem":Ljava/lang/String;
    invoke-static {v10}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v11

    .line 399
    .local v11, "e":J
    aget-object v13, p0, v2

    aput-wide v11, v13, v9

    .line 401
    nop

    .end local v10    # "elem":Ljava/lang/String;
    .end local v11    # "e":J
    add-int/lit8 v9, v9, 0x1

    .line 397
    add-int/lit8 v7, v7, 0x1

    goto :goto_2f

    .line 403
    :cond_41
    if-ne v9, v6, :cond_47

    .line 407
    nop

    .end local v3    # "elems":[Ljava/lang/String;
    .end local v9    # "colIdx":I
    add-int/lit8 v2, v2, 0x1

    .line 408
    goto :goto_1a

    .line 405
    .restart local v3    # "elems":[Ljava/lang/String;
    .restart local v9    # "colIdx":I
    :cond_47
    new-instance v1, Ljava/lang/Exception;

    invoke-direct {v1, v5}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .end local v0    # "reader":Ljava/io/BufferedReader;
    .end local p0    # "matrix":[[J
    throw v1
    :try_end_4d
    .catchall {:try_start_25 .. :try_end_4d} :catchall_5a

    .line 409
    .end local v3    # "elems":[Ljava/lang/String;
    .end local v9    # "colIdx":I
    .restart local v0    # "reader":Ljava/io/BufferedReader;
    .restart local p0    # "matrix":[[J
    :cond_4d
    if-ne v2, v6, :cond_54

    .line 414
    .end local v2    # "rowIdx":I
    .end local v4    # "row":Ljava/lang/String;
    nop

    .line 415
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 418
    return-void

    .line 411
    .restart local v2    # "rowIdx":I
    .restart local v4    # "row":Ljava/lang/String;
    :cond_54
    :try_start_54
    new-instance v1, Ljava/lang/Exception;

    invoke-direct {v1, v5}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .end local v0    # "reader":Ljava/io/BufferedReader;
    .end local p0    # "matrix":[[J
    throw v1
    :try_end_5a
    .catchall {:try_start_54 .. :try_end_5a} :catchall_5a

    .line 414
    .end local v2    # "rowIdx":I
    .end local v4    # "row":Ljava/lang/String;
    .restart local v0    # "reader":Ljava/io/BufferedReader;
    .restart local p0    # "matrix":[[J
    :catchall_5a
    move-exception v1

    if-eqz v0, :cond_60

    .line 415
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    :cond_60
    throw v1
.end method

.method public static r(Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .param p0, "s"    # Ljava/lang/String;

    .line 430
    const-string v0, ""

    .line 431
    .local v0, "out":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_3
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_4e

    .line 432
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 433
    .local v2, "c":C
    const/16 v3, 0x61

    if-lt v2, v3, :cond_19

    const/16 v3, 0x73

    if-gt v2, v3, :cond_19

    add-int/lit8 v3, v2, 0x7

    int-to-char v2, v3

    goto :goto_3c

    .line 434
    :cond_19
    const/16 v3, 0x41

    if-lt v2, v3, :cond_25

    const/16 v3, 0x53

    if-gt v2, v3, :cond_25

    add-int/lit8 v3, v2, 0x7

    int-to-char v2, v3

    goto :goto_3c

    .line 435
    :cond_25
    const/16 v3, 0x74

    if-lt v2, v3, :cond_31

    const/16 v3, 0x7a

    if-gt v2, v3, :cond_31

    add-int/lit8 v3, v2, -0x13

    int-to-char v2, v3

    goto :goto_3c

    .line 436
    :cond_31
    const/16 v3, 0x54

    if-lt v2, v3, :cond_3c

    const/16 v3, 0x5a

    if-gt v2, v3, :cond_3c

    add-int/lit8 v3, v2, -0x13

    int-to-char v2, v3

    .line 437
    :cond_3c
    :goto_3c
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 431
    .end local v2    # "c":C
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 439
    .end local v1    # "i":I
    :cond_4e
    return-object v0
.end method

.method public static sq(Ljava/lang/String;)J
    .registers 6
    .param p0, "a"    # Ljava/lang/String;

    .line 444
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v0, v1

    const v1, 0xffff

    and-int/2addr v0, v1

    .line 445
    .local v0, "n":I
    int-to-double v1, v0

    const-wide/high16 v3, 0x4000000000000000L    # 2.0

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    double-to-long v1, v1

    .line 446
    .local v1, "n2":J
    return-wide v1
.end method

.method public static th([B)Ljava/lang/String;
    .registers 6
    .param p0, "bytes"    # [B

    .line 372
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 374
    .local v0, "hexString":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_6
    array-length v2, p0

    if-ge v1, v2, :cond_23

    .line 375
    aget-byte v2, p0, v1

    and-int/lit16 v2, v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    .line 376
    .local v2, "hex":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1d

    .line 377
    const/16 v3, 0x30

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 379
    :cond_1d
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 374
    .end local v2    # "hex":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 382
    .end local v1    # "i":I
    :cond_23
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

