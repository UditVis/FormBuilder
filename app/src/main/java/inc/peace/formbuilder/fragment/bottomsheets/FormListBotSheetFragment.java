package inc.peace.formbuilder.fragment.bottomsheets;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inc.peace.formbuilder.R;

/**
 * Created by Udit on 2/11/2018.
 */

public class FormListBotSheetFragment extends BottomSheetDialogFragment {
    public FormListBotSheetFragment() {
        //Required Empty Constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flbottomsheet,container,false);
    }
}
