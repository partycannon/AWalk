package icu.partycannon.utils;

import icu.partycannon.pojo.Vocabulary;

public class VocabularyUtils {

    public static class VocabularyBuilder {
        Vocabulary vocabulary = new Vocabulary();
        public VocabularyBuilder addId(Integer id) {
            vocabulary.setId(id);
            return this;
        }
        public VocabularyBuilder addWord(String word) {
            vocabulary.setWord(word);
            return this;
        }
        public VocabularyBuilder addPos(String pos) {
            vocabulary.setPos(pos);
            return this;
        }
        public VocabularyBuilder addTranslate(String translate) {
            vocabulary.setTranslate(translate);
            return this;
        }
        public Vocabulary create() {
            return this.vocabulary;
        }
    }
}
