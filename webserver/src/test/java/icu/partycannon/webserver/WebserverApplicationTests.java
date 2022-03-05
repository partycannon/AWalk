package icu.partycannon.webserver;

import icu.partycannon.webserver.mapper.VocabularyMapper;
import icu.partycannon.webserver.pojo.Vocabulary;
import icu.partycannon.webserver.service.impl.VocabularyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebserverApplicationTests {

    @Autowired
    private VocabularyMapper vocabularyMapper;

    @Autowired
    private VocabularyServiceImpl vocabularyService;

    @Test
    void contextLoads() {

    }

    @Test
    public void vocabularyMapperGetVocabularyList() {
        List<Vocabulary> list = vocabularyMapper.getVocabularyList();
        System.out.println(list);
    }

    @Test
    public void vocabularyServiceGetVocabularyList() {
        List<Vocabulary> list = vocabularyService.getVocabularyList();
        System.out.println(list);
    }
}
