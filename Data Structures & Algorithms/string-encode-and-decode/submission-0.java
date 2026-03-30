class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";

        StringBuilder sb=new StringBuilder();
        for(String s : strs)
        {
sb.append(s.length()).append("#");
for (char c : s.toCharArray()) {
    sb.append((int)c).append(",");
}
sb.append("|"); // separator between strings

        }

        System.out.print(sb.toString());
      return sb.toString();
    }

    public List<String> decode(String s) {
 List<String> result = new ArrayList<>();

    if (s == null || s.isEmpty()) return result;

    String[] parts = s.split("\\|");

    for (String part : parts) {
        if (part.isEmpty()) continue;

        // Split length and ASCII section
        String[] split = part.split("#", 2);
        int length = Integer.parseInt(split[0]);
        String asciiPart = split[1];

        // Split ASCII values
        String[] nums = asciiPart.split(",");

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (String num : nums) {
            if (num.isEmpty()) continue; // skip trailing comma
            int val = Integer.parseInt(num);
            sb.append((char) val);
            count++;
        }

        result.add(sb.toString());
    }

    return result;
}
}
