import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.mytalkingshrek.R

class StatFragment : Fragment() {
    private lateinit var progressViewModel: ProgressViewModel
    private var foodProgressValue = 0
    private var thirstProgressValue = 0
    private var cleanProgressValue = 0

    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.food_status_bar, container, false)
        progressViewModel = ViewModelProvider(requireActivity()).get(ProgressViewModel::class.java)

        val foodProgressBar: ProgressBar = rootView.findViewById(R.id.foodProgressBar)
        val thirstProgressBar: ProgressBar = rootView.findViewById(R.id.thirstProgressBar)
        val cleanProgressBar: ProgressBar = rootView.findViewById(R.id.cleanProgressBar)
        val foodRatingTextView: TextView = rootView.findViewById(R.id.foodRatingTextView)
        val thirstRatingTextView: TextView = rootView.findViewById(R.id.thirstRatingTextView)
        val cleanRatingTextView: TextView = rootView.findViewById(R.id.cleanRatingTextView)



        progressViewModel.foodProgress.observe(viewLifecycleOwner) { newProgress ->
            foodProgressBar.progress = newProgress
            foodRatingTextView.text = "$newProgress%"
        }

        progressViewModel.thirstProgress.observe(viewLifecycleOwner) { newProgress ->
            thirstProgressBar.progress = newProgress
            thirstRatingTextView.text = "$newProgress%"
        }

        progressViewModel.cleanProgress.observe(viewLifecycleOwner) { newProgress ->
            cleanProgressBar.progress = newProgress
            cleanRatingTextView.text = "$newProgress%"
        }

        foodProgressValue = foodProgressBar.progress
        thirstProgressValue = thirstProgressBar.progress
        cleanProgressValue = cleanProgressBar.progress

        handler.postDelayed(progressUpdater, 2000)

        return rootView
    }

    private val progressUpdater = object : Runnable {
        override fun run() {
            if (foodProgressValue > 0) {
                foodProgressValue -= 1
                progressViewModel.updateFoodProgress(-1)
            }

            if (thirstProgressValue > 0) {
                thirstProgressValue -= 1
                progressViewModel.updateThirstProgress(-1)
            }

            if (cleanProgressValue > 0) {
                cleanProgressValue -= 1
                progressViewModel.updateCleanProgress(-1)
            }

            handler.postDelayed(this, 2000) // Run again after 2 seconds

        }
    }
}
