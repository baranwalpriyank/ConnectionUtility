package example.groovy;

public class ExceptionExample {

	public static void main(String[] args) {
		File file = new File("E://groovy//File.txt");
		try{
		FileReader fr = new FileReader(file);
		}
		catch(FileNotFoundException fe){
			println("FNFExc");
			println(fe.getStackTrace());
		}catch(Exception e){
			/*println("Exc");
			println("value "+e.printStackTrace())*/
		}
	}

}
