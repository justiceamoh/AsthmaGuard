package edu.dartmouth.asthmaguard;

/**
 * Created by Junior on 3/5/15.
 */

class WekaClassifier {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaClassifier.N7407201c14(i);
        return p;
    }
    static double N7407201c14(Object []i) {
        double p = Double.NaN;
        if (i[13] == null) {
            p = 0;
        } else if (((Double) i[13]).doubleValue() <= 18151.39351563869) {
            p = 0;
        } else if (((Double) i[13]).doubleValue() > 18151.39351563869) {
            p = WekaClassifier.N7fcd49c615(i);
        }
        return p;
    }
    static double N7fcd49c615(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 422.57668860797423) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 422.57668860797423) {
            p = WekaClassifier.N7ea6a7b616(i);
        }
        return p;
    }
    static double N7ea6a7b616(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -3.818402307803302) {
            p = WekaClassifier.N6f4cdeaf17(i);
        } else if (((Double) i[1]).doubleValue() > -3.818402307803302) {
            p = WekaClassifier.N27d3fee421(i);
        }
        return p;
    }
    static double N6f4cdeaf17(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -1.6287614312933716) {
            p = WekaClassifier.N1fafec3f18(i);
        } else if (((Double) i[5]).doubleValue() > -1.6287614312933716) {
            p = 0;
        }
        return p;
    }
    static double N1fafec3f18(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -2.9386517322191867) {
            p = WekaClassifier.N56bf2c5919(i);
        } else if (((Double) i[5]).doubleValue() > -2.9386517322191867) {
            p = 0;
        }
        return p;
    }
    static double N56bf2c5919(Object []i) {
        double p = Double.NaN;
        if (i[12] == null) {
            p = 0;
        } else if (((Double) i[12]).doubleValue() <= 0.5786460786746783) {
            p = WekaClassifier.N20f8b38d20(i);
        } else if (((Double) i[12]).doubleValue() > 0.5786460786746783) {
            p = 1;
        }
        return p;
    }
    static double N20f8b38d20(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() <= -2.1817979489529975) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() > -2.1817979489529975) {
            p = 0;
        }
        return p;
    }
    static double N27d3fee421(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -4.040816394339782) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > -4.040816394339782) {
            p = 1;
        }
        return p;
    }


}
