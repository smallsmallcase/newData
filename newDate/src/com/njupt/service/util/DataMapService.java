package com.njupt.service.util;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by huhui on 2017/12/5.
 */
@Service
public class DataMapService {

    /**表名和字段映射*/
    public final static Map<String, Map<String, String>> PROPERTIESMAP = new HashMap<>();

    /**表名映射*/
    public final static Map<String,String> TABLENAMEMAP = new LinkedHashMap<>();
    public final static String[] table = {
            "BasicInformation",
            "TodayDiseaseHistory",
            "PastHistory",
            "PersonHistory",
            "MarryHistory",
            "AbnormalGestation",
            "FamilyHistory",
            "BodyChange",
            "ChanKeInformation",
            "ElseDiscrible",
            "BloodTypeCheck"};
    public final static String[]tableOptional = {

            "JiaGong",
            "RoutineBloodTest",
            "PregnantBigCheck",
            "RoutIneurineTest",
            "SlidTime",
            "TieDanBaiCheck",
            "VisusEightCheck",
            "Cfy",
            "Else_Check",
            "Others"
    };
    public final static List<String> tableOptionalList = Arrays.asList(tableOptional);
    public static final Map<String,String> PRIMARYKEYMAP = new HashMap<>();
    private final String[] primaryKey = {
            "basic_id",
            "today_id",
            "pas_id",
            "person_id",
            "marry_id",
            "a_id",
            "dis_id",
            "bc_id",
            "ck_id",
            "el_id",
            "blo_id",
            "jg_id",
            "rbt_id",
            "pbg_id",
            "rt_id",
            "st_id",
            "tdbc_id",
            "vec_id",
            "cf_id",
            "bs_id",
            "o_id"};
    private final  String[] tableName = {
            "一般信息",
            "现病史",
            "既往史",
            "个人史",
            "婚姻史",
            "异常孕产情况",
            "家族史",
            "体格检查",
            "产科情况",
            "其他综合",
            "血型",


            "孕期甲功",
            "孕期血常规",
            "孕期大生化",
            "孕期尿常规",
            "孕期凝血常规",
            "孕期铁蛋白检测",
            "孕期病毒八项检查",
            "C反应蛋白",
            "B超",
            "其他"};



    private final String[]BasicInformation={"姓名","性别","年龄","婚姻","出生地","民族","职业","文化程度","工作","住址","入院日期","出院日期","住院号"};//一般信息
    private final String[]TodayDiseaseHistory={"足月产(次数)","早产(次数)","流产(次数)","存产(次数)","孕周(多少周)","LMP(末次月经时间)",
            "EDC(预产日期)","腹痛","腹痛间歇时间","腹痛持续时间","阴道流血","阴道流血量","阴道流水","阴道流水量","阴道见红","腹坠胀",
            "停经早期不适","不适出现时间","胎动出现时间(周)","宫高","腹围(cm)","孕早期保胎","保胎详细用药","早孕期病毒感染","TORCH",
            "放射线接触史","放射线具体接触时间地点","有害物质接触史","具体接触物、时间及地点","围产期建卡","唐筛","高风险应对的措施","系统超声",
            "系统超声具体异常","孕期血压监测","高血压的应对措施","孕期血糖监测","高血糖的应对措施","ABO血型","Rh血型","宫缩情况","胎动情况"};//现病史
    private final String[]PastHistory={"心肺肾疾病","癫痫疾病","传染疾病","预防接种疾病","手术史","过敏史"};//既往史
    private final String[]PersonHistory={"疫水接触","吸烟","饮酒","冶游","毒麻嗜好"};
    private final String[]MarryHistory={"是否结婚","结婚年龄","再婚年龄","丈夫姓名","丈夫年龄","丈夫职业","文化程度","健康状况"};
    private final String[]AbnormalGestation={"早期自然流产(次)","社会因素人工流产(次)","宫外孕(次)","中期流产(次)","引产(次)","胎儿异常","晚期流产(次)","分娩情况","其他"};
    private final String[]FamilyHistory={"遗传疾病"};
    private final String[]BodyChange={"身高","孕前体重","入院时体重","是否水肿"};
    private final String[]ChanKeInformation={"宫高(cm)","腹围","估计胎儿大小","胎方位","胎心心率","胎心位置","胎心强弱","先露部位","先露位置","先露衔接","胎膜","宫颈质地","宫颈位置","宫颈长度","宫颈扩张","宫缩","骨盆测量","髂嵴间径","骶耻外径","坐骨结节间径","高危因素记录"};
    private final String[]ElseDiscrible={"是否分娩","分娩方式","产时记录","产后24小时出血","感染","住院时间(天)","花费金额","产后抑郁","入院诊断"};
    private final String[]Others = {"腹痛","间歇时间","持续时间","阴道流血","阴道流血量","阴道流水","阴道流水量","阴道见红","腹坠胀","时间"};
    private final String[]BloodTypeCheck = {"ABO血型","Rh血型"};


