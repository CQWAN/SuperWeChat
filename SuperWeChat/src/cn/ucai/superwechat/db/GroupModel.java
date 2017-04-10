package cn.ucai.superwechat.db;

import android.content.Context;

import java.io.File;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.utils.OkHttpUtils;

/**
 * Created by LPP on 2017/4/10.
 */

public class GroupModel implements IGroupModel {

    @Override
    public void createGroup(Context context, String hxId, String groupName, String description, String owner, boolean isPublic, boolean isAllowInvites, File file, OnCompleteListener<String> listener) {
        OkHttpUtils<String> okHttpUtils = new OkHttpUtils<>(context);
        okHttpUtils.setRequestUrl(I.REQUEST_CREATE_GROUP)
                .addParam(I.Group.HX_ID,hxId)
                .addParam(I.Group.NAME,groupName)
                .addParam(I.Group.DESCRIPTION,description)
                .addParam(I.Group.OWNER,owner)
                .addParam(I.Group.IS_PUBLIC,String.valueOf(isPublic))
                .addParam(I.Group.ALLOW_INVITES,String.valueOf(isAllowInvites))
                .addFile2(file)
                .post()
                .targetClass(String.class)
                .execute(listener);
    }
}
