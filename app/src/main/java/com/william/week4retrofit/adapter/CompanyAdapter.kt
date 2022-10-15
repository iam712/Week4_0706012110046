package com.william.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.william.week4retrofit.model.ProductionCompany
import com.william.week4retrofit.R
import com.william.week4retrofit.databinding.ListProductionCompanyBinding
import com.william.week4retrofit.helper.Const


class CompanyAdapter(private val dataSet: List<ProductionCompany>) :
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListProductionCompanyBinding.bind(itemView)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_production_company, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        Glide.with(viewHolder.itemView.context)
            .load(Const.IMG_URL + dataSet[position].logo_path)
            .into(viewHolder.binding.imgViewLogo)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}