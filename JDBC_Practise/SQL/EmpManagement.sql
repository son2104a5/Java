create database if not exists EmployeeManagement;
use EmployeeManagement;

create table Department(
    dp_id int auto_increment primary key,
    dp_name varchar(100) not null check ( length(dp_name) > 9 ),
    dp_description varchar(255),
    dp_status bit
);

create table Employee(
    emp_id char(5) primary key,
    emp_name varchar(150) not null check ( length(emp_name) > 14 ),
    emp_email varchar(100) not null,
    emp_phone varchar(15) not null,
    gender enum('MALE', 'FEMALE', 'OTHER'),
    salary_level int not null check ( salary_level > 0 ),
    salary decimal(15, 2) not null check ( salary > 0 ),
    emp_dob date,
    address varchar(100) not null,
    emp_status enum('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    department int,
    foreign key (department) references Department(dp_id)
);

create table User(
    user_id int primary key auto_increment,
    username varchar(100) not null,
    password varchar(100) not null,
    user_role enum('ADMIN', 'HR'),
    user_status bit
);

DELIMITER //
-- EmpService
create procedure display_employee_per_page(
    display_offset int
)
begin
    select * from employee limit 10 offset display_offset;
end;

create procedure add_employee(
    id_in char(5),
    name_in varchar(150),
    email_in varchar(100),
    phone_in varchar(15),
    gender_in enum('MALE', 'FEMALE', 'OTHER'),
    salary_level_in int,
    salary_in decimal(15, 2),
    dob_in date,
    address_in varchar(100),
    status_in enum('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    department_in int
)
begin
    insert into employee(emp_id, emp_name, emp_email, emp_phone, gender, salary_level, salary, emp_dob, address, emp_status, department)
        values (id_in, name_in, email_in, phone_in, gender_in, salary_level_in, salary_in, dob_in, address_in, status_in, department_in);
end;

create procedure update_employee_name(
    id_in char(5),
    name_in varchar(100)
)
begin
    update employee
        set emp_name = name_in where emp_id = id_in;
end;

create procedure update_employee_email(
    id_in char(5),
    email_in varchar(100)
)
begin
    update employee
        set emp_email = email_in where emp_id = id_in;
end;

create procedure update_employee_phone(
    id_in char(5),
    phone_in varchar(15)
)
begin
    update employee
        set emp_phone = phone_in where emp_id = id_in;
end;

create procedure update_employee_gender(
    id_in char(5),
    gender_in enum('MALE', 'FEMALE', 'OTHER')
)
begin
    update employee
        set gender = gender_in where emp_id = id_in;
end;

create procedure update_employee_salary_level(
    id_in char(5),
    salary_level_in int
)
begin
    update employee
        set salary_level = salary_level_in where emp_id = id_in;
end;

create procedure update_employee_salary(
    id_in char(5),
    salary_in decimal(15, 2)
)
begin
    update employee
        set salary = salary_in where emp_id = id_in;
end;

create procedure update_employee_dob(
    id_in char(5),
    dob_in date
)
begin
    update employee
        set emp_dob = dob_in where emp_id = id_in;
end;

create procedure update_employee_address(
    id_in char(5),
    address_in varchar(100)
)
begin
    update employee
        set address = address_in where emp_id = id_in;
end;

create procedure update_employee_status(
    id_in char(5),
    status_in enum('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE')
)
begin
    update employee
        set emp_status = status_in where emp_id = id_in;
end;

create procedure update_employee_department(
    id_in char(5),
    department_id_in int
)
begin
    update employee
        set department = department_id_in where emp_id = id_in;
end;

create procedure delete_employee(
    id_in char(5)
)
begin
    update employee
        set emp_status = 'INACTIVE' where emp_id = id_in;
end;

create procedure search_employee_by_name(
    name_in varchar(100)
)
begin
    select * from employee where emp_name = name_in;
end;

create procedure search_employee_by_age_amount(
    age_in int,
    age_out int
)
begin
    select * from employee where timestampdiff(year, emp_dob, curdate()) between age_in and age_out;
end;

create procedure sort_employee_by_salary(
    display_offset int
)
begin
    select * from employee order by salary desc limit 10 offset display_offset;
end;

create procedure sort_employee_by_name(
    display_offset int
)
begin
    select * from employee order by emp_name limit 10 offset display_offset;
end;

-- DepartmentService
create procedure display_department_by_page(
    display_offset int
)
begin
    select * from department limit 5 offset display_offset;
end;

create procedure add_department(
    name_in varchar(100),
    description_in varchar(255),
    status_in bit
)
begin
    insert into department(dp_name, dp_description, dp_status)
        values (name_in, description_in, status_in);
end;

create procedure update_department_name(
    id_in int,
    name_in varchar(100)
)
begin
   update department
       set dp_name = name_in where dp_id = id_in;
end;

create procedure update_department_description(
    id_in int,
    description_in varchar(255)
)
begin
    update department
        set dp_description = description_in where dp_id = id_in;
end;

create procedure update_department_status(
    id_in int,
    status_in bit
)
begin
    update department
        set dp_status = status_in where dp_id = id_in;
end;

create procedure delete_department_if_no_employees(
    id_in int
)
begin
    declare emp_count int;

    select count(*) into emp_count
    from employee
    where department = id_in;

    if emp_count = 0 then
        delete from department
        where dp_id = id_in;
    end if;
end;

create procedure search_department_by_name(
    name_in varchar(100)
)
begin
    select * from department where dp_name = name_in;
end;

-- StatisticService
create procedure count_employees_by_department()
begin
    select d.dp_id, d.dp_name, count(e.emp_id) as employee_count
    from department d
             left join employee e on d.dp_id = e.department
    group by d.dp_id, d.dp_name;
end;

create procedure department_with_most_employees()
begin
    select d.dp_id, d.dp_name, count(e.emp_id) as employee_count
    from department d
             left join employee e on d.dp_id = e.department
    group by d.dp_id, d.dp_name
    order by employee_count desc
    limit 1;
end;

create procedure department_with_highest_total_salary()
begin
    select d.dp_id, d.dp_name, sum(e.salary) as total_salary
    from department d
             join employee e on d.dp_id = e.department
    group by d.dp_id, d.dp_name
    order by total_salary desc
    limit 1;
end;

create procedure get_user_account(
    username_in varchar(100),
    password_in varchar(100)
)
begin
    select * from user where username = username_in and password = password_in;
end;
DELIMITER //