package vip.ericchen.study.designpatterns.structural.proxy.dynamic.jdkproxy;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        try {
            IPerson obj = (IPerson)new JdkMeipo().getInstance(new Zhangsan());
            obj.findLove();

            //通过反编译工具可以查看源代码
            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IPerson.class});
            FileOutputStream os = new FileOutputStream("/Users/ec/study/Notes/01-design-patterns/00-code/note-design-patterns/src/main/java/vip/ericchen/study/designpatterns/structural/proxy/dynamic/jdkproxy/$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        JdkMeipo jdkMeipo = new JdkMeipo();
//        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
//        zhangsan.findLove();
//
//
//        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
//        zhaoliu.findLove();

    }
}
