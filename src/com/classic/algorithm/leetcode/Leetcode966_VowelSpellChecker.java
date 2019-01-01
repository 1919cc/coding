package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode966_VowelSpellChecker {
    public String[] spellchecker2(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        Map<String, String> capWords = new HashMap<>();
        Map<String, String> vowWords = new HashMap<>();
        
        for (String word : wordlist) {
            words.add(word);
            
            String w = capWords.toLowerCase();
            if (!capWords.containsKey(w)) capWords.put(w, word);
            
            String wv = w.replaceAll("[aeiou]", "*");
            if (!vowWords.containsKey(wv)) vowWords.put(wv, word);
        }
        
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (words.contains(q)) {
                res[i] = q;
                continue;
            }
            
            String l = q.toLowerCase();
            if (capWords.containsKey(l)) {
                res[i] = capWords.get(l);
                continue;
            }
            
            String v = l.replaceAll("[aeiou]", "*");
            if (vowWords.containsKey(v)) {
                res[i] = vowWords.get(v);
                continue;
            }
            
            res[i] = "";
        }
        
        return res;
    }
	
	
	// fail to pass
    char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] res = new String[queries.length];
        
        Set<Character> vow = new HashSet<>();
        for (char c : vowels) { vow.add(c); vow.add((char)(c-32));}
        
        boolean add = false;
        for (int i = 0; i < queries.length; i++) {
            add = false;
            for (int j = 0; j < wordlist.length && !add; j++) {
                if (wordlist[j].equals(queries[i])) {
                    res[i] = new String(wordlist[j]);
                    add = true;
                }
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            if (res[i] != null) continue;
            
            add = false;
            for (int j = 0; j < wordlist.length && !add; j++) {
                String wordLow = wordlist[j].toLowerCase();
                String queryLow = queries[i].toLowerCase();
                
                if (wordLow.equals(queryLow) && !add) {
                    // System.out.println("case wordLow = " + wordLow + "    queryLow = " + queryLow);
                    res[i] = new String(wordlist[j]);
                    add = true;
                } else if (!add){
                    if (wordLow.length() == queryLow.length()) {
                        for (int m = 0; m < wordLow.length(); m++) {
                            if (wordLow.charAt(m) == queryLow.charAt(m)
                                || (vow.contains(wordLow.charAt(m)) && vow.contains(queryLow.charAt(m)))) {
                                System.out.println(wordLow.charAt(m) + " : " + queryLow.charAt(m));
                                if (m == wordLow.length() -1) {
                                    System.out.println("vow wordLow = " + wordLow + "    queryLow = " + queryLow);
                                    res[i] = new String(wordlist[j]);
                                    add = true;
                                }
                            } else break;
                        }
                    }
                }
            }
            
            if (!add) res[i] = "";
        }
        
        return res;
    }
}
