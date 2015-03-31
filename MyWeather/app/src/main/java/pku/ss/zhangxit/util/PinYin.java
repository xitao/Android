package pku.ss.zhangxit.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by xita on 2015/3/30.
 */
public class PinYin {
   public static  String converterToSpell(String chines){
       String pinyinName = "";
       char[]nameChar = chines.toCharArray();
       HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
       defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
       for (int i = 0;i < nameChar.length;i++){
           if (nameChar[i]>128 ){
               try{
                   pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i],defaultFormat)[0];
               }catch (BadHanyuPinyinOutputFormatCombination e){
                   e.printStackTrace();
               }
           }else {
               pinyinName += nameChar[i];
           }
       }return pinyinName;
   }
}
