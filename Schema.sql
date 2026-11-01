CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100),
                          email VARCHAR(100)
);

CREATE TABLE courses (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(100)
);

CREATE TABLE enrollments (
                             id SERIAL PRIMARY KEY,
                             student_id INT REFERENCES students(id) ON DELETE CASCADE,
                             course_id INT REFERENCES courses(id) ON DELETE CASCADE
);