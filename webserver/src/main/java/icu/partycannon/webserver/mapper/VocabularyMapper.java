package icu.partycannon.webserver.mapper;

import icu.partycannon.webserver.pojo.Vocabulary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VocabularyMapper {
    public List<Vocabulary> getVocabularyList();
}
