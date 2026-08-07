class Solution {

    public String makeLargestSpecial(String s) {

        List<String> list = new ArrayList<>();

        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1')
                balance++;
            else
                balance--;

            // Found one complete special substring
            if (balance == 0) {

                String inner = makeLargestSpecial(s.substring(start + 1, i));

                list.add("1" + inner + "0");

                start = i + 1;
            }
        }

        // Largest lexicographical order
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();

        for (String str : list)
            ans.append(str);

        return ans.toString();
    }
}