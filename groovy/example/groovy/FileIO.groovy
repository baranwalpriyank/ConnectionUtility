package example.groovy
class FileIO{
	static void main(String[] args){
	
	/* types of constructor present for File 
		public java.io.File#<init>(java.lang.String, java.lang.String)
		public java.io.File#<init>(java.lang.String)
		private java.io.File#<init>(java.lang.String, java.io.File)
		public java.io.File#<init>(java.io.File, java.lang.String)
		public java.io.File#<init>(java.net.URI)
		private java.io.File#<init>(java.lang.String, int)*/
		
	//reading file line by line
		/*new File("F:/Docs/sysaudit change.txt").eachLine{
			line -> println "line:$line";
			
			//reading the content of a file as string
			def file = new File("F:/Docs/sysaudit change.txt");
			println file.text
		}
		//writing data to files
		new File("F:/Docs/fileFromGroovy.txt").withWriter('utf-8'){
			writer -> writer.writeLine "This is newly created File"
		}
		//size of the file 
		def file = new File("F:/Docs/fileFromGroovy.txt")
		println "The file ${file.absolutePath} has ${file.length()} bytes"
		
		//checking if it is directory or file
		def file = new File("F:/Docs/fileFromGroovy.txt")
		println "File ? ${file.isFile()}"
		println "Directory ? ${file.isDirectory()}"
		
		//making Directory
		def file = new File("F:/Directory")
		file.mkdir()
		
		//deleting file
		def file = new File('F:/Directory/file.txt.txt')
		boolean val = file.delete()
		println (val)
		
		//checking if the file exist
		boolean valu = file.exists()
		println (valu)
		
		//copying data from one file to another (data gets append not every time a new file is created)
		def source = new File('F:/Docs/fileFromGroovy.txt');
		def target = new File('F:/Directory/file.txt');
		target << source.text; 
		
		//to know all the directories present on the respective system (to create new file )
		def rootFiles = new File('kuch','bhi').listRoots();
		rootFiles.each{
			file -> println(file.absolutePath);
		}
		
		//to know all the files present under any particular directory
		new File('F:/').eachFile(){
			file -> println(file.getAbsolutePath());
		}
		
		//to know all the files in a directory and it's sub direectory
		new File('F:/').eachFileRecurse(){
			file -> println(file.getAbsolutePath());
		}*/
		
	}
}