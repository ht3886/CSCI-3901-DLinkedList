	class myNode{																// class myNode
		// Define symbols and methods that we will be using in the program to iterate through our data structure
		// This is a Java bean class
		// reference : https://www.javatpoint.com/java-bean
		public String value;										
		public myNode next, prev, up, down;								 
		public myNode() {														// constructor
			next = null;
			prev = null;
			up = null;
			down = null;
			value = "";
		}
		public myNode(String data, myNode n, myNode p, myNode u, myNode d) {	// constructor
			value = data;
			next = n;
			prev = p;
			up = u;
			down = d;
		}
		public void setNext(myNode n) {							// setter methdod to traverse to next node
			next = n;
		}
		public void setPrev(myNode p) {							// setter method to traverse to previous node
			prev = p;
		}
		public void setUp(myNode u) {							// setter method used to traverse in next hierarchical row
			up = u;
		}
		public void setDown(myNode d) {							// setter method used to traverse in next hierarchical row
			down = d;
		}
		public myNode getUp() {									// getter method used to traverse in next hierarchical row
			return up;
		}
		public myNode getDown() {								// getter method used to traverse in next hierarchical row
			return down;
		}
		public myNode getNext() {								// getter methdod to get next node
			return next;
		}
		public myNode getPrev() {								// getter methdod to get previous node
			return prev;
		}
		public void setData(String data) {						// setter methdod to set node value
			value=data;
		}
		public String getData() {								// getter methdod to get node value
			return value;
		}
	} //end of class myNode
	
	
	class myList{
		// define symbols to be used in performing operations in data structure
		public myNode firstNode;
		public myNode secondFirstNode;
		public int size;	
		public int lowerSize;
		
		public myList() {										// constructor	
		firstNode = null;
		secondFirstNode = null;
		size = 0;
		lowerSize = 0;
		}       
	       
		public boolean add(String key, int level ) {			// add method, used to add key to data structure
		myNode node = new myNode(key, null, null, null, null);	// new object of class myNode
		myNode x,y;												// declaring temporary variables, used in iterating through the list
		boolean flag = false;
			if (firstNode == null) {		
				// add in begining if list is empty
				flag = true;
				firstNode = node;
			}
			else if(key.compareToIgnoreCase(firstNode.getData()) <= 0) {	
				// compare string lexicographically and add in left side of the data structure
				node.setNext(firstNode);
				firstNode.setPrev(node);
				firstNode=node;
				flag = true;
			}
			else {
				x = firstNode;
				y = firstNode.getNext();
				while(y!=null) {
					if(key.compareToIgnoreCase(x.getData()) >=0 && key.compareToIgnoreCase(y.getData()) <=0) {
						// compare string lexicographically and add in right side of the data structure
						x.setNext(node);
						node.setPrev(x);
						node.setNext(y);
						y.setPrev(node);
						flag = true;
						break;
					}
					else{
						x=y;
						y=y.getNext();
					}
				}
				if (!flag) {
					x.setNext(node);
					node.setPrev(x);
				}
				lowerSize++;
				flag = true;
			}
			
			if(level > 0) {								// adding nodes to higher level
			myNode temp = firstNode;
				while(temp.getNext()!=null) {
					if(temp.getData()==key) {
					temp.setUp(node);
					node.setData(key);
					size++;
					flag = true;
						if(size == 1) {
						secondFirstNode = node;
						flag = true;
						} 
						else if (key.compareToIgnoreCase(secondFirstNode.getData()) <= 0){
						node.setNext(secondFirstNode);
						secondFirstNode.setPrev(node);
						secondFirstNode=node;
						flag = true;
						} 
						else {
						x = secondFirstNode;
						y = secondFirstNode.getNext();
							while(y!=null) {
								if(key.compareToIgnoreCase(x.getData()) >=0 && key.compareToIgnoreCase(y.getData()) <=0) {
								x.setNext(node);
								node.setPrev(x);
								node.setNext(y);
								y.setPrev(node);
								flag = true;
								break;
								}
								else{
								x=y;
								y=y.getNext();
								flag = true;
								}
							}
							if (!flag) {
							x.setNext(node);
							node.setPrev(x);
							}
							flag = true;
						}
					}
					temp=temp.getNext();
				}
			}
			return flag;
		}
		
		public boolean find(String key) {				// function to find key in data structure
			myNode temp = firstNode;
			boolean flag = false;
			if(temp==null) {
				// finding an element when list is empty
				System.out.println("List is empty");
				return false;
			}
			else {
				// iterating through the list until "key" is found
				while(temp.getNext()!=null) {
					if(temp.getData().compareTo(key) == 0) {
						flag=true;
						break;
			}
				temp=temp.getNext();
				}
				if(temp.getData().compareTo(key) == 0) {
					flag=true;
				}
				else {
					flag=false;
				}
				return flag;
			}
		}
		
			  
	}//end of class myList
	
	
	public class ListHierarchy {	//starting class 
		Coin toss;
		int maxCount=0;
		myList my = new myList();	// new object of class myList
	
		public ListHierarchy(Coin flip) {
			//constructor for the class that accepts an obeject of type Coin
			if(flip==null) {
			System.out.println("Null value is not accepted");
			}
			else {
			toss=flip;
			}
		}
	
		boolean add(String key) {
			// add a key to data structure
			boolean flagAdd = false;
			if(key.length() > 0 && key != null) {
				while((toss.flip() != 0)) {
					maxCount++;	
				}
				System.out.println("Coin" +maxCount);
				flagAdd = my.add(key, maxCount);
				maxCount = 0;
				return flagAdd;
			} 
			else {
			System.out.println("Enter a valid string");
			return flagAdd;									// return true if if key is added or is already in list,
			}												//  return false if there was an error
		}
	
		boolean find (String key) {
			// search the data structure for the key value
			boolean searchFlag = false;
			if(key.length() > 0 && key != null) {
			  searchFlag = my.find(key);
			  return searchFlag;
			}
			else {
			return searchFlag;								//  return true if key value is in data structure
			}												//  return false if there was an error
		}	
	}//end of class ListHierarchy