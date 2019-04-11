public class Part3 {


    public boolean twoOccurences (String stringa, String stringb){
        boolean flag = false;
        int firstOccur = stringa.indexOf(stringb);
        if(firstOccur==-1){
            return flag;
        } else {
            int secondOccur = stringa.indexOf(stringb,firstOccur+stringb.length());
            if(secondOccur==-1){
                return flag;
            } else{
                flag = true;
            }
        }
        return flag;
    }


    public void testing(){
        String dna1 = "acaagtttgtacaa";
        String dna2 = "tgg";
        String dna3 =  "cgtcaaggcccacca";
        String dna4 = "cca";
        String dna5 = "aggccaacat";
        String dna6 = "agg";
        System.out.println("First test: "+twoOccurences(dna1,dna2));
        System.out.println("Second test: "+twoOccurences(dna3,dna4));
        System.out.println("Third test: "+twoOccurences(dna5,dna6));
        String dna7 = "an";
        String dna8 = "banana";
        String dna9 = "zoo";
        String dna10 = "forest";
        String dna11 = "lo";
        String dna12 = "gallo";
        System.out.println("Fourth test: "+lastPart(dna7,dna8));
        System.out.println("Fifth test: "+lastPart(dna9,dna10));
        System.out.println("Sixth test: "+lastPart(dna11,dna12));

    }


    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        String subStringb = "";
        if(index == -1){
            return stringb;
        } else {
            subStringb = stringb.substring(index+stringa.length());
        }
        return subStringb;
    }


    public static void main(String[] args) {
        Part3 p3 = new Part3();
        p3.testing();

    }



}
