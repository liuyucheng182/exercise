/*
 * ApplicationConstants
 * V 1.0.0
 * 2012/11/14
 *
 * Copyright © 2012 中国电信股份有限公司 版权所有
 *
 * 所有文字、代码资料，版权均属中国电信股份有限公司增值业务运营中心
 * 所有，任何公司或个人未经本司协议授权，不得复制、下载、存储或公开
 * 显示。违者本公司将依法追究责任。
 */
package test;


import java.io.File;


/**
 * 系统常量
 * <br>
 *
 * @author 刘通
 */
public class ApplicationConstants {

    /**
     * 系统换行符
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /**
     * 目录风格符
     */
    public static final String FILE_SEPARATOR = File.separator;
    /**
     * 时间格式化字符串
     */
    public static final String[] TIME_PATTERN = new String[]{"yyyy-MM", "yyyyMM", "yyyy/MM", "yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss"};

	/* -----------------------------------
     *       常用变量
	 ----------------------------------- */
    /**
     * 链接打开客户端前缀
     */
    public static String clientLinkPrefix;
    
	/**
     * 自动充值状态--未充值
     */
    public final static String RECHARGE_STATE_NO = "未充值";
    /**
     * 自动充值状态--充值成功
     */
    public final static String RECHARGE_STATE_SUCCESS = "充值成功";
    /**
     * 自动充值状态--充值金额错误
     */
    public final static String RECHARGE_STATE_WRONG_PRICE = "充值失败,充值金额错误";
    /**
     * 卡密系统地址
     */
    public  static String cardRechargeUrl;

	/* -----------------------------------
	 *       配置模块
	 ----------------------------------- */
    /**
     * 自动充值短信发送状态--未发送
     */
    public final static String RECHARGE_SMS_STATE_NO = "未发送";
    /**
     * 自动充值短信发送状态--待发送
     */
    public final static String RECHARGE_SMS_STATE_WAIT = "待发送";
    /**
     * 自动充值短信发送状态--已发送
     */
    public final static String RECHARGE_SMS_STATE_DONE = "已发送";
    /**
     * 自动充值短信发送状态--发送失败
     */
    public final static String RECHARGE_SMS_STATE_FAIL = "发送失败";
    /**
     * 自动充值卡密状态--已充值
     */
    public final static String RECHARGE_CARD_PW_STATE_SUCCESS = "充值成功";
    /**
     * 自动充值卡密状态--待充值
     */
    public final static String RECHARGE_CARD_PW_STATE_WAIT = "待充值";
    /**
     * 自动充值卡密状态--卡密失效
     */
    public final static String RECHARGE_CARD_PW_STATE_FAIL = "卡密失效";
    /**
     * 合约类型-存费送机
     */
    public final static long C_TYPE_STORE_CHARGES_TO_PHONE = 100001L;
    /**
     * 合约类型-存费送机北京
     */
    public final static long C_TYPE_STORE_CHARGES_TO_PHONE_BJ = 100002L;
    /**
     * 合约类型-旧购机送费
     */
    public final static long C_TYPE_BUY_PHONE_TO_CHARGES_OLD = 200001L;
    /**
     * 合约类型-新购机送费
     */
    public final static long C_TYPE_BUY_PHONE_TO_CHARGES_NEW = 300002L;
    /**
     * 合约类型-0元租机
     */
    public final static long C_TYPE_FREE_RENT_PHONE = 300001L;
    /**
     * 合约类型-0元租机-差额购
     */
    public final static long C_TYPE_FREE_RENT_PHONE_DIFF_BUY = 300003L;
    /**
     * 政企店铺编码头
     */
    public final static String CUST_SHOP_BM_HEAD = "50000";
    /**
     * 政企店铺标识
     */
    public final static String CUST_SHOP_FLAG = "zq";
    /**
     * 政企主产品id
     */
    public  static String productIdZq ;
    /**
     * 政企套餐ID
     */
    public  static String telpackageIdZq;
    /**
     * 系统中文名称
     */
    public static String appContextNameCN;
    /**
     * 系统英文名称
     */
    public static String appContextNameEN;
    /**
     * 系统临时目录
     */
    public static String systemTmp = System.getProperty("java.io.tmpdir");
    /**
     * 集团店铺ID
     */
    public static String shopId_JT;
    /**
     * 北京店铺ID
     */
    public static String shopBm_BJ;
    /**
     * android店铺编码
     */
    public static String shopBm_Android;
    /**
     * android店铺编码
     */
    public static String shopBm_Wap;
    /**
     * ios店铺编码
     */
    public static String shopBm_Ios;
    /**
     * A1类型ID
     */
    public static String abTypeId_A1;
    /**
     * B类型ID
     */
    public static String abTypeId_B;
	/* -----------------------------------
	 *      充值模块
	 ----------------------------------- */
    /**
     * 号段信息
     */
    public static String[] titleArr;
    /**
     * 运营中心店铺编码
     */
    public static String SHOP_BM_YYZX = "10036";
    /**
     * 北京店铺编码
     */
    public static String SHOP_BM_BEIJING = "10001";
    /**
     * 集团店铺编码
     */
    public static String SHOP_BM_JT = "10000";
    /**
     * * 中国电信电子渠道店铺编码
     */
    public static String SHOP_BM_E_CHANNEL = "1003600155";
    /**
     * * 中国电信电子渠道直营店铺编码
     */
    public static String SHOP_BM_E_CHANNEL_ZY = "10039";
    /**
     * * 政企店铺编码
     */
    public static String SHOP_BM_ZQ = "50000";
    /**
     * 集团省份编码
     */
    public static String PROV_BM_JT = "1000000037";
    /**
     * 集团省份编码
     */
    public static String PROV_BM_DEFAULT = "1000000038";
	
