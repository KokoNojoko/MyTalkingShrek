import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.mytalkingshrek.R

class PetFragment : Fragment() {
    private lateinit var progressViewModel: ProgressViewModel
    private lateinit var petMoodImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_pet, container, false)
        progressViewModel = ViewModelProvider(requireActivity()).get(ProgressViewModel::class.java)
        petMoodImageView = rootView.findViewById(R.id.imgStart1)

        val feedButton: ImageButton = rootView.findViewById(R.id.Food)
        val waterButton: ImageButton = rootView.findViewById(R.id.Drink)
        val washButton: ImageButton = rootView.findViewById(R.id.Wash)

        feedButton.setOnClickListener {
            progressViewModel.updateFoodProgress(10)
            petMoodImageView.setImageResource(R.drawable.shrek_eating)
        }

        waterButton.setOnClickListener {
            progressViewModel.updateThirstProgress(10)
            petMoodImageView.setImageResource(R.drawable.shrek_drinking)

        }

        washButton.setOnClickListener {
            progressViewModel.updateCleanProgress(10)
            petMoodImageView.setImageResource(R.drawable.shrek_bathing)

        }

        return rootView
    }
}
