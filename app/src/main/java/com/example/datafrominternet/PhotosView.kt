import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datafrominternet.MarsPhotos
import com.example.datafrominternet.MarsViewModel
import com.example.datafrominternet.R
import com.example.datafrominternet.databinding.FragmentPhotosViewBinding
import androidx.fragment.app.activityViewModels




class PhotosView : Fragment() {

    private lateinit var binding: FragmentPhotosViewBinding
    private val viewModel: MarsViewModel by activityViewModels()


    private val TAG = "Photos"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView called")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos_view, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.marsPhoto.observe(viewLifecycleOwner) { photos ->
            if (photos.isNotEmpty()) {
                setupRecyclerView(photos)
            }
        }
    }

    private fun setupRecyclerView(photos: List<MarsPhotos>) {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val marsAdapter = MarsViewAdapter(photos)
        recyclerView.adapter = marsAdapter
    }















    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }







}
