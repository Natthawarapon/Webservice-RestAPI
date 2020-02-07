package com.webservice.restapitest.repository;

import com.webservice.restapitest.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Persisrepo {
    @PersistenceContext
    private EntityManager entityManager;

        public int addEmployee(String name, Long age , Long id_dep ){
            //รับเป็น bean
            //เครื่องหมาย : บอกระบุตัวแปรใน
            String sql = "INSERT INTO users_database.employee (name, age, id_dep) VALUES ( :name, :age , :id_dep)";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("name",name  );
            query.setParameter("age",age );
            query.setParameter("id_dep",id_dep );

            return  query.executeUpdate();
        }

        public int updateEmployee(Long id ,String name , Long age , Long id_dep ){
            String sql = "UPDATE users_database.employee SET name = :name , age = :age ,id_dep = :id_dep WHERE id = :id";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("id",id  );
            query.setParameter("name",name  );
            query.setParameter("age",age );
            query.setParameter("id_dep",id_dep );

        return query.executeUpdate();
        }


        public  int deleteEmployee(Long id ) throws Exception {

            try {
                String sql = "DELETE FROM users_database.employee WHERE id = :id";
                Query query = entityManager.createNativeQuery(sql);
                query.setParameter("id", id);
                return query.executeUpdate();
            }catch (Exception e){
                throw new Exception();
            }
        }


    public int addDepartment(String name){
        //รับเป็น bean
        //เครื่องหมาย : บอกระบุตัวแปรใน
        String sql = "INSERT INTO users_database.department (name_dep) VALUES ( :name)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name",name  );

        return    query.executeUpdate() ;
    }



//
    public  int addDescride_Task(Long id_emp , Long id_task ,String date){
            String sql ="INSERT INTO users_database.describe_task (id_emp,id_task,date_des) VALUES ( :id_emp , :id_task , :date )";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_emp",id_emp);
        query.setParameter("id_task",id_task);
        query.setParameter("date", date);
        return   query.executeUpdate();

    }

public int addTask( String name_task){
      String sql   = "INSERT INTO users_database.task (name_task)\n" +
                        "VALUES(:name_task)";
    Query query = entityManager.createNativeQuery(sql);
    query.setParameter("name_task" , name_task);
    return  query.executeUpdate();

}













}
