package org.example.company.services;

import org.example.company.domain.Position;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PositionServiceTest {

    private final ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("spring-context.xml");

    private final PositionService positionService = context.getBean(PositionService.class);

    private Position position;

    @Before
    public void init() {
        position = new Position("HR", 5);
        positionService.addPosition(position);
    }

    @Test
    public void whenAddPositionShouldBeReturnTrue() {
        Position position = new Position("DEVELOPER", 20);
        boolean actualValue = positionService.addPosition(position);

        assertTrue(actualValue);
    }

    @Test
    public void whenRemovePositionShouldBeReturnTrueIfPositionContains() {
        boolean actualValue = positionService.deletePosition(position);

        assertTrue(actualValue);
    }

    @Test
    public void whenRemovePositionShouldBeReturnFalseIfPositionNotContains() {
        Position position = new Position("DEVELOPER", 20);

        boolean actualValue = positionService.deletePosition(position);

        assertFalse(actualValue);
    }

    @Test
    public void whenGetPositionByNameShouldReturnPositionIfContains() {
        Position actualValue = positionService.getPositionByName("HR").get();

        assertThat(actualValue, is(position));
    }

    @Test
    public void whenGetPositionByNameShouldReturnPositionIfNotContains() {
        Optional<Position> actualValue = positionService.getPositionByName("DEVELOPER");

        assertThat(actualValue, is(Optional.empty()));
    }

    @Test
    public void whenGetPositionSetShouldReturnCollectionOfSet() {
        List<Position> positionSet = positionService.getPositionList();

        assertTrue(positionSet.contains(position));
    }
}
