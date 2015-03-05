package edu.dartmouth.asthmaguard;

/**
 * Created by Junior on 3/5/15.
 */
class WekaClassifier {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaClassifier.N39c9e08a0(i);
        return p;
    }
    static double N39c9e08a0(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -10.9749) {
            p = WekaClassifier.N74b4a1a91(i);
        } else if (((Double) i[2]).doubleValue() > -10.9749) {
            p = WekaClassifier.N693a5d7e5(i);
        }
        return p;
    }
    static double N74b4a1a91(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() <= -2.9156) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() > -2.9156) {
            p = WekaClassifier.N7ee19a1a2(i);
        }
        return p;
    }
    static double N7ee19a1a2(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 5.3532) {
            p = WekaClassifier.Nd4c620a3(i);
        } else if (((Double) i[0]).doubleValue() > 5.3532) {
            p = 1;
        }
        return p;
    }
    static double Nd4c620a3(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -14.023) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > -14.023) {
            p = WekaClassifier.N11b885584(i);
        }
        return p;
    }
    static double N11b885584(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= 2.3005) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() > 2.3005) {
            p = 0;
        }
        return p;
    }
    static double N693a5d7e5(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -11.782) {
            p = WekaClassifier.N76d0312a6(i);
        } else if (((Double) i[3]).doubleValue() > -11.782) {
            p = WekaClassifier.N404ca42a19(i);
        }
        return p;
    }
    static double N76d0312a6(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 13.6397) {
            p = WekaClassifier.N5e4bf9567(i);
        } else if (((Double) i[0]).doubleValue() > 13.6397) {
            p = WekaClassifier.N6917302215(i);
        }
        return p;
    }
    static double N5e4bf9567(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 6.0512) {
            p = WekaClassifier.N4ddead778(i);
        } else if (((Double) i[0]).doubleValue() > 6.0512) {
            p = 0;
        }
        return p;
    }
    static double N4ddead778(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -11.4493) {
            p = WekaClassifier.N564e87919(i);
        } else if (((Double) i[5]).doubleValue() > -11.4493) {
            p = WekaClassifier.N3da66cdb10(i);
        }
        return p;
    }
    static double N564e87919(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -17.0702) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > -17.0702) {
            p = 0;
        }
        return p;
    }
    static double N3da66cdb10(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -5.9472) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -5.9472) {
            p = WekaClassifier.N7934bd7b11(i);
        }
        return p;
    }
    static double N7934bd7b11(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -11.7297) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -11.7297) {
            p = WekaClassifier.N7584146712(i);
        }
        return p;
    }
    static double N7584146712(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -6.2556) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > -6.2556) {
            p = WekaClassifier.N3257b27713(i);
        }
        return p;
    }
    static double N3257b27713(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -0.22356) {
            p = WekaClassifier.N1b85bc7314(i);
        } else if (((Double) i[0]).doubleValue() > -0.22356) {
            p = 0;
        }
        return p;
    }
    static double N1b85bc7314(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -1.8611) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -1.8611) {
            p = 0;
        }
        return p;
    }
    static double N6917302215(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 72.9248) {
            p = WekaClassifier.N71593e1416(i);
        } else if (((Double) i[0]).doubleValue() > 72.9248) {
            p = WekaClassifier.N20b4d5fc18(i);
        }
        return p;
    }
    static double N71593e1416(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 65.5063) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 65.5063) {
            p = WekaClassifier.N19facd2f17(i);
        }
        return p;
    }
    static double N19facd2f17(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -3.1242) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -3.1242) {
            p = 0;
        }
        return p;
    }
    static double N20b4d5fc18(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -16.7824) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > -16.7824) {
            p = 0;
        }
        return p;
    }
    static double N404ca42a19(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -15.6809) {
            p = WekaClassifier.N67ade26020(i);
        } else if (((Double) i[1]).doubleValue() > -15.6809) {
            p = WekaClassifier.N779231e126(i);
        }
        return p;
    }
    static double N67ade26020(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -2.5365) {
            p = WekaClassifier.N48e941cd21(i);
        } else if (((Double) i[3]).doubleValue() > -2.5365) {
            p = WekaClassifier.N577493c323(i);
        }
        return p;
    }
    static double N48e941cd21(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= -8.9709) {
            p = WekaClassifier.N49df1f2022(i);
        } else if (((Double) i[4]).doubleValue() > -8.9709) {
            p = 1;
        }
        return p;
    }
    static double N49df1f2022(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -0.22101) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -0.22101) {
            p = 1;
        }
        return p;
    }
    static double N577493c323(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -3.384) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > -3.384) {
            p = WekaClassifier.N2691141024(i);
        }
        return p;
    }
    static double N2691141024(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -5.0463) {
            p = WekaClassifier.N7ebc3a3725(i);
        } else if (((Double) i[2]).doubleValue() > -5.0463) {
            p = 0;
        }
        return p;
    }
    static double N7ebc3a3725(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -0.077985) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() > -0.077985) {
            p = 1;
        }
        return p;
    }
    static double N779231e126(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -13.1192) {
            p = WekaClassifier.N1f08e81b27(i);
        } else if (((Double) i[6]).doubleValue() > -13.1192) {
            p = WekaClassifier.N4009ef5433(i);
        }
        return p;
    }
    static double N1f08e81b27(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -5.2516) {
            p = WekaClassifier.N1be548828(i);
        } else if (((Double) i[2]).doubleValue() > -5.2516) {
            p = WekaClassifier.N769fad9c29(i);
        }
        return p;
    }
    static double N1be548828(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -4.7126) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > -4.7126) {
            p = 1;
        }
        return p;
    }
    static double N769fad9c29(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -5.8774) {
            p = WekaClassifier.N6d3f199b30(i);
        } else if (((Double) i[1]).doubleValue() > -5.8774) {
            p = 1;
        }
        return p;
    }
    static double N6d3f199b30(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 13.6397) {
            p = WekaClassifier.N49aa472531(i);
        } else if (((Double) i[0]).doubleValue() > 13.6397) {
            p = WekaClassifier.N4a24f3eb32(i);
        }
        return p;
    }
    static double N49aa472531(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -7.4409) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > -7.4409) {
            p = 0;
        }
        return p;
    }
    static double N4a24f3eb32(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 70.2177) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 70.2177) {
            p = 0;
        }
        return p;
    }
    static double N4009ef5433(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -17.5254) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > -17.5254) {
            p = WekaClassifier.N4c3f94a434(i);
        }
        return p;
    }
    static double N4c3f94a434(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 13.6397) {
            p = WekaClassifier.N6237c21735(i);
        } else if (((Double) i[0]).doubleValue() > 13.6397) {
            p = WekaClassifier.N7f6e8cd55(i);
        }
        return p;
    }
    static double N6237c21735(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -12.9223) {
            p = WekaClassifier.N3aa7a66136(i);
        } else if (((Double) i[1]).doubleValue() > -12.9223) {
            p = WekaClassifier.N6052bb6938(i);
        }
        return p;
    }
    static double N3aa7a66136(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -4.2617) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > -4.2617) {
            p = WekaClassifier.N549c485c37(i);
        }
        return p;
    }
    static double N549c485c37(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -8.1079) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > -8.1079) {
            p = 0;
        }
        return p;
    }
    static double N6052bb6938(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 1.6564) {
            p = WekaClassifier.N578e1be639(i);
        } else if (((Double) i[5]).doubleValue() > 1.6564) {
            p = WekaClassifier.N6fcc6d352(i);
        }
        return p;
    }
    static double N578e1be639(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 0.40098) {
            p = WekaClassifier.N32c9c5f240(i);
        } else if (((Double) i[0]).doubleValue() > 0.40098) {
            p = 0;
        }
        return p;
    }
    static double N32c9c5f240(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -9.1832) {
            p = WekaClassifier.N5ce2acea41(i);
        } else if (((Double) i[8]).doubleValue() > -9.1832) {
            p = WekaClassifier.N46597a643(i);
        }
        return p;
    }
    static double N5ce2acea41(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -1.6366) {
            p = WekaClassifier.N25c6664a42(i);
        } else if (((Double) i[6]).doubleValue() > -1.6366) {
            p = 0;
        }
        return p;
    }
    static double N25c6664a42(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 1.5677) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 1.5677) {
            p = 0;
        }
        return p;
    }
    static double N46597a643(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -7.8908) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > -7.8908) {
            p = WekaClassifier.N29c7158b44(i);
        }
        return p;
    }
    static double N29c7158b44(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -10.4909) {
            p = WekaClassifier.N4d576e1a45(i);
        } else if (((Double) i[1]).doubleValue() > -10.4909) {
            p = WekaClassifier.N7c1c5a0d48(i);
        }
        return p;
    }
    static double N4d576e1a45(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -9.4401) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > -9.4401) {
            p = WekaClassifier.N26fd94a146(i);
        }
        return p;
    }
    static double N26fd94a146(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -10.8576) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -10.8576) {
            p = WekaClassifier.N5228ea0647(i);
        }
        return p;
    }
    static double N5228ea0647(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= -6.5228) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > -6.5228) {
            p = 0;
        }
        return p;
    }
    static double N7c1c5a0d48(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -7.9741) {
            p = WekaClassifier.N295c4b2349(i);
        } else if (((Double) i[6]).doubleValue() > -7.9741) {
            p = WekaClassifier.N6a48fc0b50(i);
        }
        return p;
    }
    static double N295c4b2349(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() <= -1.7278) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() > -1.7278) {
            p = 0;
        }
        return p;
    }
    static double N6a48fc0b50(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 0;
        } else if (((Double) i[10]).doubleValue() <= -8.1774) {
            p = WekaClassifier.N5d9b6cb051(i);
        } else if (((Double) i[10]).doubleValue() > -8.1774) {
            p = 0;
        }
        return p;
    }
    static double N5d9b6cb051(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -7.675) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -7.675) {
            p = 0;
        }
        return p;
    }
    static double N6fcc6d352(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() <= -1.4806) {
            p = WekaClassifier.N3d614a3a53(i);
        } else if (((Double) i[10]).doubleValue() > -1.4806) {
            p = 0;
        }
        return p;
    }
    static double N3d614a3a53(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -2.3837) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -2.3837) {
            p = WekaClassifier.N3e50455154(i);
        }
        return p;
    }
    static double N3e50455154(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 9.5091) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > 9.5091) {
            p = 1;
        }
        return p;
    }
    static double N7f6e8cd55(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 66.0981) {
            p = WekaClassifier.N632deed056(i);
        } else if (((Double) i[0]).doubleValue() > 66.0981) {
            p = WekaClassifier.N327cfd7268(i);
        }
        return p;
    }
    static double N632deed056(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= 0.010647) {
            p = WekaClassifier.N5c99cc8e57(i);
        } else if (((Double) i[3]).doubleValue() > 0.010647) {
            p = WekaClassifier.N167fdec566(i);
        }
        return p;
    }
    static double N5c99cc8e57(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= 8.5115) {
            p = WekaClassifier.N7544ae2058(i);
        } else if (((Double) i[6]).doubleValue() > 8.5115) {
            p = 0;
        }
        return p;
    }
    static double N7544ae2058(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -2.5653) {
            p = WekaClassifier.N7003f30559(i);
        } else if (((Double) i[2]).doubleValue() > -2.5653) {
            p = WekaClassifier.N5db0e24461(i);
        }
        return p;
    }
    static double N7003f30559(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() <= 3.3144) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() > 3.3144) {
            p = WekaClassifier.N134806b760(i);
        }
        return p;
    }
    static double N134806b760(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 61.698) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 61.698) {
            p = 0;
        }
        return p;
    }
    static double N5db0e24461(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 47.7777) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 47.7777) {
            p = WekaClassifier.N7d70e6a62(i);
        }
        return p;
    }
    static double N7d70e6a62(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -8.7662) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() > -8.7662) {
            p = WekaClassifier.N37f3552b63(i);
        }
        return p;
    }
    static double N37f3552b63(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 1.2672) {
            p = WekaClassifier.N485c96bf64(i);
        } else if (((Double) i[2]).doubleValue() > 1.2672) {
            p = 0;
        }
        return p;
    }
    static double N485c96bf64(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -2.9226) {
            p = WekaClassifier.N36acfab665(i);
        } else if (((Double) i[3]).doubleValue() > -2.9226) {
            p = 0;
        }
        return p;
    }
    static double N36acfab665(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -1.706) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -1.706) {
            p = 0;
        }
        return p;
    }
    static double N167fdec566(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 46.8987) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 46.8987) {
            p = WekaClassifier.N24fa630d67(i);
        }
        return p;
    }
    static double N24fa630d67(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -3.5467) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > -3.5467) {
            p = 0;
        }
        return p;
    }
    static double N327cfd7268(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -8.2501) {
            p = WekaClassifier.N2be3614369(i);
        } else if (((Double) i[2]).doubleValue() > -8.2501) {
            p = 0;
        }
        return p;
    }
    static double N2be3614369(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 69.1545) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 69.1545) {
            p = 0;
        }
        return p;
    }
}