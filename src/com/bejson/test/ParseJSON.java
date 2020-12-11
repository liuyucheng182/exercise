package com.bejson.test;

import com.alibaba.fastjson.JSON;
import com.bejson.pojo.JsonRootBean;

public class ParseJSON {

	public static void main(String[] args) {
		/**
         * json字符串转化为对象
         */
		
        String jsonString = getJsonString();
        JsonRootBean jsonRootBean = JSON.parseObject(jsonString, JsonRootBean.class);
        System.out.println(jsonRootBean.getReportMessage().getHeader().getMessageHeader().getReportSN());
        System.out.println(jsonRootBean.getReportMessage().getHeader().getMessageHeader().getQueryTime());
        System.out.println(jsonRootBean.getReportMessage().getPublicInfo().getAccFund().getComPercent());
	}
	
	public static String getJsonString() {
		String jsonString = "{\r\n" + 
				"  \"ReportMessage\": {\r\n" + 
				"    \"Header\": {\r\n" + 
				"      \"MessageHeader\": {\r\n" + 
				"        \"ReportSN\": \"2011051600000000108911\",\r\n" + 
				"        \"QueryTime\": \"2011.05.17 07:49:38\",\r\n" + 
				"        \"ReportCreateTime\": \"2011.05.17 07:49:38\"\r\n" + 
				"      },\r\n" + 
				"      \"QueryReq\": {\r\n" + 
				"        \"#text\": \"< ProductType >1</ ProductType > < Format >1</ Format > < FormatVersion >1</ FormatVersion >          \",\r\n" + 
				"        \"Name\": \"王玲\",\r\n" + 
				"        \"Certtype\": \"0|身份证\",\r\n" + 
				"        \"Certno\": \"51050219690201002X\",\r\n" + 
				"        \"QueryReason\": \"19|特约商户实名审查\",\r\n" + 
				"        \"QueryOrg\": \"B10111000H0001\",\r\n" + 
				"        \"UserCode\": \"gsh\",\r\n" + 
				"        \"QueryResultCue\": \"1|查询到该客户信息\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"PersonalInfo\": {\r\n" + 
				"      \"Identity\": {\r\n" + 
				"        \"Gender\": \"1|男性\",\r\n" + 
				"        \"Birthday\": \"2011.01.01\",\r\n" + 
				"        \"MaritalState\": \"2|已婚\",\r\n" + 
				"        \"Mobile\": \"12560242299\",\r\n" + 
				"        \"OfficeTelephoneNo\": \"01060242299\",\r\n" + 
				"        \"HomeTelephoneNo\": \"010－123456\",\r\n" + 
				"        \"EduLevel\": \"1|研究生\",\r\n" + 
				"        \"EduDegree\": \"1|名誉博士\",\r\n" + 
				"        \"PostAddress\": \"北京海淀\",\r\n" + 
				"        \"RegisteredAddress\": \"北京\"\r\n" + 
				"      },\r\n" + 
				"      \"Spouse\": {\r\n" + 
				"        \"Name\": \"新娘\",\r\n" + 
				"        \"Certtype\": \"1|户口簿\",\r\n" + 
				"        \"Certno\": \"123456789\",\r\n" + 
				"        \"Employer\": \"金电\",\r\n" + 
				"        \"TelephoneNo\": \"654321\"\r\n" + 
				"      },\r\n" + 
				"      \"Residence\": [\r\n" + 
				"        {\r\n" + 
				"          \"Address\": \"西洪门1\",\r\n" + 
				"          \"ResidenceType\": \"1|自置\",\r\n" + 
				"          \"GetTime\": \"2011.01.05\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Address\": \"西洪门2\",\r\n" + 
				"          \"ResidenceType\": \"1|自置\",\r\n" + 
				"          \"GetTime\": \"2011.01.05\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"Professional\": {\r\n" + 
				"        \"Employer\": \"金电\",\r\n" + 
				"        \"EmployerAddress\": \"北京西洪门\",\r\n" + 
				"        \"Occupation\": \"1|国家机关、党群组织、企业、事业单位负责人\",\r\n" + 
				"        \"Industry\": \"a |农、林、牧、渔业\",\r\n" + 
				"        \"Duty\": \"1|高级领导（行政级别局级及局级以上领导或大公司高级管理人员）\",\r\n" + 
				"        \"Title\": \"1|高级\",\r\n" + 
				"        \"StartYear\": \"2006\",\r\n" + 
				"        \"GetTime\": \"2011.01.10\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"InfoSummary\": {\r\n" + 
				"      \"CreditCue\": {\r\n" + 
				"        \"CreditSummaryCue\": {\r\n" + 
				"          \"PerHouseLoanCount\": \"1\",\r\n" + 
				"          \"PerBusinessHouseLoanCount\": \"1\",\r\n" + 
				"          \"OtherLoanCount\": \"2\",\r\n" + 
				"          \"FirstLoanOpenMonth\": \"2010.01\",\r\n" + 
				"          \"LoancardCount\": \"3\",\r\n" + 
				"          \"FirstLoancardOpenMonth\": \"2010.02\",\r\n" + 
				"          \"StandardLoancardCount\": \"4\",\r\n" + 
				"          \"FirstStandardLoancardOpenMonth\": \"2010.03\",\r\n" + 
				"          \"AnnounceCount\": \"5\",\r\n" + 
				"          \"DissentCount\": \"6\"\r\n" + 
				"        },\r\n" + 
				"        \"CreditScore\": {\r\n" + 
				"          \"Score\": \"20\",\r\n" + 
				"          \"ScoreLevel\": \"> 1/100\",\r\n" + 
				"          \"ScoreElements\": [\r\n" + 
				"            {\r\n" + 
				"              \"ScoreEle\": \"01|存在逾期还款记录\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"ScoreEle\": \"02|存在展期记录\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        }\r\n" + 
				"      },\r\n" + 
				"      \"OverdueAndFellback\": {\r\n" + 
				"        \"FellbackSummary\": {\r\n" + 
				"          \"FellbackDebtSum\": {\r\n" + 
				"            \"Count\": \"3\",\r\n" + 
				"            \"Balance\": \"170000\"\r\n" + 
				"          },\r\n" + 
				"          \"AssetDispositionSum\": {\r\n" + 
				"            \"Count\": \"1\",\r\n" + 
				"            \"Balance\": \"200000\"\r\n" + 
				"          },\r\n" + 
				"          \"AssureerRepaySum\": {\r\n" + 
				"            \"Count\": \"1\",\r\n" + 
				"            \"Balance\": \"100000\"\r\n" + 
				"          }\r\n" + 
				"        },\r\n" + 
				"        \"OverdueSummary\": {\r\n" + 
				"          \"LoanSum\": {\r\n" + 
				"            \"Count\": \"3\",\r\n" + 
				"            \"Months\": \"6\",\r\n" + 
				"            \"HighestOverdueAmountPerMon\": \"5500\",\r\n" + 
				"            \"MaxDuration\": \"2\"\r\n" + 
				"          },\r\n" + 
				"          \"LoancardSum\": {\r\n" + 
				"            \"Count\": \"2\",\r\n" + 
				"            \"Months\": \"6\",\r\n" + 
				"            \"HighestOverdueAmountPerMon\": \"5500\",\r\n" + 
				"            \"MaxDuration\": \"2\"\r\n" + 
				"          },\r\n" + 
				"          \"StandardLoancardSum\": {\r\n" + 
				"            \"Count\": \"2\",\r\n" + 
				"            \"Months\": \"4\",\r\n" + 
				"            \"HighestOverdueAmountPerMon\": \"5500\",\r\n" + 
				"            \"MaxDuration\": \"4\"\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      },\r\n" + 
				"      \"ShareAndDebt\": {\r\n" + 
				"        \"UnpaidLoan\": {\r\n" + 
				"          \"FinanceCorpCount\": \"2\",\r\n" + 
				"          \"FinanceOrgCount\": \"2\",\r\n" + 
				"          \"AccountCount\": \"3\",\r\n" + 
				"          \"CreditLimit\": \"1010000\",\r\n" + 
				"          \"Balance\": \"55100\",\r\n" + 
				"          \"Latest6MonthUsedAvgAmount\": \"6000\"\r\n" + 
				"        },\r\n" + 
				"        \"UndestoryLoancard\": {\r\n" + 
				"          \"FinanceCorpCount\": \"2\",\r\n" + 
				"          \"FinanceOrgCount\": \"2\",\r\n" + 
				"          \"AccountCount\": \"4\",\r\n" + 
				"          \"CreditLimit\": \"110000\",\r\n" + 
				"          \"MaxCreditLimitPerOrg\": \"30000\",\r\n" + 
				"          \"MinCreditLimitPerOrg\": \"20000\",\r\n" + 
				"          \"UsedCreditLimit\": \"15000\",\r\n" + 
				"          \"Latest6MonthUsedAvgAmount\": \"4000\"\r\n" + 
				"        },\r\n" + 
				"        \"UndestoryStandardLoancard\": {\r\n" + 
				"          \"FinanceCorpCount\": \"3\",\r\n" + 
				"          \"FinanceOrgCount\": \"3\",\r\n" + 
				"          \"AccountCount\": \"4\",\r\n" + 
				"          \"CreditLimit\": \"95000\",\r\n" + 
				"          \"MaxCreditLimitPerOrg\": \"30000\",\r\n" + 
				"          \"MinCreditLimitPerOrg\": \"5000\",\r\n" + 
				"          \"UsedCreditLimit\": \"12000\",\r\n" + 
				"          \"Latest6MonthUsedAvgAmount\": \"2000\"\r\n" + 
				"        },\r\n" + 
				"        \"GuaranteeSummary\": {\r\n" + 
				"          \"Count\": \"1\",\r\n" + 
				"          \"Amount\": \"200000\",\r\n" + 
				"          \"Balance\": \"100000\"\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"CreditDetail\": {\r\n" + 
				"      \"AssetDisposition\": {\r\n" + 
				"        \"Organname\": \"D\",\r\n" + 
				"        \"ReceiveTime\": \"2007.11.08\",\r\n" + 
				"        \"Money\": \"400000\",\r\n" + 
				"        \"LatestRepayDate\": \"2011.01.08\",\r\n" + 
				"        \"Balance\": \"20000\"\r\n" + 
				"      },\r\n" + 
				"      \"AssurerRepay\": {\r\n" + 
				"        \"Organname\": \"F\",\r\n" + 
				"        \"LatestAssurerRepayDate\": \"2007.10.05\",\r\n" + 
				"        \"Money\": \"1000000\",\r\n" + 
				"        \"LatestRepayDate\": \"2010.01.08\",\r\n" + 
				"        \"Balance\": \"10000\"\r\n" + 
				"      },\r\n" + 
				"      \"Loan\": [\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2005年10月20日商业银行“工商银行北京分行”发放的500,000元（美元折人民币）住房贷款，业务号001，抵押担保，180期，按月归还，2020年10月20日到期。截至2011年11月5日，账户状态为“呆账”，余额为150,000元\",\r\n" + 
				"          \"ContractInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"工商银行北京分行\",\r\n" + 
				"            \"FinanceType\": \"商业银行\",\r\n" + 
				"            \"Account\": \"业务号001\",\r\n" + 
				"            \"Type\": \"11|个人住房贷款\",\r\n" + 
				"            \"Currency\": \"美元折人民币\",\r\n" + 
				"            \"OpenDate\": \"2005.10.20\",\r\n" + 
				"            \"EndDate\": \"2020.10.20\",\r\n" + 
				"            \"CreditLimitAmount\": \"500000\",\r\n" + 
				"            \"GuaranteeType\": \"1|质押(含保证金)\",\r\n" + 
				"            \"PaymentRating\": \"03|月\",\r\n" + 
				"            \"PaymentCyc\": \"180期\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"4|呆帐\",\r\n" + 
				"          \"CurrAccountInfo\": {\r\n" + 
				"            \"Balance\": \"150000\"\r\n" + 
				"          }\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2005年9月22日商业银行“工商银行北京分行”发放的500,000元（美元折人民币）住房贷款，业务号002，抵押担保，180期，按月归还，2020年9月22日到期。截至 2011年11月5日\",\r\n" + 
				"          \"ContractInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"工商银行北京分行\",\r\n" + 
				"            \"FinanceType\": \"商业银行\",\r\n" + 
				"            \"Account\": \"业务号001\",\r\n" + 
				"            \"Type\": \"11|个人住房贷款\",\r\n" + 
				"            \"Currency\": \"美元折人民币\",\r\n" + 
				"            \"OpenDate\": \"2005.09.22\",\r\n" + 
				"            \"EndDate\": \"2020.09.22\",\r\n" + 
				"            \"CreditLimitAmount\": \"500000\",\r\n" + 
				"            \"GuaranteeType\": \"1|质押(含保证金)\",\r\n" + 
				"            \"PaymentRating\": \"03|月\",\r\n" + 
				"            \"PaymentCyc\": \"180期\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"1|正常\",\r\n" + 
				"          \"CurrAccountInfo\": {\r\n" + 
				"            \"StateEndDate\": \"2011.02.05\",\r\n" + 
				"            \"Class5State\": \"3|次级\",\r\n" + 
				"            \"Balance\": \"400000\",\r\n" + 
				"            \"RemainPaymentCyc\": \"117\",\r\n" + 
				"            \"ScheduledPaymentAmount\": \"4055\",\r\n" + 
				"            \"ScheduledPaymentDate\": \"2011.02.05\",\r\n" + 
				"            \"ActualPaymentAmount\": \"0\",\r\n" + 
				"            \"RecentPayDate\": \"2011.12.05\"\r\n" + 
				"          },\r\n" + 
				"          \"CurrOverdue\": {\r\n" + 
				"            \"CurrOverdueCyc\": \"2\",\r\n" + 
				"            \"CurrOverdueAmount\": \"5500\",\r\n" + 
				"            \"Overdue31To60Amount\": \"1000\",\r\n" + 
				"            \"Overdue61To90Amount\": \"0\",\r\n" + 
				"            \"Overdue91To180Amount\": \"0\",\r\n" + 
				"            \"OverdueOver180Amount\": \"0\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest24MonthPaymentState\": {\r\n" + 
				"            \"BeginMonth\": \"2009.03\",\r\n" + 
				"            \"EndMonth\": \"2011.02\",\r\n" + 
				"            \"Latest24State\": \"NNNN1NNNNNNNNNNNNNNNNN12\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest5YearOverdueRecord\": {\r\n" + 
				"            \"BeginMonth\": \"2006.03\",\r\n" + 
				"            \"EndMonth\": \"2011.02\",\r\n" + 
				"            \"OverdueRecord\": [\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2011.02\",\r\n" + 
				"                \"LastMonths\": \"2\",\r\n" + 
				"                \"Amount\": \"5500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2011.01\",\r\n" + 
				"                \"LastMonths\": \"1\",\r\n" + 
				"                \"Amount\": \"2500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2008.08\",\r\n" + 
				"                \"LastMonths\": \"1\",\r\n" + 
				"                \"Amount\": \"2500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2007.04\",\r\n" + 
				"                \"LastMonths\": \"1\",\r\n" + 
				"                \"Amount\": \"2500\"\r\n" + 
				"              }\r\n" + 
				"            ]\r\n" + 
				"          },\r\n" + 
				"          \"SpecialTrade\": {\r\n" + 
				"            \"Type\": \"1|展期(延期)\",\r\n" + 
				"            \"GetTime\": \"2008.09.22\",\r\n" + 
				"            \"ChangingMonths\": \"10\",\r\n" + 
				"            \"ChangingAmount\": \"318020\",\r\n" + 
				"            \"Content\": \"该贷款展期10个月。\"\r\n" + 
				"          },\r\n" + 
				"          \"BankIlluminate\": {\r\n" + 
				"            \"Content\": \"该客户委托XX房地产开发公司偿还贷款，因开发公司不按时还款导致出现多次逾期。\",\r\n" + 
				"            \"GetTime\": \"2008.12.22\"\r\n" + 
				"          },\r\n" + 
				"          \"DissentInfo\": {\r\n" + 
				"            \"Content\": \"该贷款记录正处于异议处理中。\",\r\n" + 
				"            \"GetTime\": \"2010.12.25\"\r\n" + 
				"          },\r\n" + 
				"          \"AnnounceInfo\": {\r\n" + 
				"            \"Content\": \"本人因出国未能按时还款，非恶意拖欠。\",\r\n" + 
				"            \"GetTime\": \"2007.12.12\"\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"Loancard\": [\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2005年5月9日机构“A”发放的贷记卡（人民币账户），业务号X，授信额度30,000元，共享授信额度30,000元，免担保。截至2009年8月5日，账户状态为“呆账”，余额为10,000元\",\r\n" + 
				"          \"AwardCreditInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"A\",\r\n" + 
				"            \"FinanceType\": \"商业银行\",\r\n" + 
				"            \"Account\": \"业务号001\",\r\n" + 
				"            \"Currency\": \"人民币账户\",\r\n" + 
				"            \"OpenDate\": \"2005.05.09\",\r\n" + 
				"            \"CreditLimitAmount\": \"30000\",\r\n" + 
				"            \"GuaranteeType\": \"4|信用/免担保\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"5|呆帐\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2007年8月12日机构“A”发放的贷记卡（人民币账户），业务号X，授信额度50,000元，共享授信额度50,000元，免担保。截至2011年9月5日，账户状态为“销户”\",\r\n" + 
				"          \"AwardCreditInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"工商银行信用卡中心\",\r\n" + 
				"            \"FinanceType\": \"商业银行\",\r\n" + 
				"            \"Account\": \"业务号002\",\r\n" + 
				"            \"Currency\": \"人民币账户\",\r\n" + 
				"            \"OpenDate\": \"2005.03.01\",\r\n" + 
				"            \"CreditLimitAmount\": \"30000\",\r\n" + 
				"            \"GuaranteeType\": \"4|信用/免担保\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"1|正常\",\r\n" + 
				"          \"RepayInfo\": {\r\n" + 
				"            \"StateEndDate\": \"2011.01.12\",\r\n" + 
				"            \"ShareCreditLimitAmount\": \"30000\",\r\n" + 
				"            \"UsedCreditLimitAmount\": \"5000\",\r\n" + 
				"            \"Latest6MonthUsedAvgAmount\": \"4000\",\r\n" + 
				"            \"UsedHighestAmount\": \"7000\",\r\n" + 
				"            \"ScheduledPaymentDate\": \"2011.01.12\",\r\n" + 
				"            \"ScheduledPaymentAmount\": \"2000\",\r\n" + 
				"            \"ActualPaymentAmount\": \"0\",\r\n" + 
				"            \"RecentPayDate\": \"2010.06.12\"\r\n" + 
				"          },\r\n" + 
				"          \"CurrOverdue\": {\r\n" + 
				"            \"CurrOverdueCyc\": \"2\",\r\n" + 
				"            \"CurrOverdueAmount\": \"5500\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest24MonthPaymentState\": {\r\n" + 
				"            \"BeginMonth\": \"2009.02\",\r\n" + 
				"            \"EndMonth\": \"2011.01\",\r\n" + 
				"            \"Latest24State\": \"NNNN1NNNNNNNNNNNNNNNNN12\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest5YearOverdueRecord\": {\r\n" + 
				"            \"BeginMonth\": \"2006.03\",\r\n" + 
				"            \"EndMonth\": \"2011.01\",\r\n" + 
				"            \"OverdueRecord\": [\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2011.01\",\r\n" + 
				"                \"LastMonths\": \"2\",\r\n" + 
				"                \"Amount\": \"5500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2010.12\",\r\n" + 
				"                \"LastMonths\": \"1\",\r\n" + 
				"                \"Amount\": \"2500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2008.08\",\r\n" + 
				"                \"LastMonths\": \"2\",\r\n" + 
				"                \"Amount\": \"5500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2008.07\",\r\n" + 
				"                \"LastMonths\": \"1\",\r\n" + 
				"                \"Amount\": \"2500\"\r\n" + 
				"              }\r\n" + 
				"            ]\r\n" + 
				"          },\r\n" + 
				"          \"SpecialTrade\": {\r\n" + 
				"            \"Type\": \"9|其他\",\r\n" + 
				"            \"GetTime\": \"2009.07\",\r\n" + 
				"            \"ChangingMonths\": \"0\",\r\n" + 
				"            \"ChangingAmount\": \"1000\",\r\n" + 
				"            \"Content\": \"——\"\r\n" + 
				"          },\r\n" + 
				"          \"BankIlluminate\": {\r\n" + 
				"            \"Content\": \"该卡逾期情况极为严重。\",\r\n" + 
				"            \"GetTime\": \"2010.12.15\"\r\n" + 
				"          },\r\n" + 
				"          \"DissentInfo\": {\r\n" + 
				"            \"Content\": \"该贷记卡记录正处于异议处理中。\",\r\n" + 
				"            \"GetTime\": \"2010.11.22\"\r\n" + 
				"          },\r\n" + 
				"          \"AnnounceInfo\": {\r\n" + 
				"            \"Content\": \"本人因出国无法及时还款，导致当前逾期，非恶意违约。\",\r\n" + 
				"            \"GetTime\": \"2011.01.02\"\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"StandardLoancard\": [\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2005年5月9日机构“A”发放的准贷记卡（人民币账户），业务号X，授信额度30,000元，共享授信额度30,000元，免担保。截至2009年8月5日，账户状态为“呆账”，余额为10,000元\",\r\n" + 
				"          \"AwardCreditInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"A\",\r\n" + 
				"            \"FinanceType\": \"商业银行\",\r\n" + 
				"            \"Account\": \"业务号001\",\r\n" + 
				"            \"Currency\": \"人民币账户\",\r\n" + 
				"            \"OpenDate\": \"2005.07.09\",\r\n" + 
				"            \"CreditLimitAmount\": \"300000\",\r\n" + 
				"            \"GuaranteeType\": \"4|信用/免担保\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"5|呆帐\",\r\n" + 
				"          \"RepayInfo\": {\r\n" + 
				"            \"ShareCreditLimitAmount\": \"10000\",\r\n" + 
				"            \"RecentPayDate\": \"2009.02.15\"\r\n" + 
				"          }\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2005年5月9日机构“A”发放的准贷记卡（人民币账户），业务号X1，授信额度30,000元，共享授信额度30,000元，免担保。截至2009年8月5日，账户状态为“呆账”，余额为10,000元\",\r\n" + 
				"          \"AwardCreditInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"工商银行\",\r\n" + 
				"            \"FinanceType\": \"商业银行\",\r\n" + 
				"            \"Account\": \"业务号002\",\r\n" + 
				"            \"Currency\": \"人民币账户\",\r\n" + 
				"            \"OpenDate\": \"2005.03.11\",\r\n" + 
				"            \"CreditLimitAmount\": \"300000\",\r\n" + 
				"            \"GuaranteeType\": \"4|信用/免担保\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"1|正常\",\r\n" + 
				"          \"RepayInfo\": {\r\n" + 
				"            \"StateEndDate\": \"2011.01.12\",\r\n" + 
				"            \"ShareCreditLimitAmount\": \"30000\",\r\n" + 
				"            \"UsedCreditLimitAmount\": \"1000\",\r\n" + 
				"            \"Latest6MonthUsedAvgAmount\": \"1000\",\r\n" + 
				"            \"UsedHighestAmount\": \"2000\",\r\n" + 
				"            \"ScheduledPaymentDate\": \"2011.01.12\",\r\n" + 
				"            \"ActualPaymentAmount\": \"0\",\r\n" + 
				"            \"RecentPayDate\": \"2010.06.19\"\r\n" + 
				"          },\r\n" + 
				"          \"CurrOverdue\": {\r\n" + 
				"            \"OverdueOver180Amount\": \"0\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest24MonthPaymentState\": {\r\n" + 
				"            \"BeginMonth\": \"2009.02\",\r\n" + 
				"            \"EndMonth\": \"2011.01\",\r\n" + 
				"            \"Latest24State\": \"NNNN1NNNNNNNNNNNNNNNNN12\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest5YearOverdueRecord\": {\r\n" + 
				"            \"BeginMonth\": \"2006.03\",\r\n" + 
				"            \"EndMonth\": \"2011.01\",\r\n" + 
				"            \"OverdueRecord\": [\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2011.01\",\r\n" + 
				"                \"LastMonths\": \"3\",\r\n" + 
				"                \"Amount\": \"2500\"\r\n" + 
				"              },\r\n" + 
				"              {\r\n" + 
				"                \"Month\": \"2008.12\",\r\n" + 
				"                \"LastMonths\": \"4\",\r\n" + 
				"                \"Amount\": \"3500\"\r\n" + 
				"              }\r\n" + 
				"            ]\r\n" + 
				"          },\r\n" + 
				"          \"SpecialTrade\": {\r\n" + 
				"            \"Type\": \"9|其他\",\r\n" + 
				"            \"GetTime\": \"2009.07\",\r\n" + 
				"            \"ChangingMonths\": \"0\",\r\n" + 
				"            \"ChangingAmount\": \"1000\",\r\n" + 
				"            \"Content\": \"——\"\r\n" + 
				"          },\r\n" + 
				"          \"BankIlluminate\": {\r\n" + 
				"            \"Content\": \"该卡透支情况极为严重。\",\r\n" + 
				"            \"GetTime\": \"2010.12.15\"\r\n" + 
				"          },\r\n" + 
				"          \"DissentInfo\": {\r\n" + 
				"            \"Content\": \"该准贷记卡记录正处于异议处理中。\",\r\n" + 
				"            \"GetTime\": \"2010.11.22\"\r\n" + 
				"          },\r\n" + 
				"          \"AnnounceInfo\": {\r\n" + 
				"            \"Content\": \"本人因出国无法及时还款，导致当前透支，非恶意违约。\",\r\n" + 
				"            \"GetTime\": \"2011.01.02\"\r\n" + 
				"          }\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Cue\": \"2005年3月15日A发放的准贷记卡（人民元账户），业务号003，授信额度30,000元，免担保。截至2011年1月12日\",\r\n" + 
				"          \"AwardCreditInfo\": {\r\n" + 
				"            \"FinanceOrg\": \"A\",\r\n" + 
				"            \"Account\": \"业务号003\",\r\n" + 
				"            \"Currency\": \"人民元账户\",\r\n" + 
				"            \"OpenDate\": \"2005.03.15\",\r\n" + 
				"            \"CreditLimitAmount\": \"300000\",\r\n" + 
				"            \"GuaranteeType\": \"4|信用/免担保\"\r\n" + 
				"          },\r\n" + 
				"          \"State\": \"1|正常\",\r\n" + 
				"          \"RepayInfo\": {\r\n" + 
				"            \"StateEndDate\": \"2011.01.12\",\r\n" + 
				"            \"ShareCreditLimitAmount\": \"30000\",\r\n" + 
				"            \"UsedCreditLimitAmount\": \"1000\",\r\n" + 
				"            \"Latest6MonthUsedAvgAmount\": \"1000\",\r\n" + 
				"            \"UsedHighestAmount\": \"2000\",\r\n" + 
				"            \"ScheduledPaymentDate\": \"2011.01.12\",\r\n" + 
				"            \"ActualPaymentAmount\": \"1000\",\r\n" + 
				"            \"RecentPayDate\": \"2011.01.12\"\r\n" + 
				"          },\r\n" + 
				"          \"CurrOverdue\": {\r\n" + 
				"            \"OverdueOver180Amount\": \"0\"\r\n" + 
				"          },\r\n" + 
				"          \"Latest24MonthPaymentState\": {\r\n" + 
				"            \"BeginMonth\": \"2009.02\",\r\n" + 
				"            \"EndMonth\": \"2011.01\",\r\n" + 
				"            \"Latest24State\": \"NNNN1NNNNNNNNNNNNNNNNN12\"\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"GuaranteeInfo\": [\r\n" + 
				"        {\r\n" + 
				"          \"GuaranteeFormat\": \"1|对外贷款担保\",\r\n" + 
				"          \"Guarantee\": [\r\n" + 
				"            {\r\n" + 
				"              \"Organname\": \"工商银行\",\r\n" + 
				"              \"ContractMoney\": \"200000\",\r\n" + 
				"              \"BeginDate\": \"2008.05.15\",\r\n" + 
				"              \"EndDate\": \"2025.05.14\",\r\n" + 
				"              \"GuananteeMoney\": \"200000\",\r\n" + 
				"              \"GuaranteeBalance\": \"100000\",\r\n" + 
				"              \"Class5State\": \"1|正常\",\r\n" + 
				"              \"BillingDate\": \"2011.01.10\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"Organname\": \"工商银行\",\r\n" + 
				"              \"ContractMoney\": \"200000\",\r\n" + 
				"              \"BeginDate\": \"2008.05.15\",\r\n" + 
				"              \"EndDate\": \"2025.05.14\",\r\n" + 
				"              \"GuananteeMoney\": \"200000\",\r\n" + 
				"              \"GuaranteeBalance\": \"100000\",\r\n" + 
				"              \"Class5State\": \"1|正常\",\r\n" + 
				"              \"BillingDate\": \"2011.01.10\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"GuaranteeFormat\": \"2|对外信用卡担保\",\r\n" + 
				"          \"Guarantee\": {\r\n" + 
				"            \"Organname\": \"工商银行\",\r\n" + 
				"            \"ContractMoney\": \"200000\",\r\n" + 
				"            \"BeginDate\": \"2008.05.15\",\r\n" + 
				"            \"EndDate\": \"2025.05.14\",\r\n" + 
				"            \"GuananteeMoney\": \"200000\",\r\n" + 
				"            \"GuaranteeBalance\": \"100000\",\r\n" + 
				"            \"Class5State\": \"1|正常\",\r\n" + 
				"            \"BillingDate\": \"2011.01.10\"\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"PublicInfo\": {\r\n" + 
				"      \"TaxArrear\": [\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"北京市东城区地税局\",\r\n" + 
				"          \"TaxArreaAmount\": \"500\",\r\n" + 
				"          \"Revenuedate\": \"2009.05.11\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"甘肃省靖远县国家税务局\",\r\n" + 
				"          \"TaxArreaAmount\": \"700\",\r\n" + 
				"          \"Revenuedate\": \"2008.03.17\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"CivilJudgement\": [\r\n" + 
				"        {\r\n" + 
				"          \"Court\": \"北京市宣武区人民法院\",\r\n" + 
				"          \"CaseReason\": \"——\",\r\n" + 
				"          \"RegisterDate\": \"2008.09.11\",\r\n" + 
				"          \"ClosedType\": \"1|判决\",\r\n" + 
				"          \"CaseResult\": \"被告张十五赔偿原告李四人民币500,000元\",\r\n" + 
				"          \"CaseValidatedate\": \"2007.07.09\",\r\n" + 
				"          \"SuitObject\": \"房屋买卖纠纷\",\r\n" + 
				"          \"SuitObjectMoney\": \"500000\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Court\": \"北京市东城区人民法院\",\r\n" + 
				"          \"CaseReason\": \"——\",\r\n" + 
				"          \"RegisterDate\": \"2007.05.09\",\r\n" + 
				"          \"ClosedType\": \"1|判决\",\r\n" + 
				"          \"CaseResult\": \"被告张十五赔偿原告王五人民币200,000元\",\r\n" + 
				"          \"CaseValidatedate\": \"2008.10.11\",\r\n" + 
				"          \"SuitObject\": \"房屋买卖纠纷\",\r\n" + 
				"          \"SuitObjectMoney\": \"200000\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"ForceExecution\": [\r\n" + 
				"        {\r\n" + 
				"          \"Court\": \"北京市西城区人民法院\",\r\n" + 
				"          \"CaseReason\": \"——\",\r\n" + 
				"          \"RegisterDate\": \"2008.09.11\",\r\n" + 
				"          \"ClosedType\": \"002|自动履行\",\r\n" + 
				"          \"CaseState\": \"执行完毕\",\r\n" + 
				"          \"ClosedDate\": \"2007.09.15\",\r\n" + 
				"          \"EnforceObject\": \"房屋\",\r\n" + 
				"          \"EnforceObjectMoney\": \"420000\",\r\n" + 
				"          \"AlreadyEnforceObject\": \"房屋买卖纠纷\",\r\n" + 
				"          \"AlreadyEnforceObjectMoney\": \"420000\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Court\": \"北京市宣武区人民法院\",\r\n" + 
				"          \"CaseReason\": \"——\",\r\n" + 
				"          \"RegisterDate\": \"2007.05.09\",\r\n" + 
				"          \"ClosedType\": \"002|自动履行\",\r\n" + 
				"          \"CaseState\": \"执行完毕\",\r\n" + 
				"          \"ClosedDate\": \"2008.10.11\",\r\n" + 
				"          \"EnforceObject\": \"房屋\",\r\n" + 
				"          \"EnforceObjectMoney\": \"220000\",\r\n" + 
				"          \"AlreadyEnforceObject\": \"房屋买卖纠纷\",\r\n" + 
				"          \"AlreadyEnforceObjectMoney\": \"220000\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"AdminPunishment\": [\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"青海省西宁市地方税务局\",\r\n" + 
				"          \"Content\": \"责令限期改正、没收违法所得\",\r\n" + 
				"          \"Money\": \"400\",\r\n" + 
				"          \"BeginDate\": \"2007.07.01\",\r\n" + 
				"          \"EndDate\": \"2008.07.01\",\r\n" + 
				"          \"Result\": \"无\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"湖南省建设管理服务中心\",\r\n" + 
				"          \"Content\": \"暂扣或者吊销许可证、暂扣或者吊销执照\",\r\n" + 
				"          \"Money\": \"900\",\r\n" + 
				"          \"BeginDate\": \"2006.09.11\",\r\n" + 
				"          \"EndDate\": \"2008.09.11\",\r\n" + 
				"          \"Result\": \"无\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"AccFund\": {\r\n" + 
				"        \"Area\": \"内蒙古自治区通辽市\",\r\n" + 
				"        \"RegisterDate\": \"2006.07.01\",\r\n" + 
				"        \"FirstMonth\": \"2006.07\",\r\n" + 
				"        \"ToMonth\": \"2006.12\",\r\n" + 
				"        \"State\": \"001|缴交\",\r\n" + 
				"        \"Pay\": \"1000\",\r\n" + 
				"        \"OwnPercent\": \"12%\",\r\n" + 
				"        \"ComPercent\": \"12%\",\r\n" + 
				"        \"Organname\": \"科左中旗努日木苏木经管站\",\r\n" + 
				"        \"GetTime\": \"2010.07.01\"\r\n" + 
				"      },\r\n" + 
				"      \"EndowmentInsuranceDeposit\": {\r\n" + 
				"        \"Area\": \"北京市东城区\",\r\n" + 
				"        \"RegisterDate\": \"2001.03.08\",\r\n" + 
				"        \"MonthDuration\": \"36\",\r\n" + 
				"        \"WorkDate\": \"1995.06\",\r\n" + 
				"        \"State\": \"1|参保缴费\",\r\n" + 
				"        \"OwnBasicMoney\": \"5623\",\r\n" + 
				"        \"Money\": \"1022\",\r\n" + 
				"        \"Organname\": \"中国工商银行\",\r\n" + 
				"        \"PauseReason\": \"——\",\r\n" + 
				"        \"GetTime\": \"2010.11.08\"\r\n" + 
				"      },\r\n" + 
				"      \"EndowmentInsuranceDeliver\": {\r\n" + 
				"        \"Area\": \"北京市东城区\",\r\n" + 
				"        \"RetireType\": \"2|正常退休\",\r\n" + 
				"        \"RetiredDate\": \"2010.03\",\r\n" + 
				"        \"WorkDate\": \"1995.06\",\r\n" + 
				"        \"Money\": \"1560\",\r\n" + 
				"        \"PauseReason\": \"——\",\r\n" + 
				"        \"Organname\": \"中国工商银行\",\r\n" + 
				"        \"GetTime\": \"2011.01.08\"\r\n" + 
				"      },\r\n" + 
				"      \"Salvation\": {\r\n" + 
				"        \"PersonnelType\": \"1|在职职工\",\r\n" + 
				"        \"Area\": \"北京市\",\r\n" + 
				"        \"Organname\": \"——\",\r\n" + 
				"        \"Money\": \"200\",\r\n" + 
				"        \"RegisterDate\": \"1995.01.08\",\r\n" + 
				"        \"PassDate\": \"1995.03.08\",\r\n" + 
				"        \"GetTime\": \"2000.03.15\"\r\n" + 
				"      },\r\n" + 
				"      \"Competence\": [\r\n" + 
				"        {\r\n" + 
				"          \"CompetencyName\": \"会计从业资格证书\",\r\n" + 
				"          \"Grade\": \"2|省市级机构颁发的执业资格证书\",\r\n" + 
				"          \"AwardDate\": \"2007.05.23\",\r\n" + 
				"          \"EndDate\": \"2007.05.23\",\r\n" + 
				"          \"RevokeDate\": \"——\",\r\n" + 
				"          \"Organname\": \"江西省财政厅\",\r\n" + 
				"          \"Area\": \"江西省南昌市市辖区\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"CompetencyName\": \"会计从业资格证书\",\r\n" + 
				"          \"Grade\": \"2|省市级机构颁发的执业资格证书\",\r\n" + 
				"          \"AwardDate\": \"2009.03.12\",\r\n" + 
				"          \"EndDate\": \"2010.03.12\",\r\n" + 
				"          \"RevokeDate\": \"——\",\r\n" + 
				"          \"Organname\": \"北京市财政厅\",\r\n" + 
				"          \"Area\": \"北京市市辖区朝阳区\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"AdminAward\": [\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"甘肃省白银市地方税务局\",\r\n" + 
				"          \"Content\": \"优秀纳税人\",\r\n" + 
				"          \"BeginDate\": \"2008.06.13\",\r\n" + 
				"          \"EndDate\": \"2008.06.13\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"湖南省建筑管理服务中心\",\r\n" + 
				"          \"Content\": \"暂缺\",\r\n" + 
				"          \"BeginDate\": \"2009.05.14\",\r\n" + 
				"          \"EndDate\": \"2010.05.14\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"Vehicle\": [\r\n" + 
				"        {\r\n" + 
				"          \"EngineCode\": \"JTLGK12E79563\",\r\n" + 
				"          \"LicenseCode\": \"京NJ8745\",\r\n" + 
				"          \"Brand\": \"丰田\",\r\n" + 
				"          \"CarType\": \"K|客车\",\r\n" + 
				"          \"UseCharacter\": \"A|非营运\",\r\n" + 
				"          \"State\": \"A|正常\",\r\n" + 
				"          \"PledgeFlag\": \"0|未抵押\",\r\n" + 
				"          \"GetTime\": \"2010.09.14\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"EngineCode\": \"GKJTL12E79536\",\r\n" + 
				"          \"LicenseCode\": \"京NK5624\",\r\n" + 
				"          \"Brand\": \"大众\",\r\n" + 
				"          \"CarType\": \"K|客车\",\r\n" + 
				"          \"UseCharacter\": \"A|非营运\",\r\n" + 
				"          \"State\": \"A|正常\",\r\n" + 
				"          \"PledgeFlag\": \"1|已抵押\",\r\n" + 
				"          \"GetTime\": \"2010.12.14\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"TelPayment\": [\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"中国铁通甘肃分公司\",\r\n" + 
				"          \"Type\": \"固定电话后付费\",\r\n" + 
				"          \"RegisterDate\": \"2006.08.17\",\r\n" + 
				"          \"State\": \"1|欠费\",\r\n" + 
				"          \"ArrearMoney\": \"500\",\r\n" + 
				"          \"ArrearMonths\": \"欠费超过宽限期1个月不足2个月\",\r\n" + 
				"          \"Status24\": \"NNNN1NNNNNNNNNNNNNNNNN12\",\r\n" + 
				"          \"GetTime\": \"2010.10\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"Organname\": \"中国网通(集团)山西省通信公司\",\r\n" + 
				"          \"Type\": \"移动电话\",\r\n" + 
				"          \"RegisterDate\": \"2007.03.24\",\r\n" + 
				"          \"State\": \"1|欠费\",\r\n" + 
				"          \"ArrearMoney\": \"0\",\r\n" + 
				"          \"ArrearMonths\": \"欠费超过宽限期1个月不足2个月\",\r\n" + 
				"          \"Status24\": \"NNNN1NNNNNNNNNNNNNNNNNNN\",\r\n" + 
				"          \"GetTime\": \"2010.11\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"Announce\": {\r\n" + 
				"      \"AnnounceInfo\": {\r\n" + 
				"        \"Content\": \"本人因出国无法及时还款，导致当前透支，非恶意违约。\",\r\n" + 
				"        \"GetTime\": \"2011.01.02\"\r\n" + 
				"      },\r\n" + 
				"      \"DissentInfo\": {\r\n" + 
				"        \"Content\": \"该准贷记卡记录正处于异议处理中。\",\r\n" + 
				"        \"GetTime\": \"2010.11.22\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"QueryRecord\": {\r\n" + 
				"      \"RecordSummary\": {\r\n" + 
				"        \"LatestMonthQueryorgSum\": [\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"02|贷款审批\",\r\n" + 
				"            \"Sum\": \"0\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"03|信用卡审批\",\r\n" + 
				"            \"Sum\": \"0\"\r\n" + 
				"          }\r\n" + 
				"        ],\r\n" + 
				"        \"LatestMonthQueryrecordSum\": [\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"02|贷款审批\",\r\n" + 
				"            \"Sum\": \"0\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"04|本人查询\",\r\n" + 
				"            \"Sum\": \"2\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"03|信用卡审批\",\r\n" + 
				"            \"Sum\": \"0\"\r\n" + 
				"          }\r\n" + 
				"        ],\r\n" + 
				"        \"TwoyearQueryrecordSum\": [\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"01|贷后管理\",\r\n" + 
				"            \"Sum\": \"7\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"08|担保资格审查\",\r\n" + 
				"            \"Sum\": \"0\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"QueryReason\": \"19|特约商户实名审查\",\r\n" + 
				"            \"Sum\": \"0\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      \"RecordInfo\": {\r\n" + 
				"        \"QueryReqFormat\": \"1|信贷审批查询\",\r\n" + 
				"        \"RecordDetail\": [\r\n" + 
				"          {\r\n" + 
				"            \"QueryDate\": \"2010.02.10\",\r\n" + 
				"            \"Querier\": \"D/xykcrmz\",\r\n" + 
				"            \"QueryReason\": \"03|信用卡审批\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"QueryDate\": \"2009.12.14\",\r\n" + 
				"            \"Querier\": \"B/kmzui\",\r\n" + 
				"            \"QueryReason\": \"02|贷款审批\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		return jsonString;
	}
}
