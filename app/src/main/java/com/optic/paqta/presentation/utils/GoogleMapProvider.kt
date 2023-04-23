package com.optic.paqta.presentation.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GoogleMapProvider  {
    public lateinit var map: GoogleMap

    private var start: String = ""
    private var end: String = ""

    var poly: Polyline? = null

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }
//
//    fun onMapReady(map: GoogleMap) {
//        this.map = map
//        enableLocation()
//    }
//
//    private fun isLocationPermissionsGranted(context: Context) = ContextCompat.checkSelfPermission(
//        context,
//        Manifest.permission.ACCESS_FINE_LOCATION
//    ) == PackageManager.PERMISSION_GRANTED
//
//    private fun enableLocation(){
//        if(!::map.isInitialized) return
//        if(isLocationPermissionsGranted()){
//            map.isMyLocationEnabled = true
//        }else{
//            requestLocationPermissions()
//        }
//    }
//
//    private fun requestLocationPermissions(context: Context, activity: Activity) {
//        if(ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)){
//            Toast.makeText(context, "ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
//        }else{
//            ActivityCompat.requestPermissions(
//                activity,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//                REQUEST_CODE_LOCATION)
//        }
//    }
//
//    @SuppressLint("MissingPermission")
//    fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray,
//        context: Context
//    ) {
//        when (requestCode) {
//            REQUEST_CODE_LOCATION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                map.isMyLocationEnabled = true
//            } else {
//                Toast.makeText(
//                    context,
//                    "Para acceder a la localización ve a ajustes y acepta los permisos",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            else -> {}
//        }
//    }
//
//    override fun onResumeFragments() {
//        super.onResumeFragments()
//        if(!::map.isInitialized) return
//        if(!isLocationPermissionsGranted()){
//            map.isMyLocationEnabled = true
//            Toast.makeText(
//                this,
//                "Para activar a la localización ve a ajustes y acepta los permisos",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//
//    override fun onMyLocationButtonClick(): Boolean {
//        Toast.makeText(this,"Boton Pulsado", Toast.LENGTH_SHORT).show()
//        return false
//    }
//
//    private fun createRoute() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val call = getRetrofit().create(ApiService::class.java)
//                .getRoute("5b3ce3597851110001cf624801b41d55db1f400aaa0ab7edbf66d1a7", start, end)
//            if (call.isSuccessful) {
//                drawRoute(call.body())
//            } else {
//                Log.i("aris", "KO")
//            }
//        }
//    }
//
//    private fun drawRoute(routeResponse: RouteResponse?) {
//        val polyLineOptions = PolylineOptions()
//        routeResponse?.features?.first()?.geometry?.coordinates?.forEach {
//            polyLineOptions.add(LatLng(it[1], it[0]))
//        }
//        runOnUiThread {
//            poly = map.addPolyline(polyLineOptions)
//        }
//    }
//
//    private fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://api.openrouteservice.org/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }


}