
public class SLL {
	
	private Node head;
	
	
	public SLL() {
		head = null;
		
	}
	public Node addInsertSort( Node newNode )
	{
	    if( head == null )
	    {
	        head = newNode;
	        
	    }
	    else
	    {
	        Node curNode = head , preNode = null;
	        // This is How InsertionSort would have gone to search the list
	        while( curNode != null && (int)(((Player) newNode.getData()).getPlayerScore()) <(int)(((Player) curNode.getData()).getPlayerScore()) )
	        {
	            preNode = curNode;
	            curNode = curNode.getLink();
	        }
	        //Thats the happy ending of the insertionSort algo
	        //Now we need to link newNode with OUR DYNAMICALLY GROWING LIST
	        //When the insertion Algo stopped, It told us where the newNode 
	        //shall be placed in comparison to the current state of list

	        // Is this supposed to be the head node now??
	        if( curNode == head )
	        {
	            newNode.setLink(head);
	            head = newNode;
	        }
	        else // maybe we landed BETWEEN the list or at the END OF LIST??
	        {
	            if( curNode != null && preNode != null ) //BETWEEN THE list
	            {
	                newNode.setLink(curNode);
	                preNode.setLink(newNode);
	            }
	            else if( curNode == null ) // end of list
	            {
	                preNode.setLink(newNode);
	                 
	            }
	        }
	    }
	    return newNode; 
	}
	
	 public Node head() {             //Returns value at head of list. Doesn't alter the list.
	        head.getData();
			return head;
	    }
	 public String objectPrint() {             
	        String out = "";
	        Node current = head;
	        for (int i = 1; i <= this.size(); i++) {
	        	
	            out = out + current.getData() + "\n";
	            current = current.getLink();
	        }

	        return out;
	    }
	
	public void addFront(Object dataToAdd) {
		Node newNode = new Node(dataToAdd);
		if(head == null) {			
			head = newNode;
		}
		
		else {			
			newNode.setLink(head);
			head=newNode;
		}
	}
	
	public void addLast(Object dataToAdd) {
		Node newNode = new Node(dataToAdd);
           
        if (head == null) {
            head = newNode;
        }
        else {          
            Node temp = head;
            while (temp.getLink() != null) {
                temp = temp.getLink();
            }
              
            temp.setLink(newNode);
        }
   
	}
	public void addIndex(Object dataToAdd) {
		
		Node previous = null;
		Node newNode = new Node(dataToAdd);
		if (head == null) {
			newNode.setLink(head);
            head = newNode;
        }
		else {
			Node temp = head;
			while (temp != null&&(int)dataToAdd > (int)temp.getData()) {
				 previous = temp;
	             temp = temp.getLink();
	         }
	           
	         if(temp == null) {	 
	        	 temp = head;
	             while (temp.getLink() != null) {
	                 temp = temp.getLink();
	             }
	               
	             temp.setLink(newNode);
	         }
	         
	         else {
	        	 if(previous!=null) {
		        	 newNode.setLink(temp);
		        	 previous.setLink(newNode);
	        	 }
	        	 else {
	        		 newNode.setLink(head);
	                 head = newNode;
	        	 }
	         }
        
		}
	}
	
	
	public void delete(Object dataToDelete) {
		if(head == null) {
			System.out.println("Linked list is empty!!");
		}
		else {
			while ((int)dataToDelete == (int)head.getData()) {
				head=head.getLink();
			}
			Node temp = head;
			Node previous = null;
			while (temp!=null) {
				if ((int)dataToDelete == (int)temp.getData()) {
					
		        	previous.setLink(temp.getLink());
		        	temp=previous;
				}
				previous = temp;
				temp=temp.getLink();
			}
		}
	}
	public void deleteFront(Object dataToDelete) {
		if(head == null) {
			System.out.println("Linked list is empty!!");
		}
		else {
			while ((int)dataToDelete == (int)head.getData()) {
				head=head.getLink();
			}
			Node temp = head;
			Node previous = null;
			while (temp!=null) {
				if ((int)dataToDelete == (int)temp.getData()) {					
		        	previous.setLink(temp.getLink());
		        	temp=previous;
		        	break;
				}
				else {
					previous = temp;
				}
				
				temp=temp.getLink();
			}
		}
	}
	public void deleteNodeByValue(Object dataToDelete, int size) {
	    Node currNode = head;
	    boolean found = false;
	    Node prevNode = head;
	    if (head != null) {
	        for (int i = 0; i < size; i++) {
	            if ((int)currNode.getData() == (int)dataToDelete) {
	                ///////DELETE START
	                if (currNode == head) {
	                    head = currNode.getLink();
	                } else {
	                	prevNode.setLink(currNode.getLink());
			        	currNode=prevNode;
	                }
	                ////DELETE END
	                found = true;
	                size--;
	                break;
	            }
	            prevNode = currNode;
	            currNode = currNode.getLink();
	        }
	        if (!found)
	            System.out.println("value not found.");
	    }
	}

	public boolean search(Object item) {
		boolean flag = false;
		  
		if (head == null) {
			System.out.println("linked list is empty");
		}
		else {
			Node temp = head;
		while (temp != null) {
			if (item == temp.getData()) {
				flag = true;
				
			}			
			temp = temp.getLink();
			}
		}
		
		return flag;
	}
	public void display() {		
		Node temp = head;		
		while(temp != null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getLink();
		}			
		
	}
	public int size() {
		int count = 0;
		
		if(head == null) {
			System.out.println("Linked list is empty!!");
		}
		else {
			Node temp = head;
			while(temp != null) {
				count++;
				temp = temp.getLink();
			}			
		}
		return count;				
		
	}
	public int count(Object cnt) {
		int count = 0;
		if(head == null) {
			
		}
		else {
			Node temp = head;
			while(temp != null) {
				if((int)temp.getData() ==(int) cnt) {
					count++;
					
				}
				temp = temp.getLink();
			}		
		}
		
		return count;
	}
		
	}
	


