package tudelft.ghappy;

public class GHappy {

    public boolean gHappy(String str) {
        assert str!=null;
        if (str.length()==0) return false;
        boolean result=false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'g') {
                if (i >= 1 && str.charAt(i-1) == 'g') { return true; }
                if (i+1 < str.length() && str.charAt(i+1) == 'g') { return true;}

            }
        }

        return result;

    }
}
