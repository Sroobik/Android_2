package com.example.android_2.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android_2.R
import com.example.android_2.SecondActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> setName()
            R.id.action_settings -> Toast.makeText(context, "AHAAA", Toast.LENGTH_LONG).show()
            R.id.new_activity -> newActivity()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun newActivity() {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("Data","data")
        startActivity(intent)
    }

    private fun showDialog() {
        val editText: EditText = EditText(context)


        context?.let {
            AlertDialog.Builder(it)
                .setTitle("VYSTRAHA")
                .setMessage("POZOR")
                .setView(editText)
                .show()
        }

    }

    private fun setName() {
        val dialogContentView = View.inflate(context, R.layout.dialog_edit_text, null)
        val editText = dialogContentView.findViewById<EditText>(R.id.editText)
        editText.inputType = InputType.TYPE_CLASS_TEXT

        android.app.AlertDialog.Builder(context)
            .setTitle("Zadaj text")
            .setView(dialogContentView)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                homeViewModel.setName(editText.text.toString())
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
