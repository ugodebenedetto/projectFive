package SystemTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import it.tirociniosmart.control.tirocinio.visualizza.VisualizaInfoTirociniTest;
import it.tirociniosmart.control.tirocinio.visualizza.VisualizzaListaTirociniTest;
import it.tirociniosmart.control.tirocinio.visualizza.VisualizzaRichiestaTirocinioTest;
import it.tirociniosmart.control.utente.LoginTest;
import it.tirociniosmart.control.utente.LoginTestDidattica;
import it.tirociniosmart.control.utente.LoginTutorTest;
import it.tirociniosmart.control.utente.LogoutTest;
import it.tirociniosmart.control.utente.ModificaInfoTutorTest;
import it.tirociniosmart.control.utente.ModificaInformazioniAccountTest;
import it.tirociniosmart.control.utente.RecuperaPasswordTest;
import it.tirociniosmart.control.utente.RegistrazioneTest;
import it.tirociniosmart.control.utente.RegistrazioneTutorTest;
import it.tirociniosmart.control.utente.UtenteDAOTest;

@RunWith(Suite.class)
@SuiteClasses({LoginTest.class, LoginTestDidattica.class, LoginTutorTest.class, LogoutTest.class,
  ModificaInformazioniAccountTest.class, ModificaInfoTutorTest.class, RecuperaPasswordTest.class,
  RegistrazioneTest.class, RegistrazioneTutorTest.class, UtenteDAOTest.class,VisualizaInfoTirociniTest.class, VisualizzaListaTirociniTest.class,
  VisualizzaRichiestaTirocinioTest.class})
public class AllTests {

}
