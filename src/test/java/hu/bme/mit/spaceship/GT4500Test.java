package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  
  private GT4500 ship;
  private TorpedoStore storeOne;
  private TorpedoStore storeTwo;

  @Before
  public void init(){
	storeOne = mock(TorpedoStore.class);
	storeTwo = mock(TorpedoStore.class);
    this.ship = new GT4500(storeOne, storeTwo);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
	when(storeOne.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(storeOne, times(1)).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
	when(storeOne.isEmpty()).thenReturn(true);
	when(storeTwo.isEmpty()).thenReturn(false);
	when(storeTwo.fire(1)).thenReturn(true);
	
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(storeTwo, times(1)).fire(1);
    assertEquals(true, result);
  }

}
