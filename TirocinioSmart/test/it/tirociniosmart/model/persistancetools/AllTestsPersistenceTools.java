package it.tirociniosmart.model.persistancetools;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import it.tirociniosmart.model.factory.AbstractFactoryTest;

@RunWith(Suite.class)
@SuiteClasses({AbstractFactoryTest.class,DAOCacheTest.class, DBManagerTest.class, FileManagerTest.class,
    StartupCacheTest.class})
public class AllTestsPersistenceTools {

}