    private final String[]JiaGong={"时间","甲状腺素(T4)","三碘甲状原氨酸(T3)","促甲状腺激素(TSH)","游离T3","游离T4"};
    private final String[]RoutineBloodTest={"白细胞计数","红细胞计数","血红蛋白浓度","血小板计数","中性粒细胞比率","淋巴细胞比率","单核细胞比率","嗜酸性粒细胞比率","嗜碱性粒细胞比率","中性粒细胞计数","淋巴细胞计数","单核细胞计数","嗜酸性粒细胞计数","嗜碱性粒细胞技术","红细胞平均体积","红细胞压积","平均红细胞含量","平均红细胞浓度","红细胞分布宽度-CV","红细胞分布宽度-SD","平均血小板体积","血小板压积","血小板分布宽度","大型血小板比率","时间"};
    private final String[]PregnantBigCheck={"钾","钠","氯","钙","磷","二氧化碳","总蛋白","白蛋白","球蛋白","白球比","前白蛋白","总胆汁酸","总胆红素","直接胆红素","间接胆红素","谷丙转氨酶","谷草转氨酶","碱性磷酸酶","谷氨酰转肽酶","乳酸脱氢酶","胆碱酯酶","葡萄糖","尿素氮","肌酐","尿酸","胱抑素C","时间"};
    private final String[]RoutIneurineTest={"尿胆原","胆红素","酮体","隐血","尿蛋白","亚硝酸盐","白细胞(NP)","葡萄糖","比重","PH值","维生素C","微量白蛋白","红细胞(高倍视野)","红细胞","红细胞信息","白细胞(高倍视野)","白细胞","上皮细胞(高倍视野)","上皮细胞","管型(低倍视野)","病理管型","管型","类酵母菌","小圆细胞","细菌","电导率","粘液丝","结晶","时间"};
    private final String[]SlidTime={"时间","凝血酶原时间(秒)","纤维蛋白原(g/L)","活化部分凝血活酶时间(秒)","凝血酶时间(秒)","凝血酶原活动度(%)"};
    private final String[]TieDanBaiCheck={"铁蛋白检测时间","铁蛋白检测含量"};
    private final String[]VisusEightCheck={"乙肝表面抗原","乙肝表面抗体","乙肝e抗原","乙肝e抗体","乙肝核心抗体","人体免疫缺陷病毒抗体","丙肝抗体","梅毒快速血浆的反应素","时间"};
    private final String[]Cfy={"C反应蛋白","时间"};
    private final String[]Else_Check={"时间","B超"};



    private final String[]AbnormalGestationEng={"early_num","rengong_num","gongwaiyuan_num","zhongqi_num","yingchang_num","taieryichang","wanqiliuchang_num","fengmian","elsething"};
    private final String[]BasicInformationEng={"personname","personsex","personage","personmarry","personborn","personnation","personoccupation","personeducation","personworkadress","personnowadress","personintime","personouttime","ad_number"};
    private final String[]BloodTypeCheckEng={"abo","rh"};
    private final String[]BodyChangeEng={"person_high","before_weight","after_weight","shuizhong"};
    private final String[]CfyEng={"c_fanying_danbai","c_time"};
    private final String[]ChanKeInformationEng={"gonghigh","fuwei","taierdaxiao","taifangwei","taixin","taixinweizhi","qiangdu","xianlou","weizhi","xianjie","taimo","gongjingzhidi","gongjingweizhi","gongjinglength","gongjingkuozhang","gongsuo","gupenmeasure","inlength","outlength","inoutlength","record"};
    private final String[]ElseDiscribleEng={"intype","fenmian","changhoublood","changruganran","staytime","money","changhouyiyi","chanchijilu","AD"};
    private final String[]Else_CheckEng={"e_time","b_chao"};
    private final String[]FamilyHistoryEng={"disease"};
    private final String[]JiaGongEng={"j_time","t4","t3","tsh","yl_t3","yl_t4"};
    private final String[]MarryHistoryEng={"is_marry","marryage","againmarryage","husbandname","husbandage","husband_work","husband_education","husbandhealthy"};
    private final String[]OthersEng={"fu_tong","fu_jxtime","fu_cxtime","blood","bloodvom","water","watervom","jianhong","zhui_zhang","o_time"};
    private final String[]PastHistoryEng={"xfs_diseasee","dianxian_disease","infectioushistory","yufang_disease","surgicalhistory","transfusion"};
    private final String[]PersonHistoryEng={"smokehistory","drinkhistory","touchhistory","zhiyouhistory","else_like"};
    private final String[]PregnantBigCheckEng={"k","na","cl","ca","p","co2","tp","alb","gb","whiteballratio","prealbumin","tba","tb","brd","urd","alt","got","alk","gpt","ldh","ce","glucose","bun","cr","ua","cystain","p_time"};
    private final String[]RoutIneurineTestEng={"uro","bil","ket","blo","pro","nitrite","wbc","putaotang","proportion","ph","vc","smallaf","rbc_h","rbc","rbc_message","wbc_high","wbc_","epithelium_high","epithelium","guanxing_low","b_guanxing","guanxing","ylf","small_cell","germ","conduct","vs","crystal","r_time"};
    private final String[]RoutineBloodTestEng={"wbc_number","rbc_number","hb_number","plt_number","neut_rate","ly_rate","mono_rate","egr_rate","bgr_rate","neut_number","ly_number","mono_number","egr_number","bgr_number","mcv","hct","mch","mchc","rdw_cv","rdw_sd","mpv","pct","pdw","plcr","r_time"};
    private final String[]SlidTimeEng={"s_time","lxmy_time","qwdby","lxhm_time","lxm_time","hdd"};
    private final String[]TieDanBaiCheckEng={"ch_time","ch"};
    private final String[]TodayDiseaseHistoryEng={"zu_chang","zao_chang","liu_chang","cu_chang","yunzhou","lmp","edc","fu_tong","fu_jxtime","fu_cxtime","blood","bloodvom","water","watervom","jianhong","zhui_zhang","zaoqibushi","bushi_time","taidongtime","gonggao","fuwei","earlybaotai","baotai_drag","virusinfection","torch","fangshe","shijdid","youhaiwuzhi","yhshijdid","jianka","tangshai","cuoshi","chaosheng","yichang","xueya","gxycs","xuetang","gxtcs","abobloodtype","rhbloodtype","gongsuo","taidong"};
    private final String[]VisusEightCheckEng={"iu","miu","eiu","emiu","emiu_in","hiv","b_kangti","meidu","v_time"};



