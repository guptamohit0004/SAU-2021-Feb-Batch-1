package com.Hibernate.EmployeeManager;
import java.sql.ResultSet;
import java.util.-;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.-;
import org.hibernate.Session;
import org.hibernate.Session.-;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
    	OutputMenu outObj=new OutputMenu();
    	Scanner sch = new Scanner(System.in);
        int selectedOption;
        String sql;
        do {
        	System.out.println("\nMENU for Employee Management.\n");
            outObj.printList();
            selectedOption = sch.nextInt();
            Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
    		SessionFactory sf=con.buildSessionFactory();
    		Session session= sf.openSession();
    		Transaction tx=session.beginTransaction();
            switch (selectedOption)
            {
                case 1:
                	System.out.println("\n");
                	Employee addE=outObj.entChoice();
                	if (Objects.isNull(addE))
                		break;
                	else {
                		session.save(addE);
                		System.out.println("------------Employee Have been added!!!!!");
                		tx.commit();
                	}
                	System.out.println("\n");
                	break;
                case 2:
                	System.out.println("\n");
                	System.out.println("Enter the ID for which details need to be updated");
                	int oldID=sch.nextInt();
                	outObj.printChoice();
                	int updChoice=sch.nextInt();
                	sch.nextLine();
                	Employee updateRec=null;
                	switch(updChoice)
                	{
                		case 1:
                			System.out.println("Enter New ID");
                			int newID=sch.nextInt();
                			sch.nextLine();
                			sql = String.format("Update Employee SET id='%d' where id='%d';",newID,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------ID UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;

                		case 2:
                			System.out.println("Enter New First Name");
                			String newFN=sch.nextLine();
                			sql = String.format("Update Employee SET fname='%s' where id='%d';",newFN,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------FIRST NAME UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;

                		case 3:
                			System.out.println("Enter New Last Name");
                			String newLN=sch.nextLine();
                			sql = String.format("Update Employee SET lname='%s' where id='%d';",newLN,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------LAST NAME UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;
                		case 4:
                			System.out.println("Enter New Date of Birth");
                			String newDOB=sch.nextLine();
                			sql = String.format("Update Employee SET dob='%s' where id='%d';",newDOB,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------DOB UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;
                		case 5:
                			System.out.println("Enter New Designation");
                			String newDESI=sch.nextLine();
                			sql = String.format("Update Employee SET designation='%s' where id='%d';",newDESI,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------DESIGNATION UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;
                		case 6:
                			System.out.println("Enter New Salary");
                			int newSAL=sch.nextInt();
                			sch.nextLine();
                			sql = String.format("Update Employee SET salary='%d' where id='%d';",newSAL,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------SALARY UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;
                		case 7:
                			System.out.println("Enter New Age");
                			int newAGE=sch.nextInt();
                			sch.nextLine();
                			sql = String.format("Update Employee SET age='%d' where id='%d';",newAGE,oldID);
                    		try {
                    			session.createSQLQuery(sql).executeUpdate();
                    			System.out.println("----------AGE UPDATED-------------");
                    			tx.commit();
                    		}
                    		catch(Exception e2) {
                    			System.out.println("No Employee Found");
                    		}
                    		break;

                		default:
                			System.out.println("Invalid Choice!");
                			break;
                	}
                	System.out.println("\n");
                    break;
                case 3:
                	System.out.println("\n");
                    System.out.println("Enter Employee to be deleted");
                    int toDel=sch.nextInt();
        			sch.nextLine();
        			sql = String.format("Delete from Employee where id='%d';",toDel);
            		try {
            			session.createSQLQuery(sql).executeUpdate();
            			System.out.println("---------Employee DELETED---------");
            			tx.commit();
            		}
            		catch(Exception e2) {
            			System.out.println("No Employee Found");
            		}
            		System.out.println("\n");
                    break;
                case 4:
                	System.out.println("\n");
            		try {
            			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            			Root<Employee> root = criteriaQuery.from(Employee.class);
            			criteriaQuery.select(root);
            			Query<Employee> query = session.createQuery(criteriaQuery);
            			List<Employee> EmployeeList = query.getResultList();
            			System.out.println("------------All The Employees---------");
            			for(int i=0;i<EmployeeList.size();i++) {
            				Employee temp= (Employee) EmployeeList.get(i);
            				System.out.println(temp.toString());
            			}
            			System.out.println("\n");

            		}
            		catch(Exception e2) {
            			System.out.println("No Employee Found");
            		}
            		break;

                case 5:
                	System.out.println("\n");
                	Employee fetchedID=null;
                	System.out.println("Enter ID whose records to be fetched");
                    int userID=sch.nextInt();
                    System.out.println("\nFETCHIING RECORD....");
                	fetchedID=(Employee) session.get(Employee.class, userID);
                	System.out.println(fetchedID.toString());
                	break;
                default:
                    System.out.println("Enter value between 1 and 5. Enter 6 to Exit");
            }
        } while (selectedOption != 6);

    }
}
