package com.github.ipwt22.tum4world.models;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DB {
    private static final Connection conn;
    private static final Statement stmt;

    private static PreparedStatement prepStmt;

    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/tum4world", "App", "Password");
            stmt = conn.createStatement();
            creaTabelle();


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void creaTabelle() {
        try {
            stmt.executeUpdate("CREATE TABLE utenti (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "token VARCHAR(255) NOT NULL," +
                    "nome VARCHAR(255) NOT NULL," +
                    "cognome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "telefono VARCHAR(255) NOT NULL," +
                    "username VARCHAR(255) NOT NULL UNIQUE ," +
                    "password VARCHAR(255) NOT NULL," +
                    "data_di_nascita VARCHAR(255) NOT NULL," +
                    "ruolo INTEGER NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
            stmt.executeUpdate("CREATE TABLE citazioni (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "testo VARCHAR(255) NOT NULL," +
                    "autore VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
            stmt.executeUpdate("CREATE TABLE attivita (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "titolo VARCHAR(255) NOT NULL," +
                    "descrizione VARCHAR(255) NOT NULL," +
                    "immagine VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
            stmt.executeUpdate("CREATE TABLE iscrizioni (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "utente_id INTEGER NOT NULL," +
                    "attivita_id INTEGER NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (utente_id) REFERENCES utenti(id)," +
                    "FOREIGN KEY (attivita_id) REFERENCES attivita(id)" +
                    ")");
            stmt.executeUpdate("CREATE TABLE donazioni (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "utente_id INTEGER NOT NULL," +
                    "importo DECIMAL(10,2) NOT NULL," +
                    "data DATE NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (utente_id) REFERENCES utenti(id)" +
                    ")");
            stmt.executeUpdate("CREATE TABLE contatore (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "url VARCHAR(255) NOT NULL," +
                    "visite INTEGER NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
            stmt.executeUpdate("INSERT INTO utenti (token, nome, cognome, email, telefono, username, password, data_di_nascita, ruolo) " +
                    "VALUES ('null', 'PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'admin', '22Adm1n!', '29-10-2022', 2)" +
                    ",('null', 'PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'amministratore', 'amministratore', '29-10-2022', 2)" +
                    ",('null', 'PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'aderente', 'aderente', '29-10-2022', 1)" +
                    ",('null', 'PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'simpatizzante', 'simpatizzante', '29-10-2022', 0)"
            );
            stmt.executeUpdate("INSERT INTO citazioni (testo, autore) VALUES " +
                    "('Il volontariato è l’arte di mettere il proprio cuore dove gli altri hanno bisogno di esso.', 'Autori vari'), " +
                    "('Il volontariato non è un lavoro pagato perché non ha prezzo.', 'Sherry Anderson'), " +
                    "('L’altruismo è la forma più elevata di autorealizzazione.', 'Ayn Rand'), " +
                    "('Non possiamo fare grandi cose sulla terra, solo piccole cose con grande amore.', 'Madre Teresa'), " +
                    "('La felicità non arriva mai da sola, a meno che non la si condivida con gli altri.', 'Helen Keller'), " +
                    "('Il vero significato della vita è trovare la propria vocazione nel servizio degli altri.', 'Albert Schweitzer'), " +
                    "('Il volontariato è l’opportunità di cambiare il mondo una persona alla volta.', 'Autori vari'), " +
                    "('Non possiamo aiutare tutti, ma tutti possono aiutare qualcuno.', 'Ronald Reagan'), " +
                    "('Il volontariato non è solo una parola, ma un’azione che può cambiare il mondo.', 'Autori vari'), " +
                    "('Il volontariato è l’arte di donare il proprio tempo e le proprie energie per migliorare la vita degli altri e della propria comunità.', 'Autori vari'), " +
                    "('Il volontariato è l’opportunità di fare la differenza nella vita degli altri e nella propria vita.', 'Autori vari'), " +
                    "('Il volontariato è l’opportunità di dare il proprio contributo alla società e alla propria comunità.', 'Autori vari'), " +
                    "('La felicità non è avere ciò che si desidera, ma desiderare ciò che si ha.', 'Dale Carnegie'), " +
                    "('L’unico modo per fare un grande lavoro è amare quello che fai.', 'Steve Jobs'), " +
                    "('La vita è un’opportunità, coglila.', 'Madre Teresa'), " +
                    "('Non c’è mai abbastanza tempo per fare tutto, ma c’è sempre abbastanza tempo per fare la cosa giusta.', 'Wesley Duewel'), " +
                    "('Il modo migliore per trovare se stessi è perdersi nel servizio degli altri.', 'Mahatma Gandhi'), " +
                    "('Fai del bene di nascosto e arrossisci a vederlo divulgato.', 'Seneca'), " +
                    "('Ogni uomo è colpevole di tutto il bene che non ha fatto.', 'Voltaire'), " +
                    "('Non basta fare del bene, bisogna anche farlo bene.', 'Denis Diderot')");
            //admin -> 22Adm1n!
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //settings per il database

    public static void signUp(String nome, String cognome, String email, String telefono, String username, String password, String dataDiNascita, int ruolo) {
        String sql = "INSERT INTO utenti (token, nome, cognome, email, telefono, username, password, data_di_nascita, ruolo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "null");
            prepStmt.setString(2, nome);
            prepStmt.setString(3, cognome);
            prepStmt.setString(4, email);
            prepStmt.setString(5, telefono);
            prepStmt.setString(6, username);
            prepStmt.setString(7, password);
            prepStmt.setString(8, dataDiNascita);
            prepStmt.setInt(9, ruolo);
            prepStmt.executeUpdate();
            prepStmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static Utente getUtenteFromResultSet(ResultSet resultSet) throws SQLException {
        Utente user = null;
        if (resultSet.next()) { //se la query non ha restituito niente
            user = new Utente();
            Date dataDiNascita = null;
            try {
                dataDiNascita = new SimpleDateFormat("dd-MM-yyyy").parse(resultSet.getString("data_di_nascita"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setNome(resultSet.getString("nome"));
            user.setCognome(resultSet.getString("cognome"));
            user.setUsername(resultSet.getString("username"));
            user.setHashPassword(resultSet.getString("password"));
            user.setRuolo(Utente.Ruolo.values()[resultSet.getInt("ruolo")]);
            user.setEmail(resultSet.getString("email"));
            user.setTelefono(resultSet.getString("telefono"));
            user.setDataDiNascita(dataDiNascita);
        }
        return user;
    }

    public static Utente getUserFromUsername(String username) {
        String sql = "SELECT * FROM Utenti WHERE username = ?";
        Utente user = null;
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            ResultSet resultSet = prepStmt.executeQuery();
            user = getUtenteFromResultSet(resultSet);
            prepStmt.close();
            resultSet.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Ottiene l'utente a partire dal token.
     *
     * @param token
     * @return Utente associato al token
     */
    public static Utente getUserFromToken(String token) throws Exception {
        if (token == null) throw new Exception("token is null");
        String sql = "SELECT * FROM Utenti WHERE token = ?";
        Utente user = null;
        prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, token);
        ResultSet resultSet = prepStmt.executeQuery();
        user = getUtenteFromResultSet(resultSet);
        prepStmt.close();
        resultSet.close();
        return user;
    }

    public static void setKeyOfUser(String username, String token) {
        String sql = "UPDATE Utenti SET token = ? WHERE username = ?";
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, token);
            prepStmt.setString(2, username);
            prepStmt.executeUpdate();
            prepStmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static Citazione getRandomCitazione() {
        String sql = "SELECT COUNT(*) FROM Citazioni";
        Random random = new Random();
        int numberOfRows = -1;
        int index;
        Citazione citazione = new Citazione();
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.next();
            numberOfRows = resultSet.getInt(1);
            index = random.nextInt(numberOfRows);
            sql = "SELECT * FROM Citazioni";
            resultSet = stmt.executeQuery(sql);
            for(int i=1;i<=index;++i)
                resultSet.next();
            citazione.setCitazione(resultSet.getString("testo"));
            citazione.setAutore(resultSet.getString("autore"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return citazione;
    }

    /**
     * Verifica se l'utente è iscritto all'attività.
     *
     * @param utente
     * @param attivita
     * @return true se l'utente è iscritto all'attività, false altrimenti
     */
    public static boolean iscritto(Utente utente, Attivita attivita) {
        return true;
    }

    /**
     * Preleva tutte le donazioni
     *
     * @return lista di donazioni
     */
    public static List<Donazione> getDonazioni() {
        List<Donazione> donazioni = new ArrayList<>();
        String sql = "SELECT * FROM Donazioni;";
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                Donazione donazione = new Donazione();
                donazione.setImporto(resultSet.getDouble("importo"));
                donazione.setData(resultSet.getDate("data"));
                donazioni.add(donazione);
            }
        }
        catch (SQLException e){}
        return donazioni;
    }

    public static List<Utente> getUtenti(){
        return null;
    }

    public static void addDonation(Utente utente, int amount) {
        // TODO: fai la donazione
    }
}
