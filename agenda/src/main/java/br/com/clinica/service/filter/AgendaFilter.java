package br.com.clinica.service.filter;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;

public class AgendaFilter {

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private String status;
    @Enumerated(EnumType.STRING)
    private String procedimento;
    private Pageable pageable;

    public AgendaFilter(LocalDateTime startDate, LocalDateTime endDate, String status, String procedimento,
	    Pageable pageable) {
	this.startDate = startDate;
	this.endDate = endDate;
	this.status = status;
	this.procedimento = procedimento;
	this.pageable = pageable;
    }

    @SuppressWarnings("unused")
    private AgendaFilter() {
    }

    public LocalDateTime getStartDate() {
	return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
	this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
	return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
	this.endDate = endDate;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getProcedimento() {
	return procedimento;
    }

    public void setProcedimento(String procedimento) {
	this.procedimento = procedimento;
    }

    public Pageable getPageable() {
	return pageable;
    }

    public void setPageable(Pageable pageable) {
	this.pageable = pageable;
    }

}
