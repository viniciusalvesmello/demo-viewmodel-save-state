package viniciusalvesmello.github.demoviewmodelsavestate


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateVMFactory
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    
    private val viewModel: MainViewModel by lazy {
        activity?.run {
            ViewModelProviders
                .of(this, SavedStateVMFactory(this))
                .get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        
        viewModel.mainData.observe(this, Observer {
            if (it != null && it != getMainData()) {
                etText1.setText(it.firstText)
                etText2.setText(it.secondText)
            }
        })
        
        mbReturnToFirstFragment.setOnClickListener {
            viewModel.updateMainData(getMainData())
            this.findNavController().popBackStack()
        }
        
    }
    
    private fun getMainData() : MainData = MainData(
        firstText = etText1.text.toString(),
        secondText = etText2.text.toString()
    )
    
}
