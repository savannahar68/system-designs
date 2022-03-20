package stackoverflow.Interface;

import stackoverflow.Domain.Question;

import java.util.List;

public interface SearchService {
    List<Question> searchText(String text);
    List<Question> searchWithTags(List<String> tags);
    List<Question> searchWithKeywords(List<String> keywords);
    List<Question> searchSimilar(Question question);
}
