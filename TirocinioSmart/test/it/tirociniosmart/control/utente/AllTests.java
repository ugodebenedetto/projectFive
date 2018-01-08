package it.tirociniosmart.control.utente;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import it.tirociniosmart.control.didattica.insertandedit.InserisciAnnuncioTest;
import it.tirociniosmart.control.didattica.insertandedit.ModificaAnnuncioTest;
import it.tirociniosmart.control.didattica.visualizza.VisualizzaFeedbackTest;
import it.tirociniosmart.control.didattica.visualizza.VisualizzaListaAnnunciTest;
import it.tirociniosmart.control.didattica.visualizza.VisualizzaListaStudentiTest;
import it.tirociniosmart.control.tirocinio.editandinsert.InserisciFeedbackTest;
import it.tirociniosmart.control.tirocinio.editandinsert.InserisciTirocinioTest;
import it.tirociniosmart.control.tirocinio.editandinsert.InviaRichiestaTirocinioTest;
import it.tirociniosmart.control.tirocinio.editandinsert.ModificaTirocinioTest;
import it.tirociniosmart.control.tirocinio.editandinsert.ValutaRichiestaTirocinioTest;

@RunWith(Suite.class)

@SuiteClasses({InserisciAnnuncioTest.class, ModificaAnnuncioTest.class,
    VisualizzaFeedbackTest.class, VisualizzaListaAnnunciTest.class,
    VisualizzaListaStudentiTest.class, InserisciFeedbackTest.class, InserisciTirocinioTest.class,
    InviaRichiestaTirocinioTest.class, ModificaTirocinioTest.class,
    ValutaRichiestaTirocinioTest.class, LoginTest.class, LoginTestDidattica.class,
    LoginTutorTest.class, LogoutTest.class, ModificaInformazioniAccountTest.class,
    ModificaInfoTutorTest.class, RecuperaPasswordTest.class, RegistrazioneTest.class,
    RegistrazioneTutorTest.class, UtenteDAOTest.class})
public class AllTests {

}
