import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.util.Calendar.*;

/**
 * FormatDateDriver runs and tests the class FormatDate.
 * 
 * @author Kim Schulze 
 * @version 1.1; December 3, 2020
 */
public class FormatDateDriver
{
    /**
     * main() reads a day, a month, and a year and displays the date in various formats:
     * January 1, 2000
     * 01/01/2000
     */
    
    static void printDateFormat(String month, int day, int year) {
        System.out.print("The date is ");
        System.out.print(month + " ");
        System.out.print( + day + ", ");
        System.out.println(+ year + ".");  // Displays "The date is January 1, 2000.
    }
    
    static int yearTwoDigit(int yearValue)  {
        String stringYear = Integer.toString(yearValue);
      
        String twoDigitsstring = stringYear.substring(0,4);
     
        int twoDigits = Integer.parseInt(twoDigitsstring);
     
        return twoDigits;
    }
    
    static boolean leapyearTest(int yearValue, int twoDigits)  {
       boolean leapyearValue = false; 
       
       if (yearValue % 4 == 0 && twoDigits % 4 == 0)  {
           leapyearValue = true;
       }
        
       return leapyearValue;
    }
    
    static String DaysOfMonth(int monthValue)  {
        String monthType = "d";
        
        if (monthValue == 1 || monthValue == 3 || monthValue == 5 || monthValue == 7 || monthValue == 8 || monthValue == 10 || monthValue == 12)  {
            monthType = "a";
        }
        
        if (monthValue == 4 || monthValue == 6 || monthValue == 9 || monthValue == 11)  {
            monthType = "b";
        }
        
        if (monthValue == 2)  {
            monthType = "c";
        }
        
        return monthType;
    }
    
    static boolean monthCheck(int dayValue, int monthValue, int yearValue, int twoDigits)  {  // Checks if day is a valid day of the month
        boolean trueDay = false;
        
        // For months with 31 days.
        if (monthValue == 1 || monthValue == 3 || monthValue == 5 || monthValue == 7 || monthValue == 8 || monthValue == 10 || monthValue == 12)  {
            if (dayValue >= 1 && dayValue <= 31)  {
                trueDay = true;
            }
            else {
                trueDay = false;
            }
        }
        
        // For months with 30 days.
        else if (monthValue == 4 || monthValue == 6 || monthValue == 11)  {
            if (dayValue >= 1 && dayValue <= 30)  {
                trueDay = true;
            }
            else {
                trueDay = false;
            }
        }
        
        // For February, which has 28 days in most years but 29 days in leap years.
        else if (monthValue == 2)  {
            if (yearValue % 4 == 0 && twoDigits % 4 == 0)  {
                if (dayValue >= 1 && dayValue <= 29)  {
                   trueDay = true; 
                }
                else  {
                   trueDay = false;
                }
            }
            else  {
                if (dayValue >= 1 && dayValue <= 28)  {
                    trueDay = true;
                }
                else  {
                    trueDay = false;
                }
            }
        }
        
        if (trueDay == false)  {
            System.out.println("I'm sorry.  That date does not exist.");
            System.out.println("Please try again.");
        }
        
        return trueDay;
    }
    
    static String getMonth(int monthValue)  {
        boolean trueMonth;
        String monthName = "";
        
        if (monthValue >= 1 || monthValue <= 12) {
            trueMonth = true;
        }
        else {
            trueMonth = false;
        }
        
        if (trueMonth) {
            
            switch (monthValue)  {
                case 1:
                    monthName = "January";
                    break;
                case 2:
                    monthName = "February";
                    break;
                case 3:
                    monthName = "March";
                    break;
                case 4:
                    monthName = "April";
                    break;
                case 5:
                    monthName = "May";
                    break;
                case 6:
                    monthName = "June";
                    break;
                case 7:
                    monthName = "July";
                    break;
                case 8:
                    monthName = "August";
                    break;
                case 9:
                    monthName = "September";
                    break;
                case 10:
                    monthName = "October";
                    break;
                case 11:
                    monthName = "November";
                    break;
                case 12:
                    monthName = "December";
                    break;
            }
        }
            
        return monthName;
    }
    
    static boolean askPlay(String inputPlay)  {
        boolean wannaPlay = false;
        
        switch (inputPlay)  {        
            case "y":
                wannaPlay = true;
                break;
            case "yes":
                wannaPlay = true;
                break;
            case "Yes":
                wannaPlay = true;
                break;
            case "Y":
                wannaPlay = true;
                break;
            case "n":
                wannaPlay = false;
                break;
            case "no":
                wannaPlay = false;
                break;
            case "No":
                wannaPlay = false;
                break;
            case "N":
                wannaPlay = false;
                break;
        }
            
        return wannaPlay;
    }
    
