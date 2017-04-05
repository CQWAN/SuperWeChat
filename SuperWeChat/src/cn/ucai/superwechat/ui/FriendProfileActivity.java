package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.easeui.domain.User;
import com.hyphenate.easeui.utils.EaseUserUtils;
import com.hyphenate.easeui.widget.EaseTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

/**
 * Created by LPP on 2017/4/5.
 */
public class FriendProfileActivity extends BaseActivity {
    @BindView(R.id.title_bar)
    EaseTitleBar titleBar;
    @BindView(R.id.profile_image)
    ImageView profileImage;
    @BindView(R.id.tv_userinfo_nick)
    TextView tvUserinfoNick;
    @BindView(R.id.tv_userinfo_name)
    TextView tvUserinfoName;
    @BindView(R.id.btn_add_contact)
    Button btnAddContact;
    @BindView(R.id.btn_send_msg)
    Button btnSendMsg;
    @BindView(R.id.btn_send_video)
    Button btnSendVideo;
    User user = null;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_friend_profile);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MFGT.finish(FriendProfileActivity.this);
            }
        });
    }

    private void initData() {
        user = (User) getIntent().getSerializableExtra(I.User.TABLE_NAME);
        Log.i("main", user.toString());
        if (user != null) {
            showUserInfo();
        } else {
            MFGT.finish(FriendProfileActivity.this);
        }
    }

    private void showUserInfo() {
        tvUserinfoName.setText(user.getMUserName());
        EaseUserUtils.setAppUserAvatar(FriendProfileActivity.this,user.getMUserName(),profileImage);
//        Glide.with(FriendProfileActivity.this).load(user.getAvatar()).into(profileImage);
        EaseUserUtils.setAppUserNick(user.getMUserName(),tvUserinfoNick);
       /* showFriend(isFriend);*/
    }

    private void showFriend(boolean isFriend) {
        btnAddContact.setVisibility(isFriend?View.GONE:View.VISIBLE);
        btnSendMsg.setVisibility(isFriend?View.VISIBLE:View.GONE);
        btnSendVideo.setVisibility(isFriend?View.VISIBLE:View.GONE);
    }
}