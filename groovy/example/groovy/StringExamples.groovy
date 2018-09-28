package example.groovy

class StringExamples {
	public static void main(String[] args){
		String sample1 = "Priyank Barnwal"
		String sample2 = "Aishwarya"
		
		/*
		//to know the char at certain index
		println(sample1[-15..-1]);
		println(sample2[2]);
		
		//concatenate
		println(sample2 + sample1)
		
		//repetetion of string
		println((sample2 + sample1)*10)
		
		//lenght of string
		println((sample2 + sample1).length())
		
		//Returns a new String of length numberOfChars consisting of the recipient padded on the left and right with space characters.
		println(sample2.center(15))
		
		//leftPAdding
		println(sample2.padLeft(15,'<3 '));*/
		
		//This method is called by the ++ operator for the class String. It increments the last character in the given String.
		println (sample2.next())
		
	}
}