	/* -----------------------------------
	 *      产品模块
	 ----------------------------------- */
    /**
     * 集团省份编码
     */
    public static String PROV_NAME_DEFAULT = "默认";
    /**
     * 产品现金预存类型-编码
     */
    public static String PRODUCT_XJYC = "200004";
    /**
     * 产品补贴类型-编码
     */
    public static String PRODUCT_BT = "200003";
    /**
     * 产品启用状态
     */
    public static String PRODUCT_STATE_QY = "0";
    /**
     * 优惠券加(解)密密钥
     */
    public static String couponCode;
	
	/* -----------------------------------
	 *      销售品模块
	 ----------------------------------- */
    /**
     * 虚拟赠品优惠券加(解)密密钥
     */
    public static String giftCouponCode;
    /**
     * 卡密加(解)密密钥
     */
    public static String cardCode;
    /**
     * 前台销售品集约组url
     */
    public static String goodsTeamUrl;
    /**
     * 本系统设备号
     */
    public static String srcSsDeviceNo;
	
	/* -----------------------------------
	 *       单点登录
	 ----------------------------------- */
    /**
     * UDB登录跳转地址
     */
    public static String loginReturnURL;
    /**
     * UDB退出跳转地址
     */
    public static String logoutReturnURL;
    /**
     * 本系统登录跳转URL
     */
    public static String loginURL;
    /**
     * 北京节点WSAL地址
     */
    public static String wsdlURL_BJ;
	
	/* -----------------------------------
	 *        接口配置
	 ----------------------------------- */
    /**
     * 短链接转长链接查询接口
     */
    public static String getTransUrlShortToLong;
    /**
     * 长链接转短链接查询接口
     */
    public static String getTransUrlLongToShort;
    /**
     * 长短链接查询接口地址
     */
    public static String getTransUrlIp;
    
    /**
     * 政企客户信息查询接口
     */
    public static String getCustInfo;
    /**
     * 政企客户信息查询接口地址
     */
    public static String getCustInfoIp;
    /**
     * 客户端-宽带资源
     */
    public static String ecServiceBroadBand;
    /**
     * 客户端-客户端配置
     */
    public static String ecServiceClientConfig;
    /**
     * 客户端-redis仓库
     */
    public static String ecServiceStore;
 
