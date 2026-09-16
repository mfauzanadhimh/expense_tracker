package org.example.repository

import org.example.model.Expenses

class ExpenseRepository {

    private val expenses = mutableListOf<Expenses>()


    fun findById(id: Int): Expenses? {

        return expenses.find {
            it.id == id
        }

    }


    fun save(expense: Expenses): Expenses {

        expenses.add(expense)

        return expense
    }


    fun update(expense: Expenses): Expenses? {

        val index = expenses.indexOfFirst {
            it.id == expense.id
        }


        if (index == -1) {
            return null
        }


        expenses[index] = expense

        return expense
    }



    fun deleteById(id: Int): Expenses? {

        val index = expenses.indexOfFirst {
            it.id == id
        }


        if(index == -1){
            return null
        }


        return expenses.removeAt(index)

    }



    fun findAll(): List<Expenses> {

        return expenses

    }

}