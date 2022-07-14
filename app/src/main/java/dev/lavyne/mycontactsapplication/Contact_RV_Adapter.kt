package dev.lavyne.mycontactsapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.lavyne.mycontactsapplication.databinding.ContactListItemBinding

class Contact_RV_Adapter(var contactList:List<Contact>):RecyclerView.Adapter<contactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        var binding=ContactListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
            return contactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        val context= holder.itemView.context
//        var contactBinding=holder.binding
//        contactBinding.tvName.text=currentContact.name
//        contactBinding.tvPhoneNUmber.text=currentContact.phone
//        contactBinding.tvEmail.text=currentContact.email
//        contactBinding.tvAddress.text=currentContact.address
//        or
        with(holder.binding){
            tvName.text=currentContact.name
            tvPhoneNUmber.text=currentContact.phone
            tvEmail.text=currentContact.email
            tvAddress.text=currentContact.address
            Picasso.get()
                .load(currentContact.image)
                .resize(300,300)
                .centerCrop()
//                    IF THERE IS AN ERROR
//                .placeholder(R.drawable.ic_round_person_24)
//                .error(R.drawable.ic_baseline_error_outline_24)
                .into(holder.binding.imgContact)
            cvContact.setOnClickListener {
                val intent=Intent(context,ViewContactActivity::class.java)
                intent.putExtra("NAME",currentContact.name)
                intent.putExtra("PHONE_NUMBER",currentContact.phone)
                intent.putExtra("ADDRESS",currentContact.address)
                intent.putExtra("EMAIL",currentContact.email)
                intent.putExtra("IMAGE", currentContact.image)
                context.startActivity(intent)
            }
            imgContact.setOnClickListener {
//                val intent= Intent(context,ViewContactActivity::class.java)
//                intent.putExtra("IMAGE",currentContact.image)
//                context.startActivity(intent)
                Toast.makeText(context,"You have clicked on you face",Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

    override fun getItemCount(): Int {
        return  contactList.size

    }
}
class  contactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root){


}