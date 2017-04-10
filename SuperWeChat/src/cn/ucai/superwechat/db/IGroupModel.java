package cn.ucai.superwechat.db;

import android.content.Context;

import java.io.File;

/**
 * Created by LPP on 2017/4/10.
 */

public interface IGroupModel {
    // 创建群组
    public void createGroup(Context context, String hxId, String groupName, String description,
                            String owner, boolean isPublic, boolean isAllowInvites,File file,
                            OnCompleteListener<String> listener);
}
