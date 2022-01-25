public class KDTree{
	public Node root = null ;
    public static int k = 2 ;

    public Node getRoot() {
        return root;
    }
    // Here we start from node and 
    public void insert(Bank place){
        root = insertNodeRecursive(root,place,0);
    }
    public Node insertNodeRecursive(Node root, Bank place, int depth)
    {

        if (root == null){
            root = new Node(place.coordination, place);

            return root ;
        }
        int theDimention = depth % k;
        // we are at dimention X
        if(theDimention == 0){
            System.out.println("done222");
            if(place.coordination.x < root.coordination.x){
                root.left = insertNodeRecursive(root.left,place ,depth+1);
            }
            else{
                root.right = insertNodeRecursive(root.right ,place , depth + 1);
            }
        }

        // we are at dimention X
        else{

            if(place.coordination.y < root.coordination.y){
                root.left = insertNodeRecursive(root.left ,  place, depth+1);
            }
            else{
                root.right = insertNodeRecursive(root.right  ,place , depth + 1);
            }
        }

        return root;
    }
    //searching the tree looking for a coordination of a bank
    public Node searchTreeRecursive(Node root, Bank place ,  int depth){
    	if(root == null){
    		return null;
    	}
    	if(root.coordination.equals(place.coordination)){
    		return root;
    	}
        int theDimention = depth % k;
    	// we are at dimention X 
    	if(theDimention == 0){
    		if(place.coordination.x < root.coordination.x){
    			return searchTreeRecursive(root.left, place, depth+1);
    		}
    		else{
    			return searchTreeRecursive(root.right, place, depth+1);
    		}
    	}
    	// we are at dimention X
    	else{
    		if(place.coordination.y < root.coordination.y){
    			return searchTreeRecursive(root.left, place, depth+1);
    		}
    		else{
    			return searchTreeRecursive(root.right, place, depth+1);
    		}
    	}
    }
    //getting all nodes using preorder method
    public void getAllNodes(){
    	this.printPreorder(this.root);
    }
    public void printPreorder(Node node)
    {
        if (node == null){
            System.out.println("fuck!");
            return;
        }
        //if (! node.getCoordinatio().equals(this.root.getCoordinatio())) {
        
            System.out.println(node.getNodeDetailes());
        //}
        
        /* then recur on left subtree */
        printPreorder(node.left);
 
        /* now recur on right subtree */
        printPreorder(node.right);
    }


    public static Node minNode(Node x, Node y, Node z, int d) {
        Node res = x;

        if(d == 0){
            if (y != null && y.coordination.x < res.coordination.x)
                res = y;
            if (z != null && z.coordination.x < res.coordination.x)
                res = z;
        }

        else if(d == 1){
            if (y != null && y.coordination.y < res.coordination.y)
                res = y;
            if (z != null && z.coordination.y < res.coordination.y)
                res = z;
        }

        return res;
    }
    //compares three nodes in a dimention
    public static Node minNodeFinder(Node one, Node two, Node three, int d) {
        Node ans ;

        if(d == 0){
            if (two != null && two.coordination.x < one.coordination.x)
                ans = two;
            if (three != null && three.coordination.x < one.coordination.x)
                ans = three;
            else 
                ans = one;
        }
        else{
            if (two != null && two.coordination.y < one.coordination.y)
                 ans = two;
            if (three != null && three.coordination.y < one.coordination.y)
                ans = three;
            else 
                ans = one;
        }
        return ans;
    }
    public static Node findMin(Node root , int dimension , int depth){

        if(root == null) 
            return null;
        /* 
        if we are in the same dimention that we are trying to find the minimum,
        we only continue searching on the left side of the tree, just like BST.
        */
        int theDimention = depth % k;
        if(theDimention == dimension){
            if(root.left == null)
                return root;
            return findMin(root.left , dimension , depth + 1);

        }
        /* 
        if we are not in the same dimention that we are trying to find the minimum,
        we continue searching on both side of the tree, cause the minimum is based on another dimention.
        so the minimum of the root and the left and right side, is the minimum.
        */
        else{
            return minNodeFinder(root , findMin(root.left ,dimension , depth + 1) ,
            findMin(root.right , dimension , depth +1) , dimension);
        }
        
    }

    public Node deleteNode(Node root , Node place , int depth){

        //finding the dimention that we are checking

        int theDimention = depth % k;

        if(root == null) 
            return null;
        
        //HERE we start to delete the node by finding the minimum
        if(root.coordination.equals(place.coordination)){
            if(root.right != null){
                Node min = findMin(root.right , (theDimention) , 0);
                root.coordination = min.coordination;
                root.place = min.place;
                root.right = deleteNode(root.right, min, depth+1);
            }
            else if(root.left != null){
                Node min = findMin(root.left,  theDimention, 0);
                root.coordination = min.coordination;
                root.place = min.place;
                root.left = deleteNode(root.left, min, depth+1);
            }
            else{
                return null;
            }
        }
        // if the wanted node is not equal to the root, it means we have too
        // go overthe tree to finde the wanted node
        // X dimention
        if( theDimention == 0){

            if(root.coordination.x > place.coordination.x){
               root.left =  deleteNode(root.left , place , depth + 1);
            }
            else{
              root.right =  deleteNode(root.right , place , depth + 1);
            }

        }
        // Y dimention 
        else if( theDimention == 1){

            if(root.coordination.y > place.coordination.y){
             root.left  =  deleteNode(root.left , place , depth + 1);
            }
            else{
               root.right = deleteNode(root.right ,place , depth + 1);
            }
        }

        return root; 
    }
    public int distanceCalculator(Coordination a, Coordination b){
        return((a.x - b.x)*(a.x - b.x) + (a.y-b.y)*(a.y-b.y));
    }
    public  Node nearestNeighborRec(Node point , Node root ,  Node bestNode , int depth){

        if(root == null) 
            return bestNode;

        if(distanceCalculator(point.coordination,root.coordination) 
            < distanceCalculator(point.coordination,bestNode.coordination)) 
            bestNode = root;

        int currentDimension = depth % k;

        Node goodSide=  null ;
        // X
        if(currentDimension == 0){

            if(point.coordination.x <  root.coordination.x){
                goodSide = root.left ;
            }
            else{
                goodSide = root.right ;
            }
        }

        // Y
        else if(currentDimension == 1){

            if(point.coordination.y <  root.coordination.y){
                goodSide = root.left ;
            }
            else{
                goodSide = root.right ;
            }
        }
        bestNode = nearestNeighborRec(point , goodSide , bestNode , depth + 1);

        return bestNode ;

    }
}