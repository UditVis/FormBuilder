package inc.peace.formbuilder.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import inc.peace.formbuilder.R;

/**
 * Created by Udit on 2/13/2018.
 */

public class FLBotSheetCustomAdapter extends BaseAdapter {

    private Context mContext;
    private int[] optionsImageId;
    private String[] optionsText;
    private static LayoutInflater inflater = null;
    private ItemViewHolder itemViewHolder;



    public FLBotSheetCustomAdapter(Context context,String[] optionsText,int[] optionsImages) {
        this.mContext = context;
        this.optionsText = optionsText;
        this.optionsImageId = optionsImages;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("FB","FLBotSheetCustomAdapter");
    }

    @Override
    public int getCount() {
        return optionsText.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = initViews(view,viewGroup);
        setViewsWithValues(position);
        Log.d("FB","FLBotSheetCustomAdapter->getView" + view);
        view.setOnClickListener(getOnRowItemClickListener(position));
        return view;
    }

    public class ItemViewHolder{
        ImageView optionsImageView;
        TextView optionTextView;
    }

    public View initViews(View view,ViewGroup viewGroup){
        itemViewHolder = new ItemViewHolder();
        view = inflater.inflate(R.layout.layout_formlistbottomsheet_item,viewGroup,false);
        itemViewHolder.optionsImageView = (ImageView) view.findViewById(R.id.formoption_imageview);
        itemViewHolder.optionTextView = view.findViewById(R.id.formoption_textview);
        Log.d("FB","FLBotSheetCustomAdapter->initViews");
        return view;
    }

    public void setViewsWithValues(int position){
        if(itemViewHolder != null){
            itemViewHolder.optionTextView.setText(optionsText[position]);
            itemViewHolder.optionsImageView.setImageResource(optionsImageId[position]);
            Log.d("FB","FLBotSheetCustomAdapter->setViewsWithValues");
        }
    }

    public View.OnClickListener getOnRowItemClickListener(final int position){
        View.OnClickListener rowClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("FB","FLBotSheetCustomAdapter->getOnRowItemClickListener->onClick");
                switch (position){
                    case 0:
                        doThis(position);
                        break;
                    case 1:
                        doThis(position);
                        break;
                    case 2:
                        doThis(position);
                        break;
                    case 3:
                        doThis(position);
                        break;
                    case 4:
                        doThis(position);
                        break;
                    case 5:
                        doThis(position);
                        break;
                    case 6:
                        doThis(position);
                        break;
                }
            }
        };
        return rowClickListener;
    }

    public void doThis(int position){
        Log.d("FB","FLBotSheetCustomAdapter->doThis");
        Toast.makeText(mContext,"Clicked on : " + position,Toast.LENGTH_LONG).show();
    }


}
