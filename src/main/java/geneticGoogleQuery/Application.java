package geneticGoogleQuery;

public class Application {

    public static void main(String args[]) {

        int generations = 500;

        EvolutionHandler evolution = new EvolutionHandler();
        Population population = new Population(true);

        Individual fittest = new Individual(true);

        for (int i = 0; i < generations; i++) {

            population = evolution.evolve(population);
            if (fittest.getFittness() < population.getFittest().getFittness()) {
                fittest = population.getFittest();
                System.out.println("Genom: '" + new String(fittest.getGene()) + "'  Fitness: " + fittest.getFittness() + "\t Generation: " + i + "  \t Mutations: " + EvolutionHandler.mutations);
//                if (FitnessCalc.getFitness(fittest) >= 200000) {
//                    System.out.println(fittest);
//                    break;
//                }
                System.out.println("**********************");
            }
        }
    }


}
