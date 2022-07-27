package com.example.mentorship.features.todolist


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorship.R
import com.example.mentorship.features.todolist.bindingadapters.ListAdapter
import com.example.mentorship.features.todolist.model.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ToDoListActivity : AppCompatActivity() {
    private var toDoList: ArrayList<Task> = arrayListOf()
    private lateinit var taskAdapter : ListAdapter
    private lateinit var listView: ListView
    private var taskIDCounter: Int = 0

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        taskAdapter = ListAdapter(this, R.layout.item_textview, toDoList)
        //arrayAdapter.setOnUpdateTaskItemListener { id, newName, isChecked ->  }
        findViewById<FloatingActionButton>(R.id.addTaskFAB).setOnClickListener {
            addTask()
        }

//        findViewById<ListView>(R.id.taskListView).onItemClickListener =
//            AdapterView.OnItemClickListener { _, view, _, _ ->
//                val text: TextView = view as TextView
//                text.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
//            }
//
//        findViewById<ListView>(R.id.taskListView).onItemLongClickListener =
//            AdapterView.OnItemLongClickListener { _, _, position, _ ->
//                val listItem: Any = listView.getItemAtPosition(position) as Any
//                toDoList.remove(listItem)
//                taskAdapter.notifyDataSetChanged()
//
//                true
//            }
    }

    private fun addTask() {
        val editText: EditText = findViewById(R.id.addTaskET)
        val taskName = editText.text.toString()
        listView = findViewById(R.id.taskListView)
        listView.adapter = taskAdapter
        if (taskName.trim().isEmpty()) {
            Toast.makeText(this, "Please write a task", Toast.LENGTH_LONG).show()
        } else {
            val newTask = Task(taskIDCounter, taskName, false)
            toDoList.add(newTask)
            taskAdapter.notifyDataSetChanged()
            editText.setText("")
        }
    }


}
