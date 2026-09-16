package org.example

class ExpenseService(
    private repo: ExpenseRepository
  ){

    suspend fun getExpense(id: Int): Expenses{
        if(id == null){
            throw Exception("Expense id is null")
        }

        val expense = repo.findById(id)
    }

    suspend fun createExpense(expense: Expenses): Expenses {
        if (expense.quantity <= 0) throw Exception("Expense quantity is 0 or below")


        if(expense.name == null) throw Exception("Expense name is null")

        if(expense.category == null) throw Exception("Expense category is null")

        return repo.save(expense)
    }

    suspend fun updateExpense(expense: Expenses): Expenses {

        val result  = update(expense)

        if(result == null) throw Exception("Expense is not found")

        return result
    }

    suspend fun deleteExpense(id: Int): Expenses {
        val result = deleteById(id)
        if(result == null) throw Exception("Expense is not found")

        return result
    }

    suspend fun getTotalExpenses(): Int{
        return repo.findAll.sumOf{it.quantity}
    }



}