public class BankFinder{
	public static void main(String[] args) {
		Neighborhood man = new Neighborhood(new Coordination(2,2), new Coordination(2,4),
		 new Coordination(4,2), new Coordination(4,4), "heycutie");
		TrieTree banks = TrieTree.getNeighborhoodNames();
		 banks.insertNeighborhood(man, "heycutie");

	}
}