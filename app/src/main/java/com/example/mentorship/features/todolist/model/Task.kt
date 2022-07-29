package com.example.mentorship.features.todolist.model
//TODO: I would suggest expanding data classes declarations to have their fields on a single line each
//      Also, avoid using `var` in data classes. (But this is a comment to keep in mind for the future, no need to go back now to refactor
//      this ListAdapter. The exercise is about views and not interacting with list items, so it can stay like this
data class Task(val id : Int, var name : String, var isChecked : Boolean)