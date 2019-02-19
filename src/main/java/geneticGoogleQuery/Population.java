package geneticGoogleQuery;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Population {

    public  static int populationNumber = 5;
    private Individual[] individuals;

    public Population(boolean init) {
        individuals = new Individual[populationNumber];

        if (init) {
            for (int i = 0; i < populationNumber; i++) {
                individuals[i] = new Individual(init);
            }
        }
    }


    public List<Individual> getMatingPool(Population pop){

        List<Individual> matingPool = new ArrayList<>();

        for(Individual indi : pop.individuals){

            for (int i = 0; i < indi.getFittness(); i++) {
                matingPool.add(indi);
            }
        }
        return matingPool;
    }


    public Individual getFittest(){

        Individual fittest = new Individual(false);
        int fittnessLevel=0;

        for(Individual i : individuals){
            int newfit = FitnessCalc.getFitness(i);
            if(newfit > fittnessLevel){
                fittest=i;
                fittnessLevel = newfit;
            }
        }

        return fittest;
    }
}
