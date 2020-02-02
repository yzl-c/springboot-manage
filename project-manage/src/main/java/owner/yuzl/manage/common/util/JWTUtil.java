package owner.yuzl.manage.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.Date;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 12:13
 * @Description：
 */
public class JWTUtil {
    //有效期60分钟
    private static final long EXPIRE_TIME= 60*60*1000;
    //密钥盐
    private static final String TOKEN_SECRET="yzl123";

    /**
     * 签名生成
     * @param user
     * @return
     */
    public static String sign(SysUserPO user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("account", user.getAccount())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;

    }


    /**
     * 签名验证
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
//            System.out.println("issuer: " + jwt.getIssuer());
//            System.out.println("account: " + jwt.getClaim("account").asString());
            System.out.println("过期时间： " + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
