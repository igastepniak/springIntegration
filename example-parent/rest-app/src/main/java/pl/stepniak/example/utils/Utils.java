package pl.stepniak.example.utils;

public class Utils {
    
    public static java.sql.Timestamp convertDateToSqlDate(java.util.Date date) {
        
        return date != null ? new java.sql.Timestamp(date.getTime()) : null;
    }
    
}
