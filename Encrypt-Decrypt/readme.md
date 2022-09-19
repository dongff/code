- 对称加密和非对称加密的区别

1、区别：加密一般分为两种，对称加密和非对称加密。对称加密就是加密解密都用同一个秘钥，比如DES、3DES（TripleDES）和AES等。
非对称加密就是加密和解密不是用的同一种秘钥，比如RSA算法、DSA算法、ECC算法、DH算法等。
在非对称加密中，用来加密的秘钥叫公钥，用来解密的秘钥叫私钥。公钥和私钥都是成对生成的，公钥分发给其他人用来加密，私钥用来解密。
2、优缺点：
对称加密：解密速度快，但保密性差。
非对称加密：加密算法保密性好，它消除了最终用户交换密钥的需要。但是加解密速度要远远低于对称加密。

- 目前主流的加密方式有：（对称加密）AES、DES        （非对称加密）RSA、DSA