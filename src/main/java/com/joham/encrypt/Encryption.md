#加密工具类

##BASE64
按照RFC2045的定义，Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式。（The Base64 Content-Transfer-Encoding is designed to represent arbitrary sequences of octets in a form that need not be humanly readable.）
常见于邮件、http加密，截取http信息，你就会发现登录操作的用户名、密码字段通过BASE64加密的。

##MD5加密
MD5 -- message-digest algorithm 5 （信息-摘要算法）缩写，广泛用于加密和解密技术，常用于文件校验。校验？不管文件多大，经过MD5后都能生成唯一的MD5值。

##SHA加密
SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD5通过碰撞法都被破解了， 但是SHA仍然是公认的安全加密算法，较之MD5更为安全。

##HMAC
HMAC(Hash Message Authentication Code，散列消息鉴别码，基于密钥的Hash算法的认证协议。消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。使用一个密钥生成一个固定大小的小数据块，即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的密钥进行鉴别认证等。

##DES（对称加密算法）
DES-Data Encryption Standard,即数据加密算法。是IBM公司于1975年研究成功并公开发表的。DES算法的入口参数有三个:Key、Data、Mode。其中Key为8个字节共64位,是DES算法的工作密钥;Data也为8个字节64位,是要被加密或被解密的数据;Mode为DES的工作方式,有两种:加密或解密。DES算法把64位的明文输入块变为64位的密文输出块,它所使用的密钥也是64位。

##AES（对称加密算法）
AES（The Advanced Encryption Standard）是美国国家标准与技术研究所用于加密电子数据的规范。AES 是一个新的可以用于保护电子数据的加密算法。明确地说，AES 是一个迭代的、对称密钥分组的密码，它可以使用128、192 和 256 位密钥，并且用 128 位（16字节）分组加密和解密数据。与公共密钥密码使用密钥对不同，对称密钥密码使用相同的密钥加密和解密数据。通过分组密码返回的加密数据 的位数与输入数据相同。迭代加密使用一个循环结构，在该循环中重复置换（permutations ）和替换(substitutions）输入数据。Figure 1 显示了 AES 用192位密钥对一个16位字节数据块进行加密和解密的情形。

##RSA（非对称加密算法）
这种算法1978年就出现了，它是第一个既能用于数据加密也能用于数字签名的算法。它易于理解和操作，也很流行。算法的名字以发明者的名字命名：Ron Rivest, AdiShamir 和Leonard Adleman。这种加密算法的特点主要是密钥的变化，上文我们看到DES只有一个密钥。相当于只有一把钥匙，如果这把钥匙丢了，数据也就不安全了。RSA同时有两把钥匙，公钥与私钥。同时支持数字签名。数字签名的意义在于，对传输过来的数据进行校验。确保数据在传输工程中不被修改。

##DH（非对称加密算法）
Diffie-Hellman算法(D-H算法)，密钥一致协议。是由公开密钥密码体制的奠基人Diffie和Hellman所提出的一种思想。简单的说就是允许两名用户在公开媒体上交换信息以生成"一致"的、可以共享的密钥。换句话说，就是由甲方产出一对密钥（公钥、私钥），乙方依照甲方公钥产生乙方密钥对（公钥、私钥）。以此为基线，作为数据传输保密基础，同时双方使用同一种对称加密算法构建本地密钥（SecretKey）对数据加密。这样，在互通了本地密钥（SecretKey）算法后，甲乙双方公开自己的公钥，使用对方的公钥和刚才产生的私钥加密数据，同时可以使用对方的公钥和自己的私钥对数据解密。不单单是甲乙双方两方，可以扩展为多方共享数据通讯，这样就完成了网络交互数据的安全通讯！该算法源于中国的同余定理——中国馀数定理。

##keystore证书加密
1.生成keyStroe文件
在命令行下执行以下命令：
Shell代码  收藏代码
keytool -genkey -validity 36000 -alias www.zlex.org -keyalg RSA -keystore d:\zlex.keystore


其中
-genkey表示生成密钥
-validity指定证书有效期，这里是36000天
-alias指定别名，这里是www.zlex.org
-keyalg指定算法，这里是RSA
-keystore指定存储位置，这里是d:\zlex.keystore

在这里我使用的密码为 123456

控制台输出：
Console代码  收藏代码
输入keystore密码：
再次输入新密码:
您的名字与姓氏是什么？
  [Unknown]：  www.zlex.org
您的组织单位名称是什么？
  [Unknown]：  zlex
您的组织名称是什么？
  [Unknown]：  zlex
您所在的城市或区域名称是什么？
  [Unknown]：  BJ
您所在的州或省份名称是什么？
  [Unknown]：  BJ
该单位的两字母国家代码是什么
  [Unknown]：  CN
CN=www.zlex.org, OU=zlex, O=zlex, L=BJ, ST=BJ, C=CN 正确吗？
  [否]：  Y

输入<tomcat>的主密码
        （如果和 keystore 密码相同，按回车）：
再次输入新密码:

这时，在D盘下会生成一个zlex.keystore的文件。

2.生成自签名证书
光有keyStore文件是不够的，还需要证书文件，证书才是直接提供给外界使用的公钥凭证。
导出证书：
Shell代码  收藏代码
keytool -export -keystore d:\zlex.keystore -alias www.zlex.org -file d:\zlex.cer -rfc


其中
-export指定为导出操作
-keystore指定keystore文件
-alias指定导出keystore文件中的别名
-file指向导出路径
-rfc以文本格式输出，也就是以BASE64编码输出
这里的密码是 123456

控制台输出：
Console代码  收藏代码
输入keystore密码：
保存在文件中的认证 <d:\zlex.cer>


当然，使用方是需要导入证书的！
可以通过自签名证书完成CAS单点登录系统的构建！