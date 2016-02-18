# 商品

## 1.  商品列表
## qiaoyu
### RESTFul数据接口
#### 搜索商品
| URL        | HTTP           | 功能  |  
| ------------- |-------------| -----|  
| /search/goods/      | GET | 返回商品列表 |

* 请求参数

| 参数名        | 数据类型           | 可需  |   描述 |  
| ------------- |-------------| -----|  ---------|
| cateName | string | 必填 | 分类名称 |
| pageNum | int | 选填 | 当前页，从0开始，默认是0 |
| pageSize | int | 选填 | 分页，默认是10 |

* 返回结果

```
{
    "total":1,
    "data":
        [
            {
                "marketPrice":3299.00,
                "creatorName":"qmbbc",
                "brandList":
                    [
                        {
                            "brandId":1026,
                            "brandNickname":null,
                            "brandName":"爱他美",
                            "brandUrl":null,
                            "brandLogo":null
                        }
                    ],
                "freeShipment":"0",
                "itemNo":"201602171410141",
                "deleteFlag":"0",
                "modifyTime":
                    {
                        "monthValue":2,
                        "hour":14,
                        "minute":49,
                        "second":31,
                        "nano":0,
                        "year":2016,
                        "month":"FEBRUARY",
                        "dayOfMonth":17,
                        "dayOfWeek":"WEDNESDAY",
                        "dayOfYear":48,
                        "chronology":
                            {
                                "calendarType":"iso8601",
                                "id":"ISO"
                            }
                        },
                        "exParamList":
                            [
                                {
                                    "expandparamName":"价格",
                                    "expandparamId":1916,
                                    "expandparamValueName":"0-299",
                                    "expandparamValueId":16658
                                },
                                {
                                    "expandparamName":"网络",
                                    "expandparamId":1917,
                                    "expandparamValueName":"移动4G",
                                    "expandparamValueId":16665
                                },
                                {
                                    "expandparamName":"热点",
                                    "expandparamId":1918,
                                    "expandparamValueName":"三星S6/S6 edge",
                                    "expandparamValueId":16675
                                },
                                {
                                    "expandparamName":"屏幕尺寸",
                                    "expandparamId":1919,
                                    "expandparamValueName":"5.6英寸及以上",
                                    "expandparamValueId":16696
                                },
                                {
                                    "expandparamName":"系统",
                                    "expandparamId":1920,
                                    "expandparamValueName":"安卓（Android）",
                                    "expandparamValueId":16702
                                },
                                {
                                    "expandparamName":"机身颜色",
                                    "expandparamId":1921,
                                    "expandparamValueName":"白色",
                                    "expandparamValueId":16706
                                },
                                {
                                    "expandparamName":"购买方式",
                                    "expandparamId":1922,
                                    "expandparamValueName":"移动合约",
                                    "expandparamValueId":16719
                                }
                            ],
                            "goodCommentPercent":0.92,
                            "goodCommentNum":5098,
                            "addedStatus":"1",
                            "id":6088,
                            "stock":0,
                            "showMobile":"1",
                            "thirdType":"0",
                            "wareList":
                                [
                                    {
                                        "id":12751,"wareId":71,
                                        "warePrice":3199.00,
                                        "wareStock":122
                                    },
                                    {
                                        "id":12752,"wareId":72,
                                        "warePrice":3199.00,
                                        "wareStock":122
                                    },
                                    {
                                        "id":12753,
                                        "wareId":74,
                                        "warePrice":3199.00,
                                        "wareStock":122
                                    }
                                ],
                            "image":"http://img01.ningpai.com/1455689269628.jpg!160",
                            "thirdShopName":"BOSS",
                            "saleCount":0,
                            "costPrice":null,
                            "weight":100.00,
                            "preferPrice":3199.00,
                            "isCustomerDismount":"0",
                            "showList":"1",
                            "createTime":
                                {
                                    "monthValue":2,
                                    "hour":14,
                                    "minute":10,
                                    "second":50,
                                    "nano":0,
                                    "year":2016,
                                    "month":"FEBRUARY",
                                    "dayOfMonth":17,
                                    "dayOfWeek":"WEDNESDAY",
                                    "dayOfYear":48,
                                    "chronology":
                                        {
                                            "calendarType":"iso8601",
                                            "id":"ISO"
                                        }
                                },
                            "thirdShopId":0,
                            "cateId":4035,
                            "brandId":1026,
                            "subtitle":"",
                            "collectionCount":0,
                            "name":"华为 Mate 8 3GB 32GB版 月光银 移动联通电信4G手机 双卡双待(红色自定义版本1)",
                            "auditStatus":"0",
                            "spuId":2224,
                            "typeId":554,
                            "cateList":
                                [
                                    {
                                        "catId":4017,
                                        "catName":"手机、配件",
                                        "catParentId":0
                                    },
                                    {
                                        "catId":4019,
                                        "catName":"手机通讯",
                                        "catParentId":4017
                                    },
                                    {
                                        "catId":4035,
                                        "catName":"手机",
                                        "catParentId":4019
                                    }
                                ],
                            "modifierName":"qmbbc",
                            "imageList":
                                [
                                    {
                                        "goodsImgId":10887,
                                        "imageInName":"http://img01.ningpai.com/1455689269628.jpg!160",
                                        "imageThumName":"http://img01.ningpai.com/1455689269628.jpg!56",
                                        "imageBigName":"http://img01.ningpai.com/1455689269628.jpg!352",
                                        "imageArtworkName":"http://img01.ningpai.com/1455689269628.jpg",
                                        "goodsImgSort":1
                                    },
                                    {
                                        "goodsImgId":10877,
                                        "imageInName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg!160",
                                        "imageThumName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg!56",
                                        "imageBigName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg!352",
                                        "imageArtworkName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg",
                                        "goodsImgSort":0
                                    },
                                    {
                                        "goodsImgId":10883,
                                        "imageInName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg!160",
                                        "imageThumName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg!56",
                                        "imageBigName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg!352",
                                        "imageArtworkName":"http://test.kstore.qianmi.com:80/upload/20160214/1455427894510.jpg",
                                        "goodsImgSort":0
                                    }
                                ]
                            }
                        ],
                        "aggResultMap":null,
                        "queryString":null,
                        "validQueryString":null
                    }

```  
#### 店铺商品搜索
| URL        | HTTP           | 功能  |  
| ------------- |-------------| -----|  
| /:version/search/:shop/goods/      | GET | 返回商品搜索结果 |

