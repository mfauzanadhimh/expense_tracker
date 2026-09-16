package org.example.service

import org.example.model.Expenses
import org.example.repository.ExpenseRepository

class ExpenseService(
    private val repo: ExpenseRepository
){


    fun getExpense(id: Int): Expenses {

        val expense =
            repo.findById(id)


        if(expense == null){
            throw Exception("Expense not found")
        }


        return expense
    }



    fun createExpense(expense: Expenses): Expenses {


        if(expense.name.isBlank()){
            throw Exception(
                "Expense name is empty"
            )
        }


        if(expense.category.isBlank()){
            throw Exception(
                "Expense category is empty"
            )
        }


        if(expense.quantity <= 0){
            throw Exception(
                "Expense quantity must be above 0"
            )
        }


        return repo.save(expense)

    }



    fun updateExpense(expense: Expenses): Expenses {


        val result =
            repo.update(expense)


        if(result == null){
            throw Exception(
                "Expense not found"
            )
        }


        return result

    }



    fun deleteExpense(id:Int): Expenses {


        val result =
            repo.deleteById(id)


        if(result == null){
            throw Exception(
                "Expense not found"
            )
        }


        return result

    }



    fun getTotalExpense():Int {


        return repo.findAll()
            .sumOf {
                it.quantity
            }

    }

}