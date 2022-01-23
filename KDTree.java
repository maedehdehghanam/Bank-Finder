public class KDTree{
	public Node root = null ;
    public static int k = 2 ;

    public Node getRoot() {
        return root;
    }
    // Here we start from node and 
    public Node insertNodeRecursive(Node root, Bank place, int depth)
    {

        if (root == null){
            root = new Node(place.coordination, place);
            return root ;
        }
        // we are at dimention X
        if(depth % k == 0){

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
    //searching the tree looking for a coordination
    public Node searchTreeRecursive(Node root, Bank place ,  int depth){
    	if(root == null){
    		return null;
    	}
    	if(root.coordination == place.coordination){
    		return root;
    	}
    	// we are at dimention X 
    	if(depth%2 == 0){
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

}