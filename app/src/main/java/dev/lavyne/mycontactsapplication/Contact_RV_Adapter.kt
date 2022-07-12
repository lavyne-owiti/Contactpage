package dev.lavyne.mycontactsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        }

    }

    override fun getItemCount(): Int {
        return  contactList.size

    }
}
class  contactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root){


}