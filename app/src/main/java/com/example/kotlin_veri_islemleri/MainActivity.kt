package com.example.kotlin_veri_islemleri

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin_veri_islemleri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*yorum*/
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)


        sharedPref = this.getSharedPreferences("com.example.kotlin_veri_islemleri", Context.MODE_PRIVATE)

        val kullanici_yas_Pref = sharedPref.getInt("yasimkey",-1) //default değer döndür yoksa

        if (kullanici_yas_Pref == -1){
            binding.textView.text ="Yaşiniz : "
        }
        else{
            binding.textView.text ="Yaşınız : ${kullanici_yas_Pref}"
        }

        println("aaaaaaaaaaa")
        println("bbbbbbbbbb")

    }

    // SharedPreferences - XML - Key- Value
    // xml dosyasında küçük veriler ramde kaydedilir.

    fun kaydet(view : View){

        val yasim = binding.editText.text.toString().toIntOrNull()

        if (yasim != null){
            binding.textView.text ="Yaşınız : ${yasim}"
            sharedPref.edit().putInt("yasimkey", yasim).apply() //key'e al ve kaydet
        }

    }

    fun silmek(view: View){

        val kullanici_yas_Pref = sharedPref.getInt("yasimkey",-1)
        if (kullanici_yas_Pref != -1){
            sharedPref.edit().remove("yasimkey").apply()
            binding.textView.text = "Yaşınız : "

        }
    }

}