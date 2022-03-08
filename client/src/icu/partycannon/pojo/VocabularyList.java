package icu.partycannon.pojo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class VocabularyList {
    private static final VocabularyList INSTANCE = new VocabularyList();
    private static Map<String,Vocabulary> map;

    // 单例模式 构造方法私有
    private VocabularyList() {
        map = new HashMap<>();
    }

    // 外界唯一可以获得VocabularyList的方法
    public static VocabularyList getInstance() {
        return INSTANCE;
    }

    // 通过word来获取整个Vocabulary
    public Vocabulary getVocabularyByWord(String word) {
        return map.get(word);
    }

    // 添加Vocabulary
    public void addVocabulary(Vocabulary vocabulary) {
        map.put(vocabulary.getWord(), vocabulary);
    }

    // 清空map
    public void clearAll() {
        map.clear();
    }

    // 返回所有的value
    public Collection<Vocabulary> getAll() {
        return map.values();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
