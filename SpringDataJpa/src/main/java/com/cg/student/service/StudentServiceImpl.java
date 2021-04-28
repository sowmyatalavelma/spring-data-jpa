package com.cg.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.student.dao.StudentDao;
import com.cg.student.entities.Student;
import com.cg.student.exception.StudentNotFoundException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao sDao;

	@Override
	public Student addStudent(Student student) {
		Student stud = sDao.save(student);
		return stud;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = sDao.findAll();
		return list;
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> opt = sDao.findById(id);
		if(!opt.isPresent()) {
			throw new StudentNotFoundException("Student not found for id: "+id);
		}
		Student stud = opt.get();
		return stud;
	}

	@Override
	public List<Student> findByName(String name) {
		List<Student> studList = sDao.findByFirstName(name);
		return studList;
	}

	@Override
	public List<Student> findByFullName(String fname, String lname) {
		List<Student> studList = sDao.findByFullName(fname, lname);
		return studList;
	}
}
