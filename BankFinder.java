import java.util.* ;
public class BankFinder{
	public static int distanceCalculator(Coordination a, Coordination b){
        return((a.x - b.x)*(a.x - b.x) + (a.y-b.y)*(a.y-b.y));
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    	System.out.println("Hi! welcome to Bank Finder!");
    	while(true){
    		String order = scanner.nextLine();
    		if (order.equals("addN")){
    			System.out.println("Please enter your neighborhood name:\n");
    			String name = scanner.nextLine();
    			if(TrieTree.searchForNeighborhood(name)!=null){
    				System.out.println("A neighborhood with this name already exists!");
    			} else{
    				System.out.println("Left up:\n");	
    				Coordination LU = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
    				System.out.println("Left down:\n");	
	    			Coordination LD = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
	    			System.out.println("Right up: \n");
	    			Coordination RU = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
	    			System.out.println("Right down: \n");
	    			Coordination RD = new Coordination(scanner.nextInt(), scanner.nextInt()) ;
	    			Neighborhood neighborhood = new Neighborhood(LU,LD,RU,RD, name);
    			}
    			
    		}
    		else if(order.equals("addB")){

    			System.out.println("please enter a name to build a bank!");
    			String name = scanner.nextLine();
    			if(TrieTree.searchForBank(name) != null){
    				System.out.println("a bank with this name already exists!");
    			} else {
	    			System.out.println("please enter your desired coordination to build a bank!");
	    			int x = scanner.nextInt();
	    			int y =scanner.nextInt();
	    			Bank mainBank = new Bank(new Coordination(x, y),name);

	    			if(Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(), mainBank,0 ) != null){
	    				System.out.println("This coordination is Taken! Please choose another coordination!");
	    			}else{
		    			Bank.addToKDTree(mainBank);
		    			Bank.allBanksKDTree.getAllNodes();
		    			mainBank.addBankToTriTree(mainBank);
		    			System.out.println("Bank is successfully added");
	    			}
	    		}

    		}
    		else if (order.equals("addBr")){

    			System.out.println("please enter your desired cordination, Bank name and branch name to build a branch!");
    			String bankn =scanner.nextLine();
    			if(TrieTree.searchForBank(bankn) == null){
    				System.out.println("There is not such a bank");
    			} else{
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
    			System.out.println("Please enter name of the bank:\n");
    			String name =scanner.nextLine();
    			if(TrieTree.searchForBank(name)== null){
    				System.out.println("There is not such a bank");
    			}
    			else{
    				System.out.println("Number of branches: "+TrieTree.searchForBank(name).noBranches);
    				TrieTree.searchForBank(name).getAllBranches();
    			}
    		}
    		else if(order.equals("nearB")){
    			System.out.println("Please enter your desiered cordination:\n");
    			Coordination c = new Coordination(scanner.nextInt(), scanner.nextInt());
    			Node ans  = Bank.allBanksKDTree.nearestNeighborRec(new Node(c),Bank.allBanksKDTree.getRoot() ,
    				new Node(new Coordination(Integer.MAX_VALUE , Integer.MAX_VALUE)),0);
    			int r= distanceCalculator(ans.coordination,c);
    			Bank.allBanksKDTree.printDistanceD(Bank.allBanksKDTree.getRoot(),c,r,0);
    			System.out.println("The nearest bank is "+ ans.place.name +" at "+ans.coordination.toString());
    		}
    		else if(order.equals("nearBr")){
    			System.out.println("Please enter the name of the bank:\n");
    			String name =scanner.nextLine();
    			if(TrieTree.searchForBank(name)== null){
    				System.out.println("There is not such a bank");
    			}
    			else{
    				Bank b = TrieTree.searchForBank(name);
    				Coordination c = new Coordination(scanner.nextInt(), scanner.nextInt());
    				KDTree theBranchs = b.branches;
    				Node ans  = theBranchs.nearestNeighborRec(new Node(c),theBranchs.getRoot(),
    					new Node(new Coordination(Integer.MAX_VALUE , Integer.MAX_VALUE)),0);
    				int r = distanceCalculator(ans.coordination, c);
    				if(distanceCalculator(b.coordination,c)<r)
    					System.out.println("The nearest branch of "+b.name+" is at "+b.coordination.toString());
    				else{
    					if(distanceCalculator(b.coordination,c)==r)
    						System.out.println(b.name+ "(main Bank): "+b.coordination.toString());
    					b.branches.printDistanceD(b.branches.getRoot(),c,r,0);
    				}
    				
    			}
    		}
    		else if(order.equals("availB")){
    			System.out.println("Please enter R:\n");
    			double r = scanner.nextDouble();
    			System.out.println("Please enter your desiered cordination:\n");
    			Coordination c= new Coordination(scanner.nextInt(), scanner.nextInt());
    			Bank.allBanksKDTree.findAvailableR(Bank.allBanksKDTree.getRoot(),c,r, 0);
    		}
    		else if(order.equals("listB")){
    			System.out.println("Please enter your desiered neighborhood name:\n");
    			String name = scanner.nextLine();
    			Neighborhood n = TrieTree.searchForNeighborhood(name);
    			Bank.allBanksKDTree.neighborhoodCheckbank(Bank.allBanksKDTree.getRoot(),n,0);
    			
    		}
    	}
	}
}