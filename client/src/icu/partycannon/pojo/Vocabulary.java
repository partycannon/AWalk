package icu.partycannon.pojo;

public class Vocabulary {
    private Integer id;
    private String word;
    private String posAndTranslate;

    public Vocabulary() {
    }

    public Vocabulary(String word, String posAndTranslate) {
        this.word = word;
        this.posAndTranslate = posAndTranslate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPosAndTranslate() {
        return posAndTranslate;
    }

    public void setPosAndTranslate(String posAndTranslate) {
        this.posAndTranslate = posAndTranslate;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", posAndTranslate='" + posAndTranslate + '\'' +
                '}';
    }
}
