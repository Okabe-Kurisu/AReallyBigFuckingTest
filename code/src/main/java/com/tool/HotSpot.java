package com.tool;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;

import java.util.*;

/**
 * Created by Amadeus on 2018/5/10.
 */
public class HotSpot {
    private Map<String, Integer> hotspot;
    public List<String> getHotWords(){
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<String> hotWords = null;
        int date = (int) System.currentTimeMillis()/1000;
        date -= 7*24*3600;
        try {
            hotWords = sqlSession.selectList("weibo/SearchLogMapper.selectSearchLog", date);
        } finally {
            sqlSession.close();
        }
        return hotWords;
    }

    public void seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
        List<String> result = new ArrayList<String>();
        for(Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)){
            String rst = word.getText();
            int value = hotspot.get(hotspot.get(rst));
            if (hotspot.get(rst) != null || hotspot.get(rst) != 0){
                hotspot.put(rst, value + 1);
            }else {
                hotspot.put(rst, 1);
            }
        }
    }

    public void analysis(List<String> words){
        for(String word: words){
            seg(word, SegmentationAlgorithm.BidirectionalMaximumMatching);
        }

    }

    public static void main(String[] args) {
        int date = (int) System.currentTimeMillis()/1000;
        HotSpot hotSpot = new HotSpot();
        List words = hotSpot.getHotWords();
        hotSpot.analysis(words);
        System.out.println(hotSpot);
        date = (int) System.currentTimeMillis()/1000 -date;
        System.out.println(date);
    }

    public Map<String, Integer> getHotspot() {
        return hotspot;
    }

    public void setHotspot(Map<String, Integer> hotspot) {
        this.hotspot = hotspot;
    }
}
