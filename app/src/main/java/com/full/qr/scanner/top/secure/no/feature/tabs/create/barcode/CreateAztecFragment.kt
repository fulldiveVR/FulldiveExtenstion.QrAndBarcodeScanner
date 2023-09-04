package com.full.qr.scanner.top.secure.no.feature.tabs.create.barcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.full.qr.scanner.top.secure.no.R
import com.full.qr.scanner.top.secure.no.extension.isNotBlank
import com.full.qr.scanner.top.secure.no.extension.textString
import com.full.qr.scanner.top.secure.no.feature.common.view.SettingsButton
import com.full.qr.scanner.top.secure.no.feature.tabs.create.BaseCreateBarcodeFragment
import com.full.qr.scanner.top.secure.no.model.schema.Other
import com.full.qr.scanner.top.secure.no.model.schema.Schema

class CreateAztecFragment : BaseCreateBarcodeFragment() {
    private lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_aztec, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentView = view
        fragmentView.findViewById<EditText>(R.id.edit_text)?.let { edit_text ->
            edit_text.requestFocus()
            edit_text.addTextChangedListener {
                parentActivity.isCreateBarcodeButtonEnabled = edit_text.isNotBlank()
            }
        }
    }

    override fun getBarcodeSchema(): Schema {
        return Other(fragmentView.findViewById<EditText>(R.id.edit_text).textString)
    }
}