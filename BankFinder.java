import java.util.* ;
public class BankFinder{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    	System.out.println("Hi! welcome to Bank Finder!");
    	while(true){
    		String order = scanner.nextLine();
    		if (order.equals("addN")){
    			String name = scanner.nextLine();
    			Coordination LU = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Coordination LD = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Coordination RU = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Coordination RD = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    			Neighborhood neighborhood = new Neighborhood(LU,LD,RU,RD, name);
    		}
    		else if(order.equals("addB")){

    			System.out.println("please enter a name to build a bank!");
    			String name = scanner.nextLine();
    			while(TrieTree.searchForBank(name) != null){
    				System.out.println("a bank with this name already exists!");
    				name = scanner.nextLine();
    			}
    			System.out.println("please enter your desired coordination to build a bank!");
    			int x = scanner.nextInt();
    			int y =scanner.nextInt();
    			Bank mainBank = new Bank(new Coordination(x, y),name);

    			while(Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), mainBank,0 ) != null){
    				System.out.println("This coordination is Taken! Please choose another coordination!");
    				mainBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),scanner.nextLine());
    			}
    			Bank.addToKDTree(mainBank);
    			Bank.allBanksKDTree.getAllNodes();
    			mainBank.addBankToTriTree(mainBank);
    			System.out.println("Bank is successfully added");
    			scanner.next();

    		}
    		else if (order.equals("addBr")){

    			System.out.println("please enter your desired cordination, Bank name and branch name to build a branch!");
    			String bankn =scanner.nextLine();
    			String branchn=  scanner.nextLine();
    			Bank branchBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),
    				bankn,branchn);

    			while(Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), branchBank,0 ) != null){
    				System.out.println("This coordination is Taken! Please choose another coordination!");
    				branchBank = new Bank(new Coordination(scanner.nextInt(), scanner.nextInt()),
    					scanner.nextLine(),scanner.nextLine());
    			}
    			Bank.addToKDTree(branchBank);
    			TrieTree.searchForBank(branchBank.bankName).addBranch(branchBank);
    			System.out.println("Branch is successfully added");
    		}
    		else if(order.equals("delBr")){
    			Coordination c = new Coordination(scanner.nextInt(), scanner.nextInt());
    			Bank search = new Bank(c,"search");
    			if(Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), search,0 ) == null){
    				System.out.println("There is not a bank here!");
    			}
    			else{
    				search =Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), search,0 ).place;
    				if (search.isBranch) {
    					boolean deleted = TrieTree.searchForBank(search.bankName).deleteBranch(search);
    					if(deleted){
    						System.out.println("Branch is deleted!");
    					}
    					else{
    						System.out.println("this Branch doesn't exists!");
    					}
    				}
    				else{
    					System.out.println("This is the main branch of "+ search.bankName+
    						" bank. You can't delete a main branch!");
    				}
    			}
    			
    		}
    		else if(order.equals("listBrs")){
    			String name =scanner.nextLine();
    			if(TrieTree.searchForBank(name)== null){
    				System.out.println("There is noy such a bank");
    			}
    			else{
    				System.out.println(TrieTree.searchForBank(name).noBranches);
    				TrieTree.searchForBank(name).getAllBranches();
    			}
    		}
    		else if(order.equals("nearB")){
    			Coordination c = new Coordination(scanner.nextInt(), scanner.nextInt());
    			Node ans  = Bank.allBanksKDTree.nearestNeighborRec(new Node(c),Bank.allBanksKDTree.getRoot() ,
    				new Node(new Coordination(Integer.MAX_VALUE , Integer.MAX_VALUE)),0);
    			System.out.println("The nearest bank is "+ ans.place.name +" at "+ans.coordination.toString());
    		}
    		else if(order.equals("nearBr")){
    			String name =scanner.nextLine();
    			if(TrieTree.searchForBank(name)== null){
    				System.out.println("There is not such a bank");
    			}
    			else{
    				Bank b = TrieTree.searchForBank(name);
    				if(b.branches.searchTreeRecursive(b.branches.getRoot(), b, 0) == null){
    					System.out.println("There is not such a bank");
    				}
    				
    				Coordination c = new Coordination(scanner.nextInt(), scanner.nextInt());
    				KDTree theBranchs = b.branches;
    				Node ans  = theBranchs.nearestNeighborRec(new Node(c),theBranchs.getRoot(),
    					new Node(new Coordination(Integer.MAX_VALUE , Integer.MAX_VALUE)),0);
    				System.out.println("The nearest branch of "+ name+" is at "+ans.coordination.toString());
    				
    			}
    		}
    		else if(order.equals("availB")){
    			double r = scanner.nextDouble();
    			Coordination c= new Coordination(scanner.nextInt(), scanner.nextInt());
    			Bank.allBanksKDTree.findAvailableR(Bank.allBanksKDTree.getRoot(),c,r, 0);
    		}
    	}
	}
}