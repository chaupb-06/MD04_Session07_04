package ra.appointmentservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ra.appointmentservice.dto.request.AppointmentRequestDTO;
import ra.appointmentservice.dto.response.AppointmentResponseDTO;
import ra.appointmentservice.entity.Appointment;
import ra.appointmentservice.exception.ServerUnavailableException;
import ra.appointmentservice.repository.AppointmentRepository;
import ra.appointmentservice.service.AppointmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppontmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final RestTemplate restTemplate;

    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        try {
            restTemplate.getForObject("http://patient-service/api/v1/patients/" + appointmentRequestDTO.getPatientId(), Object.class);
        } catch (Exception e) {
            throw new ServerUnavailableException("Bệnh nhân không tồn tại!");
        }
        try {
            restTemplate.getForObject("http://doctor-service/api/v1/doctors/" + appointmentRequestDTO.getDoctorId(), Object.class);
        } catch (Exception e) {
            throw new ServerUnavailableException("Hệ thống quản lý bác sĩ hiện không khả dụng. Vui lòng đặt lịch sau!");
        }
        Appointment appointment = Appointment.builder()
                .patientId(appointmentRequestDTO.getPatientId())
                .doctorId(appointmentRequestDTO.getDoctorId())
                .appointmentDate(appointmentRequestDTO.getAppointmentDate())
                .reason(appointmentRequestDTO.getReason())
                .build();
        appointmentRepository.save(appointment);
        return AppointmentResponseDTO.builder()
                .appointmentId(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .appointmentDate(appointment.getAppointmentDate())
                .reason(appointment.getReason())
                .status(appointment.getStatus())
                .build();
    }

    @Override
    public List<AppointmentResponseDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(appointment -> AppointmentResponseDTO.builder()
                        .appointmentId(appointment.getId())
                        .patientId(appointment.getPatientId())
                        .doctorId(appointment.getDoctorId())
                        .appointmentDate(appointment.getAppointmentDate())
                        .reason(appointment.getReason())
                        .status(appointment.getStatus())
                        .build()
                ).toList();
    }
}
