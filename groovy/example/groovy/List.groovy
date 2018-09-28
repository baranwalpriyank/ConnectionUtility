package example.groovy
class ListExapmle{
	public static void main(String[] args){
		def list= [1,2,3,4];
		def newList=[];
		println(list);
		
		/*//adding at last position of the list
		list.add(8);
		println(list);
		println(list.size());
		
		//adding at specific position of the list
		list.add(2,90);
		println(list);
		println(list.size());
		
		//to check if the list contains the value passed in paranthesis
		println(list.contains(8));
		println(list.contains(2));
		
		//Returns the element at the specified position in this List.
		println("at index 1 the element is "+list.get(1));
		
		//check if the list is empty or not
		println(list.isEmpty());
		println(newList.isEmpty());
		
		//Creates a new List composed of the elements of the original without those specified in the collection
		newList = list.minus([4,1]);
		println(newList);
		
		//Creates a new List composed of the elements of the original together with those specified in the collection
		newList = list.plus([45,889]);
		println(newList);
		
		//removes the last item from the list
		println(list.pop());
		println(list);
		
		//removes the item from the list of the specific index
		println(list.remove(1));
		println(list);*/
		
		//Create a new List that is the reverse the elements of the original List
		newList=list.reverse();
		println(newList);
		
		//Returns a sorted copy of the original List
		println(newList.sort());
			
	}
}
