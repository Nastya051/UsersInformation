package com.example.usersinfo.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.usersinfo.R
import com.example.usersinfo.databinding.FragmentCurrentUserBinding

class CurrentUserFragment : Fragment() {
    lateinit var binding: FragmentCurrentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrentUserBinding.inflate(inflater, container, false)

        val info = CurrentUserFragmentArgs.fromBundle(requireArguments()).userInfo
        binding.apply {
            val glideUrl = GlideUrl(
                info.photo, LazyHeaders.Builder()
                    .build()
            )
            Glide.with(requireContext()).load(glideUrl).into(imageView2)
            textViewGender.text = "${resources.getString(R.string.gender)} ${info.gender}"
            textViewTitle.text = "${resources.getString(R.string.title)} ${info.title}"
            textViewFirst.text = "${resources.getString(R.string.first)} ${info.firstName}"
            textViewLast.text = "${resources.getString(R.string.last)} ${info.lastName}"
            textViewStreetNum.text = "${resources.getString(R.string.numberStr)} ${info.streetNumber}"
            textViewStreetName.text = "${resources.getString(R.string.nameStr)} ${info.streetName}"
            textViewCity.text = "${resources.getString(R.string.city)} ${info.city}"
            textViewState.text = "${resources.getString(R.string.state)} ${info.state}"
            textViewCountry.text = "${resources.getString(R.string.country)} ${info.country}"
            textViewPostcode.text = "${resources.getString(R.string.postcode)} ${info.postcode}"
            textViewLatitude.text = "${resources.getString(R.string.latitude)} ${info.latitude}"
            textViewLongitude.text = "${resources.getString(R.string.longitude)} ${info.longitude}"
            textViewOffset.text = "${resources.getString(R.string.offset)} ${info.offset}"
            textViewDescription.text = "${resources.getString(R.string.description)} ${info.description}"
            textViewEmail.text = "${resources.getString(R.string.email)} ${info.email}"
            textViewUuid.text = "${resources.getString(R.string.uuid)} ${info.uuid}"
            textViewUserName.text = "${resources.getString(R.string.username)} ${info.username}"
            textViewPassword.text = "${resources.getString(R.string.password)} ${info.password}"
            textViewSalt.text = "${resources.getString(R.string.salt)} ${info.salt}"
            textViewmd5.text = "${resources.getString(R.string.md5)} ${info.md5}"
            textViewsh1.text = "${resources.getString(R.string.sha1)} ${info.sha1}"
            textViewsh256.text = "${resources.getString(R.string.sha256)} ${info.sha256}"
            textViewDateBirth.text = "${resources.getString(R.string.dateBirth)} ${info.dateBirth}"
            textViewAgeBirth.text = "${resources.getString(R.string.ageBirth)} ${info.ageBirth}"
            textViewDateRegis.text = "${resources.getString(R.string.dateRegis)} ${info.dateRegis}"
            textViewAgeRegis.text = "${resources.getString(R.string.ageRegis)} ${info.ageRegis}"
            textViewphone.text = "${resources.getString(R.string.phone)} ${info.phone}"
            textViewCell.text = "${resources.getString(R.string.cell)} ${info.cell}"
            textViewIdName.text = "${resources.getString(R.string.idName)} ${info.idName}"
            textViewIdValue.text = "${resources.getString(R.string.idValue)} ${info.idValue}"
            textViewNat.text = "${resources.getString(R.string.nat)} ${info.nat}"
            textViewSeed.text = "${resources.getString(R.string.seed)} ${info.seed}"
            textViewResults.text = "${resources.getString(R.string.results)} ${info.results}"
            textViewPage.text = "${resources.getString(R.string.page)} ${info.page}"
            textViewVersion.text = "${resources.getString(R.string.version)} ${info.version}"
        }
        binding.textViewphone.setOnClickListener {
            val number = binding.textViewphone.text.substring(startIndex = 7)
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        }
        binding.textViewCell.setOnClickListener {
            val number = binding.textViewCell.text.substring(startIndex = 6)
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        }
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, binding.textViewEmail.text.substring(startIndex = 7))
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
            startActivity(Intent.createChooser(intent,
                "Send Email Using: "));
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
    }
}