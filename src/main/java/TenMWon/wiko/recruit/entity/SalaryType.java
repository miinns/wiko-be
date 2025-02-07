package TenMWon.wiko.recruit.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SalaryType {

    MONTHLY("월급"),
    DAILY("일봉"),
    ANNUAL("연봉");

    private final String salaryType;

    @JsonValue
    public String getSalaryType() {
        return salaryType;
    }

    @JsonCreator
    public static SalaryType fromValue(String value) {
        for (SalaryType salaryType : SalaryType.values()) {
            if (salaryType.salaryType.equals(value)) {
                return salaryType;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
