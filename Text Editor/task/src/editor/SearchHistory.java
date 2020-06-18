package editor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchHistory {

    private List<Match> searchResults;
    private int currentPosition;

    public SearchHistory() {
        searchResults = new ArrayList<>();
    }

    public Match startSearch(String wordToFind, String text, boolean regex) {
        Pattern word;
        if (regex) {
            word = Pattern.compile(wordToFind.replaceAll("\\\\", "\\\\"));
        } else {
            word = Pattern.compile(wordToFind);
        }
        Matcher matcher = word.matcher(text);

        searchResults.clear();
        while (matcher.find()) {
            searchResults.add(new Match(matcher.start(), matcher.group()));
        }

        if (searchResults.isEmpty()) {
            return null;
        } else {
            currentPosition = 0;
            return searchResults.get(currentPosition);
        }
    }

    public Match getNextMatch() {
        if (searchResults.isEmpty()) {
            return null;
        } else {
            if (currentPosition < searchResults.size() - 1) {
                currentPosition++;
            } else {
                currentPosition = 0;
            }
            return searchResults.get(currentPosition);
        }
    }

    public Match getPreviousMatch() {
        if (searchResults.isEmpty()) {
            return null;
        } else {
            if (currentPosition > 0) {
                currentPosition--;
            } else {
                currentPosition = searchResults.size() - 1;
            }
            return searchResults.get(currentPosition);
        }

    }
}
