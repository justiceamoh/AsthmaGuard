package edu.dartmouth.asthmaguard;

/**
 * Created by Junior on 2/24/15.
 */
public class Utils {

    // Root Mean Squared Energy
    public static double rms(double[] signal){
        double rmsval = 0;
        for (int i=0; i<signal.length; i++)
            rmsval += signal[i]*signal[i];
        rmsval /= signal.length;
        return Math.sqrt(rmsval);
    }

    //Zero Crossings Rate
    // Adapted from: https://github.com/gast-lib/gast-lib/blob/master/library/src/root/gast/audio/processing/ZeroCrossing.java
    public static double zerocross(int sampleRate, double[] signal){

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


}
