package com.webservice.restapitest.repository;

import com.webservice.restapitest.model.Department;
import com.webservice.restapitest.model.EmployeewithDepartment;
import com.webservice.restapitest.model.Employee;
import com.webservice.restapitest.model.EmployeewithTask;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Queryrepo {


    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getEmployees(){
        String sql = "SELECT * FROM users_database.employee";
        Query query = entityManager.createNativeQuery(sql);
        //list ของ Object
        //list ของ object array คือ colum 1 , คอมลัม colum 2 , colum 3 ...
        List<Object[]>  resultList = query.getResultList();
        //create list ของ Employee เพื่อเอาข้อมูลมาจากที่ได้ จาก List ของ Object array
        List<Employee> employees = new ArrayList<>();
        resultList.forEach(objects -> {
            //ปั้ม object มา map แล้ว add เข้า้ List<Employee>
            Employee employee = new Employee();
            employee.setId(((Integer)(objects[0])).longValue() );
            employee.setName((String) objects[1]);
            employee.setAge(((Integer)(objects[2])).longValue());
            employee.setId_dep(((Integer)(objects[3])).longValue());
                employees.add(employee);
        });

        return employees;
    }

    public List<Employee> getEmployeeById(Long id) throws NoResultException{

//        try {
//            String sql = "SELECT * from users_database.employee  where id = :id";
//            Query query = entityManager.createNativeQuery(sql);
//
//            query.setParameter("id", id);
//            return (Employee) query.getSingleResult();
//        } catch (NoResultException noResultEx) {
//            throw new NoResultException();
//        }


            String sql = "SELECT * from users_database.employee  where id = :id";
            Query query = entityManager.createNativeQuery(sql);

            query.setParameter("id", id);
        List<Object[]>  resultList = query.getResultList();
        List<Employee> employees = new ArrayList<>();
        resultList.forEach(objects -> {
            Employee employee = new Employee();
            employee.setId(((Integer)(objects[0])).longValue() );
            employee.setName((String) objects[1]);
            employee.setAge(((Integer)(objects[2])).longValue());
            employee.setId_dep(((Integer)(objects[3])).longValue());
            employees.add(employee);
        });
        return employees;


    }

    public List<Department> getDepartments(){
        String sql = "SELECT * FROM users_database.department";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]>  resultList = query.getResultList();
        List<Department> departments = new ArrayList<>();
        resultList.forEach(objects -> {
            Department department = new Department();
            department.setId(((Integer)(objects[0])).longValue() );
            department.setDepartment((String) objects[1]);
            departments.add(department);
        });
        return departments;
    }

    public Department getDepartmentById(Long id_dep) throws NoResultException{

        try {
            String sql = "SELECT * from users_database.department  where id_dep = :id_dep";
            Query query = entityManager.createNativeQuery(sql);
            //list ของ Object
            query.setParameter("id_dep", id_dep);
            return (Department) query.getSingleResult();
        } catch (NoResultException noResultEx) {
            throw new NoResultException();
        }

    }


    public List getEmployeewithDepartmentById(Long id_dep){
        String sql = "SELECT  employee.name, department.name_dep FROM users_database.employee INNER JOIN department ON employee.id_dep = department.id_dep where employee.id_dep = :id_dep";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_dep" , id_dep);
        List<Object[]>  resultList = query.getResultList();
        List<EmployeewithDepartment> employeewithDepartmentList = new ArrayList<>();
        resultList.forEach(objects -> {
            EmployeewithDepartment employeewithDepartment = new EmployeewithDepartment();

            employeewithDepartment.setName((String) objects[0]);
            employeewithDepartment.setDepartment((String) objects[1]);
            employeewithDepartmentList.add(employeewithDepartment);
        });
        return employeewithDepartmentList;
    }






    public  List getEmployeeByIdwithTask(Long id){

    String sql ="SELECT  employee.name, department.name_dep , task.name_task ,describe_task.date_des\n" +
            "FROM users_database.employee\n" +
            "INNER JOIN department\n" +
            "ON employee.id_dep = department.id_dep\n" +
            "INNER  JOIN describe_task\n" +
            "ON employee.id = describe_task.id_emp\n" +
            "INNER JOIN task\n" +
            "ON describe_task.id_task = task.id_task\n" +
            "where employee.id = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id" , id);

        List<Object[]>  resultList = query.getResultList();

        List<EmployeewithTask> employeewithTasks = new ArrayList<>();

        resultList.forEach(objects -> {

            EmployeewithTask employeewithTask = new EmployeewithTask();

            employeewithTask.setName_emp((String) objects[0]);
            employeewithTask.setDepartment((String) objects[1]);
            employeewithTask.setName_task((String) objects[2]);
            employeewithTask.setDate_des((String) objects[3]);
            employeewithTasks.add(employeewithTask);
        });
        return employeewithTasks;
}
    }
