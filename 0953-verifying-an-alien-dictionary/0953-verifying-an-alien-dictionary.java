import java.util.*;

class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        // words = alien language ke words
        // order = alien alphabet ka correct order
        // return true  → words correct order mein hain
        // return false → words correct order mein nahi hain


        HashMap<Character, Integer> map = new HashMap<>();
        // Key   → character
        // Value → us character ki position/rank
        //
        // Example:
        // order = "hlabc..."
        //
        // map:
        // h → 0
        // l → 1
        // a → 2
        // b → 3


        for (int i = 0; i < order.length(); i++) {
            // Alien alphabet ke har character par ja rahe hain.

            map.put(order.charAt(i), i);
            // Current character ko uski position ke saath store kar rahe hain.
            //
            // Example:
            // i = 0 → h → 0
            // i = 1 → l → 1
            // i = 2 → a → 2
        }


        for (int i = 0; i < words.length - 1; i++) {
            // adjacent words compare karenge.
            //
            // words[0] vs words[1]
            // words[1] vs words[2]
            // words[2] vs words[3]
            // ...


            String a = words[i];
            // Pehla word


            String b = words[i + 1];
            // Uske immediately next wala word


            int len = Math.min(a.length(), b.length());
            // Dono words mein se chhote word ki length le rahe hain.
            //
            // Kyunki comparison utne hi characters tak
            // kar sakte hain jitne dono mein available hain.


            for (int j = 0; j < len; j++) {
                // Dono words ke characters ko compare karenge.

                char c1 = a.charAt(j);
                // Pehle word ka current character.

                char c2 = b.charAt(j);
                // Doosre word ka current character.


                if (c1 != c2) {
                    // Agar dono characters different hain,
                    // toh unki alien alphabet mein position check karenge.


                    if (map.get(c1) > map.get(c2)) {
                        // Agar first word ka character
                        // second word ke character ke BAAD aata hai,
                        // toh order galat hai.

                        return false;
                        // Words sorted nahi hain.
                    }


                    break;
                    // Agar first different character mil gaya
                    // aur order correct hai,
                    // toh baaki characters check karne ki zarurat nahi.
                }
            }


            if (a.length() > b.length() && a.startsWith(b)) {
                // Special case bhai:
                //
                // Example:
                // a = "apple"
                // b = "app"
                //
                // "app" pehle aana chahiye.
                // Lekin yahan "apple" pehle hai.
                //
                // Isliye invalid.

                return false;
            }
        }


        return true;
        // Agar koi bhi wrong ordering nahi mili,
        // toh words correctly sorted hain.
    }
}