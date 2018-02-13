package inc.peace.formbuilder.fragment.bottomsheets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import inc.peace.formbuilder.R;
import inc.peace.formbuilder.adapters.FLBotSheetCustomAdapter;

/**
 * Created by Udit on 2/11/2018.
 */

public class FormListBotSheetFragment extends BottomSheetDialogFragment {

    private View fragmentView;
    private ListView bottomSheetOptionListView;
    private Context mContext;
    private FLBotSheetCustomAdapter botSheetCustomAdapter;
    private static String[] options = {"View Form","Edit Form","Delete Form","Add Form Data","View Form Data","Edit Form Data"};
    private static int[] optionsImages = {R.drawable.ic_remove_red_eye_black_24dp,R.drawable.ic_edit_black_24dp,R.drawable.ic_delete_black_24dp,R.drawable.ic_playlist_add_black_24dp,R.drawable.ic_data_usage_black_24dp,R.drawable.ic_adjust_black_24dp};

    public FormListBotSheetFragment() {
        //Required Empty Constructor
        Log.d("FB","FormListBotSheetFragment");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FB","FormListBotSheetFragment--onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_flbottomsheet,container,false);
        Log.d("FB","FormListBotSheetFragment--onCreateView");
        if(fragmentView != null){
            bottomSheetOptionListView = (ListView) fragmentView.findViewById(R.id.fl_bottomsheetlist);
            Log.d("FB","FormListBotSheetFragment--view init");
            setAdapterForBotSheetList();
        }
        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void setAdapterForBotSheetList(){
        mContext = getActivity();
        if(bottomSheetOptionListView != null){
            botSheetCustomAdapter = new FLBotSheetCustomAdapter(mContext,options,optionsImages);
            Log.d("FB","FormListBotSheetFragment--setAdapterForBotSheetList");
            bottomSheetOptionListView.setAdapter(botSheetCustomAdapter);
        }
    }
}
