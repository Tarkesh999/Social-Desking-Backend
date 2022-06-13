//package com.Gettintogether;
//
//import com.Gettintogether.model.Desk;
//import com.Gettintogether.model.User;
//import com.Gettintogether.service.IDeskService;
//import com.Gettintogether.service.IUserService;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//@SpringTest ---> todo
//class GettintogetherApplicationTests {
//    @Autowired
//    IUserService userService;
//    IDeskService deskService;
//
//
//    @Test
//    public void testFindUserByEmail() {
//        Optional<User> actualUser = userService.findUserByEmail("");
//        assertFalse(actualUser.isEmpty());
//    }
//
////    @Test(expected = IllegalArgumentException.class)
////    public void testFindUserByEmailBadArgument() {
////        Optional<User> actualUser = userService.findUserByEmail("");
////        assertFalse(actualUser.isEmpty());
////    }
//
//    @Test
//    public void testFindUserByTeam() {
//        Optional<User> actualUser = userService.findUserByTeam(1);
//        assertFalse(actualUser.isEmpty());
//    }
//
//    @Test
//    public void testFindDeskByDeskId() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindDeskByLocation() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindSlotBySlotId() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindSlotByDate() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindSlotByDeskId() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindSlotByStatus() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testUpdateSlotStatus() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testSaveBooking() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindBookingByEmail() {
//        fail("not implemented yet");
//    }
//
//    @Test
//    public void testFindAllBooking() {
//        fail("not implemented yet");
//    }
//}
