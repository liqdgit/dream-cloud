package com.dream.core.common.util;

import java.io.*;

/**
 * <p>Title:      ObjectSerializeUtil. </p>
 * <p>Description 对象序列化 </p>
 * <p>Company:    李清栋 </p>
 *
 * @author         <a href="liqingdong"/>李清栋</a>
 * @CreateDate     2017/9/29 10:56
 */
public class ObjectSerializeUtil {

	/**
	 * <p>Title:      对象序列化. </p>
	 * <p>Description </p>
	 *
	 * @param
	 * @Author        <a href="liqingdong"/>李清栋</a>
	 * @CreateDate    2017/9/29 10:57
	 * @return
	 */
	public static <T extends Serializable> byte[] serialize(T value) throws IOException {
		if(value == null) {
			throw new NullPointerException("Can't serialize null");
		}
		ByteArrayOutputStream byteOutPut = new ByteArrayOutputStream();
		ObjectOutputStream objOutPut = new ObjectOutputStream(byteOutPut);

		objOutPut.writeObject(value);
		byteOutPut.close();
		objOutPut.close();

		byte[] result = byteOutPut.toByteArray();
		return result;
	}

		/**
		 * <p>Title:      反序列化. </p>
		 * <p>Description </p>
		 *
		 * @param
		 * @Author        <a href="liqingdong"/>李清栋</a>
		 * @CreateDate    2017/9/29 10:58
		 * @return
		 */
	public static <T extends Serializable> T deserialize(byte[] values) throws IOException, ClassNotFoundException {
		if(values == null) {
			throw new NullPointerException("Can't serialize null");
		}
		
		ByteArrayInputStream byteInput = new ByteArrayInputStream(values);
		ObjectInputStream objInput = new ObjectInputStream(byteInput);

		T t = (T)objInput.readObject();

		byteInput.close();
		objInput.close();
		return t;
	}

}
