package gr.aueb.cf.schoolapp.mapper;

//import gr.aueb.cf.schoolapp.core.enums.RoleType;
import gr.aueb.cf.schoolapp.core.enums.RoleType;
import gr.aueb.cf.schoolapp.dto.*;
import gr.aueb.cf.schoolapp.model.Teacher;
//import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.security.SecUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {

    private Mapper() {}

    public static Teacher mapToTeacher(TeacherInsertDTO dto) {
        return new Teacher(null, dto.getVat(), dto.getFirstname(), dto.getLastname());
    }

    public static Teacher mapToTeacher(TeacherUpdateDTO dto) {
        return new Teacher(dto.getId(), dto.getVat(), dto.getFirstname(), dto.getLastname());
    }

    public static TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher) {
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getVat(), teacher.getFirstname(), teacher.getLastname());
    }

    public static List<TeacherReadOnlyDTO> teachersToReadOnlyDTOs(List<Teacher> teachers) {
        return teachers.stream()
                .map(Mapper::mapToTeacherReadOnlyDTO)
                .collect(Collectors.toList());
    }

    public static Map<String , Object> mapToCriteria(TeacherFiltersDTO filtersDTO) {
        Map<String , Object> filters = new HashMap<>();

        if (filtersDTO.firstname() != null && !filtersDTO.firstname().isEmpty()) {
            filters.put("firstname", filtersDTO.firstname());
        }

        if (filtersDTO.lastname() != null && !filtersDTO.lastname().isEmpty()) {
            filters.put("lastname", filtersDTO.lastname());
        }

        if (filtersDTO.vat() != null && !filtersDTO.vat().isEmpty()) {
            filters.put("vat", filtersDTO.vat());
        }
        return filters;
    }

    public static User mapToUser(UserInsertDTO dto) {
        return new User(null, dto.getUsername(), dto.getPassword(),
                RoleType.valueOf(dto.getRole()));
    }

    public static UserReadOnlyDTO mapToUserReadOnlyDTO(User user) {
        return new UserReadOnlyDTO(user.getId(), user.getUsername(), user.getPassword(),
                user.getRoleType().name());
    }

}

