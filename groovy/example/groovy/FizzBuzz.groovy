package example.groovy
class GroovyFizzBuzz{
    
    static def method(num){
	
        if((num%5 === 0 && num%3 === 0)){
            print("FizzBuzz");
        }
        else if(num%5 === 0){
            print("Buzz");
        }
        else if(num%3 === 0){
            print("Fizz");
        }
    }
    
    static void main (String[] args){
	
         method(3);
        //println(num);
    }
}
