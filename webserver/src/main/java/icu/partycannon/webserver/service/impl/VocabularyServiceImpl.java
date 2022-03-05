package icu.partycannon.webserver.service.impl;

import icu.partycannon.webserver.mapper.VocabularyMapper;
import icu.partycannon.webserver.pojo.Vocabulary;
import icu.partycannon.webserver.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired
    private VocabularyMapper vocabularyMapper;

    @Override
    public List<Vocabulary> getVocabularyList() {
        return vocabularyMapper.getVocabularyList();
    }
}
