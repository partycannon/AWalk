package icu.partycannon.test;

import icu.partycannon.mapper.VocabularyMapper;
import icu.partycannon.pojo.Vocabulary;
import icu.partycannon.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddVocabularyTest {
    // 通过拼接字符串来添加到数据库中
    @Test
    public void test_01() {
        List<Vocabulary> list = new ArrayList<>();

        String str = "explore=v.=探测，考察&survival=n.=生存&specimen=n.=标本&species=n.=（生物学）物种&assume=vt.=想当然，以为&influence=n.=影响&extinct=a.=灭绝的；熄灭的&giant=n.,a.=巨人；巨大的怪物；巨大的&squid=n.=鱿鱼&observe=vt.=观察&observation=n.=观察&elusive=a.=难以捉摸的&habitat=n.=栖息地&landmark=n.=地标；里程碑&ingenuity=n.=创造性；创新；机智&monumental=a.=巨大的&vital=a.=重要的；充满活力的&impact=n.=冲击，影响&planet=n.=行星&entirety=n.=全部&vessel=n.=船；容器&documentary=n.=纪录片&alien=a.=陌生的，不常见的&shark=n.=鲨鱼&whale=n.=鲸鱼&submersible=n.=潜水器&ensuing=a.=随后的&frenzy=n.=狂乱；颠狂&array=n.=大批，大量&overlook=vt.=忽视&micro-ecosystem=n.=微生态系统&buffet=n.=自助餐&antique=a.=古老的&tick=vi.=发滴答声&intricate=a.=复杂的&gear=n.=齿轮&hostile=a.=不友好的；敌对的&expertise=n.=专长&similarity=n.=相似（性）&disparity=n.=差距，不一致&amount=n.=数量，总额&funding=n.=资金&countless=a.=数不清的&jigsaw=n.=拼图&puzzle=n.=难题，迷&completion=n.=完成，实现&reveal=vt.=揭露，透露&imperative=a.=必要的，急需做的&accord=vt.=给予&expedition=n.=探险（队）&extraterrestrial=a.=地球外的&permanent=a.=永久的&costly=a.=昂贵的&mega-project=n.=大项目&radiation=n.=辐射&miniaturization=n.=小型化，微型化&rove=vt.=漫游&spur=v.=鞭策，刺激&fallow=a.=休耕的，不活跃的&combat=vt.=与……作斗争&bacterium=n.=细菌&bacterial=a.=细菌的&fertilization=n.=受精&regenerate=vt.=使新生，使再生&carbon dioxide=n.=二氧化碳&excrete=vt.=排泄，分泌&galaxy=n.=银河，星系&enthusiast=n.=热衷于……的人&spinoff=n.=派生产品，副产品&tout=v.=吹嘘，吹捧；兜售&extravagant=a.=过度的；奢侈的&shipyard=n.=造船厂&champagne=n.=香槟酒&tether=n.=缆绳&plunge=vi.,n.=跳进，投入&launch-pad=n.=发射台&submarine=n.=潜水艇&streamline=vt.=使成流线型&implode=vi.=内爆，崩溃&offshore=a.=离岸的";
        String[] vocabularys = str.split("&");
        for(int i = 0; i < vocabularys.length; i++) {
            String[] wordAndPosAndTranslate = vocabularys[i].split("=");
            String word = wordAndPosAndTranslate[0];
            String pos = wordAndPosAndTranslate[1];
            String translate = wordAndPosAndTranslate[2];
            Vocabulary vocabulary = new Vocabulary(word,pos,translate);
            list.add(vocabulary);
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);
        for(Vocabulary vocabulary : list) {
            vocabularyMapper.insertVocabulary(vocabulary);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_02() throws IOException {
        InputStream inputStream = AddVocabularyTest.class.getClassLoader().getResourceAsStream("files/20220310.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        VocabularyMapper vocabularyMapper = sqlSession.getMapper(VocabularyMapper.class);

        String str = "";
        while ((str=bufferedReader.readLine())!=null) {
            String[] wordAndPosAndTranslate = str.split(" ");
            String word = wordAndPosAndTranslate[0];
            String pos = wordAndPosAndTranslate[1];
            String translate = wordAndPosAndTranslate[2];

            Vocabulary vocabulary = new Vocabulary(word,pos,translate);
            vocabularyMapper.insertVocabulary(vocabulary);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