    /**
     * wap通用广告位刷新缓存接口服务器IP
     */
    public static String updateWapPicCacheIp;
    /**
     * wap通用广告位刷新缓存接口
     */
    public static String updateWapPicCache;
	/**
     * 客户端配置中心刷新缓存接口服务器IP
     */
    public static String updateClientCacheIp;
    /**
     * 客户端配置中心刷新缓存接口
     */
    public static String updateClientCache;
    /**
     * wap早市发布
     */
    public static String wapRelease;
    public static String releasePublish;
    /**
     * 夜市发布
     */
    public static String wapRelease0;
    public static String releasePublish0;
    /**
     * 新wap厅刷新缓存
     */
    public static String wapRefreshIp;
    public static String refreshWap;
    /**
     * wap限时购活动发布
     */
    public static String wapXSGRelease1;
    public static String releaseXSG1;
    public static String wapXSGRelease2;
    public static String releaseXSG2;
    public static String wapXSGRelease3;
    public static String releaseXSG3;
    
    /**
     * ec-service-IP
     */
    public static String ecServiceHost;
    /**
     * cms服务器IP
     */
    public static String cmsHost;
    /**
     * 前台销售品预览地址URL
     */
    public static String cmsProductsTestUrl;
    /**
     * 前台预览地址URL
     */
    public static String cmsProductsUrl;
    /**
     * 码上天翼访问地址
     */
    public static String maProductsUrl;
    /**
     * ios/安卓访问地址
     */
    public static String iosProductsUrl;
    /**
     * CMS销售品发布地址
     */
    public static String cmsHtmlSave;
    /**
     * CMS销售品上架地址
     */
    public static String cmsHtmlOn;
    /**
     * CMS销售品下架地址
     */
    public static String cmsHtmlOff;
    /**
     * 新的底层接口服务器IP
     */
    public static String bllwebNewHost;
    /**
     * 0元购机-差额购-底层接口服务器IP
     */
    public static String bllwebUnfreezeIp;
    /**
     * 销售品上下架
     */
    public static String bllwebGoods;
 	/**
 	 * 销售品上下架的时候，是否需要同步到自营流量包数据库
 	 */
 	public static boolean dev4llbzyFlag;
    /**
     * 底层接口服务器计费域IP
     */
    public static String bllwebAccmanageIp;
    /**
     * 底层接口服务器充值相关IP
     */
    public static String bllwebRechargeIp;
    /**
     * 验证号码
     */
    public static String bllwebIcMaterial;
    /**
     * 卡密充值
     */
    public static String bllwebByrechargecard;
    /**
     * 宝宝购机轮播图刷新缓存
     */
    public static String bllwebPictureZp;
    /**
     * 查询自电商编码路径
     */
    public static String  bllwebRefereecode;
    /**
     * 查询自电商编码服务器地址
     */
    public static String  bllwebRefereecodePath;
    /**
     * 查询用户id路径
     */
    public static String   bllwebUserid;
    /**
     * 查询用户id服务器地址
     */
    public static String  bllwebUseridPath;
    
	/**
	 * 同步异网充值销售品信息、同步异网充值活动策略
	 */
	public static String bllwebDiffNetsRechargeIp;
	public static String bllwebDiffNetsRechargeGoods;
	public static String bllwebDiffNetsRechargeStrategy;
	/**
	 * 同步省份上下架信息
	 */
	public static String bllwebShelveProvConf;
	/**
	 * 618拍卖策略获取最终销售品价格
	 */
    public static String bllwebPaimaiHost;
    public static String bllwebPaimaiUri;
	/**
	 * 查询号码状态
	 */
	public static String bllwebNumStatusIp;
	public static String bllwebNumStatusActiveTime;
	
    /**
     * 客户唯一标识
     */
    public static String amapKey;
    /**
     * 数据表唯一标识
     */
    public static String amapTableid;
    /**
     * 高德-接口地址
     */
    public static String amapHost;
    /**
     * 高德-创建单条数据
     */
    public static String amapDataCreate;
    /**
     * 高德-更新一条数据
     */
    public static String amapDataUpdate;
    /**
     * 高德-删除数据（单条/批量）
     */
    public static String amapDataDelete;
	
	/* -----------------------------------
	 *        清结算管理
	 ----------------------------------- */
    /**
     * 团购秒杀链接地址
     */
    public static String marketingUrl;
    /**
     * 页面分页每页条数
     */
    public static int pageSize;


