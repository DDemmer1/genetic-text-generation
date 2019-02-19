package geneticGoogleQuery;


public class FitnessCalc {

	public static int sol = 5;

	public static int getFitness(Individual individual) {

		int fitness = GoogleRequestJsoup.getGoogleHits(new String(individual.getGene()));

		individual.setFittness(fitness);

		return fitness;
	}

}
