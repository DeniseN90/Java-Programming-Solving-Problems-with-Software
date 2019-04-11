public class Part2 {

    public int howMany (String stringa, String stringb){
        int startIndex = 0;
        int numberOccurences = 0;
        int stringbLength = stringb.length();
        int stringaLength = stringa.length();
        while(startIndex+stringaLength<stringbLength) {
            int currentIndex = stringb.indexOf(stringa,startIndex);
            if(currentIndex==-1){
                return currentIndex;
            } else {
                numberOccurences += 1;
                startIndex = currentIndex+stringaLength;
            }
        }
        return numberOccurences;
    }

    public void testHowMany(){
        String string1 = "an";
        String string2 = "banana";
        String string3 = "oc";
        String string4 = "ACCGTCTACGTAGACGATGAC";
        String string5 = "AC";
        System.out.println(howMany(string1,string2));
        System.out.println(howMany(string3, string2));
        System.out.println(howMany(string5, string4));
    }


    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.testHowMany();
    }








}
