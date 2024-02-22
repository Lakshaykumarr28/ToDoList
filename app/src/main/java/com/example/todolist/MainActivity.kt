package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btAddTodo = findViewById<Button>(R.id.btAddTodo)

        val etAddItems = findViewById<EditText>(R.id.etAddItems)
        btAddTodo.setOnClickListener {
            val todoTitle = etAddItems.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etAddItems.text.clear()
            }
        }

        val btDelDone = findViewById<Button>(R.id.btDelDone)
        btDelDone.setOnClickListener {
            todoAdapter.deleteDone()
        }
    }
}