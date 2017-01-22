package com.tutorials.hp.recyclercontextmenu;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oclemmy on 3/29/2016 for ProgrammingWizards Channel.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnCreateContextMenuListener{

    ImageView img;
    TextView nameTxt;
    LongClickListener longClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img= (ImageView) itemView.findViewById(R.id.movieImage);

        itemView.setOnLongClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void setLongClickListener(LongClickListener lc)
    {
        this.longClickListener=lc;
    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onItemLongClick(getLayoutPosition());
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select Action");
        menu.add(0, 0, 0, "Share");
        menu.add(0,1,0,"Rate");
        menu.add(0,2,0,"Watch");
    }
}
