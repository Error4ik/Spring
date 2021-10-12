package org.example.company.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.company.domain.Position;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PositionStorage {

    private static final Logger logger = LogManager.getLogger();
    private final Set<Position> positionList = new HashSet<>();

    public boolean addPosition(Position position) {
        logger.info(String.format("Position - %s has been added for the Company.", position.getPositionName()));
        return positionList.add(position);
    }

    public boolean deletePosition(Position position) {
        boolean result = positionList.remove(position);
        if (result) {
            logger.info(String.format("Position - %s has been removed.", position.getPositionName()));
            return true;
        }
        return false;
    }

    public Position getPositionByName(String positionName) {
        for (Position p : positionList) {
            if (p.getPositionName().equalsIgnoreCase(positionName)) {
                logger.info(String.format("Returning %s.", p));
                return p;
            }
        }
        return null;
    }

    public List<Position> getPositionList() {
        List<Position> positions = new ArrayList<>();
        for (Position position : positionList) {
            if (position.getEmployeeCount() < position.getEmployeeLimit()) {
                positions.add(position);
            }
        }
        return positions;
    }
}
