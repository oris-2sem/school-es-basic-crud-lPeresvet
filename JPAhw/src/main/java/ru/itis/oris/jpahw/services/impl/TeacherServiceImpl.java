package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.teacher.TeacherDto;
import ru.itis.oris.jpahw.entities.users.Teacher;
import ru.itis.oris.jpahw.repositories.TeacherRepository;
import ru.itis.oris.jpahw.services.TeacherService;
import ru.itis.oris.jpahw.services.converters.TeacherMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    @Override
    public TeacherDto getById(Long id) {
        Teacher teacher = (Teacher) GetHelper.getOrThrow(id, teacherRepository);
        return teacherMapper.fromTeacherToDto(teacher);
    }

    @Override
    public TeacherDto save(SignUpDto signUpDto) {
        Teacher teacher = teacherMapper.fromSignUp(signUpDto);
        teacherRepository.save(teacher);
        return teacherMapper.fromTeacherToDto(teacher);
    }

    @Override
    public TeacherDto update(Long id, UpdateUserDto updateDto) {
        Teacher teacherToUpdate = (Teacher) GetHelper.getOrThrow(id, teacherRepository);

        teacherToUpdate.setLogin(updateDto.getLogin());
        teacherToUpdate.setName(updateDto.getName());
        teacherToUpdate.setSurname(updateDto.getSurname());
        teacherToUpdate.setPatronymic(updateDto.getPatronymic());

        teacherRepository.save(teacherToUpdate);
        return teacherMapper.fromTeacherToDto(teacherToUpdate);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = (Teacher) GetHelper.getOrThrow(id, teacherRepository);
        teacherRepository.delete(teacher);
    }
}
