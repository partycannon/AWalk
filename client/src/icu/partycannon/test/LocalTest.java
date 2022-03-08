package icu.partycannon.test;

import icu.partycannon.pojo.Vocabulary;
import icu.partycannon.pojo.VocabularyList;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocalTest {
    // 测试从文本文档读取数据并且保存到全局VocabularyList中
    @Test
    public void test_01() throws IOException {
        VocabularyList vocabularyList = VocabularyList.getInstance();

        // 将文本文档中的内容 存入全局容器
        InputStream inputStream = LocalTest.class.getClassLoader().getResourceAsStream("files/20220310.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            String[] strs = str.split("\t");
            String word = strs[0].trim();
            String posAndTranslate = strs[1].trim();

            // 将单词放到容器内部
            Vocabulary vocabulary = new Vocabulary(word, posAndTranslate);
            vocabularyList.addVocabulary(vocabulary);
        }

        // 将全局容器的内容打印出来
        System.out.println(vocabularyList);

        // 显示所有的词性和中文
        for (Vocabulary vocabulary : vocabularyList.getAll()) {
            System.out.println(vocabulary.getPosAndTranslate());
        }
    }
}
