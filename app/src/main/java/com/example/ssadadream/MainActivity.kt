package com.example.ssadadream


import android.Manifest
import android.app.Activity
import android.app.DownloadManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.OkHttpClient
import org.json.JSONObject
import okhttp3.RequestBody

var jsonResult = ""
var postResult = ""

class MainActivity : AppCompatActivity() {

    private val PERMISSION_CODE = 1000;
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //BUTTON CLICK
        img_pick_btn.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }

        signup.setOnClickListener {
            //if (username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
            //   makePostRequst(this, username.text.toString(), password.text.toString()).execute()
            val intent = Intent(this, LoginActivity::class.java)
            // start your next activity
            startActivity(intent)
        }




    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            image_view.setImageURI(data?.data)
        }
    }


    class makePostRequst(var activity: MainActivity, var username: String, var password: String) : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String {
            val client = OkHttpClient()
            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", username)
                .addFormDataPart("password", password)
                .build()
            val request = Request.Builder()
                .url("http://192.168.43.212/postlogin.php")
                .post(requestBody)
                .build()
            val response = client.newCall(request).execute()
            return response.body()!!.string()
        }

        override fun onPostExecute(result: String?) {
            if (result != null) {
                val obj = JSONObject(result)
                postResult = obj.getString("message")
                makeJSONRequst(activity, username, password).execute()
            }
            super.onPostExecute(result)
        }

    }

    class makeJSONRequst(var activity: MainActivity, var username: String, var password: String) : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String {
            val JSON = MediaType.parse("application/json; charset=utf-8")
            val client = OkHttpClient()
            val requestObject = com.example.ssadadream.Model.Request()
            requestObject.username = username
            requestObject.password = password
            val body = RequestBody.create(JSON, Gson().toJson(requestObject))
            val request = Request.Builder()
                .url("http://192.168.43.212/login.php")
                .post(body)
                .build()
            val response = client.newCall(request).execute()
            return response.body()!!.string()
        }

        override fun onPostExecute(result: String?) {
            if (result != null) {
                val obj = JSONObject(result)
                jsonResult = obj.getString("message")
            }
            val dialog = AlertDialog.Builder(activity)
            val view = activity.layoutInflater.inflate(R.layout.dialog_result, null)
            dialog.setView(view)
            view.findViewById<TextView>(R.id.json_result).text = jsonResult
            view.findViewById<TextView>(R.id.post_result).text = postResult
            dialog.show()
            super.onPostExecute(result)
        }
    }

}