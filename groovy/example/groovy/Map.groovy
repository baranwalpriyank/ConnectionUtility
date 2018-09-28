package example.groovy
class MapExample{
	public static void main(String[] args){
		def map =["Groom":"Priyank","Bride":"Asihwarya"];
		
		/*//check if the map contains the key?
		println(map.containsKey("Bride"));
		println(map.containsKey("Aishwarya"));
		
		//return the value of the given corresponding key if key is not present than null is returned
		println(map.get("Groom")+" loves "+map.get("Bride"));
		println(map.get("enemy"));
		
		//Obtain a Set of the keys in this Map
		println(map.keySet());
		
		//put the value in the map for new key and replace value if key is already present
		map.put("realtion","GirlFriend");
		println(map);
		map.put("realtion","Wife");
		println(map);
		
		//returns the size of map
		println(map.size());
		map.put("realtion","Wife");
		println(map.size());*/
		
		//print the all the values present in map
		println(map.values());
		
	}
}