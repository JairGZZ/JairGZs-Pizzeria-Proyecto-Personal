package com.jair.jairgzspizzeria.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jair.jairgzspizzeria.R
import com.jair.jairgzspizzeria.adapter.PizzaAdapter
import com.jair.jairgzspizzeria.databinding.FragmentHomeBinding
import com.jair.jairgzspizzeria.model.PizzaModel
import java.time.LocalDateTime

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Configuración del RecyclerView
        binding.recyclerPizza.layoutManager = LinearLayoutManager(requireContext())

        // Observa el LiveData del ViewModel y actualiza el RecyclerView cuando cambien los datos
        homeViewModel.pizzaList.observe(viewLifecycleOwner) { pizzaList ->
            val adapter = PizzaAdapter(pizzaList)
            binding.recyclerPizza.adapter = adapter
        }

        val floating = binding.floating
        floating.setOnClickListener {
            registerUpdateNote(null)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun registerUpdateNote(pizza: PizzaModel?) {
        val mDialogView = LayoutInflater.from(requireContext())
            .inflate(R.layout.crear_pizza, null)
        val titleAlertNote = "Registrar Pizza"


        val mBuilder = AlertDialog.Builder(requireContext())
            .setView(mDialogView)
            .setTitle(titleAlertNote)
        val mAlertDialog = mBuilder.show()

        val edtTitlePizza = mDialogView.findViewById<EditText>(R.id.edtTitlePizza)
        val edtDescription = mDialogView.findViewById<EditText>(R.id.edtDescriptionPizza)
        val btnCreate = mDialogView.findViewById<Button>(R.id.btnCreate)






    }

//        val edtTitleNote = mDialogView.findViewById<EditText>(R.id.edtTitleNote)
//        val edtDescriptionNote = mDialogView.findViewById<EditText>(R.id.edtDescriptionNote)
//        val btnCreate = mDialogView.findViewById<Button>(R.id.btnCreate)
//
//        if (type == TypeOperation.UPDATE) {
//            edtTitleNote.setText(note?.title)
//            edtDescriptionNote.setText(note?.description)
//        }
//
//        btnCreate.setOnClickListener {
//            mAlertDialog.dismiss()
//            val title = edtTitleNote.text.toString()
//            val description = edtDescriptionNote.text.toString()
//            val date = LocalDateTime.now().formatDateTime()
//
//            val noteV = Note(title, description, date)
//
//            if (type == TypeOperation.UPDATE) {
//                noteV.noteId = note!!.noteId
//                noteViewModel.updateNote(noteV)
//            } else {
//                noteViewModel.saveNote(noteV)
//            }
//
//        }

    }
