package org.example.company.services;

import org.example.company.domain.Position;
import org.example.company.storage.PositionStorage;
import org.example.company.validator.MyValidator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

public class PositionServiceTest {

    private final PositionStorage positionStorage = mock(PositionStorage.class);
    private final MyValidator validator = mock(MyValidator.class);
    private final PositionService positionService = new PositionService(validator, positionStorage);
    private final Position position = mock(Position.class);

    @Test
    public void whenAddPositionShouldBeReturnTrue() {
        when(validator.validatePosition(any(Position.class))).thenReturn(true);
        when(positionStorage.addPosition(any(Position.class))).thenReturn(true);

        boolean actualValue = positionService.addPosition(position);

        assertTrue(actualValue);
        verify(positionStorage, times(1)).addPosition(position);
    }

    @Test
    public void whenRemovePositionShouldBeReturnTrueIfPositionContains() {
        when(positionStorage.deletePosition(any(Position.class))).thenReturn(true);

        boolean actualValue = positionService.deletePosition(position);

        assertTrue(actualValue);
        verify(positionStorage, times(1)).deletePosition(position);
    }

    @Test
    public void whenRemovePositionShouldBeReturnFalseIfPositionNotContains() {
        when(positionStorage.deletePosition(any(Position.class))).thenReturn(false);

        boolean actualValue = positionService.deletePosition(position);

        assertFalse(actualValue);
        verify(positionStorage, times(1)).deletePosition(position);
    }

    @Test
    public void whenGetPositionByNameShouldReturnPositionIfContains() {
        String positionName = "HR";
        when(positionStorage.getPositionByName(any(String.class))).thenReturn(position);

        Position actualValue = positionService.getPositionByName(positionName).get();

        assertThat(actualValue, is(position));
        verify(positionStorage, times(1)).getPositionByName(positionName);
    }

    @Test
    public void whenGetPositionByNameShouldReturnPositionIfNotContains() {
        String positionName = "HR";
        when(positionStorage.getPositionByName(any(String.class))).thenReturn(null);

        Optional<Position> actualValue = positionService.getPositionByName(positionName);

        assertThat(actualValue, is(Optional.empty()));
        verify(positionStorage, times(1)).getPositionByName(positionName);
    }

    @Test
    public void whenGetPositionSetShouldReturnCollectionOfSet() {
        when(positionStorage.getPositionList()).thenReturn(new ArrayList<>());

        positionService.getPositionList();

        verify(positionStorage, times(1)).getPositionList();
    }
}
