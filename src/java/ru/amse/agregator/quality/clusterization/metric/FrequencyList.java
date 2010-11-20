package ru.amse.agregator.quality.clusterization.metric;

import java.util.Map;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.Set;

/**
 *
 * @author pavel
 *
 * FrequencyList is a wrapper
 */
final public class FrequencyList {

    // a map representing a list
    private Map<String, Integer> dictionaryMap = null;

    private final String nonCharacterSymbols = " \n\t<>''\"{}[],;:%&*^#@!?";

    public FrequencyList() {
        reset();
    }

    public FrequencyList(String text) {
        this();
        addText(text);
    }

    // sets to empty
    public void reset() {
        dictionaryMap = new TreeMap<String, Integer>();
    }

    // adds a word to dictionary or increases it's count in the list
    public void addWord(String word) {
        Integer wordCount = dictionaryMap.get(word);
        if (wordCount == null) {
            // add a word to dictionary with a 1 count
            dictionaryMap.put(word, 1);
        } else {
            // increase a count
            ++wordCount;
        }
    }

    // returns the word's count
    public int getCount(String word) {
        Integer wordCount = dictionaryMap.get(word);
        if (wordCount == null) {
            return 0;
        } else {
            return wordCount;
        }
    }

    public int size() {
        return dictionaryMap.size();
    }

    // add text to list
    public void addText(String text) {
        // use tokenizer to parse the text
        StringTokenizer tokenizer = new StringTokenizer(text, nonCharacterSymbols);
        while (tokenizer.hasMoreTokens()) {
            addWord(tokenizer.nextToken());
        }
    }

    public Set<String> getVocabulary() {

        return dictionaryMap.keySet();
        
    }
}
