package cn.ucai.superwechat.db;

import android.content.Context;

import java.io.File;

/**
 * Created by LPP on 2017/3/29.
 */

public interface IGroupModel {
    void newGroup(Context context, String hxid, String groupName, String des, String owner, boolean isPublic,
                  boolean isInvites, File file, OnCompleteListener<String> listener);
    void addGroupMembers(Context context,String members,String hxId,OnCompleteListener<String> listener);
    void delGroupMember(Context context,String groupId,String userName,OnCompleteListener<String> listener);
    void findGroupByHxId(Context context,String hxId,OnCompleteListener<String> listener);
    void updateGroupNameByHxId(Context context,String hxId,String newGroupName,OnCompleteListener<String> listener);
    void deleteGroup(Context context,String groupId,OnCompleteListener<String> listener);
}
