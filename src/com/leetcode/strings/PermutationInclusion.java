package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInclusion {

	/*
	 * Time: O(S1 + S2) Space: O(S1 + S2)
	 */
	public boolean checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;

		Map<Character, Integer> s1Map = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> s2Map = new HashMap<>();

		int start = 0;
		int end = s1.length();
		int formed = 0;
		int required = s1Map.size();

		for (int i = start; i < end; i++) {
			char c = s2.charAt(i);

			if (s1Map.containsKey(c)) {
				s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
				if (s1Map.get(c).intValue() == s2Map.get(c).intValue()) {
					formed++;
				}
			}
		}

		if (formed == required)
			return true;
		start = start + 1;
		end = end + 1;

		while (end <= s2.length()) {
			
			// remove the previous character since we are moving the sliding window
			char c = s2.charAt(start - 1);
			if (s1Map.containsKey(c)) {
				int prevCount = s2Map.getOrDefault(c, 0);
				s2Map.put(c, s2Map.getOrDefault(c, 0) - 1);

				// reduce only when if it had increased "formed"
				if ((prevCount == s2Map.get(c).intValue()) && s2Map.get(c).intValue() < s1Map.get(c).intValue()) {
					formed--;
				}
			}
			
			// add the new character since we are moving the sliding window
			char n = s2.charAt(end - 1);
			if (s1Map.containsKey(n)) {
				s2Map.put(n, s2Map.getOrDefault(n, 0) + 1);
				if (s2Map.get(n).intValue() == s1Map.get(n).intValue()) {
					formed++;
				}
			}

			if (formed == required)
				return true;
			start = start + 1;
			end = end + 1;
		}
		return false;
	}
	
	/*
	 * Time: O(S1 + (S2 - S1)) Space: O(1)
	 */
	public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }
        // s2map is added with s1 length chars
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            
            if (count == 26)
                return true;
            
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1) // it was equal previously but increased now
                count--;
            
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1) // it was equal previously but decreased now
                count--;
        }
        return count == 26;
    }

	public static void main(String[] args) {
		PermutationInclusion pi = new PermutationInclusion();
		String s1 = "trinitrophenylmethylnitramine";
		String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";

		System.out.println(pi.checkInclusion2(s1, s2));
	}
}
