import com.dream.bean.admin.AdminUser;
import com.dream.bean.admin.ApiManager;
import com.dream.core.common.util.ObjectSerializeUtil;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by edz on 2018/1/23.
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ApiManager apiManager = new ApiManager();
        byte[] bytes = ObjectSerializeUtil.serialize(apiManager);
        apiManager = ObjectSerializeUtil.deserialize(bytes);
        System.out.println(bytes);
    }
}
