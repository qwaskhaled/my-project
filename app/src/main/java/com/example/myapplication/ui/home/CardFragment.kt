package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentCardBinding
import com.example.myapplication.model.CardContent

private const val ARG_CARD_DATA = "data"

class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!

    private var cardContent: CardContent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cardContent = it.getParcelable(ARG_CARD_DATA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardContent?.image?.let { resource ->
            binding.ivPoster.setImageResource(resource)
        }

        cardContent?.title?.let { title ->
            binding.tvTitle.text  = title
        }

        cardContent?.subtitle?.let { subtitle ->
            binding.tvSubtitle.text = subtitle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(data: CardContent) = CardFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_CARD_DATA, data)
            }
        }
    }
}