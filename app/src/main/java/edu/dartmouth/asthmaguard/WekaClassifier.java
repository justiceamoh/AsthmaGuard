package edu.dartmouth.asthmaguard;

/**
 * Created by Junior on 3/5/15.
 */

class WekaClassifier {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaClassifier.N48c08ea50(i);
        return p;
    }
    static double N48c08ea50(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 3.8324) {
            p = WekaClassifier.N59d517f31(i);
        } else if (((Double) i[2]).doubleValue() > 3.8324) {
            p = WekaClassifier.N6155981e93(i);
        }
        return p;
    }
    static double N59d517f31(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 32.6029) {
            p = WekaClassifier.N351780982(i);
        } else if (((Double) i[0]).doubleValue() > 32.6029) {
            p = 0;
        }
        return p;
    }
    static double N351780982(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -13.9701) {
            p = WekaClassifier.N19fb96633(i);
        } else if (((Double) i[3]).doubleValue() > -13.9701) {
            p = WekaClassifier.N5c3d109d7(i);
        }
        return p;
    }
    static double N19fb96633(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 30.4639) {
            p = WekaClassifier.N544e4ae84(i);
        } else if (((Double) i[0]).doubleValue() > 30.4639) {
            p = WekaClassifier.N43b3f77c6(i);
        }
        return p;
    }
    static double N544e4ae84(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -17.435) {
            p = WekaClassifier.N6017f0955(i);
        } else if (((Double) i[1]).doubleValue() > -17.435) {
            p = 1;
        }
        return p;
    }
    static double N6017f0955(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -2.8881) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -2.8881) {
            p = 1;
        }
        return p;
    }
    static double N43b3f77c6(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -8.3999) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > -8.3999) {
            p = 0;
        }
        return p;
    }
    static double N5c3d109d7(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -12.1535) {
            p = WekaClassifier.N2d0de2ba8(i);
        } else if (((Double) i[4]).doubleValue() > -12.1535) {
            p = WekaClassifier.N5306922327(i);
        }
        return p;
    }
    static double N2d0de2ba8(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -11.1534) {
            p = WekaClassifier.N6aa038719(i);
        } else if (((Double) i[1]).doubleValue() > -11.1534) {
            p = WekaClassifier.N33b146315(i);
        }
        return p;
    }
    static double N6aa038719(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -12.2793) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > -12.2793) {
            p = WekaClassifier.N3cd9b96710(i);
        }
        return p;
    }
    static double N3cd9b96710(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -6.9945) {
            p = WekaClassifier.N7a1b386611(i);
        } else if (((Double) i[2]).doubleValue() > -6.9945) {
            p = WekaClassifier.N33baf8cf13(i);
        }
        return p;
    }
    static double N7a1b386611(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 5.2825) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() > 5.2825) {
            p = WekaClassifier.N1113ef2b12(i);
        }
        return p;
    }
    static double N1113ef2b12(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 23.396) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 23.396) {
            p = 0;
        }
        return p;
    }
    static double N33baf8cf13(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 22.0429) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 22.0429) {
            p = WekaClassifier.N3824f89114(i);
        }
        return p;
    }
    static double N3824f89114(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -2.9343) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > -2.9343) {
            p = 0;
        }
        return p;
    }
    static double N33b146315(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -13.6526) {
            p = WekaClassifier.N1bb7713d16(i);
        } else if (((Double) i[9]).doubleValue() > -13.6526) {
            p = WekaClassifier.N2620535419(i);
        }
        return p;
    }
    static double N1bb7713d16(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -8.1968) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > -8.1968) {
            p = WekaClassifier.N286b6a0217(i);
        }
        return p;
    }
    static double N286b6a0217(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -14.788) {
            p = WekaClassifier.N23fcbe0918(i);
        } else if (((Double) i[5]).doubleValue() > -14.788) {
            p = 0;
        }
        return p;
    }
    static double N23fcbe0918(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -0.51869) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > -0.51869) {
            p = 0;
        }
        return p;
    }
    static double N2620535419(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -3.0076) {
            p = WekaClassifier.N143ec35a20(i);
        } else if (((Double) i[1]).doubleValue() > -3.0076) {
            p = 1;
        }
        return p;
    }
    static double N143ec35a20(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -21.2013) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -21.2013) {
            p = WekaClassifier.N248b541821(i);
        }
        return p;
    }
    static double N248b541821(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= 6.4553) {
            p = WekaClassifier.N373e066622(i);
        } else if (((Double) i[3]).doubleValue() > 6.4553) {
            p = WekaClassifier.N33ee129726(i);
        }
        return p;
    }
    static double N373e066622(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() <= -12.4597) {
            p = WekaClassifier.N49162edf23(i);
        } else if (((Double) i[8]).doubleValue() > -12.4597) {
            p = WekaClassifier.N4f5f57f524(i);
        }
        return p;
    }
    static double N49162edf23(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -11.1969) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > -11.1969) {
            p = 1;
        }
        return p;
    }
    static double N4f5f57f524(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -4.7539) {
            p = WekaClassifier.N7c87be8825(i);
        } else if (((Double) i[6]).doubleValue() > -4.7539) {
            p = 1;
        }
        return p;
    }
    static double N7c87be8825(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 29.232) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 29.232) {
            p = 0;
        }
        return p;
    }
    static double N33ee129726(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -5.9532) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -5.9532) {
            p = 1;
        }
        return p;
    }
    static double N5306922327(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -8.4653) {
            p = WekaClassifier.N5464626a28(i);
        } else if (((Double) i[1]).doubleValue() > -8.4653) {
            p = WekaClassifier.Nf4643f54(i);
        }
        return p;
    }
    static double N5464626a28(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -0.9794) {
            p = WekaClassifier.Na79486f29(i);
        } else if (((Double) i[2]).doubleValue() > -0.9794) {
            p = WekaClassifier.N3d709aa448(i);
        }
        return p;
    }
    static double Na79486f29(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 10.6887) {
            p = WekaClassifier.N208274c830(i);
        } else if (((Double) i[0]).doubleValue() > 10.6887) {
            p = WekaClassifier.N4893db8733(i);
        }
        return p;
    }
    static double N208274c830(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -12.331) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -12.331) {
            p = WekaClassifier.N54c1072431(i);
        }
        return p;
    }
    static double N54c1072431(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -9.5769) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() > -9.5769) {
            p = WekaClassifier.N4cbbf7f432(i);
        }
        return p;
    }
    static double N4cbbf7f432(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 1;
        } else if (((Double) i[7]).doubleValue() <= 9.6023) {
            p = 1;
        } else if (((Double) i[7]).doubleValue() > 9.6023) {
            p = 0;
        }
        return p;
    }
    static double N4893db8733(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= 5.0237) {
            p = WekaClassifier.N6331a14a34(i);
        } else if (((Double) i[8]).doubleValue() > 5.0237) {
            p = 0;
        }
        return p;
    }
    static double N6331a14a34(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= 5.9292) {
            p = WekaClassifier.N4f54342635(i);
        } else if (((Double) i[6]).doubleValue() > 5.9292) {
            p = WekaClassifier.N78a5c39146(i);
        }
        return p;
    }
    static double N4f54342635(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -20.8559) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -20.8559) {
            p = WekaClassifier.N212bd37a36(i);
        }
        return p;
    }
    static double N212bd37a36(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -6.667) {
            p = WekaClassifier.N4448ff9937(i);
        } else if (((Double) i[9]).doubleValue() > -6.667) {
            p = WekaClassifier.N1582b27939(i);
        }
        return p;
    }
    static double N4448ff9937(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= -7.569) {
            p = WekaClassifier.N1484b8d538(i);
        } else if (((Double) i[3]).doubleValue() > -7.569) {
            p = 0;
        }
        return p;
    }
    static double N1484b8d538(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -13.3539) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -13.3539) {
            p = 1;
        }
        return p;
    }
    static double N1582b27939(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= -9.74) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() > -9.74) {
            p = WekaClassifier.N379330f740(i);
        }
        return p;
    }
    static double N379330f740(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -16.943) {
            p = WekaClassifier.N2073c4a241(i);
        } else if (((Double) i[2]).doubleValue() > -16.943) {
            p = WekaClassifier.N4b39999443(i);
        }
        return p;
    }
    static double N2073c4a241(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -17.5219) {
            p = WekaClassifier.N1072785342(i);
        } else if (((Double) i[1]).doubleValue() > -17.5219) {
            p = 1;
        }
        return p;
    }
    static double N1072785342(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -17.9928) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -17.9928) {
            p = 1;
        }
        return p;
    }
    static double N4b39999443(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 18.5325) {
            p = WekaClassifier.N3291ea2144(i);
        } else if (((Double) i[0]).doubleValue() > 18.5325) {
            p = 0;
        }
        return p;
    }
    static double N3291ea2144(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -6.6056) {
            p = WekaClassifier.N9a2367745(i);
        } else if (((Double) i[2]).doubleValue() > -6.6056) {
            p = 1;
        }
        return p;
    }
    static double N9a2367745(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 2.3175) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 2.3175) {
            p = 1;
        }
        return p;
    }
    static double N78a5c39146(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 28.051) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 28.051) {
            p = WekaClassifier.N4acaa27847(i);
        }
        return p;
    }
    static double N4acaa27847(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= 13.8103) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > 13.8103) {
            p = 1;
        }
        return p;
    }
    static double N3d709aa448(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 20.6805) {
            p = WekaClassifier.N2bb8a47f49(i);
        } else if (((Double) i[0]).doubleValue() > 20.6805) {
            p = WekaClassifier.N75dafc0b52(i);
        }
        return p;
    }
    static double N2bb8a47f49(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -5.567) {
            p = WekaClassifier.N6737a44550(i);
        } else if (((Double) i[5]).doubleValue() > -5.567) {
            p = 1;
        }
        return p;
    }
    static double N6737a44550(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -5.6743) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > -5.6743) {
            p = WekaClassifier.N7601e2f351(i);
        }
        return p;
    }
    static double N7601e2f351(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -14.8471) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -14.8471) {
            p = 0;
        }
        return p;
    }
    static double N75dafc0b52(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= 7.8686) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > 7.8686) {
            p = WekaClassifier.N7bd9729f53(i);
        }
        return p;
    }
    static double N7bd9729f53(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 23.8492) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 23.8492) {
            p = 1;
        }
        return p;
    }
    static double Nf4643f54(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 4.0535) {
            p = WekaClassifier.N2ce1649655(i);
        } else if (((Double) i[0]).doubleValue() > 4.0535) {
            p = WekaClassifier.N4c44f74757(i);
        }
        return p;
    }
    static double N2ce1649655(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -12.4053) {
            p = WekaClassifier.N192cadf56(i);
        } else if (((Double) i[11]).doubleValue() > -12.4053) {
            p = 0;
        }
        return p;
    }
    static double N192cadf56(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -1.4709) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -1.4709) {
            p = 0;
        }
        return p;
    }
    static double N4c44f74757(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 0.02914) {
            p = WekaClassifier.N43c67d6f58(i);
        } else if (((Double) i[1]).doubleValue() > 0.02914) {
            p = WekaClassifier.N3efdd68689(i);
        }
        return p;
    }
    static double N43c67d6f58(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -13.1153) {
            p = WekaClassifier.N1c55252c59(i);
        } else if (((Double) i[6]).doubleValue() > -13.1153) {
            p = WekaClassifier.N6102962a62(i);
        }
        return p;
    }
    static double N1c55252c59(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= -0.90271) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() > -0.90271) {
            p = WekaClassifier.N19fb7a3c60(i);
        }
        return p;
    }
    static double N19fb7a3c60(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= 0.58919) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > 0.58919) {
            p = WekaClassifier.N4d16067761(i);
        }
        return p;
    }
    static double N4d16067761(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -7.5918) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -7.5918) {
            p = 1;
        }
        return p;
    }
    static double N6102962a62(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= -11.2414) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() > -11.2414) {
            p = WekaClassifier.N70d0d12763(i);
        }
        return p;
    }
    static double N70d0d12763(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= 11.0021) {
            p = WekaClassifier.N1d53914e64(i);
        } else if (((Double) i[6]).doubleValue() > 11.0021) {
            p = 0;
        }
        return p;
    }
    static double N1d53914e64(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -7.5937) {
            p = WekaClassifier.N5968a6ec65(i);
        } else if (((Double) i[5]).doubleValue() > -7.5937) {
            p = WekaClassifier.N7dd7c14275(i);
        }
        return p;
    }
    static double N5968a6ec65(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -23.3397) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > -23.3397) {
            p = WekaClassifier.N65a6fdcf66(i);
        }
        return p;
    }
    static double N65a6fdcf66(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -8.0807) {
            p = WekaClassifier.N3661552c67(i);
        } else if (((Double) i[3]).doubleValue() > -8.0807) {
            p = WekaClassifier.N38dc54d669(i);
        }
        return p;
    }
    static double N3661552c67(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 22.8708) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 22.8708) {
            p = WekaClassifier.N301ed79868(i);
        }
        return p;
    }
    static double N301ed79868(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 3.6964) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() > 3.6964) {
            p = 1;
        }
        return p;
    }
    static double N38dc54d669(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= 7.186) {
            p = WekaClassifier.N945cac470(i);
        } else if (((Double) i[8]).doubleValue() > 7.186) {
            p = 1;
        }
        return p;
    }
    static double N945cac470(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 11.4055) {
            p = WekaClassifier.N45030e9d71(i);
        } else if (((Double) i[7]).doubleValue() > 11.4055) {
            p = 1;
        }
        return p;
    }
    static double N45030e9d71(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -2.32) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -2.32) {
            p = WekaClassifier.N4bb488d072(i);
        }
        return p;
    }
    static double N4bb488d072(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -3.2498) {
            p = WekaClassifier.N3982368473(i);
        } else if (((Double) i[4]).doubleValue() > -3.2498) {
            p = 0;
        }
        return p;
    }
    static double N3982368473(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 19.7166) {
            p = WekaClassifier.N13c9319b74(i);
        } else if (((Double) i[0]).doubleValue() > 19.7166) {
            p = 0;
        }
        return p;
    }
    static double N13c9319b74(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 9.6456) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 9.6456) {
            p = 1;
        }
        return p;
    }
    static double N7dd7c14275(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -7.173) {
            p = WekaClassifier.N5fd1149976(i);
        } else if (((Double) i[9]).doubleValue() > -7.173) {
            p = WekaClassifier.N33733f9c82(i);
        }
        return p;
    }
    static double N5fd1149976(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -6.8711) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > -6.8711) {
            p = WekaClassifier.N179f79f477(i);
        }
        return p;
    }
    static double N179f79f477(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= -1.5086) {
            p = WekaClassifier.N66ff8e4978(i);
        } else if (((Double) i[3]).doubleValue() > -1.5086) {
            p = 0;
        }
        return p;
    }
    static double N66ff8e4978(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 28.4303) {
            p = WekaClassifier.N13d68f7379(i);
        } else if (((Double) i[0]).doubleValue() > 28.4303) {
            p = 0;
        }
        return p;
    }
    static double N13d68f7379(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -3.1616) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() > -3.1616) {
            p = WekaClassifier.N6b63d13180(i);
        }
        return p;
    }
    static double N6b63d13180(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -11.1397) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() > -11.1397) {
            p = WekaClassifier.N663b1f0b81(i);
        }
        return p;
    }
    static double N663b1f0b81(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -5.2484) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > -5.2484) {
            p = 1;
        }
        return p;
    }
    static double N33733f9c82(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 19.7166) {
            p = WekaClassifier.N5355352783(i);
        } else if (((Double) i[0]).doubleValue() > 19.7166) {
            p = WekaClassifier.N3b4406e487(i);
        }
        return p;
    }
    static double N5355352783(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 0.29824) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 0.29824) {
            p = WekaClassifier.N7f14be2e84(i);
        }
        return p;
    }
    static double N7f14be2e84(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 0.59748) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > 0.59748) {
            p = WekaClassifier.N2ad1ff3085(i);
        }
        return p;
    }
    static double N2ad1ff3085(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 1;
        } else if (((Double) i[9]).doubleValue() <= -1.4572) {
            p = WekaClassifier.N40c8be4686(i);
        } else if (((Double) i[9]).doubleValue() > -1.4572) {
            p = 1;
        }
        return p;
    }
    static double N40c8be4686(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() <= -1.2844) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() > -1.2844) {
            p = 0;
        }
        return p;
    }
    static double N3b4406e487(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -3.1973) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -3.1973) {
            p = WekaClassifier.N6f20812188(i);
        }
        return p;
    }
    static double N6f20812188(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -11.3059) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > -11.3059) {
            p = 0;
        }
        return p;
    }
    static double N3efdd68689(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -2.5967) {
            p = WekaClassifier.Nb0f17b990(i);
        } else if (((Double) i[4]).doubleValue() > -2.5967) {
            p = 1;
        }
        return p;
    }
    static double Nb0f17b990(Object []i) {
        double p = Double.NaN;
        if (i[12] == null) {
            p = 1;
        } else if (((Double) i[12]).doubleValue() <= 2.1776) {
            p = 1;
        } else if (((Double) i[12]).doubleValue() > 2.1776) {
            p = WekaClassifier.Nbde785b91(i);
        }
        return p;
    }
    static double Nbde785b91(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -0.083688) {
            p = WekaClassifier.N3aafa47392(i);
        } else if (((Double) i[8]).doubleValue() > -0.083688) {
            p = 1;
        }
        return p;
    }
    static double N3aafa47392(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 8.7402) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() > 8.7402) {
            p = 1;
        }
        return p;
    }
    static double N6155981e93(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 30.0794) {
            p = WekaClassifier.N3a760b7e94(i);
        } else if (((Double) i[0]).doubleValue() > 30.0794) {
            p = WekaClassifier.N6aecc07d102(i);
        }
        return p;
    }
    static double N3a760b7e94(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 7.3237) {
            p = WekaClassifier.N1bec9b2e95(i);
        } else if (((Double) i[0]).doubleValue() > 7.3237) {
            p = WekaClassifier.N5c6c531799(i);
        }
        return p;
    }
    static double N1bec9b2e95(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -5.0142) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -5.0142) {
            p = WekaClassifier.N4abff75496(i);
        }
        return p;
    }
    static double N4abff75496(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 0;
        } else if (((Double) i[10]).doubleValue() <= 2.0243) {
            p = 0;
        } else if (((Double) i[10]).doubleValue() > 2.0243) {
            p = WekaClassifier.N106d22397(i);
        }
        return p;
    }
    static double N106d22397(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() <= -1.0713) {
            p = WekaClassifier.N66cdf85b98(i);
        } else if (((Double) i[11]).doubleValue() > -1.0713) {
            p = 0;
        }
        return p;
    }
    static double N66cdf85b98(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 2.4935) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 2.4935) {
            p = 0;
        }
        return p;
    }
    static double N5c6c531799(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -13.0427) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -13.0427) {
            p = WekaClassifier.N4bc33a68100(i);
        }
        return p;
    }
    static double N4bc33a68100(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 23.2632) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 23.2632) {
            p = WekaClassifier.N7e2fa8b3101(i);
        }
        return p;
    }
    static double N7e2fa8b3101(Object []i) {
        double p = Double.NaN;
        if (i[12] == null) {
            p = 0;
        } else if (((Double) i[12]).doubleValue() <= -4.0238) {
            p = 0;
        } else if (((Double) i[12]).doubleValue() > -4.0238) {
            p = 1;
        }
        return p;
    }
    static double N6aecc07d102(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -9.6145) {
            p = WekaClassifier.N5d518562103(i);
        } else if (((Double) i[1]).doubleValue() > -9.6145) {
            p = 0;
        }
        return p;
    }
    static double N5d518562103(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -4.2805) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > -4.2805) {
            p = WekaClassifier.N130c14cb104(i);
        }
        return p;
    }
    static double N130c14cb104(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 32.9142) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 32.9142) {
            p = 0;
        }
        return p;
    }
}