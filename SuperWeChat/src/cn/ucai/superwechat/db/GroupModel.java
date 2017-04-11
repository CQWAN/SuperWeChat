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
    public void newGroup(Context context, String hxid, String groupName, String des, String owner, boolean isPublic, boolean isInvites, File file, OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_CREATE_GROUP)
                .addParam(I.Group.HX_ID,hxid)
                .addParam(I.Group.NAME,groupName)
                .addParam(I.Group.DESCRIPTION,des)
                .addParam(I.Group.OWNER,owner)
                .addParam(I.Group.IS_PUBLIC,String.valueOf(isPublic))
                .addParam(I.Group.ALLOW_INVITES,String.valueOf(isInvites))
                .addFile2(file)
                .targetClass(String.class)
                .post()
                .execute(listener);
    }

    @Override
    public void addGroupMembers(Context context, String members, String hxId, OnCompleteListener<String> listener) {
        OkHttpUtils<String> okHttpUtils = new OkHttpUtils<>(context);
        okHttpUtils.setRequestUrl(I.REQUEST_ADD_GROUP_MEMBERS)
                .addParam(I.Group.NAME,members)
                .addParam(I.Group.HX_ID,hxId)
                .targetClass(String.class)
                .execute(listener);
    }

    @Override
    public void delGroupMember(Context context, String groupId, String userName, OnCompleteListener<String> listener) {
        OkHttpUtils<String> okHttpUtils = new OkHttpUtils<>(context);
        okHttpUtils.setRequestUrl(I.REQUEST_DELETE_GROUP_MEMBER)
                .addParam(I.Group.GROUP_ID,groupId)
                .addParam(I.Group.NAME,userName)
                .targetClass(String.class)
                .execute(listener);
    }

    @Override
    public void findGroupByHxId(Context context, String hxId, OnCompleteListener<String> listener) {
        OkHttpUtils<String> okHttpUtils = new OkHttpUtils<>(context);
        okHttpUtils.setRequestUrl(I.REQUEST_FIND_GROUP_BY_HXID)
                .addParam(I.Group.HX_ID,hxId)
                .targetClass(String.class)
                .execute(listener);
    }
}
