package com.projectgoth.migwebviewtest;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by houdangui on 23/6/15.
 */
public class MessageListAdapter extends BaseAdapter {

    private ArrayList<Message> msgDataList = new ArrayList<>();
    private LayoutInflater mInflater;
    private Activity mActivity;
    private MessageViewHolder.WebViewListener listener;

    public MessageListAdapter(Activity activity) {
        super();
        mActivity = activity;
        mInflater = LayoutInflater.from(mActivity);
    }

    public void setWebViewListener(MessageViewHolder.WebViewListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return msgDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return msgDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.holder_message_item, null);
            viewHolder = new MessageViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MessageViewHolder) convertView.getTag();
        }

        Log.d("WebinList", "MessageListAdapter.getView pos:" + position);

        Message msg = (Message)getItem(position);
        viewHolder.setContext(mActivity);
        viewHolder.setData(msg);
        viewHolder.setWebViewListener(listener);

        return convertView;
    }

    public void setMsgDataList(ArrayList<Message> msgDataList) {
        this.msgDataList = msgDataList;
    }

}
