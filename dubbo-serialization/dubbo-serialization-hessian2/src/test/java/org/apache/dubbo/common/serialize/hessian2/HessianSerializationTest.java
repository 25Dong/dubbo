package org.apache.dubbo.common.serialize.hessian2;

import com.alibaba.com.caucho.hessian.io.HessianInput;
import com.alibaba.com.caucho.hessian.io.HessianOutput;
import org.apache.dubbo.common.serialize.hessian2.dubbo.Hessian2FactoryInitializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * @Description: Hessian进行序列化和反序列化
 * @Author: yichengdong
 * @CreateDate: 2023/9/2 23:32
 * @Copyright : 豆浆油条个人非正式工作室
 */
public class HessianSerializationTest {

    public static void main(String[] args) throws IOException {
        // 创建一个示例对象
        Person person = new Person("John", 30);

        // 将对象序列化为字节数组
        byte[] serializedData = serialize(person);
        System.out.println(serializedData.length);

        // 将字节数组反序列化为对象
        Person deserializedPerson = deserialize(serializedData);

        // 打印反序列化后的对象
        System.out.println("Deserialized Person: " + deserializedPerson);
    }

    // 使用Hessian进行序列化
    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput out = new HessianOutput(bos);
        out.setSerializerFactory(Hessian2FactoryInitializer.getInstance().getSerializerFactory());

        out.writeObject(obj);
        out.flush();
        return bos.toByteArray();
    }

    // 使用Hessian进行反序列化
    private static <T> T deserialize(byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        HessianInput in = new HessianInput(bis);
        in.setSerializerFactory(Hessian2FactoryInitializer.getInstance().getSerializerFactory());
        return (T) in.readObject();
    }

    // 示例对象
    static class Person implements Serializable {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
        }
    }
}
