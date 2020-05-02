package space.nikitin.carrenta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {
    private static final String TAG = "Contacts";

    private RecyclerView photoRecyclerView;
    private List<Galleryitem> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Contacts.this,NewActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        photoRecyclerView = (RecyclerView) findViewById(R.id.photo_galery_recycler_view);
        photoRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

        new FetchItemTask().execute();
        setupAdapter();

    }
    private void setupAdapter(){
        photoRecyclerView.setAdapter(new PhotoAdapter(mItems));
    }

    private class PhotoHolder extends  RecyclerView.ViewHolder {
        private ImageView itemImageView;
        public PhotoHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = (ImageView) itemView.findViewById(R.id.photo_gallery_image_view);
        }
    }
    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<Galleryitem> mGalleryItems;

        public PhotoAdapter(List<Galleryitem> items){
             mGalleryItems = items;
        }

        @NonNull
        @Override
        public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(Contacts.this);
            View v = inflater.inflate(R.layout.gallery_item, parent, false);
            return new PhotoHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
            Galleryitem galleryitem = mGalleryItems.get(position);
            Picasso.with(Contacts.this).load(galleryitem.getUrl()).into(holder.itemImageView);

        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }
    private class FetchItemTask extends AsyncTask<Void, Void, List<Galleryitem>> {

        @Override
        protected List<Galleryitem> doInBackground(Void... params) {
            return new FlickFetcher().fetchItems();
        }

        @Override
        protected void onPostExecute(List<Galleryitem> items) {
            mItems = items;
            setupAdapter();
        }
    }

    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Contacts.this,NewActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }
}
