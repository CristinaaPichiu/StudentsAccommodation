package gui.util;

import java.sql.*;
import java.util.Scanner;

public class DataBaseColegi {
    public static void main(String[] args) {
        String lastName;
        String firstName;
        int indexClass;
        String nameClass;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con= DriverManager.getConnection(
                    "jdbc:postgresql://hansken.db.elephantsql.com:5432/xunyvuvx","xunyvuvx","jrAnITrg2JHb91MPNUYuitE3BBKy-UBo");


            Scanner console = new Scanner(System.in);

            System.out.print("Enter last_name: ");
            lastName = console.nextLine();


            System.out.print("Enter first_name: ");
            firstName = console.nextLine();


            System.out.print("Enter an: ");
            indexClass = console.nextInt();

            console = new Scanner(System.in);
            System.out.print("Enter grupa: ");
            nameClass = console.nextLine();



            String sql = "SELECT id FROM studenti WHERE nume = ? AND prenume = ? AND an = ? AND grupa = ?";
            PreparedStatement prepStmt = con.prepareStatement(sql);
            prepStmt.setString(1, lastName);
            prepStmt.setString(2, firstName);
            prepStmt.setInt(3, indexClass);
            prepStmt.setString(4, nameClass);
            ResultSet rs1 = prepStmt.executeQuery();
            Integer id = 0;

            while(rs1.next()) {
                System.out.println("Studentul cu datele introduse are id-ul: " + rs1.getInt(1));
                id = rs1.getInt(1);
            }

            CallableStatement cstmt = con.prepareCall("{? = call how_many_colleagues(?)}");
            //Registering the out parameter of the function (return type)
            cstmt.registerOutParameter(1, Types.INTEGER);
            //Setting the input parameters of the function
            cstmt.setInt(2, id);

            //Executing the statement
            cstmt.execute();
            System.out.print("Afisam cati colegi are studentul: "+cstmt.getInt(1));

            System.out.println("\nColegii recomandati pentru acest student sunt:");


            cstmt = con.prepareCall("{? = call get_colegi_proj(?)}");
            //Registering the out parameter of the function (return type)
            cstmt.registerOutParameter(1, Types.VARCHAR);
            //Setting the input parameters of the function
            cstmt.setInt(2,id);
            //Executing the statement
            cstmt.execute();

            System.out.print(cstmt.getString(1));

            con.close();

            }catch(Exception e){ System.out.println(e);
        }
    }
}
