package com.chen.jpareferquery;

import com.chen.jpareferquery.dao.UserProfileRepository;
import com.chen.jpareferquery.dao.UserRepository;
import com.chen.jpareferquery.entity.Gender;
import com.chen.jpareferquery.entity.User;
import com.chen.jpareferquery.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class JpaReferQueryApplication{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaReferQueryApplication.class, args);
    }


    public void run(String... args) throws Exception {
        //  implements CommandLineRunner
        // Clean up database tables
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        //=========================================

        // Create a User instance
        User user = new User("Rajeev", "Singh", "rajeev@callicoder.com",
                "MY_SUPER_SECRET_PASSWORD");

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

        // Create a UserProfile instance
        UserProfile userProfile = new UserProfile("+91-8197882053",
                Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross",
                "Golf View Road, Kodihalli",
                "Bangalore", "Karnataka",
                "India", "560008");


        // Set child reference(userProfile) in parent entity(user)
        user.setUserProfile(userProfile);

        // Set parent reference(user) in child entity(userProfile)
        userProfile.setUser(user);

        // Save Parent Reference (which will save the child as well)
        User save = userRepository.save(user);
        System.out.println(save);

        //=========================================
    }
}