* 请求参数  

同商品分类列表

* 返回结果  

同商品分类列表

## 2. 搜索建议词
### 界面原型
![](http://ww3.sinaimg.cn/mw690/44608603gw1eyddla7u60j20k00zkjs3.jpg)
### RESTFul数据接口
#### 建议词提示  
| URL        | HTTP           | 功能  |  
| ------------- |-------------| -----|  
| /:version/suggests/goods/      | GET | 返回建议词列表，支持英文、拼音、汉字提示 |      

* 请求参数

| 参数名        | 数据类型           | 可需  |   描述 |  
| ------------- |-------------| -----|  ---------|  
| q | string | 必填 | 要提示的单词 |
| size | string | 选填 | 候选词的数目，默认为10 |
| format | string | 选填 | 返回数据的格式，支持json、xml，默认json；也可以在HTTP header中指定返回消息格式 |

* 返回结果

```
[
    {
        "key": "alck",
        "doc_count": 32
    },
    {
        "key": "AD运动",
        "doc_count": 8
    },
    {
        "key": "Apple",
        "doc_count": 17
    },
    {
        "key": "ad",
        "doc_count": 8
    },
    {
        "key": "adidas",
        "doc_count": 4
    },
    {
        "key": "air",
        "doc_count": 4
    },
    {
        "key": "atopico",
        "doc_count": 13
    },
    {
        "key": "昂达",
        "doc_count": 4
    },
    {
        "key": "阿迪达斯",
        "doc_count": 4
    },
    {
        "key": "阿根廷",
        "doc_count": 2
    }
]

```  


