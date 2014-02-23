package jp.co.dk.property;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAbstractProperty.class, TestPropertiesFile.class })
public class TestAll {}
