
/**
 * Write a description of class ממן13 here.
 *
 * @author (shira gildi)
 * @version (01/05/2022)
 */
public class Ex13
{
    

    /**
     * This method is a recursive static method that gets a positive integer
     * and returns the length of the longest identical sequence of digits found in the num.
     * @return The length of the longest identical sequence of digits found in num.
     * @param num The integer the method receives from which it must return the longest identical sequence of digits.
     */
    public static int equalDigits(int num)
    {
        if(num == 0)
        {
            return 1;
        }
        return Math.max(sequence(num) , equalDigits(num/10));
    }

    /**
     * This method is an auxiliary method to the previous method This method is also a recursive static that gets an integer
     * and returns the sequence of the same digits and stops when you encounter a non-identical number.
     * @return The sequence of identical digits and stops when you encounter a non-identical number.
     * @param num The integer the method receives from which it must
     * return the length of the identical digit sequence until it encounters a non-identical number.
     */
    public static int sequence(int num)//Auxiliary method
    {
        if(num == 0 || num%10 != (num/10)%10)
        {
            return 1;
        }
        return sequence(num / 10)+1;
    }

    /**
     * A method that accepts as a parameter a natural number (positive integer), and a positive integer between 0 and 9
     * The method must return a num subnumber whose all digits are divided by a digit.
     * This method is an envelope method that sends the number and digit and adds a variable to the method that returns the desired subset.
     * @return Method that returns the desired subset.
     * @param num The positive integer from which the subset is returned.
     * @param digit The digit in which only the numbers that are divided will be returned in a subset.
     */
    public static int subNumber (int num , int digit)
    {
        return subNumber (num , digit , 0 , 1);
    }

    /**
     * The method a envelope method sends to it returns the subset of the number obtained.
     * @return The desired subset.
     *@return -1 if temp eqaels to ziroe
     *@param num The positive integer from which the subset is returned.
     * @param digit The digit in which only the numbers that are divided will be returned in a subset.
     * @param tempNum the tempNum A temporary number that will hold all the digits divided by the digital.
     * @param place The additional variable it shows on the location of the digit where you will need to be the digit in the new subset.

     */
    public static int subNumber (int num , int digit , int subArrai, int place)
    {
        if(num == 0)
        {
            if(subArrai == 0)
            {
                return -1;
            }
            return subArrai;
        }

        if((num % 10) % digit == 0)
        {
            return subNumber((num/10) , digit , subArrai + num%10*place, place*10);
        }
        else 
        {
            return subNumber((num/10) , digit , subArrai ,place);    
        }

    }

    /**
     * A recursive Boolean static method, which accepts an integer as a parameter and returns true if the number is a special number
     * and false otherwise.
     * Take the set of positive integers:
     * Now every second number in the group is deleted, and we are left with some group from which every third number is delete
     * and so a special number is a number that is never delete
     * This method is an envelope method that sends to another method the number and the beginning of the deletion round which is 2.
     * @return A recursive Boolean static method, which accepts as an parameter an integer and another variable that shows the rotation number
     * and returns true if the number is a special number and otherwise false.
     * @param n The resulting number that needs to be checked is special.

     */
    public static boolean isSpecial(int n)//שיטת מעטפת
    {
        return isSpecial(n,2); 
    }

    /**
     *     * recursive Boolean static method, which accepts as an parameter an integer and another variable that shows the rotation number.
     * And returns true if the number is special and false otherwise.
     * @return True if the number is special and not true otherwise.
     * @param n The resulting number that needs to be checked is special.
     * @param jump The variable obtained from the envelope method shows the number of rounds of deletions.

     */
    public static boolean isSpecial(int n, int jump)
    {
        if(n < jump)
        {
            return true;
        }
        if(n % jump == 0)
        {
            return false;
        }
        else
        {
            return isSpecial( n-n/jump,  jump+1);
        }
    }

}
