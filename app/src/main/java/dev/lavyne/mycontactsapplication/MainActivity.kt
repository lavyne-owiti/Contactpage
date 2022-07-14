package dev.lavyne.mycontactsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.lavyne.mycontactsapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        displayContacts()
//        val intent=Intent(this@MainActivity,ViewContactActivity::class.java)
//            intent.putExtra("name","phone","image","address")
////            context.startActivity(intent)
    }
    fun displayContacts(){
        var contact =Contact("Lavy","0700045678","la@gmail.com","616 korongo road","https://images.pexels.com/photos/1858175/pexels-photo-1858175.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact1 =Contact("Gesare","0710045678","ges@gmail.com","10 Ngong road","https://images.pexels.com/photos/871495/pexels-photo-871495.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2 =Contact("Jojo","0700045699","joj@gmail.com","61 West","https://images.pexels.com/photos/938013/pexels-photo-938013.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3 =Contact("Shar","0700077678","sha@gmail.com","16 Makadara","https://images.pexels.com/photos/1559086/pexels-photo-1559086.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4 =Contact("Cheko","0702345678","che@gmail.com","22 Lusaka road","https://images.pexels.com/photos/3063910/pexels-photo-3063910.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contactList= listOf(contact,contact1,contact2,contact3,contact4)
         binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=Contact_RV_Adapter(contactList)

    }
}