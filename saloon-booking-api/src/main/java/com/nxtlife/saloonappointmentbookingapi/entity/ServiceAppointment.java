/*
 * package com.nxtlife.saloonappointmentbookingapi.entity;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.OneToOne; import javax.persistence.Table; import
 * javax.validation.constraints.NotNull;
 * 
 * @Entity
 * 
 * @Table(name="SERVICE_APPOINTMENT") public class ServiceAppointment {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy= GenerationType.IDENTITY) private Integer
 * serviceAppointmentID;
 * 
 * @NotNull
 * 
 * @ManyToOne()
 * 
 * @JoinColumn(name="FK_SERAPP_EMP_ID") private Employee employee;
 * 
 * @NotNull
 * 
 * @OneToOne
 * 
 * @JoinColumn(name="FK_APP_ID") private Appointment appointment;
 * 
 * @ManyToOne private ServiceOffered serviceOffered ;
 * 
 * private Float price;
 * 
 * 
 * }
 */