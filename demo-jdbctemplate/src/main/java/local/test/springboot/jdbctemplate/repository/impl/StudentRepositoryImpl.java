package local.test.springboot.jdbctemplate.repository.impl;

import local.test.springboot.jdbctemplate.entity.Student;
import local.test.springboot.jdbctemplate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public Student findById(Long id) {
        return jdbcTemplate.queryForObject("select * from student where id = ?",new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public int save(Student student) {
        return jdbcTemplate.update("insert into student(name,score,birthday) values(?,?,?)", student.getName(), student.getScore(), student.getBirthday());
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update("update student set name = ?,score = ?,birthday=? where id = ?", student.getName(), student.getScore(), student.getBirthday(), student.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from student where id = ?",id);
    }
}
