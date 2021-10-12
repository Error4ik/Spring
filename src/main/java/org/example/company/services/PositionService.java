package org.example.company.services;

import org.example.company.domain.Position;
import org.example.company.storage.PositionStorage;
import org.example.company.validator.MyValidator;

import java.util.List;
import java.util.Optional;

public class PositionService {

    private final MyValidator myValidator;
    private final PositionStorage positionStorage;

    public PositionService(MyValidator myValidator, PositionStorage positionStorage) {
        this.myValidator = myValidator;
        this.positionStorage = positionStorage;
    }

    public boolean addPosition(Position position) {
        if (myValidator.validatePosition(position)) {
            return positionStorage.addPosition(position);
        }
        return false;
    }

    public boolean deletePosition(Position position) {
        return positionStorage.deletePosition(position);
    }

    public Optional<Position> getPositionByName(String positionName) {
        Optional<Position> position = Optional.empty();
        Position p = positionStorage.getPositionByName(positionName);
        if (p != null) {
            position = Optional.of(p);
        }
        return position;
    }

    public List<Position> getPositionList() {
        return positionStorage.getPositionList();
    }
}
