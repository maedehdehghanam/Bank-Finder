public class Branch{
	private String bankName ;
    private String branchName ;
    private Coordination coordination;

    public Branch(String bankName, String branchName, Coordination coordination) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.coordination = coordination;
    }
}