package com.example.mapdemo;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MyLocationOverlay;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements OnInfoWindowClickListener{

	private LatLng defaultLatLng = new LatLng(39.233956, -77.484703);
	GoogleMap mapView;
	MapFragment mfrag;
	MyLocationOverlay loverlay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mapView = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView))
                 .getMap();
		mfrag = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView));
		
		if(mapView != null)
		{
		mapView.setMyLocationEnabled(true);
		mapView.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		
		mapView.addMarker(new MarkerOptions().position(new LatLng(40.70686417491799,
                -74.01572942733765)).title("MyMarker")
				.snippet("Snippet").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
		
		mapView.getUiSettings().setCompassEnabled(true);
		mapView.setTrafficEnabled(true);
		
		mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLatLng, 7));
		
		//GeoPoint gp = new GeoPoint((int)(52.33*1E6),(int)(4.66*1E6));
		
		PolylineOptions line=
		        new PolylineOptions().add(new LatLng(40.70686417491799,
		                                             -74.01572942733765),
		                                  new LatLng(40.76866299974387,
		                                             -73.98268461227417),
		                                  new LatLng(40.765136435316755,
		                                             -73.97989511489868),
		                                  new LatLng(40.748963847316034,
		                                             -73.96807193756104))
		                             .width(45).color(Color.RED);

		    mapView.addPolyline(line);

		    PolygonOptions area=
		        new PolygonOptions().add(new LatLng(40.748429, -73.984573),
		                                 new LatLng(40.753393, -73.996311),
		                                 new LatLng(40.758393, -73.992705),
		                                 new LatLng(40.753484, -73.980882))
		                            .strokeColor(Color.BLUE);

//mapView.addPolygon(area);
		}				
	}
	@Override
	public void onInfoWindowClick(Marker marker) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "hello ", Toast.LENGTH_LONG).show();
	}
	

	}
