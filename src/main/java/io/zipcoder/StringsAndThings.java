package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int output = 0;
        char[] charInput = input.toCharArray();
        for (int i = 0; i < charInput.length-1; i++) {
            if(!Character.isLetter(charInput[i+1]) && (charInput[i] == 'z' || charInput[i] == 'y')) {output++;}
        }
        if(charInput[charInput.length-1] == 'z' || charInput[charInput.length-1] == 'y') {output++;}
        return output;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String output = base.replace(remove,"");
        return output;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     *           added a fourth test of "noisxxnotyynotxisis"
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int countIs = ("0" + input + "0").split("is").length-1;
        int countNot = ("0" + input + "0").split("not").length-1;

        boolean output = countIs == countNot;
        System.out.print(countIs + " counts of is and " + countNot + " counts of not");
        return output;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //no parameter describes what should be returned if there are no g's
        //i will interpret the lack of any g's as g is happy, because they're all off somewhere else at a party or something together
        //if lonely g anywhere, return false
        //due to the vague criteria, the above will cover all described scenarios
        char[] charInput = input.toCharArray();
        boolean isHappy = true;
        int i = 0;
        while (i < charInput.length){
            if (charInput[i] == 'g' && charInput[i+1] != 'g') {
                isHappy = false;
                i += 2;
            }
            else if (charInput[i] == 'g' && charInput[i+1] == 'g') {i += 2;}
            else {i++;}
        }
        return isHappy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        char[] charInput = input.toCharArray();
        int output = 0;
        for (int i = 1; i < charInput.length; i++){
            if(charInput[i] == charInput[i-1] && charInput[i] == charInput[i+1]){
                output++;
            }
        }
        return output;
    }
}