    /* -----------------------------------
     *        系统配置
     ----------------------------------- */
    /* -----------------------------------
     *        执行 sql load 配置
     ----------------------------------- */
    public static String sqlldrHost;
    public static int sqlldrPort;
    public static String sqlldrUserName;
    public static String sqlldrPassword;
    public static String sqlldrCmd;
    /* -----------------------------------
     *        执行 sql load (卡密专用)配置
     ----------------------------------- */
    public static String sqlldrHostForCard;
    public static int sqlldrPortForCard;
    public static String sqlldrUserNameForCard;
    public static String sqlldrPasswordForCard;
    public static String sqlldrCmdForCard;
    /* -----------------------------------
     *        执行 sql load (天翼小白专用)配置
     ----------------------------------- */
    public static String sqlldrHostForTyxb;
    public static int sqlldrPortForTyxb;
    public static String sqlldrUserNameForTyxb;
    public static String sqlldrPasswordForTyxb;
    public static String sqlldrCmdForTyxb;
    /* -----------------------------------
     *        前台图片服务器配置
     ----------------------------------- */
    public static String imgSerPath;
    public static String imgSerUrl;
    /* -----------------------------------
     *        方形logo图片服务器地址
     ----------------------------------- */
    public static String imgSerLogoSquarePath;
    /* -----------------------------------
     *        圆形logo图片服务器地址
     ----------------------------------- */
    public static String imgSerLogoCircularPath;
    /* -----------------------------------
     *        前台图片服务器配置--wap端https专用
     ----------------------------------- */
    public static String imgSerPathWap;
    public static String imgSerUrlWap;
    /* -----------------------------------
     *        前台图片服务器配置
     ----------------------------------- */
    public static String zipSerPath;
    public static String zipSerUrl;
    /* -----------------------------------
     *        IMSI配置
     ----------------------------------- */
    public static String imsiHost;
    public static String imsiPort;
    public static String imsiUserName;
    public static String imsiPassword;
    public static String imsiPath;
    /* -----------------------------------
     *        米粉卡同步FTP
     ----------------------------------- */
    public static String miCardFtpHost;
    public static int miCardFtpPort;
    public static String miCardFtpUserName;
    public static String miCardFtpPassword;
    public static String miCardFtpPath;
	/* -----------------------------------
	*        京东卡同步FTP
	----------------------------------- */
	public static String jdCardFtpHost;
	public static int jdCardFtpPort;
	public static String jdCardFtpUserName;
	public static String jdCardFtpPassword;
	public static String jdCardFtpPath;
    /* -----------------------------------
     *        邮件配置
     ----------------------------------- */
    public static String mailFrom;
    public static String batchMailFrom;
    public static String mailPersonal1 = "中国电信网上营业厅";
    public static String mailPersonal2 = "电子渠道管理系统";
    /* -----------------------------------
     *        自电商配置
     ----------------------------------- */
    public static String zdsShareCopyUrl = "http://www.189.cn/dqmh/z.jsp?c=";
    /**
     * 新短信接口的地址
     */
    public static String sendMgsHost;

    /* -----------------------------------
     *        短信发送
     ----------------------------------- */
    public static String sendMgsInterface;
    public static String sendMgsNewInterface;
    public static String sendMgsKey;


    /* -----------------------------------
     *        日志配置
     ----------------------------------- */
    public static boolean operationLogs;

    public static boolean restLogs;
    
    /**
     * 刷新WAP签到缓存
     */
    public static String WaprefreshWapMySignIp;
    public static String refreshWapMySign;
    
    /* -----------------------------------
     *        欢go-apk
     ----------------------------------- */
    public static String apkPath = "/java/download/client/";
    public static String apkUrl = "http://118.85.207.85:9104/client/";
    
    /* -----------------------------------
     *        欢go-apk源包
     ----------------------------------- */
    public static String apkOriginalPath = "/java/download/client/demo/ctclient.apk";
    
    /* -----------------------------------
     *        刷新客户端版本缓存
     ----------------------------------- */
    public static String clientVersionRefreshIp;
    public static String refreshClientVersion;
    
    /* -----------------------------------
     *        刷新微信小程序投票缓存
     ----------------------------------- */
    public static String smallProVoteRefreshIp;
    public static String refreshSmallProVote;
    
}