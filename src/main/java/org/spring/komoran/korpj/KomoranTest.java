package org.spring.komoran.korpj;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

import java.util.List;

public class KomoranTest {
    public static void main(String[] args) {

        Komoran komoran=new Komoran(DEFAULT_MODEL.FULL);

        String testStr="우리는 웹 개발자입니다.";

        KomoranResult analyzeResultList= komoran.analyze(testStr); // 테스트 텍스트 분석

        System.out.println(analyzeResultList.getPlainText()); // 코모란 분석 텍스트 결과물 get

        List<Token> tokenList= analyzeResultList.getTokenList();
        for(Token token:tokenList){
            System.out.println(token);
            System.out.format("(%2d, %2d) %s/%s\n",
                    token.getBeginIndex(),
                    token.getEndIndex(),
                    token.getMorph(),
                    token.getPos());
            System.out.println(token.getMorph().toString().equals("우리"));

            if(token.getMorph().toString().equals("우리")){
                System.out.println("즐거운 쇼핑되세요.");
            }
        }



    }
}
