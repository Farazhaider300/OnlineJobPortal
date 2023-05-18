package com.example.JobPortal.service.implementation

import com.example.JobPortal.entity.PostJob
import com.example.JobPortal.entity.Role
import com.example.JobPortal.entity.User
import com.example.JobPortal.entity.UserRole
import com.example.JobPortal.model.PostJobModel
import com.example.JobPortal.model.UserModel
import com.example.JobPortal.repository.JobRepository
import com.example.JobPortal.repository.UserRoleRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class JobServiceImpSpec extends  Specification{
    def mockJobRepo=Mock(JobRepository.class)
    def mockUserRoleRepo=Mock(UserRoleRepository.class)
    def jobService=new JobServiceImp(jobRepository: mockJobRepo,userRoleRepository: mockUserRoleRepo)

    def"Post:/ save the job "(){
        given:
        mockJobRepo.save() >> response
        mockUserRoleRepo.findUserRoleByUser_email(_)>>user_role

        when:
        def  response=jobService.postNewJob(requestModel)

        then:
        response==response

        where:
        requestModel                                                                                                                        |   response                           |   myuser                                                                                                              |   myrole                                   | user_role
        new PostJobModel(title: "sqa",description: "this is desc",salary: 1200,address: "xyz",company: "abc",email: "faraz@gmail.com")      |   "User Permission not allowed"      |   new User(id: 1L,email: "faraz@gmail.com",firstName: "Ali",lastName: "Raza",status: true,password: "ali123")         |   new Role(id: 1L,roleName: "Job_Seeker")  | new UserRole(id: 1L,user: myuser,role: myrole)
        new PostJobModel(title: "sqa",description: "this is desc",salary: 1200,address: "xyz",company: "abc",email: "kashif@gmail.com")     |   "Job Post successfully"            |   new User(id: 2L,email: "kashif@gmail.com",firstName: "Ali",lastName: "Raza",status: true,password: "ali123")        |   new Role(id: 2L,roleName: "Job_Poster")  | new UserRole(id: 2L,user: myuser,role: myrole)

    }

}
