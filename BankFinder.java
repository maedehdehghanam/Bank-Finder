public class BankFinder{
	public static void main(String[] args) {
		Neighborhood man = new Neighborhood(new Coordination(2,2), new Coordination(2,4),
		 new Coordination(4,2), new Coordination(4,4), "heycutie");
		Neighborhood man2 = new Neighborhood(new Coordination(2,2), new Coordination(2,4),
		 new Coordination(4,2), new Coordination(4,4), "heycutier");
		TrieTree banks = TrieTree.getNeighborhoodNames();
		 banks.insertNeighborhood(man, "heycutie");
		 banks.insertNeighborhood(man2, "heycutier");
		 System.out.println(man.getName());
		Neighborhood h = banks.searchForNeighborhood(man2.getName());
		System.out.println(h.getName());

	}
}