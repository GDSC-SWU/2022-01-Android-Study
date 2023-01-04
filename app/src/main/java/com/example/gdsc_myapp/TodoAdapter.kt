package com.example.gdsc_myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_myapp.databinding.ItemListBinding

class TodoAdapter(private val todos:List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {  // 직접 생성한 viewHolder를 넣어줌

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    // 데이터의 크기
    override fun getItemCount(): Int = todos.size

    class TodoViewHolder(private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo){
            binding.tvTodo.text = todo.title
            binding.cbTodo.isChecked = todo.completed
        }
    }
}