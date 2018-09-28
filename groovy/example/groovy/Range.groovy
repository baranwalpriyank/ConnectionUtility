package example.groovy
class RangeExample{
	public static void main(String [] args){
		def aint = 1..10;
		def bint = 1..<10;
		def cint = 10..1;
		def astring = 'a'..'p';
		def bstring = 'z'..'c';
		
		//to check is the range contains the value specified or not 
	/*	println (aint.contains(9));
		println(bint.contains(10));
		println(bstring.contains(9))
		println(astring.contains('z'));
		
		//get the value at the specified index
		println(aint.get(9));
		println(bint.get(8));
		println(cint.get(9));
		
		//get the lower value of the range
		println(aint.getFrom());
		println(bstring.getFrom());
		
		//get the upper value of the range
		println(bstring.getTo());
		println(aint.getTo());
		
		//to check if the range is in reverse or not 
		println(aint.isReverse());
		println(cint.isReverse());
		println(astring.isReverse());
		println(bstring.isReverse());
		
		//returns the number of elements in the range
		println(aint.size());
		println(astring.size());*/
		
		//returns the sublist from specified index to specified index
		print(aint.subList(7,8));
	}
}