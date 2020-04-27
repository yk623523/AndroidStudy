package com.example.androidstudy;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainFragment extends Fragment {
    private TextView mTextView;
    private final static String KEY_NAME = "key_name";
    private final static String KEY_BACKGROUND = "key_background_color";
    private String mName = "";
    private @ColorInt int mBackgroundColor = Color.TRANSPARENT;

    public static MainFragment createInstance(String name, @ColorInt int color){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(KEY_NAME,name);
        args.putInt(KEY_BACKGROUND,color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        // Bundleがセットされていなかった場合はnullになるので、必ずnullチェックを行う
        if (args != null){
            mName = args.getString(KEY_NAME);
            mBackgroundColor = args.getInt(KEY_BACKGROUND,Color.TRANSPARENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    // View生成が完了した後に呼ばれるメソッド
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // fragment_main.xml内のボタンと紐付ける
        mTextView = (TextView)view.findViewById(R.id.tv1);
        // ボタンを押したときの処理
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText() + "!");
            }
        });
        view.setBackgroundColor(mBackgroundColor);
        mTextView.setText(mName);
    }
}
