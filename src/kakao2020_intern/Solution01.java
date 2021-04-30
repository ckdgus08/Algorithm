import java.util.Locale;

public class Solution01 {

    public String solution(String new_id) {
        return recommendValidId(new_id);
    }

    public String recommendValidId(String new_id) {

        new_id = new_id.toLowerCase(Locale.ROOT);
        new_id = new_id.replaceAll("[^0-9a-z\\.\\-\\_]", "");
        while (new_id.contains(".."))
            new_id = new_id.replaceAll("\\.\\.", ".");
        if (!new_id.isEmpty() && new_id.charAt(0) == '.')
            new_id = new_id.substring(1);
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }

        while (new_id.length() <= 2) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
