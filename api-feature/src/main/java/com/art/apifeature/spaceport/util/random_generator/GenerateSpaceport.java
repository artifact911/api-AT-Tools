package com.art.apifeature.spaceport.util.random_generator;

import com.art.apifeature.spaceport.transport.Bus;
import com.art.apifeature.spaceport.transport.Car;
import com.art.apifeature.spaceport.transport.Plane;
import com.art.apifeature.spaceport.transport.Ship;
import com.art.apifeature.spaceport.transport.SpaceShip;
import com.art.apifeature.spaceport.transport.Spaceport;
import com.art.apifeature.spaceport.transport.TransportType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;

import static org.art.GenerateHoursStringByNumberAmount.getHoursString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GenerateSpaceport {

    public static List<Spaceport> getSpaceportList() {
        int hoursToStart = new Random().nextInt(120);
        return List.of(
                new Spaceport("SpaceX",
                        "911",
                        hoursToStart,
                        getMessageToStart(hoursToStart),
                        List.of(new Bus(TransportType.BUS,
                                        TransportType.BUS.getId(),
                                        21,
                                        "Volvo",
                                        "to_Spaceport",
                                        LocalDate.of(2009, Month.APRIL, 4),
                                        "Sweden"),
                                new Car(TransportType.CAR,
                                        TransportType.CAR.getId(),
                                        "3999",
                                        "Mercedes",
                                        LocalDate.of(2019, Month.JULY, 10),
                                        "Germany"),
                                new Plane(TransportType.PLANE,
                                        TransportType.PLANE.getId(),
                                        80,
                                        "Boeing",
                                        "to_Байконур",
                                        LocalDate.of(2011, Month.JULY, 7),
                                        "USA"),
                                new Ship(TransportType.SHIP,
                                        TransportType.SHIP.getId(),
                                        201,
                                        Boolean.TRUE,
                                        LocalDate.of(2009, Month.JANUARY, 12),
                                        "USSR",
                                        "200_000"),
                                new SpaceShip(TransportType.SPACE_SHIP,
                                        TransportType.SPACE_SHIP.getId(),
                                        8,
                                        LocalDate.of(2021, Month.DECEMBER, 1),
                                        "USSR"
                                ))));
    }

    private static String getMessageToStart(int hoursToStart) {
        return String.format("До старта осталось %s", getHoursString(hoursToStart));
    }
}
