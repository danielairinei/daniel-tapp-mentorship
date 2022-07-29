package com.example.mentorship.features.todolist.bindingadapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.example.mentorship.R
import com.example.mentorship.features.todolist.model.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListAdapter(context: Context, resource: Int, private var toDoList: ArrayList<Task>) :
    ArrayAdapter<Task>(context, resource, toDoList) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val convertViewCopy: View = LayoutInflater.from(context).inflate(R.layout.item_textview, parent, false)
        val checkBox: CheckBox? = convertViewCopy.findViewById(R.id.taskCheckBox)
        val taskText: TextView? = convertViewCopy.findViewById(R.id.taskTV)
        val editBtn: FloatingActionButton? = convertViewCopy.findViewById(R.id.editTaskFAB)
        val editTaskText: EditText? = convertViewCopy.findViewById(R.id.editTaskET)
        taskText?.text = toDoList[position].name
        editTaskText?.setText(taskText?.text.toString(), TextView.BufferType.EDITABLE)

        checkBox?.setOnCheckedChangeListener { _, _ ->
            if (!toDoList[position].isChecked) {
                toDoList[position].isChecked = true
                taskText!!.paintFlags = 0
            }
            if (toDoList[position].isChecked) {
                taskText!!.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                toDoList[position].isChecked = false
            }
        }

        editBtn?.setOnClickListener {
            val taskAfterEdit = modifyTask(taskText, editTaskText, position).toString()
            editBtn.setOnClickListener {
                taskText?.text = taskAfterEdit
                taskText?.visibility = View.VISIBLE
                editTaskText?.visibility = View.INVISIBLE
                this.notifyDataSetChanged()
            }
            //TODO modify
        }

        return convertViewCopy
    }

    private fun modifyTask(taskToModify: TextView?, editText: EditText?, position: Int): CharSequence {
        //TODO: Avoid using "!!"
        editText!!.visibility = View.VISIBLE
        taskToModify!!.visibility = View.INVISIBLE
        toDoList[position].name = editText.text.toString()
        //onUpdateTaskItemListener?.invoke()
        return editText.text
    }
    //TODO: Declare fields at the top of the class (not always the case, but it is here)
    private var onUpdateTaskItemListener: ((id: Int, newName: String, isChecked: Boolean) -> Unit)? = null

    //TODO: Either remove this unused method and make sure you use it if you forgot about the implementation
    fun setOnUpdateTaskItemListener(onUpdateTaskItemListener: ((id: Int, newName: String, isChecked: Boolean) -> Unit)?) {
        this.onUpdateTaskItemListener = onUpdateTaskItemListener
    }

}