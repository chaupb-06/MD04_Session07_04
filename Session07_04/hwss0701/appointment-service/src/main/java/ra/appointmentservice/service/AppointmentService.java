package ra.appointmentservice.service;

import ra.appointmentservice.dto.request.AppointmentRequestDTO;
import ra.appointmentservice.dto.response.AppointmentResponseDTO;
import ra.appointmentservice.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO);
    List<AppointmentResponseDTO> findAll();
}
