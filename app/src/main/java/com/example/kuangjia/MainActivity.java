package com.example.kuangjia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.base.BaseFragment;
import com.example.fragment.CommunityFragment;
import com.example.fragment.LaorenFragment;
import com.example.fragment.MessageFragment;
import com.example.fragment.PersonFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private   RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragment;
    private int position;

    private Fragment mFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        radioGroup=(RadioGroup)findViewById(R.id.rg_main);
//        radioGroup.check(R.id.rb_home);
        initView();

        initFragment();

        setListener();
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

        radioGroup.check(R.id.rb_home);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId){
                case R.id.rb_home:
                    position=0;
                    break;
                case R.id.rb_community:
                    position=1;
                    break;
                case R.id.rb_message:
                    position=2;
                    break;
                case R.id.rb_person:
                    position=3;
                    break;
                    default:
                        position=0;
                        break;
            }

            BaseFragment to=getFragment();

            switchFragment(mFrom,to);
        }
    }

    /**
     *
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to  马上要切换到的Fragment,一会要显示
     */

    private void switchFragment(Fragment from,Fragment to){
        if(from!=to){
            mFrom=to;
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

            if(!to.isAdded()){
                if(from!=null){
                    ft.hide(from);
                }
                if(to!=null){
                    ft.add(R.id.fl_content,to).commit();
                }
            }else {
                if(from!=null){
                    ft.hide(from);
                }
                if(to!=null){
                    ft.show(to).commit();
                }
            }
        }
    }

    private BaseFragment getFragment() {
        BaseFragment fragment=mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment=new ArrayList<>();
        mBaseFragment.add(new LaorenFragment());
        mBaseFragment.add(new CommunityFragment());
        mBaseFragment.add(new MessageFragment());
        mBaseFragment.add(new PersonFragment());

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.rg_main);
    }
}