    static boolean validdayTest(int dayValue, String monthType, boolean leapyear)  {
        boolean validdayValue = false;
        
        if (monthType == "a")  {
            if (dayValue <= 1 && dayValue >= 31)  {
                validdayValue = true;
            }
            else  {
                validdayValue = false;
            }
        }
        
        if (monthType == "b")  {
            if (dayValue <=1 && dayValue >= 30)  {
                validdayValue = true;
            }
            else {
                validdayValue = false;
            }
        }
        
        if (monthType == "c")  {
            if (leapyear = true)  {
                if (dayValue <= 1 && dayValue >= 29)  {
                    validdayValue = true;
                }
                else  {
                   validdayValue = false; 
                }
            }
            else {
                if (dayValue <= 1 && dayValue >= 28)  {
                    validdayValue = true;
                }
                else {
                    validdayValue = false;
                }
            }
        }
        
        return validdayValue;
    }
    
    static int inputDayAsInteger() {
        int day = 0;
        boolean valid;
        Scanner key = new Scanner(System.in);
        
        while (day < 1 || day > 31)  {  // inputs day and checks if day is possible in a month. while (validTest == false)  {
            do {
                System.out.print("Please enter the day:  ");
                if(key.hasNextInt())  {
                    day = key.nextInt();
                    valid = true;
                }
                else {
                    System.out.println("This is not valid!");
                    System.out.println("Please, try again.");
                    valid = false;
                    key.next();
                }
        
                if (day < 1 || day > 31)  {
                    System.out.println("This day does not exist.  Please try again.");
                }  // end inputDay error check
            } while (valid == false);
        }  // ends while loop for day

        System.out.println("You entered a day of " + day + ".");
        
        return day;
    }
    
    static int inputMonthAsInteger() {
        boolean valid = false;
        int month = 0;
        Scanner key = new Scanner(System.in);
        
        while (month < 1 || month > 12)  {  // inputs month, checks if month is possible, and returns month name.
                    
            do {
                System.out.print("Please enter the month:  ");
                if (key.hasNextInt()) {
                    month = key.nextInt();
                    valid = true;
                }
                else {
                    System.out.println("Not a valid integer!");
                    System.out.println("Try again, please!");
                    key.next();
                }
                if (month < 1 || month > 12)  {
                    System.out.println("This month does not exist.  Please try again.");
                }
            } while (valid == false);
        }  // ends while loop for month

        System.out.println("You entered the month:  " + month + ".");
        
        return month;
    
    }
    
    static int inputYearAsFourDigitInteger()
    {
        boolean valid;
        int year = 0;
        Scanner key = new Scanner(System.in);
        
        do {
            // inputs year.
            System.out.print("Please enter the year:  ");
            if(key.hasNextInt())  {
                year = key.nextInt();
                valid = true;
            }
            else  {
                System.out.println("Uuuhhh, oh!");
                System.out.println("You didn't mean that.");
                valid = false;
                key.next();
            }
        } while (valid == false);

        System.out.println("You entered the year:  " + year + ".");
        
        return year;
    }
    
    public static void main(String[] args) {
        // Input scanner declaration
        Scanner keyboard = new Scanner(System.in);
        
        // inputDay, inputMonth, & inputYear are declared to receive input from the uster.
        int inputDay = 0;
        int inputMonth = 0;
        int inputYear = 1000;
        
        boolean trueDay = true;
        boolean possibleDay = false;
        boolean validTest = false;
        boolean wannaPlay = true;
        String inputPlay = "no";
        
        String monthString = "none";
        int lastTwoDigits;
        boolean leap;
        int century;
        int centuryNumber;
        String yearString;
        
        System.out.println("This program allows the user to input a date, month, and year.");
        
        // Prompt the user for input and store inputted value into inputDay, inputMonth, and inputYear.
        while (wannaPlay)  {  // while loop keeps going until user says no.
            while (!possibleDay)  {
                inputDay = 0;
                inputMonth = 0;  
                inputYear = 1000;
                
                // Input month as a number and convert that number to a string.
                inputMonth = inputMonthAsInteger();
                monthString = getMonth(inputMonth);
        
                // Input day as an integer.
                inputDay = inputDayAsInteger();
                
                // Input year as an integer.
                inputYear = inputYearAsFourDigitInteger();
                
                // Determines the last two digits of the year to identify leap years.
                lastTwoDigits = yearTwoDigit(inputYear);
            
                // Checks whether 
                possibleDay = monthCheck(inputDay, inputMonth, inputYear, lastTwoDigits);
            }
            
            // Prints date in format:  January 1, 2000.
            printDateFormat(monthString, inputDay, inputYear);
                  
            // Prompts user to play again.
            System.out.print("Do you want to try again?  ");
            inputPlay = keyboard.next();
            wannaPlay = askPlay(inputPlay);
            possibleDay = false;
        }
    }
}
