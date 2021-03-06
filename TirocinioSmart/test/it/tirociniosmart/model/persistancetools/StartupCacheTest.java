package it.tirociniosmart.model.persistancetools;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RealTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.RealUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class StartupCacheTest {

  static ProxyUtenteDAO dao = new ProxyUtenteDAO();
  static DAOCache cache = DAOCache.getIstance();
  static Didattica secondDidattica = new Didattica();
  static ProxyTirocinioDAO daoT = new ProxyTirocinioDAO();
  static ProxyAnnuncioDAO daoA = new ProxyAnnuncioDAO();
  private static final String email = "example@live.it";
  private static final String secondEmail = "example1@live.it";
  private static final String updateEmail = "exampleUpdate@live.it";
  private static final String nomeTirocinio = "esempioTirocinio";
  private static final String secondoTirocinio = "esempioTirocinioSecondo";
  private static final String tirocinioUpdate = "tirocinioUpdate";
  private static final String titolo = "exampleTitle";
  private static final String secondoTitolo = "exampleTitolodue";
  private static final String updateTitolo = "exampleTitoloUpd";
  private static TutorAccademico tutorI;
  private static TutorAccademico secondTutor;
  private static TutorAccademico updateTutor;
  private static Studente studenteI;
  private static Studente secondStudent;
  private static Tirocinio tirocinioI;
  private static Tirocinio secondTirocinio;
  private static Tirocinio updateTirocinio;
  private static RichiestaTirocinio richiestaI;
  private static RichiestaTirocinio secondRichiesta;
  private static RichiestaTirocinio updateRichiesta;
  private static Feedback feedbackI;
  private static Feedback secondFeedback;
  private static Annuncio annuncioI;
  private static Annuncio secondAnnuncio;
  private static Annuncio updateAnnuncio;


  @BeforeClass
  public static void setUp() throws Exception {
    StartupCache cache1 = new StartupCache();
    tutorI = new TutorAccademico();
    secondTutor = new TutorAccademico();
    secondTutor.setEmail(secondEmail);
    tutorI.setEmail(email);
    studenteI = new Studente();
    studenteI.setEmail(email);
    secondStudent = new Studente();
    secondStudent.setEmail(secondEmail);
    dao.inserTutorAccademico(tutorI);
    dao.inserTutorAccademico(secondTutor);
    tirocinioI = new Tirocinio();
    tirocinioI.setNome(nomeTirocinio);
    tirocinioI.setTutor(tutorI);
    secondTirocinio = new Tirocinio();
    secondTirocinio.setNome(nomeTirocinio);
    secondTirocinio.setTutor(secondTutor);
    daoT.insertTirocinio(tirocinioI);
    daoT.insertTirocinio(secondTirocinio);
    dao.insertStudente(studenteI);
    dao.insertStudente(secondStudent);

    richiestaI = new RichiestaTirocinio();
    secondRichiesta = new RichiestaTirocinio();
    tirocinioI = daoT.findTirocinioForTutorAccademico(email).get(0);
    secondTirocinio = daoT.findTirocinioForTutorAccademico(secondEmail).get(0);
    richiestaI.setTirocinio(tirocinioI);
    secondRichiesta.setTirocinio(secondTirocinio);
    richiestaI.setRichiedente(studenteI);
    secondRichiesta.setRichiedente(secondStudent);
    daoT.insertRichiestaTirocinio(richiestaI);
    daoT.insertRichiestaTirocinio(secondRichiesta);
    feedbackI = new Feedback();
    secondFeedback = new Feedback();
    feedbackI.setTirocinio(tirocinioI);
    secondFeedback.setTirocinio(secondTirocinio);
    feedbackI.setStudente(studenteI);
    secondFeedback.setStudente(secondStudent);
    daoT.insertFeedback(feedbackI);
    daoT.insertFeedback(secondFeedback);
    Didattica didatticaI = new Didattica();
    secondDidattica = new Didattica();
    secondDidattica.setEmail(secondEmail);
    didatticaI.setEmail(email);
    String sql = "INSERT INTO `mydb`.`didattica` (`email`) VALUES (?);";
    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      st.executeUpdate();
      st.setString(1, secondEmail);
      st.executeUpdate();
      cache.updateDidattica("insert", didatticaI.getEmail(), didatticaI);
      cache.updateDidattica("insert", secondDidattica.getEmail(), secondDidattica);

      annuncioI = new Annuncio();
      annuncioI.setTitolo(titolo);
      annuncioI.setAutore(didatticaI);
      secondAnnuncio = new Annuncio();
      secondAnnuncio.setTitolo(secondoTitolo);
      secondAnnuncio.setAutore(secondDidattica);
      daoA.insertAnnuncio(annuncioI);
      daoA.insertAnnuncio(secondAnnuncio);

      RealUtenteDAO real = new RealUtenteDAO();
      assertNull(real.findDidattica(new Didattica()));
      assertNull(real.findTutorAccademico(new TutorAccademico()));
      assertNull(real.findStudente(new Studente()));
      assertNull(real.selectDidattica());
      assertNull(real.selectStudente());
      assertNull(real.selectTutorAccademico());


    } catch (

    SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }
  }


  @AfterClass
  public static void tearDownClass() throws Exception {
    String sqlStudente = "DELETE FROM `mydb`.`studente` " + "WHERE `email`=?;";
    String sqlTutor = "DELETE FROM `mydb`.`tutor accademico` " + "WHERE `email`=?;";
    String sqlDidattica = "DELETE FROM `mydb`.`didattica` " + "WHERE `email`=?;";

    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement stStudente = con.prepareStatement(sqlStudente);
        PreparedStatement stTutor = con.prepareStatement(sqlTutor);
        PreparedStatement stDidattica = con.prepareStatement(sqlDidattica);) {
      stStudente.setString(1, email);
      stStudente.executeUpdate();
      stStudente.setString(1, updateEmail);
      stStudente.executeUpdate();
      stTutor.setString(1, email);
      stTutor.executeUpdate();
      stTutor.setString(1, updateEmail);
      stTutor.executeUpdate();

      stDidattica.setString(1, email);
      stDidattica.executeUpdate();
      stDidattica.setString(1, updateEmail);
      stDidattica.executeUpdate();


    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }

  }

  @Test
  public void testSetCacheStudente() throws StartupCacheException {

    Studente test = new Studente("ssssssgsagfasgsagagagasgassfasfaafsasssssssssssssssssssssda",
        " codiceFiscale", "nome", " cognome", " luogoNascita", "dataNascita", " password", " sesso",
        "residenza", "via", "telefono", "matricola", "tipoLaurea");
    assertFalse(dao.insertStudente(test));
    assertFalse(dao.updateStudente(test, studenteI));
    assertNotNull(dao.selectStudente());
    HashMap<String, Studente> tmp = cache.getStudente();
    assertNotNull(tmp.get(email));

    tmp = cache.getStudente();
    assertNotNull(tmp.get(secondEmail));
    Studente updateStudent = new Studente();
    updateStudent.setEmail(updateEmail);
    dao.updateStudente(updateStudent, secondStudent);
    tmp = cache.getStudente();
    assertNotNull(tmp.get(updateEmail));
    Studente testStudent = dao.findStudente(updateStudent);
    assertNotNull(testStudent);



  }



  @Test
  public void testSetCacheTirocinio() throws StartupCacheException {

    Tirocinio test = new Tirocinio("obiettissssssssssssssssssssssssssssssssssssssssssssvi",
        "descrizione", "fs", 5, 2, new TutorAccademico(), "tipo", " responsabile", "Fsa");

    assertFalse(daoT.insertTirocinio(test));
    assertFalse(daoT.updateTirocinio(test, tirocinioI));
    assertNotNull(daoT.selectTirocinio());
    HashMap<Integer, Tirocinio> tmp = cache.getTirocinio();

    ArrayList<Tirocinio> tirociniArray =
        daoT.findTirocinioForTutorAccademico(secondTutor.getEmail());
    int size = tirociniArray.size();
    int i = 0;
    while (i < size) {

      assertNotNull(secondTirocinio = tmp.get(tirociniArray.get(i).getId()));
      i++;
    }
    updateTirocinio = new Tirocinio();
    updateTirocinio.setNome(tirocinioUpdate);
    updateTirocinio.setTutor(updateTutor);
    daoT.updateTirocinio(updateTirocinio, secondTirocinio);
    tirociniArray = daoT.findTirocinioForTutorAccademico(updateTutor.getEmail());
    size = tirociniArray.size();
    i = 0;
    tmp = cache.getTirocinio();

    while (i < size) {
      assertNotNull(tmp.get(tirociniArray.get(i).getId()));
      assertSame(tmp.get(tirociniArray.get(i).getId()).getNome(), updateTirocinio.getNome());
      i++;
    }

  }

  @Test
  public void testSetCacheRichiesta() throws StartupCacheException {
    RichiestaTirocinio test = new RichiestaTirocinio("FAS",
        "dataRissssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssschiesta",
        "dataRisposta", new Studente(), new Tirocinio());
    RichiestaTirocinio test2 = new RichiestaTirocinio(276, "FAS", "dataRichiesta", "dataRisposta",
        new Studente(), new Tirocinio());
    assertFalse(daoT.updateRichiestaTirocinio(richiestaI,
        "sasgafagsgaggaahgadahahahgagfagagadhfshdshshsdhshdhshshdgsgdgssdhsgd"));
    assertNotNull(daoT.selectRichiestaTirocinio());
    HashMap<Integer, RichiestaTirocinio> tmp = cache.getRichiestaTirocinio();

    ArrayList<RichiestaTirocinio> tirociniArray =
        daoT.findRichiestaTirocinioForUser(studenteI.getEmail());
    int size = tirociniArray.size();
    int i = 0;
    while (i < size) {

      assertNotNull(secondRichiesta = tmp.get(tirociniArray.get(i).getId()));
      i++;
    }
    daoT.updateRichiestaTirocinio(secondRichiesta, "exampleStatus");
    tirociniArray = daoT.findRichiestaTirocinioForUser(secondRichiesta.getRichiedente().getEmail());
    size = tirociniArray.size();
    i = 0;
    tmp = cache.getRichiestaTirocinio();
    while (i < size) {
      assertNotNull(tmp.get(tirociniArray.get(i).getId()));
      assertSame(tmp.get(tirociniArray.get(i).getId()).getStato(), "exampleStatus");
      i++;
    }
    assertNotNull(daoT.findRichiestaTirocinioForTirocinio(tirocinioI.getId()));
    daoT.insertRichiestaTirocinio(test);
    Feedback feed = new Feedback();
    feed.setId(3);
    feed.setDataInvio("fsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
    feed.setStudente(new Studente());
    feed.setTirocinio(new Tirocinio());
    daoT.insertFeedback(feed);

    RealTirocinioDAO real = null;
    try {
      real = new RealTirocinioDAO();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }
    assertNull(real.selectFeedback());
    assertNull(real.selectRichiestaTirocinio());
    assertNull(real.selectTirocinio());


  }


  @Test
  public void testSetCacheAnnunci() throws StartupCacheException {
    assertNotNull(daoA.selectAnnuncio());
    HashMap<String, Annuncio> tmp = cache.getAnnunci();

    Annuncio annuncioTMP = daoA.findAnnuncio(titolo);
    Annuncio test = new Annuncio("dsa", new Didattica(), "afas", "fasfa", "fasfa");
    assertNotNull(annuncioTMP);
    updateAnnuncio = new Annuncio();
    updateAnnuncio.setTitolo(updateTitolo);
    updateAnnuncio.setAutore(secondDidattica);
    daoA.insertAnnuncio(updateAnnuncio);
    daoA.updateAnnuncio(updateAnnuncio, secondAnnuncio);
    Annuncio annuncioTMP2 = daoA.findAnnuncio(updateAnnuncio.getTitolo());
    assertNotNull(annuncioTMP2);
    tmp = cache.getAnnunci();
    assertNotNull(tmp.get(annuncioTMP2.getTitolo()));
    assertSame(tmp.get(annuncioTMP2.getTitolo()).getTitolo(), updateTitolo);
    assertTrue(daoA.removeAnnuncio(annuncioTMP2.getTitolo()));
    assertNotNull(daoA.findAnnuncio(annuncioTMP.getTitolo()));
    assertFalse(daoA.removeFile("casual"));


  }



  @Test
  public void testSetCacheFeedback() throws StartupCacheException {
    Feedback test = new Feedback(new Tirocinio(), new Studente(), "dataInvio", 2, "commento");
    Feedback test2 = new Feedback(2, new Tirocinio(), new Studente(), "dataInvio", 2, "commento");

    assertNotNull(daoT.selectFeedback());
    HashMap<Integer, Feedback> tmp = cache.getFeedback();

    ArrayList<Feedback> feedbackArray = daoT.findFeedbackForTirocinio(tirocinioI.getId());
    int size = feedbackArray.size();
    int i = 0;
    while (i < size) {

      assertNotNull(tmp.get(feedbackArray.get(i).getId()));
      i++;
    }

  }

  @Test
  public void testSetCacheTutorAccademico() throws StartupCacheException {
    TutorAccademico test =
        new TutorAccademico("sdsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssa",
            " codiceFiscale", "nome", " cognome", " luogoNascita", "dataNascita", " password",
            " sesso", "residenza", "via", "telefono", "matricola", "tipoLaurea");
    assertFalse(dao.inserTutorAccademico(test));
    assertFalse(dao.updateTutorAccademico(test, tutorI));
    assertNotNull(dao.selectTutorAccademico());
    HashMap<String, TutorAccademico> tmp = cache.getTutorAccademico();
    assertNotNull(tmp.get(email));

    tmp = cache.getTutorAccademico();
    assertNotNull(tmp.get(secondEmail));
    updateTutor = new TutorAccademico();
    updateTutor.setEmail(updateEmail);
    dao.updateTutorAccademico(updateTutor, secondTutor);
    tmp = cache.getTutorAccademico();
    assertNotNull(tmp.get(updateEmail));

  }

  @Test
  public void testSetCacheDidattica() throws StartupCacheException {
    Didattica test = new Didattica(" codicesssssssssssssssssssssssssssssssssssFiscale", "nome",
        " cognome", " luogoNascita", "dataNascita", " password", " sesso", "residenza", "via",
        "telefono", "fs", false);
    assertFalse(dao.updateDidattica(test, secondDidattica));
    assertNotNull(dao.selectDidattica());
    HashMap<String, Didattica> tmp = cache.getDidattica();
    assertNotNull(tmp.get(email));
    tmp = cache.getDidattica();
    assertNotNull(tmp.get(secondEmail));
    Didattica updateDidattica = new Didattica();
    updateDidattica.setEmail(updateEmail);
    dao.updateDidattica(updateDidattica, secondDidattica);
    tmp = cache.getDidattica();
    assertNotNull(tmp.get(updateEmail));

  }


}
