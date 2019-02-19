package geneticGoogleQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@ToString
@Getter
@Setter
public class Individual {

    private int fittness;
    private char[] gene;


    public Individual(boolean init) {
        gene = new char[FitnessCalc.sol];
        fittness = 1;

        if (init) {

            int min = 97;
            int max = 122;
//			int min = 0;
//			int max = 122;

            for (int i = 0; i < FitnessCalc.sol; i++) {
                int random = ThreadLocalRandom.current().nextInt(min, max + 1);

                char c = (char) random;
                gene[i] = c;

            }
        }
    }


    public boolean containsGene(char c) {

        for (char geneC : gene) {
            if (geneC == c)
                return true;
        }
        return false;
    }

}
