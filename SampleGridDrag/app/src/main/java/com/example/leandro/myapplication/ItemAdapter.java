package com.example.leandro.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.ldelaygue.gridviewdinamic_draganddrop.classes.SpanVariableGridView;

import java.util.List;


public class ItemAdapter extends ArrayAdapter<Item> implements SpanVariableGridView.CalculateChildrenPosition {

	private final class ItemViewHolder {

		public TextView itemTitle;
		public TextView itemDescription;
		public TextView itemDescription2;
		public TextView itemDescription3;
		public ImageView itemIcon;

	}

	private Context mContext;
	private LayoutInflater mLayoutInflater = null;

	private View.OnClickListener onRemoveItemListener = new View.OnClickListener() {

		@Override
		public void onClick(View view) {

			Integer position = (Integer) view.getTag();
			removeItem(getItem(position));

		}
	};

	public void insertItem(Item item, int where) {

		if (where < 0 || where > (getCount() - 1)) {

			return;
		}

		insert(item, where);
	}

	public boolean removeItem(Item item) {

		remove(item);

		return true;
	}

	public ItemAdapter(Context context, List<Item> plugins) {

		super(context, R.layout.item, plugins);

		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final ItemViewHolder itemViewHolder;

		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.item, parent, false);

			itemViewHolder = new ItemViewHolder();
			itemViewHolder.itemTitle = (TextView) convertView.findViewById(R.id.tVTitle);
			itemViewHolder.itemDescription = (TextView) convertView.findViewById(R.id.itemDescription);
			itemViewHolder.itemDescription2 = (TextView) convertView.findViewById(R.id.itemDescription2);
			itemViewHolder.itemDescription3 = (TextView) convertView.findViewById(R.id.itemDescription3);
			//itemViewHolder.itemIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
			convertView.setTag(itemViewHolder);

		} else {

			itemViewHolder = (ItemViewHolder) convertView.getTag();
		}

		final Item item = getItem(position);

		SpanVariableGridView.LayoutParams lp = new SpanVariableGridView.LayoutParams(convertView.getLayoutParams());
		lp.span = item.getSpans();
		convertView.setLayoutParams(lp);

		itemViewHolder.itemTitle.setText(item.getTitle());
		itemViewHolder.itemDescription.setText(item.getDescription());
		itemViewHolder.itemDescription2.setText(item.getmDescription2());
		itemViewHolder.itemDescription3.setText(item.getmDescription3());
		//itemViewHolder.itemIcon.setImageResource(item.getIcon());

		return convertView;
	}

	@Override
	public void onCalculatePosition(View view, int position, int row, int column) {

	}
}
