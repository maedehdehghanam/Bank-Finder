import java.util.* ;
public class BankFinder{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    	System.out.println("Hi! welcome to Bank Finder!");
    	String order = scanner.nextLine();
    	while(!order.equals("end")){
    		if (order.equals("addN")){
    			String name = scanner.nextLine();
    			Coordination LU = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Coordination LD = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Coordination RU = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Coordination RD = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Neighborhood neighborhood = new Neighborhood(LU,LD,RU,RD, name);
    		}
    		else if(order.equals("addB")){

    			System.out.println("please enter your desired cordination and a name to build a bank!");

    			Bank mainBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),scanner.nextLine());

    			while(Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), mainBank,0 ) != null){
    				System.out.println("This coordination is Taken! Please choose another coordination!");
    				mainBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),scanner.nextLine());
    			}
    			Bank.addToKDTree(mainBank);
    			mainBank.addBankToTriTree(mainBank);
    			System.out.println("Bank is successfully added");

    		}
    		else if (order.equals("addBr")){
    			System.out.println("please enter your desired cordination, Bank name and branch name to build a branch!");

    			Bank branchBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),
    				scanner.nextLine(),scanner.nextLine());

    			while(Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), branchBank,0 ) != null){
    				System.out.println("This coordination is Taken! Please choose another coordination!");
    				branchBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),
    					scanner.nextLine(),scanner.nextLine());
    			}
    			Bank.addToKDTree(branchBank);
    			TrieTree.searchForBank(branchBank.bankName).addBranch(branchBank);
    			System.out.println("Branch is successfully added");
    		}
    	}
	}
}