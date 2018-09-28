package example.groovy
class DateTimesExample{
	public static void main(String[] args){
		def date = new Date();
		/*System.out.println(date.toString());
		
		def dateMS = new Date(2000);
		println(dateMS);
		
		//Tests if this date is after the specified date.
		Date date1 = new Date("01/12/2019");
		Date date2 = new Date("01/12/2009");
		println(date1.after(date));
		println(date.after(date1));
		
		//compares wo dates for equality
		Date date1 = new Date("01/12/2019");
		Date date2 = new Date("01/12/2019");
		println(date1.equals(date2));
		println(date.equals(date1));
		println(date.getDay());
		println(date.getDate());
		println(date.getMonth());
		
		//Compares two Dates for ordering 0 when dates are equal -1 if the dates is less than and 1 if the date is more than
		Date date1 = new Date("01/12/2019");
		Date date2 = new Date("01/12/2009");
		println(date1.compareTo(date2));
		println(date2.compareTo(date1));
		println(date2.compareTo(date2));*/
		
		//Tests if this date is before the specified date
		Date date1 = new Date("01/12/2019");
		Date date2 = new Date("01/12/2009");
		println(date1.before(date));
		println(date.before(date1));
		println(date.getTime())
		
	}
}
