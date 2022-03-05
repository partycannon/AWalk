package icu.partycannon.webserver.controller;

import icu.partycannon.webserver.pojo.Vocabulary;
import icu.partycannon.webserver.service.impl.VocabularyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VocabularyController {
    @Autowired
    private VocabularyServiceImpl vocabularyService;

    @RequestMapping("/getVocabularyList")
    @ResponseBody
    public List<Vocabulary> getVocabularyList() {
        List<Vocabulary> list = vocabularyService.getVocabularyList();
        return list;
    }
}
