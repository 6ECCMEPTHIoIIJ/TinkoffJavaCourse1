package edu.project1;

import java.util.List;

public class SessionInfo {
    private final AnswerMapper answerMapper;
    private final String answer;

    public SessionInfo(String answer) {
        this.answer = answer;
        answerMapper = new AnswerMapper(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public int getMaxAttempts() {
        return answer.length();
    }

    public int getMaxHits() {
        return answerMapper.getLetters().size();
    }

    public boolean containsCharacter(char ch) {
        return answerMapper.getLetters().containsKey(ch);
    }

    public List<Integer> getPositionsOfCharacter(char ch) {
        return answerMapper.getLetters().get(ch);
    }

}
