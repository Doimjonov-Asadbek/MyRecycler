package app.test.myrecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Chapter one", "Chapter two", "Chapter three", "Chapter four", "Chapter five", "Chapter six", "Chapter seven")
    private var details = arrayOf("Item one details", "Item two details", "Item three details", "Item four details", "Item five details", "Item six details", "Item seven details")
    private var images = intArrayOf(R.drawable.git, R.drawable.git, R.drawable.git, R.drawable.git, R.drawable.git, R.drawable.git, R.drawable.git)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int){
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    @SuppressLint("InflateParams")
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.list_image)
            itemTitle = itemView.findViewById(R.id.list_title)
            itemDetail = itemView.findViewById(R.id.list_detail)

            itemView.setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(itemView.context)
                val bottomSheetView = LayoutInflater.from(itemView.context).inflate(R.layout.bottom_sheet, null)
                bottomSheetDialog.setContentView(bottomSheetView)
                bottomSheetView.findViewById<ImageView>(R.id.sheet_image).setImageResource(images[adapterPosition])
                bottomSheetView.findViewById<TextView>(R.id.sheet_title).text = titles[adapterPosition]
                bottomSheetView.findViewById<TextView>(R.id.sheet_detail).text = details[adapterPosition]
                bottomSheetDialog.show()

                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "click ${titles[position]}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
