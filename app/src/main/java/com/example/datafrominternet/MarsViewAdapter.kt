import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.datafrominternet.MarsPhotos
import com.example.datafrominternet.R

class MarsViewAdapter(val marsPhotos: List<MarsPhotos>): RecyclerView.Adapter<MarsViewAdapter.ViewHolder>() {

    // Define a TAG for logging
    private val TAG = "MarsViewAdapter"

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.mars_img)
        val textView: TextView = itemView.findViewById(R.id.photos_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder called")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount called. Total items: ${marsPhotos.size}")
        return marsPhotos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder called for position: $position")

        val items = marsPhotos[position]
        holder.textView.text = items.id
        holder.imageView.load(items.imageUrl)
    }

}
