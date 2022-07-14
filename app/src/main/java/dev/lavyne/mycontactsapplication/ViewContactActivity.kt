package dev.lavyne.mycontactsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import dev.lavyne.mycontactsapplication.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras() {
        val extras = intent.extras
        var name = extras?.getString("NAME", "")
        var phone = extras?.getString("PHONE_NUMBER", "")
        var adress = extras?.getString("ADDRESS", "")
        var email=extras?.getString("EMAIL","")
        var image = binding.imgHuman
        Toast.makeText(this, name, Toast.LENGTH_LONG)
        Toast.makeText(this, phone, Toast.LENGTH_LONG)
        Toast.makeText(this, adress, Toast.LENGTH_LONG)
        Toast.makeText(this,email,Toast.LENGTH_LONG)

        binding.tvNames.text=name
        binding.tvLocation.text=adress
        binding.tvPhonenumber.text=phone
        binding.tvemail.text=email
        Picasso.get()
            .load(intent.getStringExtra("IMAGE"))
            .resize(700,700)
            .centerCrop()
            .into(image)

    }

}
