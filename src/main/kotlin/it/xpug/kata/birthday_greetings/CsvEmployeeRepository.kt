package it.xpug.kata.birthday_greetings

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.text.ParseException

class CsvEmployeeRepository(private val filename: String) : EmployeeRepository {
    @Throws(IOException::class, ParseException::class)
    override fun getAll(): List<Employee> {
        val employees: MutableList<Employee> = ArrayList()
        val `in` = BufferedReader(FileReader(filename))
        var str: String?
        `in`.readLine()
        while (`in`.readLine().also { str = it } != null) {
            val employeeData = str!!.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val employee = Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3])
            employees.add(employee)
        }
        return employees
    }
}