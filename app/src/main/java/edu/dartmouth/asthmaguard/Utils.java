package edu.dartmouth.asthmaguard;

/**
 * Created by Junior on 2/24/15.
 */
public class Utils {

    // Root Mean Squared Energy
    public static double rms(short[] signal){
        double rmsval = 0;
        for (int i=0; i<signal.length; i++)
            rmsval += signal[i]*signal[i];
        rmsval /= signal.length;
        return Math.sqrt(rmsval);
    }

    //Zero Crossings Rate
    // Adapted from: https://github.com/gast-lib/gast-lib/blob/master/library/src/root/gast/audio/processing/ZeroCrossing.java
    public static double zerocross(int sampleRate, short[] signal){

        int numSamples = signal.length;
        int numCrossing = 0;
        for (int p = 0; p < numSamples-1; p++)
        {
            if ((signal[p] > 0 && signal[p + 1] <= 0) ||
                    (signal[p] < 0 && signal[p + 1] >= 0))
            {
                numCrossing++;
            }
        }

        float numSecondsRecorded = (float)numSamples/(float)sampleRate;
        float numCycles = numCrossing/2;
        float frequency = numCycles/numSecondsRecorded;
        return frequency;
    }


    public static byte[] short2byte(short[] sData) {
        //convert short to byte
        int shortArraysize = sData.length;
        byte[] bytes = new byte[shortArraysize * 2];
        for (int i = 0; i < shortArraysize; i++) {
            bytes[i * 2] = (byte) (sData[i] & 0x00FF);
            bytes[(i * 2) + 1] = (byte) (sData[i] >> 8);
            sData[i] = 0;
        }
        return bytes;

    }


    public static float[] short2float(short[] sData){
        //convert array of short to float
        float[] floats = new float[sData.length];
        for (int i=0; i<sData.length; i++){
            floats[i] = (float) sData[i];
        }

        return floats;
    }

}
