package com.example.p4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.p4.databinding.FragmentCurrencyBinding


class CurrencyFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyBinding
    private val viewModel: CurrencyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.currencyViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        binding.button.setOnClickListener { resetValues() }

        binding.rialTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.rialTextField.hasFocus()) {
                        viewModel.rialHasChanged(s.toString().toDouble())
                        setErrorFalse()
                    }
                } catch (e: Exception) {
                    setErrorRialTextField(true)
                }
            }
        })


        binding.dollarUSTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.dollarUSTextField.hasFocus()) {
                        val rial = viewModel.dollarUSHasChanged(s.toString().toDouble())
                        viewModel.rialHasChanged(rial)
                        setErrorDollarUSTextField(false)
                    }
                } catch (e: Exception) {
                    setErrorDollarUSTextField(true)
                }
            }
        })

        binding.dollarCanadaTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.dollarCanadaTextField.hasFocus()) {
                        val rial = viewModel.dollarCanadaHasChanged(s.toString().toDouble())
                        viewModel.rialHasChanged(rial)
                        setErrordollarCanadaTextField(false)
                    }
                } catch (e: Exception) {
                    setErrordollarCanadaTextField(true)
                }
            }
        })


        binding.euroTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.euroTextField.hasFocus()) {
                        val rial = viewModel.euroHasChanged(s.toString().toDouble())
                        viewModel.rialHasChanged(rial)
                        setErrorEuroTextField(false)
                    }
                } catch (e: Exception) {
                    setErrorEuroTextField(true)
                }
            }
        })

        binding.poundTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.poundTextField.hasFocus()) {
                        val rial = viewModel.poundHasChanged(s.toString().toDouble())
                        viewModel.rialHasChanged(rial)
                        setErrorPoundTextField(false)
                    }
                } catch (e: Exception) {
                    setErrorPoundTextField(true)
                }
            }
        })


        binding.dirhamTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    if (binding.dirhamTextField.hasFocus()) {
                        val rial = viewModel.dirhamHasChanged(s.toString().toDouble())
                        viewModel.rialHasChanged(rial)
                        setErrorDirhamTextField(false)
                    }
                } catch (e: Exception) {
                    setErrorDirhamTextField(true)
                }
            }
        })


    }


    private fun resetValues() {
        viewModel.reinitializeData()
        setErrorFalse()
    }


    private fun setErrorFalse() {
        setErrorRialTextField(false)
        setErrorDollarUSTextField(false)
        setErrordollarCanadaTextField(false)
        setErrorEuroTextField(false)
        setErrorPoundTextField(false)
        setErrorDirhamTextField(false)
    }

    private fun setErrorRialTextField(error: Boolean) {
        if (error) {
            binding.rial.isErrorEnabled = true
            binding.rial.error = getString(R.string.invalid_input)
        } else {
            binding.rial.isErrorEnabled = false
        }
    }


    private fun setErrorDollarUSTextField(error: Boolean) {
        if (error) {
            binding.dollarUs.isErrorEnabled = true
            binding.dollarUs.error = getString(R.string.invalid_input)
        } else {
            binding.dollarUs.isErrorEnabled = false
        }
    }


    private fun setErrordollarCanadaTextField(error: Boolean) {
        if (error) {
            binding.dollarCanada.isErrorEnabled = true
            binding.dollarCanada.error = getString(R.string.invalid_input)
        } else {
            binding.dollarCanada.isErrorEnabled = false
        }
    }


    private fun setErrorEuroTextField(error: Boolean) {
        if (error) {
            binding.euro.isErrorEnabled = true
            binding.euro.error = getString(R.string.invalid_input)
        } else {
            binding.euro.isErrorEnabled = false
        }
    }

    private fun setErrorPoundTextField(error: Boolean) {
        if (error) {
            binding.pound.isErrorEnabled = true
            binding.pound.error = getString(R.string.invalid_input)
        } else {
            binding.pound.isErrorEnabled = false
        }
    }


    private fun setErrorDirhamTextField(error: Boolean) {
        if (error) {
            binding.dirham.isErrorEnabled = true
            binding.dirham.error = getString(R.string.invalid_input)
        } else {
            binding.dirham.isErrorEnabled = false
        }
    }

}

