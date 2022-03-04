package icu.partycannon.test;

import icu.partycannon.mapper.VocabularyMapper;
import icu.partycannon.pojo.Vocabulary;
import icu.partycannon.utils.MybatisUtils;
import icu.partycannon.utils.VocabularyUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class VocabularyMapperTest {
    @Test
    public void getVocabularyList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Vocabulary> list = vocabularyMapper.getVocabularyList();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void getVocabularyById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);
        Vocabulary vocabulary = vocabularyMapper.getVocabularyById(1);
        System.out.println(vocabulary);
        sqlSession.close();
    }

    @Test
    public void getVocabularyByWord() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Vocabulary> list = vocabularyMapper.getVocabularyByWord("apple");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void getVocabularyByPos() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Vocabulary> list = vocabularyMapper.getVocabularyByPos("n.");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void getVocabularyLikeTranslate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Vocabulary> list = vocabularyMapper.getVocabularyLikeTranslate("苹");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void insertVocabulary() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);

        Vocabulary vocabulary = new Vocabulary("banana","n.","香蕉");
        int flag = vocabularyMapper.insertVocabulary(vocabulary);
        System.out.println(flag);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateVocabulary() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);

        Vocabulary vocabulary = new VocabularyUtils.VocabularyBuilder()
                .addId(2)
                .addWord("orange")
                .addTranslate("橘子")
                .create();
        int flag = vocabularyMapper.updateVocabulary(vocabulary);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteVocabulary() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);

        int flag = vocabularyMapper.deleteVocabulary(2);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteAllVocabulary() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);

        int flag = vocabularyMapper.deleteAllVocabulary();

        sqlSession.commit();
        sqlSession.close();
    }
}