    @PostConstruct
    private void init() {

        for (int i = 0; i < table.length; i++) {
            TABLENAMEMAP.put(table[i],tableName[i]);
            PRIMARYKEYMAP.put(table[i],primaryKey[i]);
        }
        for (int i = 0; i < tableOptional.length; i++) {
            TABLENAMEMAP.put(tableOptional[i],tableName[table.length+i]);
            PRIMARYKEYMAP.put(tableOptional[i],primaryKey[table.length+i]);
        }




        PROPERTIESMAP.put("AbnormalGestation", array2Map(AbnormalGestationEng, AbnormalGestation));
            PROPERTIESMAP.put("BasicInformation", array2Map(BasicInformationEng, BasicInformation));
            PROPERTIESMAP.put("BloodTypeCheck", array2Map(BloodTypeCheckEng, BloodTypeCheck));
            PROPERTIESMAP.put("BodyChange", array2Map(BodyChangeEng, BodyChange));
            PROPERTIESMAP.put("Cfy", array2Map(CfyEng, Cfy));
            PROPERTIESMAP.put("ChanKeInformation", array2Map(ChanKeInformationEng, ChanKeInformation));
            PROPERTIESMAP.put("ElseDiscrible", array2Map(ElseDiscribleEng, ElseDiscrible));
            PROPERTIESMAP.put("Else_Check", array2Map(Else_CheckEng, Else_Check));
            PROPERTIESMAP.put("FamilyHistory", array2Map(FamilyHistoryEng, FamilyHistory));
            PROPERTIESMAP.put("JiaGong", array2Map(JiaGongEng, JiaGong));
            PROPERTIESMAP.put("MarryHistory", array2Map(MarryHistoryEng, MarryHistory));
            PROPERTIESMAP.put("Others", array2Map(OthersEng, Others));
            PROPERTIESMAP.put("PastHistory", array2Map(PastHistoryEng, PastHistory));
            PROPERTIESMAP.put("PersonHistory", array2Map(PersonHistoryEng, PersonHistory));
            PROPERTIESMAP.put("PregnantBigCheck", array2Map(PregnantBigCheckEng, PregnantBigCheck));
            PROPERTIESMAP.put("RoutIneurineTest", array2Map(RoutIneurineTestEng, RoutIneurineTest));
            PROPERTIESMAP.put("RoutineBloodTest", array2Map(RoutineBloodTestEng, RoutineBloodTest));
            PROPERTIESMAP.put("SlidTime", array2Map(SlidTimeEng, SlidTime));
            PROPERTIESMAP.put("TieDanBaiCheck", array2Map(TieDanBaiCheckEng, TieDanBaiCheck));
            PROPERTIESMAP.put("TodayDiseaseHistory", array2Map(TodayDiseaseHistoryEng, TodayDiseaseHistory));
            PROPERTIESMAP.put("VisusEightCheck", array2Map(VisusEightCheckEng, VisusEightCheck));

    }

    private Map<String,String> array2Map(String[] key,String[] value) {
        int keyLen = key.length;
        int valueLen = value.length;
        if (keyLen!=valueLen){
            try {
                throw new Exception("数组的长度不一致");
            } catch (Exception e) {
                Arrays.toString(key);
                Arrays.toString(value);
                e.printStackTrace();
            }
        }
        HashMap<String, String> returnValue = new LinkedHashMap<>();
        for (int i = 0; i < keyLen; i++) {
            returnValue.put(key[i],value[i]);
        }
        return returnValue;
    }
}
