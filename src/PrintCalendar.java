import java.awt.*; // for GUI components
import javax.swing.*; // for GUI container (Applet's contents)

public class PrintCalendar {
	/** Main method */

	public static void main(String[] args) {

		// Variable Declaration
		int year = InputYear();
		int month = InputMonth();

		// Choose to print year calendar or month calendar
		if (month == 0)
			printYear(year); // print the year calendar
		else {
			// print the month calendar
			System.out.print(printMonthTitle(year, month));
			System.out.print(printMonthBoby(year, month));
		}
	}

	/** Print the calendar for a month in a year */
	static void printYear(int year) {
		JTextArea JT; // Create a JTextArea
		JPanel p1 = new JPanel(); // Create a new container
		p1.setLayout(new GridLayout(4, 3)); // Set a Layout at 4*3
		String output; // Local variable Declaration

		for (int i = 1; i <= 12; i++) {
			output = "";
			output += printMonthTitle(year, i);
			output += printMonthBoby(year, i);
			JT = new JTextArea(output); // Create a new JTextArea
			JT.setFont(new Font("Courier new", Font.PLAIN, 12)); // Set the Font
			p1.add(JT); // put JTestArear JT into Layout p1
		}
		JOptionPane.showMessageDialog(null, p1, "Year of " + year,
				JOptionPane.PLAIN_MESSAGE); // print the year calendar and title
	} // end method printYear

	/** Prompt the user to enter year */
	static int InputYear() {
		int year; // Local variable Declaration
		do {
			// Show the Dialog to prompt the user to enter year
			String yearString = JOptionPane
					.showInputDialog("Enter full year (e.g., 2001):");
			// Convert string into integer
			year = Integer.parseInt(yearString);
		} while (year < 1800);
		return year; // return the year
	} // end method InputYear

	/** Prompt the user to enter month */
	public static int InputMonth() {
		int month; // Local variable Declaration
		do {
			// Show the Dialog to prompt the user to enter month
			String monthString = JOptionPane
					.showInputDialog("Enter month as number between 1 and 12: \n (0 for whole year)");
			// Convert string into integer
			month = Integer.parseInt(monthString);
		} while (month > 12 || month < 0);
		return month; // return the month
	} // end method InputMonth

	/** Organize the month title, e.g., May, 1999 */
	public static String printMonthTitle(int year, int month) {
		String output = "           " + getMonthName(month) + " " + year + "\n"
				+ "----------------------------- " + "\n"
				+ " Sun Mon Tue Wed Thu Fri Sat " + "\n";
		return output; // return the month title
	} // end method printMonthTitle

	/** Get the English name for the month */
	public static String getMonthName(int month) {
		String StrM = ""; // Local variable Declaration
		// determine the English name for the month
		switch (month) {
		case 1:
			StrM = "January";
			break;
		case 2:
			StrM = "February";
			break;
		case 3:
			StrM = "March:";
			break;
		case 4:
			StrM = "April";
			break;
		case 5:
			StrM = "May";
			break;
		case 6:
			StrM = "June";
			break;
		case 7:
			StrM = "Jnly";
			break;
		case 8:
			StrM = "August";
			break;
		case 9:
			StrM = "September";
			break;
		case 10:
			StrM = "October";
			break;
		case 11:
			StrM = "November";
			break;
		case 12:
			StrM = "December";
			break;
		}
		return StrM; // return the English name of month
	} // end method getMonthName

	/** Determine if it is a leap year */
	public static boolean isLeapYear(int year) {
		// retrun the year is Leap Year or not
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	} // end method isLeapYear

	/** Get the number of days in a month */
	public static int getNumberOfDaysInMonth(int year, int month) {
		int day = 0; // Local variable Declaration
		// determine the number of day in a month
		switch (month) {
		case 1:
			day = 31;
			break;
		case 2: {
			if (isLeapYear(year))
				day = 29;
			else
				day = 28;
		}
			break;
		case 3:
			day = 31;
			break;
		case 4:
			day = 30;
			break;
		case 5:
			day = 31;
			break;
		case 6:
			day = 30;
			break;
		case 7:
			day = 31;
			break;
		case 8:
			day = 31;
			break;
		case 9:
			day = 30;
			break;
		case 10:
			day = 31;
			break;
		case 11:
			day = 30;
			break;
		case 12:
			day = 31;
			break;
		}
		return day; // return the number of day in a month
	} // end method getNumberOfDaysInMonth

	/** Get the start day of the first day in a month */
	public static int getStartDay(int year, int month) {
		int day = 3; // Local variable Declaration
		// determine the number of day in a year
		for (int i = 1800; i < year; i++) {
			if (isLeapYear(i) == true)
				day += 366;
			else
				day += 365;
		}
		// determine the start day of the first day in a month
		for (int j = 1; j < month; j++)
			day += getNumberOfDaysInMonth(year, j);
		day %= 7;
		return day; // return the start day of the first day in a month
	} // end method getStartDay

	/** Organize month body */
	public static String printMonthBoby(int year, int month) {
		int day = getStartDay(year, month);
		String output = ""; // Local variable Declaration
		for (int i = 0; i < day; i++)
			output += "    ";
		for (int j = 1; j <= getNumberOfDaysInMonth(year, month); j++) {
			if (j < 10)
				output += "   " + j;
			else
				output += "  " + j;
			if ((j + day) % 7 == 0)
				output += "\n";
		}
		output += "\n";
		return output; // return the output of the month body
	} // end method printMonthBoby
} // end class PrintCalendar