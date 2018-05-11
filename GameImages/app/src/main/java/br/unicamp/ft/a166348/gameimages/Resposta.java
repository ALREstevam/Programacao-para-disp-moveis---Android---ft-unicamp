package br.unicamp.ft.a166348.gameimages;

public class Resposta {
    private String answer;
    private String chosen;
    public Resposta(String answer, String chosen){
        this.answer = answer;
        this.chosen = chosen;
    }
    public String getAnswer() {
        return answer;
    }
    public String getChosen() {
        return chosen;
    }
}
