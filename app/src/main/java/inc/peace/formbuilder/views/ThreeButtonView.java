package inc.peace.formbuilder.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import inc.peace.formbuilder.R;

/**
 * Created by Udit on 2/5/2018.
 */

public class ThreeButtonView extends LinearLayout {
    View rootView;
    Button addBtn;
    Button resetBtn;
    Button cancelBtn;

    public ThreeButtonView(Context context){
        super(context);
        init(context);
    }

    public ThreeButtonView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context);
    }

    public void init(Context context) {
        rootView = inflate(context, R.layout.layout_three_button_view, this);
        addBtn = (Button) rootView.findViewById(R.id.add_field_btn);
        resetBtn = (Button) rootView.findViewById(R.id.reset_field_btn);
        cancelBtn = (Button) rootView.findViewById(R.id.cancel_field_btn);
    }

    public Button getAddBtn(){
        return addBtn;
    }
    public Button getResetBtn(){
        return resetBtn;
    }
    public Button getCancelBtn(){
        return cancelBtn;
    }

    public void setAddBtnListener(OnClickListener onClickListener){
        addBtn.setOnClickListener(onClickListener);
    }
    public void setResetBtnListener(OnClickListener onClickListener){
        resetBtn.setOnClickListener(onClickListener);
    }
    public void setCancelBtn(OnClickListener onClickListener){
        cancelBtn.setOnClickListener(onClickListener);
    }

}
