package com.sean.usmbooksearch.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.sean.usmbooksearch.R;
import com.sean.usmbooksearch.model.BookInfo;
import com.sean.usmbooksearch.ui.BookListActivity;

import java.util.List;

public class BookAdapterHolder extends RecyclerView.Adapter<BookAdapterHolder.ViewHolder> {

    private final List<BookInfo> bookInfoList;
    OnItemClickListener mItemClickListener;

    public BookAdapterHolder(BookListActivity mActivity, List<BookInfo> bookInfoList){
        this.bookInfoList = bookInfoList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_book_row, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        holder.bookIsbn.setText(bookInfoList.get(position).getISBN());
        holder.bookTitle.setText(bookInfoList.get(position).getTitle());
        holder.bookUSMNewPrice.setText(bookInfoList.get(position).getUsmNewPrice());
        holder.bookUSMUsedPrice.setText(bookInfoList.get(position).getUsmUsedPrice());
        holder.amzNewPrice.setText(bookInfoList.get(position).getAmazonNewPrice());
        holder.amzUsedPrice.setText(bookInfoList.get(position).getAmazonUsedPrice());
        String authors = bookInfoList.get(position).getAuthors();
        holder.bookAuthor.setText(authors);

            if (bookInfoList.get(position).getThumbNailURL() != null){
                UrlImageViewHelper.setUrlDrawable(holder.bookThumbnail, bookInfoList.get(position).getThumbNailURL());

            } else{
                holder.bookThumbnail.setImageResource(R.drawable.no_image_available);
            }


    }

    @Override
    public int getItemCount() {
        return bookInfoList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView bookTitle;
        final TextView bookAuthor;
        final TextView bookIsbn;
        final TextView bookUSMUsedPrice;
        final TextView bookUSMNewPrice;
        final TextView amzNewPrice;
        final TextView amzUsedPrice;
        final ImageView bookThumbnail;

        public ViewHolder(View view) {
            super(view);
            bookTitle = (TextView) view.findViewById(R.id.book_title);
            bookAuthor = (TextView) view.findViewById(R.id.book_author);
            bookIsbn = (TextView) view.findViewById(R.id.book_isbn);
            bookUSMNewPrice = (TextView) view.findViewById(R.id.usm_new_price);
            bookUSMUsedPrice = (TextView) view.findViewById(R.id.usm_used_price);
            amzNewPrice = (TextView) view.findViewById(R.id.amz_new_price);
            amzUsedPrice = (TextView) view.findViewById(R.id.amz_used_price);
            bookThumbnail = (ImageView) view.findViewById(R.id.book_thumbnail);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null){
                int i = getPosition();
                String browserURL;
                if (bookInfoList.get(i).getAffiliateLinkURL() != null){
                    browserURL = bookInfoList.get(i).getAffiliateLinkURL();
                }else{
                    browserURL = "https://www.google.com/search?q=" + bookInfoList.get(i).getISBN();
                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(browserURL));
                v.getContext().startActivity(browserIntent);
            }
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
