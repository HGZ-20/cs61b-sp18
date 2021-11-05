public class GuitarHero {
    private static final double CONCERT = 440.0;
    private static final double[] CONCERT_ARRAY = new double[37];

    public static void main(String[] args) {
        for (int i = 0; i < 37; i++) {
            CONCERT_ARRAY[i] = CONCERT * Math.pow(2, (i - 24) / 12);
        }
        /* create two guitar strings, for concert all */
        synthesizer.GuitarString[] stringArray = new synthesizer.GuitarString[37];
        for (int i = 0; i < 37; i++) {
            stringArray[i] = new synthesizer.GuitarString(CONCERT_ARRAY[i]);
        }

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index < 0) {
                    continue;
                }
                stringArray[index].pluck();
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (synthesizer.GuitarString x:stringArray) {
                sample += x.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (synthesizer.GuitarString x:stringArray) {
                x.tic();
            }
        }
    }
}


