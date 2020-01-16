package space.nikitin.carrenta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onBackPressed (){
        try {
            Intent intent = new Intent(Maps.this,NewActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng Minsk = new LatLng(53.951240, 27.711197);
        map.addMarker(new MarkerOptions().position(Minsk).title("Carrenta"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Minsk));


    }
}
