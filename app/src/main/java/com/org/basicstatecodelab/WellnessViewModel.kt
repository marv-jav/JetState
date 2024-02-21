package com.org.basicstatecodelab

import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableList()
    val tasks: List<WellnessTask> get() = _tasks

    fun removeItem(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id } ?.let { task ->
            task.checked = checked
        }
    }

    private fun getWellnessTasks() = List(100) {i -> WellnessTask(i, "Task # $i")}
}