package top.codx.core.exception;
/**
 * @program: fresh-master
 * @description: 生鲜异常处理
 * @author: lch mailto:{yulwins@163.com}
 * @create: 2022-11-30 16:06
 **/
public class TrackRuntimeException extends RuntimeException  {


    private static final long serialVersionUID = 828959048127312471L;

    private String code;



    /**
    *
    * @param msg 异常信息
    */
   public TrackRuntimeException(String msg) {
       super(msg);

   }
    /**
     *
     * @param code 异常编码
     * @param msg 异常信息
     */
    public TrackRuntimeException(String code, String msg) {
        super(msg);
        this.code=code;
    }

    /**
     * @return code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @param code 要设置的 code
     */
    public void setCode(String code)
    {
        this.code = code;
    }


}
