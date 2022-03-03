package icu.partycannon.pojo;

import java.util.Objects;

public class Vocabulary {
    private Integer id;
    private String word;
    private String pos;
    private String translate;

    public Vocabulary() {
    }

    public Vocabulary(String word, String pos, String translate) {
        this.word = word;
        this.pos = pos;
        this.translate = translate;
    }

    public Vocabulary(Integer id, String word, String pos, String translate) {
        this.id = id;
        this.word = word;
        this.pos = pos;
        this.translate = translate;
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocabulary that = (Vocabulary) o;
        return Objects.equals(id, that.id) && word.equals(that.word) && pos.equals(that.pos) && translate.equals(that.translate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, pos, translate);
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", pos='" + pos + '\'' +
                ", translate='" + translate + '\'' +
                '}';
    }
}
