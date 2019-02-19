package geneticGoogleQuery;


import java.util.concurrent.ThreadLocalRandom;

public class EvolutionHandler {
	
	public static double mutationrate = 0.2d;
	public static int mutations =0;

	public Population evolve(Population population) {

		Population newPopulation = new Population(false);

		for (int i = 0; i < Population.populationNumber; i++) {

			int randomA = ThreadLocalRandom.current().nextInt(1, population.getMatingPool(population).size());
			int randomB = ThreadLocalRandom.current().nextInt(1, population.getMatingPool(population).size());

			Individual a = population.getMatingPool(population).get(randomA);
			Individual b = population.getMatingPool(population).get(randomB);

			Individual newIndi = crossover(a, b);

			newPopulation.getIndividuals()[i]= newIndi;
		}

		return newPopulation;
	}

	public Individual crossover(Individual a, Individual b) {

		Individual newIndi = new Individual(false);

		for (int i = 0; i < FitnessCalc.sol; i++) {
			int crossOverPoint = (int) Math.round(Math.random() * FitnessCalc.sol - 1);

			if (i <= crossOverPoint)
				newIndi.getGene()[i] = a.getGene()[i];
			else {
				newIndi.getGene()[i] = b.getGene()[i];
			}

		}

		mutate(newIndi);

		return newIndi;
	}

	private void mutate(Individual indi) {

		if (Math.random() <= mutationrate) {
			int random = ThreadLocalRandom.current().nextInt(0, FitnessCalc.sol-1 + 1);
			char c = (char) ThreadLocalRandom.current().nextInt(97, 122 + 1);
			indi.getGene()[random] = c;
			mutations++;

		} else
			return;

	}

}
