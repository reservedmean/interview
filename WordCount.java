import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount {
	public static HashMap<String, Integer> valueMap(String paragraph) {
		String[] strings = paragraph.split(" ");
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for (int i = 0; i<strings.length;i++) {
			if (wordMap.containsKey(strings[i])) {
				int value = wordMap.get(strings[i]);
				value++;
				wordMap.replace(strings[i], value);
			} else {
				wordMap.put(strings[i], 0);
			}
		}
		return wordMap;
	}
	
	public static String highestCount(HashMap<String, Integer> wordMap) {
		Set<Map.Entry<String, Integer>> valueset = wordMap.entrySet();
		int max = 0;
		String highest = "";
		for( Map.Entry<String, Integer> entry : valueset) {
			if (entry.getValue() > max) {
				max = entry.getValue() + 1;
				highest = entry.getKey() + " " +max;
			}
		}
		return highest;
	}
	
	public static void main(String[] args) {
		String paragraph = "ALL'S WELL THAT ENDS WELL";
		HashMap<String, Integer> wordMap = valueMap(paragraph);
		System.out.println(highestCount(wordMap));
	}
}
