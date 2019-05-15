package com.maggie.implicitintentandsharecontet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mShowImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowImage = findViewById(R.id.showImg);

        //在其他app按分享時可以看到自己的app 並將檔案分享到自己的app上
        if (getIntent() != null && getIntent().getExtras() != null) {
            String uri = getIntent().getExtras().get(Intent.EXTRA_STREAM).toString();
            mShowImage.setImageURI(Uri.parse(uri));
        }

    }

    public void impicit(View view) {
        Intent in=new Intent();
        in.setAction("sendMsg");
        //get res/values/strings
        in.putExtra("msg",getResources().getString(R.string.share_content));
        startActivity(in);
    }


    public void share(View view) {
        Intent in=new Intent();
        //setAction可以直接寫在new Intent()中，不用拉出來寫，如上面作法
        in.setAction(Intent.ACTION_SEND);
        //EXTRA_TEXT:A constant CharSequence that is associated with the Intent, used with ACTION_SEND to supply the literal data to be sent.
        //可以查android developer:Standard Extra Data
        //These are the current standard fields that can be used as extra data via putExtra(String, Bundle).
        in.putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.share_content));
        in.setType("text/plain");
        startActivity(in);
    }
}
