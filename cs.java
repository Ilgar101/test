import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeSchema {
    public static void main(String[] args) {

        Connection connection = null;
        Connection connectionCom = null;
        String[] list = new String[]{"newdatabs.db"};

        String div= null;
        String date = null;
        String homeTeam = null;
        String awayTeam = null;
        String ftr = null;
        String htr = null;
        int fthg;
        int ftag;
        int hthg;
        int htag;

        double BbAvH;
        double BbAvD;
        double BbAvA;
        double BbAvg25;
        double BbAvl25;
        int roundH;
        int roundA;
        int goalHFH;
        int goalHAgH;
        int goalHFA;
        int goalHAgA;
        int goalAFH;
        int goalAAgH;
        int goalAFA;
        int goalAAgA;
        int maHWH;
        int maHDH;
        int maHLH;
        int maHWA;
        int maHDA;
        int maHLA;
        int maAWH;
        int maADH;
        int maALH;
        int maAWA;
        int maADA;
        int maALA;
        int rankH;
        int rankA;
        int pointH;
        int pointA;
        int HgoalHFH;
        int HgoalHAgH;
        int HgoalHFA;
        int HgoalHAgA;
        int HgoalAFH;
        int HgoalAAgH;
        int HgoalAFA;
        int HgoalAAgA;
        String formeH;
        String formeA;
        int aboveH;
        int belowH;
        int aboveA;
        int belowA;


        for (String ipo : list) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:" + ipo);
                connectionCom = DriverManager.getConnection("jdbc:sqlite:zDataBs.db");
                ResultSet rsRound = connection.createStatement().executeQuery("select * from Matches");

                while (rsRound.next()) {

                    int season = rsRound.getInt("Season");
                    String league = rsRound.getString("League");

                    date = rsRound.getString("Date");
                    if (date.length()<9) {
                        date= date.substring(0, 6)+"20"+date.substring(6);
                    }
                    homeTeam = rsRound.getString("HomeTeam");
                    awayTeam = rsRound.getString("AwayTeam");
                    ftr = rsRound.getString("FTR");
                    htr = rsRound.getString("HTR");
                    fthg = rsRound.getInt("FTHG");
                    ftag = rsRound.getInt("FTAG");
                    hthg = rsRound.getInt("HTHG");
                    htag = rsRound.getInt("HTAG");


                    BbAvH = rsRound.getDouble("BbAvH");
                    BbAvD = rsRound.getDouble("BbAvD");
                    BbAvA = rsRound.getDouble("BbAvA");
                    BbAvg25 = rsRound.getDouble("BbAvg25");
                    BbAvl25 = rsRound.getDouble("BbAvl25");

                    roundH = rsRound.getInt("roundH");
                    roundA = rsRound.getInt("roundA");
                    goalHFH = rsRound.getInt("goalHFH");
                    goalHAgH = rsRound.getInt("goalHAgH");
                    goalHFA = rsRound.getInt("goalHFA");
                    goalHAgA = rsRound.getInt("goalHAgA");
                    goalAFH = rsRound.getInt("goalAFH");
                    goalAAgH = rsRound.getInt("goalAAgH");
                    goalAFA = rsRound.getInt("goalAFA");
                    goalAAgA = rsRound.getInt("goalAAgA");
                    maHWH = rsRound.getInt("maHWH");
                    maHDH = rsRound.getInt("maHDH");
                    maHLH = rsRound.getInt("maHLH");
                    maHWA = rsRound.getInt("maHWA");
                    maHDA = rsRound.getInt("maHDA");
                    maHLA = rsRound.getInt("maHLA");
                    maAWH = rsRound.getInt("maAWH");
                    maADH = rsRound.getInt("maADH");
                    maALH = rsRound.getInt("maALH");
                    maAWA = rsRound.getInt("maAWA");
                    maADA = rsRound.getInt("maADA");
                    maALA = rsRound.getInt("maALA");
                    rankH = rsRound.getInt("rankH");
                    rankA = rsRound.getInt("rankA");
                    pointH = rsRound.getInt("pointH");
                    pointA = rsRound.getInt("pointA");
                    formeH = rsRound.getString("formeH");
                    formeA = rsRound.getString("formeA");
                    aboveH = rsRound.getInt("aboveH");
                    belowH = rsRound.getInt("belowH");
                    aboveA = rsRound.getInt("aboveH");
                    belowA = rsRound.getInt("belowA");

                    
                    connectionCom.createStatement().execute("INSERT INTO Matches (Season, League, Date, HomeTeam,AwayTeam," +
                            " FTHG, FTAG, FTR, HTHG, HTAG, HTR, BbAvH, BbAvD,BbAvA, BbAvg25, " +
                            "BbAvl25,roundH,roundA,goalHFH,goalHAgH,goalHFA,goalHAgA,goalAFH,goalAAgH,goalAFA," +
                            "goalAAgA,maHWH,maHDH,maHLH,maHWA,maHDA,maHLA,maAWH,maADH,maALH,maAWA,maADA," +
                            "maALA,rankH,rankA,pointH,pointA, formeH, formeA)" +
                            " VALUES ("+season+", '"+ league + "', '" + date + "', "+'"' +
                            homeTeam +'"'+ ", " + '"'+awayTeam +'"'+ ", " + fthg + ", " + ftag + ", '" + ftr + "', " +
                            hthg + ", " + htag + ", '" + htr + "', " + BbAvH + ", " + BbAvD + ", " + BbAvA + ", " +
                            BbAvg25 + ", " + BbAvl25 + ", " + roundH + ", " + roundA + ", " + goalHFH + ", " + goalHAgH + ", " +
                            goalHFA + ", " + goalHAgA + ", " + goalAFH + ", " + goalAAgH + ", " + goalAFA + ", " +
                            goalAAgA + ", " + maHWH + ", " + maHDH + ", " + maHLH + ", " + maHWA + ", " + maHDA + ", " +
                            maHLA + ", " + maAWH + ", " + maADH + ", " + maALH + ", " + maAWA + ", " + maADA + ", " +
                            maALA + ", " + rankH + ", " + rankA + ", " + pointH + ", " + pointA+ ", '" + formeH +
                            "', '" + formeA + "'"+")");
                    System.out.println(ipo +"   round:   " + rsRound.getString("nid"));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {

                    System.err.println(e);
                }
            }
        }
    }
}
