package org.art;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GenerateHoursStringByNumberAmount {

    public static String getHoursString(int number) {
        String oneHour = "час";
        String fewHours = "часа";
        String manyHours = "часов";
        return String.format("%d %s", (long) number, declension(number, oneHour, fewHours, manyHours));
    }

    private static String declension(long number, String caseOne, String caseFew, String caseMany) {
        long units = Math.abs(number) % 10;
        long tens = Math.abs(number) % 100;
        if (units == 1 && tens != 11) {
            return caseOne;
        } else if (units >= 2 && units <= 4 && (tens < 10 || tens >= 20)) {
            return caseFew;
        }
        return caseMany;
    }

    private long getBetweenTime() {
        LocalDateTime trustedDate = LocalDateTime.parse("2025-10-01T01:00:00");
        return ChronoUnit.HOURS.between(LocalDateTime.now(ZoneOffset.UTC), trustedDate);
    }
}
