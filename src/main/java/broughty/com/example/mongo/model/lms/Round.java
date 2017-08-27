package broughty.com.example.mongo.model.lms;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Round {

    @Id
    Integer id;

    Integer roundNumber;

    LocalDate startDate;

    BigDecimal winnings;

    public Round() {
    }

    public Round(Integer id) {
        this.id = id;
    }

    public Round(Integer number, LocalDate startDate, BigDecimal winnings) {
        this.id = number;
        this.roundNumber = id;
        this.startDate = startDate;
        this.winnings = winnings;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getWinnings() {
        return winnings;
    }

    public void setWinnings(BigDecimal winnings) {
        this.winnings = winnings;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("startDate", startDate)
                .append("winnings", winnings)
                .toString();
    }
}
