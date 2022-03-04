package icu.partycannon.mapper;

import icu.partycannon.pojo.Vocabulary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VocabularyMapper {
    @Select("select * from vocabulary")
    public List<Vocabulary> getVocabularyList();

    /**
     * 通过id编号获取单词
     * @param id 传入一个id值
     * @return 返回一个单词
     */
    public Vocabulary getVocabularyById(Integer id);

    /**
     * 通过单词英语本身获取单词集合 不同词性的属于同一个集合
     * @param word 想要获取的单词 传入英语
     * @return 返回一个单词集合
     */
    public List<Vocabulary> getVocabularyByWord(String word);

    /**
     * 通过词性获取单词集合 相同词性的单词可能有很多个
     * @param pos 想要获取的单词集合的词性 传入词性
     * @return 返回一个单词集合
     */
    public List<Vocabulary> getVocabularyByPos(String pos);

    /**
     * 通过词义获取单词集合 相同词义的单词可能有很多个
     * @param translate 想要获取的单词集合的词义 传入词义
     * @return 返回一个单词集合
     */
    public List<Vocabulary> getVocabularyLikeTranslate(String translate);

    /**
     * 传入一个Vocabulary 将Vocabulary添加进数据库中
     * @param vocabulary 将要存入数据库的Vocabulary
     * @return 返回被影响的行数
     */
    public int insertVocabulary(Vocabulary vocabulary);

    /**
     * 传入一个Vocabulary 通过id修改数据库中已有的Vocabulary
     * @param vocabulary Vocabulary的id属性必须存在 单词 词性 词义 必须至少存在一个
     * @return 返回被影响的行数
     */
    public int updateVocabulary(Vocabulary vocabulary);

    /**
     * 通过id删除整个单词
     * @param id 将要删除的单词的id号
     * @return 返回被影响的行数
     */
    public int deleteVocabulary(Integer id);

    /**
     * 删除所有数据
     * @return 返回被影响的行数
     */
    public int deleteAllVocabulary();
}
